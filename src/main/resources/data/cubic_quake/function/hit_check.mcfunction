execute as @e[dx=0] positioned ~-.99 ~-.99 ~-.99 if entity @s[dx=0] run damage @s 8 cubic_quake:cubic_quake_damage
execute as @e[dx=0] positioned ~-.99 ~-.99 ~-.99 if entity @s[dx=0] run return fail
execute if block ~ ~ ~ air run function cubic_quake:laser