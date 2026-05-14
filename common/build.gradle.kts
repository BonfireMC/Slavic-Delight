plugins {
    alias(libs.plugins.neoforged.moddev)
}

neoForge {
    neoFormVersion = libs.versions.neoform.get()
}

dependencies {
    compileOnly(libs.farmersdelight.neoforge)
}
