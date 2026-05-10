plugins {
    alias(libs.plugins.fabric.loom)
}

repositories {
    maven("https://api.modrinth.com/maven")
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

    implementation(project(":common"))
}

tasks {
    jar {
        from(project(":common").sourceSets.main.get().output)
    }
}
