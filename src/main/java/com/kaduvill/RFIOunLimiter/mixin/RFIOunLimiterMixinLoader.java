package com.kaduvill.RFIOunLimiter.mixin;

import com.kaduvill.RFIOunLimiter.RFIOunLimiter;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.FMLLaunchHandler;
import zone.rong.mixinbooter.ILateMixinLoader;

import java.util.Collections;
import java.util.List;

public class RFIOunLimiterMixinLoader implements ILateMixinLoader {
    private static final String CHISEL_GUI_MIXINS = "RFIOunLimiter.mixins.json";

    @Override
    public List<String> getMixinConfigs() {
        return Collections.singletonList(CHISEL_GUI_MIXINS);
    }
    }