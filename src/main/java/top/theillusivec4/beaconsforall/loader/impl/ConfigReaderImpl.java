/*
 * Copyright (c) 2018-2020 C4
 *
 * This file is part of Beacons For All, a mod made for Minecraft.
 *
 * Beacons For All is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Beacons For All is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Beacons For All.  If not, see <https://www.gnu.org/licenses/>.
 */

package top.theillusivec4.beaconsforall.loader.impl;

import java.util.ArrayList;
import java.util.List;
import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry.Gui.Tooltip;
import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.Comment;
import top.theillusivec4.beaconsforall.core.BeaconsForAll;
import top.theillusivec4.beaconsforall.core.base.ConfigReader;
import top.theillusivec4.beaconsforall.core.base.ModConfig.CreatureType;

@Config(name = BeaconsForAll.MODID)
public class ConfigReaderImpl implements ConfigData, ConfigReader {

  @Tooltip(count = 5)
  @Comment("Set which creatures can be affected by beacons")
  public CreatureType creatureType = CreatureType.TAMED;

  @Tooltip
  @Comment("List of specific additional creatures by registry name that can be affected by beacons")
  public List<String> additionalCreatures = new ArrayList<>();

  @Override
  public CreatureType getCreatureType() {
    return creatureType;
  }

  @Override
  public List<String> getAdditionalCreatures() {
    return additionalCreatures;
  }
}
