package com.kaduvill.RFIOunLimiter.mixin;

import com.kaduvill.RFIOunLimiter.RFIOunLimiterConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Coerce;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "net.bdew.lib.power.DataSlotPower", remap = false)
public abstract class BdLibDataSlotPowerMixin {

    @Shadow
    public abstract float capacity();

    @Shadow
    public abstract float maxReceive();

    @Shadow
    public abstract void maxReceive_$eq(float value);

    @Inject(
            method = "configure(Lnet/bdew/lib/machine/PoweredMachine;)V",
            at = @At("TAIL"),
            remap = false
    )
    private void rfiounlimiter$afterConfigure(@Coerce Object cfg, CallbackInfo ci) {
        if (!RFIOunLimiterConfig.enableBdLibUnlimiter) {
            return;
        }

        float capacity = this.capacity();
        float currentMaxReceive = this.maxReceive();

        if (capacity > currentMaxReceive) {
            this.maxReceive_$eq(capacity);
        }
    }
}