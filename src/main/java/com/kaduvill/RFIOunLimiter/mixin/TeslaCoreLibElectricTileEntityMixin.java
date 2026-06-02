package com.kaduvill.RFIOunLimiter.mixin;

import com.kaduvill.RFIOunLimiter.RFIOunLimiter;
import com.kaduvill.RFIOunLimiter.RFIOunLimiterConfig;
import net.ndrei.teslacorelib.inventory.EnergyStorage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "net.ndrei.teslacorelib.tileentities.ElectricTileEntity", remap = false)
public abstract class TeslaCoreLibElectricTileEntityMixin {

    @Shadow(remap = false)
    protected abstract long getMaxEnergy();

    @Shadow(remap = false)
    protected abstract EnergyStorage getEnergyStorage();

    @Inject(method = "initializeInventories", at = @At("TAIL"), remap = false)
    private void rfiounlimiter$afterInitializeInventories(CallbackInfo ci) {
        if (!RFIOunLimiterConfig.enableTeslaCoreLibUnlimiter) {
            return;
        }

        EnergyStorage energyStorage = this.getEnergyStorage();

        if (energyStorage == null) {
            return;
        }

        long capacity = this.getMaxEnergy();
        long currentInputRate = energyStorage.getEnergyInputRate();

        if (capacity > currentInputRate) {
            energyStorage.setEnergyInputRate(capacity);

            RFIOunLimiter.LOGGER.debug(
                    "Tesla Core Lib ElectricTileEntity patched: {} input {} -> {}",
                    this.getClass().getName(),
                    currentInputRate,
                    capacity
            );
        }
    }
}