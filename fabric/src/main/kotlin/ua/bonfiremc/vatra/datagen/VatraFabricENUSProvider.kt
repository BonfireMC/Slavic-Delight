package ua.bonfiremc.vatra.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import net.minecraft.core.HolderLookup
import ua.bonfiremc.vatra.VatraInstance
import java.util.concurrent.CompletableFuture

class VatraFabricENUSProvider(
    val vatra: VatraInstance,
    output: FabricDataOutput,
    lookup: CompletableFuture<HolderLookup.Provider>
) : FabricLanguageProvider(output, lookup) {
    override fun generateTranslations(lookup: HolderLookup.Provider, builder: TranslationBuilder) {
        for (lang in vatra.langMap) {
            builder.add(lang.key, lang.value)
        }
    }
}