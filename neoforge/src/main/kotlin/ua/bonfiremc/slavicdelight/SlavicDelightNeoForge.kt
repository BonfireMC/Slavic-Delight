package ua.bonfiremc.slavicdelight

import net.neoforged.fml.common.Mod
import thedarkcolour.kotlinforforge.neoforge.forge.MOD_BUS
import ua.bonfiremc.vatra.VatraNeoForgeAdapter
import ua.bonfiremc.vatra.VatraNeoForgeInstance

@Mod(SlavicDelight.MOD_ID)
object SlavicDelightNeoForge {
    init {
        SlavicDelight.initialize(VatraNeoForgeAdapter)

        if (SlavicDelight.SD_VATRA is VatraNeoForgeInstance) {
            (SlavicDelight.SD_VATRA as VatraNeoForgeInstance).items.register(MOD_BUS)
        }
    }
}