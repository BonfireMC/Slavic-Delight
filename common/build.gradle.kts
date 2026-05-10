plugins {
    alias(libs.plugins.neoforged.moddev)
}

neoForge {
    neoFormVersion = libs.versions.neoform.get()
}

repositories {
    maven("https://api.modrinth.com/maven")
}

dependencies {
    compileOnly(libs.farmersdelight.neoforge)
}
