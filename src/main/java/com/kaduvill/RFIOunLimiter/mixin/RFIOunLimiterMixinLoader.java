package com.kaduvill.RFIOunLimiter.mixin;

import com.kaduvill.RFIOunLimiter.RFIOunLimiter;
import net.minecraftforge.fml.common.Loader;
import zone.rong.mixinbooter.ILateMixinLoader;

import java.util.Arrays;
import java.util.List;

public class RFIOunLimiterMixinLoader implements ILateMixinLoader {

    private static final String BDLIB_MIXINS = "RFIOunLimiter.mixins.bdlib.json";
    private static final String TESLA_CORE_LIB_MIXINS = "RFIOunLimiter.mixins.teslacorelib.json";
    private static final String THERMAL_EXPANSION_MIXIN_CONFIG = "RFIOunLimiter.thermalexpansion.mixins.json";

    @Override
    public List<String> getMixinConfigs() {
        return Arrays.asList(
                BDLIB_MIXINS,
                TESLA_CORE_LIB_MIXINS,
                THERMAL_EXPANSION_MIXIN_CONFIG
        );
    }

    @Override
    public boolean shouldMixinConfigQueue(String mixinConfig) {
        if (BDLIB_MIXINS.equals(mixinConfig)) {
            return Loader.isModLoaded("bdlib");
        }

        if (THERMAL_EXPANSION_MIXIN_CONFIG.equals(mixinConfig)) {
            return Loader.isModLoaded("thermalexpansion");
        }

        if (TESLA_CORE_LIB_MIXINS.equals(mixinConfig)) {
            return Loader.isModLoaded("teslacorelib");
        }

        return true;
    }

    @Override
    public void onMixinConfigQueued(String mixinConfig) {
        RFIOunLimiter.LOGGER.info("Queued mixin config: {}", mixinConfig);
    }
}