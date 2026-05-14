package ua.bonfiremc.slavicdelight

import net.neoforged.fml.common.Mod
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.neoforge.forge.MOD_BUS
import ua.bonfiremc.vatra.VatraNeoForgeAdapter
import ua.bonfiremc.vatra.VatraNeoForgeInstance

@Mod(SlavicDelight.MOD_ID)
object SlavicDelightNeoForge {
    val LOGGER: Logger = LogManager.getLogger(SlavicDelight.MOD_ID)

    init {
        SlavicDelight.initialize(VatraNeoForgeAdapter)

        if (SlavicDelight.SD_VATRA is VatraNeoForgeInstance) {
            (SlavicDelight.SD_VATRA as VatraNeoForgeInstance).items.register(MOD_BUS)
        }
    }
}