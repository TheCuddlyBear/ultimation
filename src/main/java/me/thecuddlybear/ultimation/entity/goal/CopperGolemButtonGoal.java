package me.thecuddlybear.ultimation.entity.goal;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.block.Block;

public class CopperGolemButtonGoal extends Goal {
    public static final float DEFAULT_PROBABILITY = 0.02F;
    public final Mob mob;
    public final Class<? extends Block> goToBlock;
    public final float lookDistance;
    public final float probability;

    public CopperGolemButtonGoal(Mob mob, Class<? extends Block> goToBlock, float lookDistance){
        this(mob, goToBlock, lookDistance, 0.2F);
    }

    public CopperGolemButtonGoal(Mob mob, Class<? extends Block> goToBlock, float lookDistance, float probability){
        this.mob = mob;
        this.goToBlock = goToBlock;
        this.lookDistance = lookDistance;
        this.probability = probability;
    }

    @Override
    public void start() {
        BlockPos blockpos = null;

        for(BlockPos blockpos1 : BlockPos.betweenClosed(Mth.floor(this.mob.getX() - 2.0D), Mth.floor(this.mob.getY() - 2.0D), Mth.floor(this.mob.getZ() - 2.0D), Mth.floor(this.mob.getX() + 2.0D), this.mob.getBlockY(), Mth.floor(this.mob.getZ() + 2.0D))) {
            if (this.mob.level.getBlockState(blockpos).getBlock().equals(goToBlock)) {
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
