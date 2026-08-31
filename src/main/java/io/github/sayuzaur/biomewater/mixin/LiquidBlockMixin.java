package io.github.sayuzaur.biomewater.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.LiquidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.world.BlockView;
import net.modificationstation.stationapi.api.client.color.world.BiomeColors;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LiquidBlock.class)
public abstract class LiquidBlockMixin {
    @Inject(method = "getColorMultiplier", at = @At("HEAD"), cancellable = true)
    @Environment(EnvType.CLIENT)
    public void getColorMultiplier(BlockView blockView, int x, int y, int z, CallbackInfoReturnable<Integer> cir) {
        if (blockView.getMaterial(x, y, z) == Material.WATER) {
            blockView.method_1781().getBiomesInArea(x, z, 1, 1);
            double temp = blockView.method_1781().temperatureMap[0];
            double rain = blockView.method_1781().downfallMap[0];
            cir.setReturnValue(BiomeColors.WATER_COLOR.getColour(temp, rain));
        } else {
            cir.setReturnValue(16777215);
        }
    }
}
