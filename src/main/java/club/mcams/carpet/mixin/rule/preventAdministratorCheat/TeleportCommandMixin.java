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

package club.mcams.carpet.mixin.rule.preventAdministratorCheat;

import club.mcams.carpet.AmsServerSettings;

import net.minecraft.server.command.TeleportCommand;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;

@Mixin(TeleportCommand.class)
public abstract class TeleportCommandMixin {
    @ModifyExpressionValue(
            method = {"method_13763", "method_13764"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/command/ServerCommandSource;hasPermissionLevel(I)Z"
            )
    )
    private static boolean TeleportCommand(boolean original) {
        return original && !AmsServerSettings.preventAdministratorCheat;
    }
}
