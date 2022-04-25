package com.benbenlaw.skyopolis.item;

import com.benbenlaw.skyopolis.Skyopolis;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShearsItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Skyopolis.MOD_ID);

    public static final RegistryObject<Item> LEAFY_STRING = ITEMS.register("leafy_string", () -> new Item(
            new Item.Properties().tab(ModCreativeModTab.SKYOPOLIS)));

    public static final RegistryObject<Item> ORGANIC_SEEDS = ITEMS.register("organic_seeds", () -> new Item(
            new Item.Properties().tab(ModCreativeModTab.SKYOPOLIS)));

    public static final RegistryObject<Item> AQUA_CATALYST = ITEMS.register("aqua_catalyst", () -> new Item(
            new Item.Properties().tab(ModCreativeModTab.SKYOPOLIS)));

    public static final RegistryObject<Item> WOODEN_SHEARS = ITEMS.register("wooden_shears", () -> new ShearsItem(
            new Item.Properties().tab(ModCreativeModTab.SKYOPOLIS).defaultDurability(64)));

    public static final RegistryObject<Item> ANDESITE_PEBBLE = ITEMS.register("andesite_pebble", () -> new Item(
            new Item.Properties().tab(ModCreativeModTab.SKYOPOLIS)));

    public static final RegistryObject<Item> GRANITE_PEBBLE = ITEMS.register("granite_pebble", () -> new Item(
            new Item.Properties().tab(ModCreativeModTab.SKYOPOLIS)));

    public static final RegistryObject<Item> DIORITE_PEBBLE = ITEMS.register("diorite_pebble", () -> new Item(
            new Item.Properties().tab(ModCreativeModTab.SKYOPOLIS)));

    public static final RegistryObject<Item> STONE_PEBBLE = ITEMS.register("stone_pebble", () -> new Item(
            new Item.Properties().tab(ModCreativeModTab.SKYOPOLIS)));

    public static final RegistryObject<Item> BLANK_PEBBLE = ITEMS.register("blank_pebble", () -> new Item(
            new Item.Properties().tab(ModCreativeModTab.SKYOPOLIS)));

    public static final RegistryObject<Item> WASTE = ITEMS.register("waste", () -> new Item(
            new Item.Properties().tab(ModCreativeModTab.SKYOPOLIS)));

    public static final RegistryObject<Item> GROUT_DUST = ITEMS.register("grout_dust", () -> new Item(
            new Item.Properties().tab(ModCreativeModTab.SKYOPOLIS)));

    public static final RegistryObject<Item> SAND_DUST = ITEMS.register("sand_dust", () -> new Item(
            new Item.Properties().tab(ModCreativeModTab.SKYOPOLIS)));

    public static final RegistryObject<Item> GRAVEL_DUST = ITEMS.register("gravel_dust", () -> new Item(
            new Item.Properties().tab(ModCreativeModTab.SKYOPOLIS)));

    public static final RegistryObject<Item> BLANK_TOTEM = ITEMS.register("blank_totem", () -> new Item(
            new Item.Properties().tab(ModCreativeModTab.SKYOPOLIS)));

    public static final RegistryObject<Item> BLANK_DUST = ITEMS.register("blank_dust", () -> new Item(
            new Item.Properties().tab(ModCreativeModTab.SKYOPOLIS)));

    public static final RegistryObject<Item> BLANK_NUGGET = ITEMS.register("blank_nugget", () -> new Item(
            new Item.Properties().tab(ModCreativeModTab.SKYOPOLIS)));

    public static final RegistryObject<Item> LAPIS_LAZULI_NUGGET = ITEMS.register("lapis_lazuli_nugget", () -> new Item(
            new Item.Properties().tab(ModCreativeModTab.SKYOPOLIS)));

    public static final RegistryObject<Item> FLOWER_LOOT_BOX = ITEMS.register("flower_loot_box", () -> new Item(
            new Item.Properties().tab(ModCreativeModTab.SKYOPOLIS)));

    public static final RegistryObject<Item> SAPLING_LOOT_BOX = ITEMS.register("sapling_loot_box", () -> new Item(
            new Item.Properties().tab(ModCreativeModTab.SKYOPOLIS)));

    public static final RegistryObject<Item> MUSHROOM_BALL = ITEMS.register("mushroom_ball", () -> new Item(
            new Item.Properties().tab(ModCreativeModTab.SKYOPOLIS)
                    .food(new FoodProperties.Builder().nutrition(3).saturationMod(0.4F).build())));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


}
