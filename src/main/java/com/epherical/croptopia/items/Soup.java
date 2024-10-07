package com.epherical.croptopia.items;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class Soup extends Item {


    public Soup(Properties settings) {
        super(settings);
    }

    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity user) {
        Player playerEntity = user instanceof Player ? (Player)user : null;
        if (playerEntity != null) {
            if (!playerEntity.getAbilities().instabuild) {
                if (stack.has(DataComponents.FOOD)) {
                    user.eat(world, stack);
                }
            }
        }

        if (playerEntity == null || !playerEntity.getAbilities().instabuild) {
            if (stack.isEmpty()) {
                return new ItemStack(Items.BOWL);
            }

            if (playerEntity != null) {
                playerEntity.getInventory().add(new ItemStack(Items.BOWL));
            }
        }

        return stack;
    }
}
