package ua.bonfiremc.slavicdelight.datagen

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import ua.bonfiremc.slavicdelight.SlavicDelight

object SlavicDelightFabricDatagen : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(datagen: FabricDataGenerator) {
        val pack: FabricDataGenerator.Pack = datagen.createPack()

        SlavicDelight.SD_VATRA.addProviders(pack)
    }
}