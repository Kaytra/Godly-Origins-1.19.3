package net.kaytra.godlyorigins.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kaytra.godlyorigins.GodlyOrigins;
import net.kaytra.godlyorigins.item.custom.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item FIRE_GOD_SHARD = registerItem("fire_god_shard",
            new FireGodShardItem());
    public static final Item METAL_GOD_SHARD = registerItem("metal_god_shard",
            new MetalGodShardItem());
    public static final Item WATER_GOD_SHARD = registerItem("water_god_shard",
            new WaterGodShardItem());
    public static final Item WIND_GOD_SHARD = registerItem("wind_god_shard",
            new WindGodShardItem());
    public static final Item WOOD_GOD_SHARD = registerItem("wood_god_shard",
            new WoodGodShardItem());



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(GodlyOrigins.MODID, name), item);
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ItemGroups.TOOLS, FIRE_GOD_SHARD);
        addToItemGroup(ItemGroups.TOOLS, METAL_GOD_SHARD);
        addToItemGroup(ItemGroups.TOOLS, WATER_GOD_SHARD);
        addToItemGroup(ItemGroups.TOOLS, WIND_GOD_SHARD);
        addToItemGroup(ItemGroups.TOOLS, WOOD_GOD_SHARD);
    }

    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        GodlyOrigins.LOGGER.info("Registering Mod Items for " + GodlyOrigins.MODID);

        addItemsToItemGroup();
    }
}
