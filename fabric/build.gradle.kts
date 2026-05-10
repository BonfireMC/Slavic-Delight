plugins {
    alias(libs.plugins.fabric.loom)
}

repositories {
    maven("https://maven.greenhouse.lgbt/releases/")
}

dependencies {
    minecraft(libs.minecraft)
    mappings(loom.officialMojangMappings())

    modImplementation(libs.fabric.loader)
    modImplementation(libs.fabric.kotlin)
    modImplementation(libs.fabric.api)

    implementation(libs.farmersdelight.fabric) {
        exclude(group = "net.fabricmc")
    }

    implementation(project(":common"))
}

tasks {
    jar {
        from(project(":common").sourceSets.main.get().output)
    }
}
