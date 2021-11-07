package me.thecuddlybear.ultimation.entity;

import me.thecuddlybear.ultimation.Ultimation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ModEntities {

    private ModEntities() {}

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Ultimation.MOD_ID);

    public static final RegistryObject<EntityType<CopperGolem>> COPPER_GOLEM = ENTITIES.register("copper_golem",
            () -> EntityType.Builder.of(CopperGolem::new, MobCategory.AMBIENT).sized(0.8f, 0.8f)
            .build(new ResourceLocation(Ultimation.MOD_ID, "copper_golem").toString()));

    public static void register(IEventBus eventBus){
        ENTITIES.register(eventBus);
    }

}
