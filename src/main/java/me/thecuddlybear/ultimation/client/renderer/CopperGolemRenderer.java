package me.thecuddlybear.ultimation.client.renderer;

import me.thecuddlybear.ultimation.Ultimation;
import me.thecuddlybear.ultimation.client.renderer.model.CopperGolemModel;
import me.thecuddlybear.ultimation.entity.CopperGolem;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CopperGolemRenderer<T extends CopperGolem> extends MobRenderer<T, CopperGolemModel<T>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Ultimation.MOD_ID, "textures/entity/copper_golem.png");

    public CopperGolemRenderer(EntityRendererProvider.Context context) {
        super(context, new CopperGolemModel<>(context.bakeLayer(CopperGolemModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(T pEntity) {
        return TEXTURE;
    }
}
