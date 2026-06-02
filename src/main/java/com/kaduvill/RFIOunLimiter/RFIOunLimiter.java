package com.kaduvill.RFIOunLimiter;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = RFIOunLimiter.MODID,
        name = RFIOunLimiter.NAME,
        version = RFIOunLimiter.VERSION,
        acceptedMinecraftVersions = "[1.12.2]",
        acceptableRemoteVersions = "*",
        dependencies = RFIOunLimiter.DEPENDENCIES
)
public class RFIOunLimiter {
    public static final String MODID = "RFIOunLimiter";
    public static final String NAME = "RF I/O unLimiter";
    public static final String VERSION = "GRADLETOKEN_VERSION";
    public static final String DEPENDENCIES = "required-after:mixinbooter;";

    public static final Logger LOGGER = LogManager.getLogger(NAME);

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        LOGGER.info("{} initialized", NAME);
    }
}