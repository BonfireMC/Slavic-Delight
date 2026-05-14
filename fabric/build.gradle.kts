plugins {
    alias(libs.plugins.fabric.loom)
}

repositories {
    maven("https://jitpack.io")
}

dependencies {
    minecraft(libs.minecraft)
    mappings(loom.officialMojangMappings())

    modImplementation(libs.fabric.loader)
    modImplementation(libs.fabric.kotlin)
    modImplementation(libs.fabric.api)

    modImplementation(libs.farmersdelight.fabric) {
        exclude(group = "net.fabricmc")
    }

    // temporary fix for farmer's delight refabricated
    runtimeOnly("com.github.Chocohead:Fabric-ASM:v2.3") {
        exclude(group = "net.fabricmc.fabric-api")
    }

    implementation(project(":common"))
}

fabricApi {
    configureDataGeneration {
        client = true
        outputDirectory = project(":common").file("src/generated/resources")
    }
}
