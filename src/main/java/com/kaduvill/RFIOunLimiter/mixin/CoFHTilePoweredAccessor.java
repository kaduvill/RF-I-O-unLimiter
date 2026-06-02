package com.kaduvill.RFIOunLimiter.mixin;

import cofh.redstoneflux.impl.EnergyStorage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(targets = "cofh.core.block.TilePowered", remap = false)
public interface CoFHTilePoweredAccessor {

    @Accessor("energyStorage")
    EnergyStorage rfiounlimiter$getEnergyStorage();
}