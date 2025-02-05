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

package club.mcams.carpet.mixin.rule.amsUpdateSuppressionCrashFix;

//#if MC<=12002 || MC>=12002
import club.mcams.carpet.utils.compat.DummyClass;
//#endif

//#if MC>=11900 && MC<12002
//$$ import org.spongepowered.asm.mixin.injection.At;
//$$ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
//$$ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
//$$ import club.mcams.carpet.AmsServerSettings;
//$$ import net.minecraft.block.Block;
//$$ import net.minecraft.block.BlockState;
//$$ import net.minecraft.util.math.BlockPos;
//$$ import net.minecraft.world.World;
//$$ import net.minecraft.world.block.NeighborUpdater;
//#endif

import org.spongepowered.asm.mixin.Mixin;

//#if MC>=11900 && MC<12002
//$$ @Mixin(targets = "net.minecraft.world.block.ChainRestrictedNeighborUpdater$SixWayEntry")
//#else
@Mixin(DummyClass.class)
//#endif
public abstract class SixWayEntryMixin {
//#if MC>=11900 && MC<12002
//$$    @WrapOperation(
//$$            method = "update",
//$$            at = @At(
//$$                    value = "INVOKE",
//$$                    target = "Lnet/minecraft/block/BlockState;neighborUpdate(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/Block;Lnet/minecraft/util/math/BlockPos;Z)V"
//$$            )
//$$    )
//$$    private void update(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify, Operation<Void> original) {
//$$        if (AmsServerSettings.amsUpdateSuppressionCrashFix) {
//$$            NeighborUpdater.tryNeighborUpdate(world, state, pos, sourceBlock, sourcePos, notify);
//$$        }
//$$        original.call(state, world, pos, sourceBlock, sourcePos, notify);
//$$    }
//#endif
}