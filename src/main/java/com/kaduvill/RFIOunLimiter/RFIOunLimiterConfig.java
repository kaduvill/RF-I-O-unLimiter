package com.kaduvill.RFIOunLimiter;

import net.minecraftforge.common.config.Config;

@Config(modid = RFIOunLimiter.MODID, name = "RF_IO_unLimiter")
public class RFIOunLimiterConfig {

    //Mixins are guarded behind mod.loaded AND config-boolean

    @Config.Name("Enable BDLib unlimiter")
    @Config.Comment({
            "Runtime-only patch for BDLib machines, (Gendustry).",
            "When enabled, maxReceive is raised to its internal energy capacity.",
    })
    public static boolean enableBdLibUnlimiter = true;

    @Config.Name("Enable Tesla Core Lib unlimiter")
    @Config.Comment({
            "Patch for all Tesla Core Lib ElectricTileEntity. (Industrial Foregoing)",
            "When enabled, maxReceive is raised to at least its internal energy capacity.",
    })
    public static boolean enableTeslaCoreLibUnlimiter = true;

    @Config.Name("Enable Thermal Expansion machine unlimiter")
    @Config.Comment({
            "Runtime-only patch for Thermal Expansion machines.",
            "When enabled, maxReceive is raised to at least its internal energy capacity.",
            "Only machine input is changed. This does not touch dynamos, energy cells, storage blocks, cables, or maxExtract."
    })
    public static boolean enableThermalExpansionMachineUnlimiter = true;

}