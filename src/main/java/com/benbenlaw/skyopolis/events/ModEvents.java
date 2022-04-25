package com.benbenlaw.skyopolis.events;

import com.benbenlaw.skyopolis.Skyopolis;
import com.benbenlaw.skyopolis.block.ModBlocks;
import com.benbenlaw.skyopolis.item.ModItems;
import com.mojang.brigadier.ParseResults;
import net.minecraft.advancements.critereon.LootTableTrigger;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandFunction;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.EntityPositionSource;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntry;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.ticks.LevelTicks;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.IModBusEvent;
import net.minecraftforge.server.ServerLifecycleHooks;

import java.util.List;
import java.util.Random;


@Mod.EventBusSubscriber(modid = Skyopolis.MOD_ID)

public class ModEvents {

    @SubscribeEvent
    public static void dirtFromMulch(PlayerInteractEvent.RightClickBlock event) {
        BlockPos blockPos = event.getPos();
        BlockState blockState = event.getWorld().getBlockState(blockPos);
        Level world = event.getWorld();
        Random random = world.getRandom();
        if (event.getPlayer().getMainHandItem().is(Items.BONE_MEAL)) {
            if (blockState.is(ModBlocks.MULCH_BLOCK.get())) {
                world.setBlock(blockPos, Blocks.DIRT.defaultBlockState(), 1);
                event.getPlayer().getItemBySlot(EquipmentSlot.MAINHAND).shrink(1);
                world.addParticle(ParticleTypes.HAPPY_VILLAGER, (double) blockPos.getX() + 0.5D, (double) blockPos.getY() + 1.1D, (double) blockPos.getZ() + 0.5D, 0.0D, 0.05D, 0.0D);
            }
        }
    }

    @SubscribeEvent
    public static void grassBlockFromOrganicSeeds(PlayerInteractEvent.RightClickBlock event) {
        BlockPos blockPos = event.getPos();
        BlockState blockState = event.getWorld().getBlockState(blockPos);
        Level world = event.getWorld();
        if (event.getPlayer().getMainHandItem().is(ModItems.ORGANIC_SEEDS.get())) {
            if (blockState.is(Blocks.DIRT)) {
                world.setBlock(blockPos, Blocks.GRASS_BLOCK.defaultBlockState(), 1);
                event.getPlayer().getItemBySlot(EquipmentSlot.MAINHAND).shrink(1);
                world.addParticle(ParticleTypes.HAPPY_VILLAGER, (double) blockPos.getX() + 0.5D, (double) blockPos.getY() + 1.1D, (double) blockPos.getZ() + 0.5D, 0.0D, 0.05D, 0.0D);
            }
        }
    }

    @SubscribeEvent
    public static void waterFromAquaSeeds(PlayerInteractEvent.RightClickBlock event) {
        BlockPos blockPos = event.getPos();
        BlockState blockState = event.getWorld().getBlockState(blockPos);
        Level world = event.getWorld();
        if (event.getPlayer().getMainHandItem().is(ModItems.AQUA_CATALYST.get())) {
            if (blockState.is(ModBlocks.MULCH_BLOCK.get())) {
                world.setBlock(blockPos, Blocks.WATER.defaultBlockState(), 1);
                event.getPlayer().getItemBySlot(EquipmentSlot.MAINHAND).shrink(1);
                world.addParticle(ParticleTypes.DRIPPING_WATER, (double) blockPos.getX() + 0.5D, (double) blockPos.getY() + 1.1D, (double) blockPos.getZ() + 0.5D, 0.0D, 0.05D, 0.0D);
            }
        }
    }

    @SubscribeEvent
    public static void myceliumFromMushroomBall(PlayerInteractEvent.RightClickBlock event) {
        BlockPos blockPos = event.getPos();
        BlockState blockState = event.getWorld().getBlockState(blockPos);
        Level world = event.getWorld();
        if (event.getPlayer().getMainHandItem().is(ModItems.MUSHROOM_BALL.get())) {
            if (blockState.is(Blocks.DIRT)) {
                world.setBlock(blockPos, Blocks.MYCELIUM.defaultBlockState(), 1);
                event.getPlayer().getItemBySlot(EquipmentSlot.MAINHAND).shrink(1);
                world.addParticle(ParticleTypes.DRIPPING_WATER, (double) blockPos.getX() + 0.5D, (double) blockPos.getY() + 1.1D, (double) blockPos.getZ() + 0.5D, 0.0D, 0.05D, 0.0D);
            }
        }
    }
}
/*


//      world.addFreshEntity(new ItemEntity(world, blockPos.getX(), Math.addExact(blockPos.getY(), 2), blockPos.getZ(),
                new ItemStack(ModItems.WOODEN_SHEARS.get())));
    }

    }
}*/

    /*
    public static void mulchFromDirt(BlockEvent.EntityPlaceEvent event) throws InterruptedException {

        BlockPos blockPos = event.getPos();

        Level world = (Level) event.getWorld();

        if (event.getState().is(ModBlocks.MULCH_BLOCK.get())) {



                    world.setBlock(blockPos, Blocks.ACACIA_FENCE_GATE.defaultBlockState(), 1);

                    world.addFreshEntity(new ItemEntity(world, blockPos.getX(), Math.addExact(blockPos.getY(), 2), blockPos.getZ(),
                            new ItemStack(ModItems.WOODEN_SHEARS.get())));
                }
            }
        }

*/