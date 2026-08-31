package com.github.thedomguy.cubic_quake.mixin;

import com.github.thedomguy.cubic_quake.items.WeaponItem;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.UseAction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntityRenderer.class)
public class PlayerArmPoseMixin {
	@Inject(at = @At("HEAD"), method = "getArmPose", cancellable = true)
	private static void init(AbstractClientPlayerEntity player, Hand hand, CallbackInfoReturnable info) {
		ItemStack itemStack = player.getStackInHand(hand);
		if (itemStack.isEmpty()) {
			info.setReturnValue(BipedEntityModel.ArmPose.EMPTY);
		} else {
			if (player.getActiveHand() == hand && player.getItemUseTimeLeft() > 0) {
				UseAction useAction = itemStack.getUseAction();
				if (useAction == UseAction.BLOCK) {
					info.setReturnValue(BipedEntityModel.ArmPose.BLOCK);
					return;
				}

				if (useAction == UseAction.BOW) {
					info.setReturnValue(BipedEntityModel.ArmPose.BOW_AND_ARROW);
					return;
				}

				if (useAction == UseAction.SPEAR) {
					info.setReturnValue(BipedEntityModel.ArmPose.THROW_SPEAR);
					return;
				}

				if (useAction == UseAction.CROSSBOW && hand == player.getActiveHand()) {
					info.setReturnValue(BipedEntityModel.ArmPose.CROSSBOW_CHARGE);
					return;
				}

				if (useAction == UseAction.SPYGLASS) {
					info.setReturnValue(BipedEntityModel.ArmPose.SPYGLASS);
					return;
				}

				if (useAction == UseAction.TOOT_HORN) {
					info.setReturnValue(BipedEntityModel.ArmPose.TOOT_HORN);
					return;
				}

				if (useAction == UseAction.BRUSH) {
					info.setReturnValue(BipedEntityModel.ArmPose.BRUSH);
					return;
				}
			} else if (!player.handSwinging && ((itemStack.isOf(Items.CROSSBOW) && CrossbowItem.isCharged(itemStack)) || itemStack.getItem() instanceof WeaponItem)) {
				info.setReturnValue(BipedEntityModel.ArmPose.CROSSBOW_HOLD);
				return;
			}

			info.setReturnValue(BipedEntityModel.ArmPose.ITEM);
		}
	}
}