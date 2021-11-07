package me.thecuddlybear.ultimation.event;

import me.thecuddlybear.ultimation.Ultimation;
import me.thecuddlybear.ultimation.entity.CopperGolem;
import me.thecuddlybear.ultimation.entity.ModEntities;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Ultimation.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.COPPER_GOLEM.get(), CopperGolem.createAttributes().build());
    }

}
