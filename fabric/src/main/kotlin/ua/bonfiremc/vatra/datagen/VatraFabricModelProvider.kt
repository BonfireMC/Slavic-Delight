package ua.bonfiremc.vatra.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.models.BlockModelGenerators
import net.minecraft.data.models.ItemModelGenerators
import ua.bonfiremc.vatra.VatraInstance

class VatraFabricModelProvider(val vatra: VatraInstance, output: FabricDataOutput) : FabricModelProvider(output) {
    override fun generateBlockStateModels(generator: BlockModelGenerators) {

    }

    override fun generateItemModels(generator: ItemModelGenerators) {
        for (itemModel in vatra.itemModelMap) {
            generator.generateFlatItem(itemModel.key.value(), itemModel.value)
        }
    }
}