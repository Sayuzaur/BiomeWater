package io.github.sayuzaur.biomewater.mixin;

import net.modificationstation.stationapi.impl.client.arsenic.renderer.render.binder.ArsenicStillWater;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ArsenicStillWater.class)
public class ArsenicStillWaterMixin {
    @Unique
    float _var17;

    @ModifyVariable(method = "tick", at = @At("STORE"), name = "var17")
    private float modifyVar17(float var17) {
        _var17 = var17 * 3.0F;
        return _var17;
    }

    @ModifyVariable(method = "tick", at = @At("STORE"), name = "var18")
    private int modifyVar18(int value) {
        return (int)(192 + (_var17 * 12));
    }

    @ModifyVariable(method = "tick", at = @At("STORE"), name = "var19")
    private int modifyVar19(int value) {
        return (int)(192 + (_var17 * 12));
    }

    @ModifyVariable(method = "tick", at = @At("STORE"), name = "var7")
    private int modifyVar7(int value) {
        return (int)(192 + (_var17 * 12));
    }

    @ModifyVariable(method = "tick", at = @At("STORE"), name = "var8")
    private int modifyVar8(int value) {
        return (int)(152 + (_var17 * 34.0F));
    }
}
