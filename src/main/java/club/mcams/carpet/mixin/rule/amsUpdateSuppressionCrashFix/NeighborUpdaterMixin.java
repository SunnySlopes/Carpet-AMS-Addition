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

//#if MC<11900
import club.mcams.carpet.utils.compat.DummyClass;
//#endif

//#if MC>=11900
//$$ import net.minecraft.world.block.NeighborUpdater;
//$$ import club.mcams.carpet.utils.compat.DimensionWrapper;
//$$ import club.mcams.carpet.AmsServerSettings;
//$$ import club.mcams.carpet.helpers.rule.amsUpdateSuppressionCrashFix.ThrowableSuppression;
//$$ import club.mcams.carpet.helpers.rule.amsUpdateSuppressionCrashFix.ThrowableSuppressionContext;
//$$ import org.spongepowered.asm.mixin.injection.At;
//$$ import org.spongepowered.asm.mixin.injection.Inject;
//$$ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//$$ import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
//$$ import net.minecraft.block.Block;
//$$ import net.minecraft.block.BlockState;
//$$ import net.minecraft.util.math.BlockPos;
//$$ import net.minecraft.world.World;
//#endif

import org.spongepowered.asm.mixin.Mixin;

//#if MC<11900
@Mixin(DummyClass.class)
//#else
//$$ @Mixin(NeighborUpdater.class)
//#endif
public interface NeighborUpdaterMixin {
//#if MC>11800
//$$    @Inject(
//$$           method = "tryNeighborUpdate",
//$$           at = @At(
//$$                   value = "INVOKE",
//$$                    target = "Lnet/minecraft/util/crash/CrashReport;create(Ljava/lang/Throwable;Ljava/lang/String;)Lnet/minecraft/util/crash/CrashReport;"
//$$           ),
//$$           locals = LocalCapture.CAPTURE_FAILHARD
//$$    )
//$$    private static void tryNeighborUpdate(World world, BlockState state, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify, CallbackInfo ci, Throwable throwable) {
//$$        if (AmsServerSettings.amsUpdateSuppressionCrashFix) {
//$$           if (
//$$               throwable instanceof ClassCastException ||
//$$               throwable instanceof StackOverflowError ||
//$$               throwable instanceof OutOfMemoryError
//$$           ) {
//$$               ThrowableSuppressionContext.sendMessageToServer(pos, world);
//$$               throw new ThrowableSuppression(ThrowableSuppressionContext.suppressionMessageText(pos, world));
//$$           }
//$$        }
//$$    }
//#endif
}
