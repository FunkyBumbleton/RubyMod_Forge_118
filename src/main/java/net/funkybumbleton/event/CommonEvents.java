package net.funkybumbleton.event;

import net.funkybumbleton.rubymod.init.VillagerInit;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;


public class CommonEvents {
    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            VillagerInit.fillTradeData();
            VillagerInit.registerJewelerPOI();
        });
    }
}
