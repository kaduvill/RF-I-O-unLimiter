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
            "When enabled, maxReceive is raised toleast its internal energy capacity.",
    })
    public static boolean enableTeslaCoreLibUnlimiter = true;

}