package com.kaduvill.RFIOunLimiter.mixin;

import com.kaduvill.RFIOunLimiter.RFIOunLimiter;
import net.minecraftforge.fml.common.Loader;
import zone.rong.mixinbooter.ILateMixinLoader;

import java.util.Collections;
import java.util.List;

public class RFIOunLimiterMixinLoader implements ILateMixinLoader {

    private static final String MIXIN_CONFIG = "RFIOunLimiter.mixins.json";

    @Override
    public List<String> getMixinConfigs() {
        return Collections.singletonList(MIXIN_CONFIG);
    }

    @Override
    public boolean shouldMixinConfigQueue(String mixinConfig) {
        if (MIXIN_CONFIG.equals(mixinConfig)) {
            return Loader.isModLoaded("bdlib");
        }

        return true;
    }

    @Override
    public void onMixinConfigQueued(String mixinConfig) {
        RFIOunLimiter.LOGGER.info("Queued mixin config: {}", mixinConfig);
    }
}