package com.epherical.croptopia.listeners;

import com.epherical.croptopia.register.Content;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.living.MobSpawnEvent;

public class EntitySpawn {


    @SubscribeEvent
    public void onEntitySpawn(EntityJoinLevelEvent event) {
        Entity mob = event.getEntity();
        if (mob instanceof Pig pig) {
            pig.goalSelector.addGoal(4, new TemptGoal((PathfinderMob) mob, 1.2D, Ingredient.of(Content.YAM, Content.SWEETPOTATO), false));
        }

        if (mob instanceof Cow cow) {
            cow.goalSelector.addGoal(3, new TemptGoal((PathfinderMob) mob, 1.25D, Ingredient.of(Content.BARLEY, Content.CORN), false));
        }
    }
}
