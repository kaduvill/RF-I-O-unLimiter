package com.kaduvill.RFIOunLimiter.mixin;

import cofh.redstoneflux.impl.EnergyStorage;
import com.kaduvill.RFIOunLimiter.RFIOunLimiterConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "cofh.thermalexpansion.block.machine.TileMachineBase", remap = false)
public abstract class ThermalExpansionTileMachineBaseMixin {

    @Inject(method = "<init>", at = @At("RETURN"), remap = false)
    private void rfiounlimiter$afterConstruct(CallbackInfo ci) {
        rfiounlimiter$raiseMachineInputToCapacity();
    }

    @Inject(method = "setLevel(I)Z", at = @At("RETURN"), remap = false)
    private void rfiounlimiter$afterSetLevel(int level, CallbackInfoReturnable<Boolean> cir) {
        if (cir.getReturnValue()) {
            rfiounlimiter$raiseMachineInputToCapacity();
        }
    }

    @Inject(method = "postAugmentInstall()V", at = @At("RETURN"), remap = false)
    private void rfiounlimiter$afterPostAugmentInstall(CallbackInfo ci) {
        rfiounlimiter$raiseMachineInputToCapacity();
    }

    private void rfiounlimiter$raiseMachineInputToCapacity() {
        if (!RFIOunLimiterConfig.enableThermalExpansionMachineUnlimiter) {
            return;
        }

        EnergyStorage energyStorage =
                ((CoFHTilePoweredAccessor) (Object) this).rfiounlimiter$getEnergyStorage();

        if (energyStorage == null) {
            return;
        }

        int capacity = energyStorage.getMaxEnergyStored();
        int currentMaxReceive = energyStorage.getMaxReceive();

        if (capacity > currentMaxReceive) {
            energyStorage.setMaxReceive(capacity);
        }
    }
}