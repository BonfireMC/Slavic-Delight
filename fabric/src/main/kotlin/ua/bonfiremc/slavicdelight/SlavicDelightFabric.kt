package ua.bonfiremc.slavicdelight

import net.fabricmc.api.ModInitializer
import ua.bonfiremc.vatra.VatraFabricInstance

object SlavicDelightFabric : ModInitializer {
    override fun onInitialize() {
        SlavicDelight.initialize(::VatraFabricInstance)
    }
}