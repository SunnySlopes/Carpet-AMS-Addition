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

package club.mcams.carpet.mixin.setting;

//#if MC>=11900
//$$ import club.mcams.carpet.utils.compat.DummyClass;
//#else
import carpet.settings.ParsedRule;
import carpet.settings.Rule;
import org.spongepowered.asm.mixin.gen.Invoker;
import java.lang.reflect.Field;
//#endif

import org.spongepowered.asm.mixin.Mixin;


//#if MC<11900
@Mixin(ParsedRule.class)
//#else
//$$ @Mixin(DummyClass.class)
//#endif
public interface ParsedRuleAccessor {
    //#if MC<11900
    @SuppressWarnings("rawtypes")
    @Invoker(value = "<init>", remap = false)
    static ParsedRule invokeConstructor(Field field, Rule rule, carpet.settings.SettingsManager settingsManager) {
        throw new RuntimeException();
    }
    //#endif
}
