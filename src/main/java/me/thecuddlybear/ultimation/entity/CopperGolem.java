package me.thecuddlybear.ultimation.entity;

import me.thecuddlybear.ultimation.entity.goal.CopperGolemButtonGoal;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Panda;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.StoneButtonBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class CopperGolem extends Animal {
    private static final EntityDataAccessor<Byte> DATA_ID_FLAGS = SynchedEntityData.defineId(CopperGolem.class, EntityDataSerializers.BYTE);
    private Vec3 spinDelta;
    private static final int FLAG_SPINNING_HEAD = 1;
    private static final int FLAG_PRESSING_BUTTON = 2;

    public CopperGolem(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(3, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(6, new CopperGolemButtonGoal(this, StoneButtonBlock.class, 10F));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(9, new RandomLookAroundGoal(this));
        super.registerGoals();
    }

    public static AttributeSupplier.Builder createAttributes(){
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.MOVEMENT_SPEED, 0.05D);
    }

    public boolean isSpinningHead(){ return this.getFlag(1); }

    public boolean isPressingButton(){ return this.getFlag(2); }

    public void spinHead(boolean spinBoolean){ this.setFlag(1, spinBoolean); }

    public void pressButton(boolean buttonBoolean){ this.setFlag(2, buttonBoolean); }


    private boolean getFlag(int pFlagId) {
        return (this.entityData.get(DATA_ID_FLAGS) & pFlagId) != 0;
    }

    private void setFlag(int flag, boolean exists) {
        byte b0 = this.entityData.get(DATA_ID_FLAGS);
        if (exists) {
            this.entityData.set(DATA_ID_FLAGS, (byte)(b0 | flag));
        } else {
            this.entityData.set(DATA_ID_FLAGS, (byte)(b0 & ~flag));
        }

    }

    private void handleHeadSpin(){
        if (!this.level.isClientSide) {
            Vec3 vec3 = this.getDeltaMovement();
            float f = this.getXRot() * ((float)Math.PI / 180F);
            float f1 = 0.2F;
            this.spinDelta = new Vec3(vec3.x + (double)(-Mth.sin(f) * f1), 0.0D, vec3.z + (double)(Mth.cos(f) * f1));
            this.setDeltaMovement(this.spinDelta.add(0.0D, 0.27D, 0.0D));
            this.spinHead(false);
        }
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.COPPER_STEP;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.COPPER_HIT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.COPPER_BREAK;
    }

    @Override
    public void tick() {
        super.tick();

        if(this.isSpinningHead()){
            this.handleHeadSpin();
        }
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob parent) {
        return ModEntities.COPPER_GOLEM.get().create(level);
    }
}
