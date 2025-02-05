/*
 * This file is part of the Carpet AMS Addition project, licensed under the
 * GNU Lesser General Public License v3.0
 *
 * Copyright (C) 2023  A Minecraft Server and contributors
 *
 * Carpet AMS Addition is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Carpet AMS Addition is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Carpet AMS Addition.  If not, see <https://www.gnu.org/licenses/>.
 */

package club.mcams.carpet.mixin.rule.flippinCactusSoundEffect;

import carpet.helpers.BlockRotator;

import club.mcams.carpet.AmsServerSettings;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockRotator.class)
public abstract class BlockRotatorMixin {
    @SuppressWarnings("EnhancedSwitchMigration")
    @Inject(
            //#if MC>11800
            //$$ method = "flipBlock",
            //#else
            method = "flip_block",
            //#endif
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/World;setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;I)Z"
            )
    )
    private static void flipBlock(BlockState state, World world, PlayerEntity player, Hand hand, BlockHitResult hit, CallbackInfoReturnable<Boolean> cir) {
        if (AmsServerSettings.flippinCactusSoundEffect != 0) {
            SoundEvent soundEvents = SoundEvents.BLOCK_LEVER_CLICK;
            float volume = 0.0F, pitch = 0.0F;
            switch (AmsServerSettings.flippinCactusSoundEffect) {
                case 1:
                    volume = 1.0F;
                    pitch = 0.95F;
                    break;
                case 2:
                    volume = 1.0F;
                    pitch = 2.5F;
                    break;
                case 3:
                    volume = 1.0F;
                    pitch = 0.75F;
                    break;
            }
            player.playSound(soundEvents, SoundCategory.BLOCKS, volume, pitch);
        }
    }
}
