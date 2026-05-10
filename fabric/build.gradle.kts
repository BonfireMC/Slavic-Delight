plugins {
    alias(libs.plugins.fabric.loom)
}

dependencies {
    minecraft(libs.minecraft)
    mappings(loom.officialMojangMappings())

    modImplementation(libs.fabric.loader)
    modImplementation(libs.fabric.kotlin)
    modImplementation(libs.fabric.api)

    implementation(project(":common"))
}

fabricApi {
    configureDataGeneration {
        client = true
    }
}

tasks {
    jar {
        from(project(":common").sourceSets.main.get().output)
    }
}
