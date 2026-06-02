package com.kaduvill.RFIOunLimiter.mixin;

import com.kaduvill.RFIOunLimiter.RFIOunLimiterConfig;
import net.ndrei.teslacorelib.inventory.EnergyStorage;
import net.minecraft.nbt.NBTTagCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = EnergyStorage.class, remap = false)
public abstract class TeslaCoreLibEnergyStorageMixin {

    // If this fails to compile, the field may live in GenericEnergyStorage.
    // In that case, use an accessor mixin instead.
    @Shadow protected long capacity;

    @Shadow public abstract long getEnergyInputRate();

    @Shadow public abstract EnergyStorage setEnergyInputRate(long rate);

    @Inject(method = "deserializeNBT", at = @At("TAIL"), remap = false)
    private void rfiounlimiter$afterDeserializeNBT(NBTTagCompound nbt, CallbackInfo ci) {
        if (!RFIOunLimiterConfig.enableTeslaCoreLibUnlimiter) {
            return;
        }

        long currentInputRate = this.getEnergyInputRate();

        if (this.capacity > currentInputRate) {
            this.setEnergyInputRate(this.capacity);
        }
    }
}