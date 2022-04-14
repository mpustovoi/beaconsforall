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

package top.theillusivec4.beaconsforall;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkConstants;
import top.theillusivec4.beaconsforall.common.BeaconsForAllConfig;

@Mod(BeaconsForAll.MODID)
public class BeaconsForAll {

  public static final String MODID = "beaconsforall";

  public BeaconsForAll() {
    IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
    eventBus.addListener(this::configLoading);
    eventBus.addListener(this::configReloading);
    ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, BeaconsForAllConfig.CONFIG_SPEC);
    ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class,
        () -> new IExtensionPoint.DisplayTest(() -> NetworkConstants.IGNORESERVERONLY,
            (a, b) -> true));
  }

  private void configLoading(final ModConfigEvent.Loading evt) {

    if (evt.getConfig().getModId().equals(MODID)) {
      BeaconsForAllConfig.bake();
    }
  }

  private void configReloading(final ModConfigEvent.Reloading evt) {

    if (evt.getConfig().getModId().equals(MODID)) {
      BeaconsForAllConfig.bake();
    }
  }
}
