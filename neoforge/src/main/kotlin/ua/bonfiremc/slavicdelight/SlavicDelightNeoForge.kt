package ua.bonfiremc.slavicdelight

import net.neoforged.fml.common.Mod
import thedarkcolour.kotlinforforge.neoforge.forge.MOD_BUS
import ua.bonfiremc.vatra.VatraNeoForgeInstance

@Mod(SlavicDelight.MOD_ID)
object SlavicDelightNeoForge {
    init {
        SlavicDelight.initialize(::VatraNeoForgeInstance).register(MOD_BUS)
    }
}