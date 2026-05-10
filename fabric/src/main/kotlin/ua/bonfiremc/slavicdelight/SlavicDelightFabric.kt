package ua.bonfiremc.slavicdelight

import net.fabricmc.api.ModInitializer

object SlavicDelightFabric : ModInitializer {
    override fun onInitialize() {
        SlavicDelight.initialize()
    }
}