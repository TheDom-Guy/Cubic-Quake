package com.github.thedomguy.cubic_quake.items;

import com.github.thedomguy.cubic_quake.entities.NailProjectile;
import com.github.thedomguy.cubic_quake.entities.WeaponProjectile;
import com.github.thedomguy.cubic_quake.items.weapons.NailgunItem;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.util.RenderUtil;

import java.util.function.Consumer;

public class WeaponItem extends Item implements GeoItem {

    private final float damage;
    private final Item ammo;
    private final int firerate;
    private final WeaponProjectile.Factory<? extends WeaponProjectile> projectile;
    private final int ammoConsumption;
    private final GeoItemRenderer<? extends WeaponItem> renderer;

    private int fireDelay = 0;
    private boolean firing = false;

    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    private boolean a = true;

    public WeaponItem(Settings settings, Weapons weapon) {
        super(settings.maxCount(1));
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
        damage = weapon.DAMAGE();
        ammo = weapon.AMMO();
        firerate = weapon.FIRERATE();
        projectile = weapon.PROJECTILE();
        ammoConsumption = weapon.AMMO_CONSUMPTION();
        renderer = weapon.RENDERER();
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.setCurrentHand(hand);
        if (world instanceof ServerWorld) {
            firing = true;
        }

        return TypedActionResult.pass(itemStack);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (world instanceof ServerWorld) {
            firing = false;
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (world instanceof ServerWorld serverWorld && entity instanceof PlayerEntity user) {
            if (fireDelay <= 0 && firing) {
                if (user.isCreative()) {
                    fireLogic(serverWorld, user, stack);
                } else {
                    if (user.getOffHandStack().getItem() == ammo) {
                        user.getOffHandStack().decrement(ammoConsumption);

                        fireLogic(serverWorld, user, stack);
                    } else {
                        for(int i = 0; i < user.getInventory().size(); ++i) {
                            ItemStack itemStack = user.getInventory().getStack(i);
                            if (itemStack.getItem() == ammo) {
                                itemStack.decrement(ammoConsumption);

                                fireLogic(serverWorld, user, stack);
                                break;
                            }
                        }
                    }
                }
            } else {
                fireDelay -= 1;
            }
        }
    }

    private void fireLogic(ServerWorld serverWorld, PlayerEntity user, ItemStack stack) {
        fireDelay = firerate;
       /* if (projectile.create(serverWorld) instanceof WeaponProjectile) {

            serverWorld.spawnEntity(new NailProjectile(serverWorld, user, damage));
        }*/

        if (projectile.create(serverWorld, user, damage) != null) {
            serverWorld.spawnEntity(projectile.create(serverWorld, user, damage));
        }
        if (this instanceof NailgunItem) {
            nailgunAnim(serverWorld, user, stack);
        } else {
            triggerAnim(user, GeoItem.getOrAssignId(stack, serverWorld), "weapon_anim_controller", "fire");
        }
    }

    private void nailgunAnim(ServerWorld serverWorld, PlayerEntity user, ItemStack stack) {
        if (a) {
            triggerAnim(user, GeoItem.getOrAssignId(stack, serverWorld), "weapon_anim_controller", "fire");
            a = false;
        } else {
            triggerAnim(user, GeoItem.getOrAssignId(stack, serverWorld), "weapon_anim_controller", "fire2");
            a = true;
        }

    }


    //GeckoLib stuff
    @Override
    public boolean allowComponentsUpdateAnimation(PlayerEntity player, Hand hand, ItemStack oldStack, ItemStack newStack) {
        return false;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "weapon_anim_controller", 0, state -> PlayState.CONTINUE)
                .triggerableAnim("fire", RawAnimation.begin().thenPlay("animation.weapon.fire"))
                .triggerableAnim("fire2", RawAnimation.begin().thenPlay("animation.weapon.fire2"))
        );
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public double getTick(Object itemStack) {
        return RenderUtil.getCurrentTick();
    }

    @Override
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider() {
            @Override
            public @Nullable BuiltinModelItemRenderer getGeoItemRenderer() {
                return renderer;
            }
        });
    }
}
