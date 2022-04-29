package com.benbenlaw.skyopolis.loot;

import com.benbenlaw.skyopolis.Skyopolis;
import com.google.common.collect.Sets;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Collections;
import java.util.Set;

//Thanks foliet

public class ModLootTables {

    private static ResourceLocation register(String string) {
        return register(new ResourceLocation(Skyopolis.MOD_ID, string));
    }

    private static final Set<ResourceLocation> LOCATIONS = Sets.newHashSet();
    public static final ResourceLocation FLOWER_LOOT_BOX = register("loot_boxes/flower_loot_box");
    public static final ResourceLocation SAPLING_LOOT_BOX = register("loot_boxes/sapling_loot_box");
    private static final Set<ResourceLocation> IMMUTABLE_LOCATIONS = Collections.unmodifiableSet(LOCATIONS);


    private static ResourceLocation register(ResourceLocation location) {
        if (LOCATIONS.add(location)) {
            return location;
        } else {
            throw new IllegalArgumentException(location + " is already a registered built-in loot table");
        }
    }

    public static Set<ResourceLocation> all() {
        return IMMUTABLE_LOCATIONS;
    }
}
