package net.funkybumbleton.init;

import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import com.google.common.collect.ImmutableSet;
import net.funkybumbleton.rubymod.RubyMod;
import net.funkybumbleton.rubymod.block.ModBlocks;
import net.funkybumbleton.rubymod.item.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.BasicItemListing;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;


public class VillagerInit
{
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, RubyMod.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(ForgeRegistries.PROFESSIONS, RubyMod.MOD_ID);

    //    public VillagerTradesEvent(Int2ObjectMap<List<ItemListing>> trades, VillagerProfession type)

    public static final RegistryObject<PoiType> JEWELER_POI = POI_TYPES.register("jeweler",
            () -> new PoiType("jeweler",
                    PoiType.getBlockStates(ModBlocks.RUBY_BLOCK.get()),
                    1,
                    1));

    public static final RegistryObject<VillagerProfession> JEWELER = VILLAGER_PROFESSIONS.register("jeweler",
            () -> new VillagerProfession("jeweler",
                    JEWELER_POI.get(),
                    ImmutableSet.of(),
                    ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_MASON));

    public static void registerJewelerPOI() {
        try
        {
            ObfuscationReflectionHelper.findMethod(PoiType.class, "registerBlockStates", PoiType.class).invoke(null, JEWELER_POI.get());
        } catch (InvocationTargetException | IllegalAccessException e)
        {
            e.printStackTrace();
        }
    }

    public static void fillTradeData()
    {
        BasicItemListing jewelerTrade1 = new BasicItemListing(new ItemStack(ModItems.RUBY.get(), 1), new ItemStack(Items.BLAZE_ROD, 1), 100, 1, 2f);

        VillagerTrades.ItemListing[] jewelerLevel1 = new VillagerTrades.ItemListing[]{jewelerTrade1};
        VillagerTrades.TRADES.put(JEWELER.get(), toIntMap(ImmutableMap.of(1, jewelerLevel1)));
    }

    private static Int2ObjectMap<VillagerTrades.ItemListing[]> toIntMap(ImmutableMap<Integer, VillagerTrades.ItemListing[]> pMap) {
        return new Int2ObjectOpenHashMap<>(pMap);
    }
}
