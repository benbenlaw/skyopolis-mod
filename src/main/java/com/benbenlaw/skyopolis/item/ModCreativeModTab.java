package com.benbenlaw.skyopolis.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModTab {
    public static final CreativeModeTab SKYOPOLIS = new CreativeModeTab("skyopolis") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.LEAFY_STRING.get());
        }
    };
}
