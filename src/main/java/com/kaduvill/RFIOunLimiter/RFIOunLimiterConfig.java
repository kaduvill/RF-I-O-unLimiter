package com.kaduvill.RFIOunLimiter;

import net.minecraftforge.common.config.Config;

@Config(modid = RFIOunLimiter.MODID, name = "RF_IO_unLimiter")
public class RFIOunLimiterConfig {
    @Config.Name("Enable Gendustry (BdLib) unlimiter")
    @Config.Comment({
            "unlimits RF I/O for all BDlib mods"
    })
    public static boolean enableXXXplaceholderUnlimiter = true;
}