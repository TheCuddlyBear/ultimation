package me.thecuddlybear.ultimation.entity.goal;

import me.thecuddlybear.ultimation.block.CustomWeatheringButtonBlock;
import me.thecuddlybear.ultimation.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.level.block.Block;

public class CopperGolemButtonGoal extends Goal {
    public static final float DEFAULT_PROBABILITY = 0.02F;
    public final Mob mob;
    public final Class<? extends Block> goToButton;
    public final float lookDistance;
    public final float probability;

    public CopperGolemButtonGoal(Mob mob, Class<? extends Block> goToButton, float lookDistance){
        this(mob, goToButton, lookDistance, 0.2F);
    }

    public CopperGolemButtonGoal(Mob mob, Class<? extends Block> goToButton, float lookDistance, float probability){
        this.mob = mob;
        this.goToButton = goToButton;
        this.lookDistance = lookDistance;
        this.probability = probability;
    }

    @Override
    public void start() {
        BlockPos blockpos = null;

        for(BlockPos blockpos1 : BlockPos.betweenClosed(Mth.floor(this.mob.getX() - 2.0D), Mth.floor(this.mob.getY() - 2.0D), Mth.floor(this.mob.getZ() - 2.0D), Mth.floor(this.mob.getX() + 2.0D), this.mob.getBlockY(), Mth.floor(this.mob.getZ() + 2.0D))) {
            if (this.mob.level.getBlockState(blockpos).is(BlockTags.DIRT)) {
                blockpos = blockpos1;
                break;
            }
        }

        if (blockpos != null) {
            this.mob.getMoveControl().setWantedPosition((double)blockpos.getX(), (double)blockpos.getY(), (double)blockpos.getZ(), 1.0D);
        }
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public boolean canUse() {
        return false;
    }
}
