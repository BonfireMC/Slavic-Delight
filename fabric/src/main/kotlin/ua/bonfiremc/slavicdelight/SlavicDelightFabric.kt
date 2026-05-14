package ua.bonfiremc.slavicdelight

import net.fabricmc.api.ModInitializer
import ua.bonfiremc.vatra.VatraFabricAdapter

object SlavicDelightFabric : ModInitializer {
    override fun onInitialize() {
        SlavicDelight.initialize(VatraFabricAdapter)
    }
}