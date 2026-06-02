package com.kaduvill.RFIOunLimiter;

import net.minecraftforge.common.config.Config;

@Config(modid = RFIOunLimiter.MODID, name = "RF_IO_unLimiter")
public class RFIOunLimiterConfig {

    //Mixins are guarded behind mod.loaded AND config-boolean

    @Config.Name("Enable BDLib unlimiter")
    @Config.Comment({
            "Runtime-only patch for BDLib machines, (Gendustry).",
            "When enabled, BDLib machine maxReceive is raised to at least its internal energy capacity.",
    })
    public static boolean enableBdLibUnlimiter = true;
}