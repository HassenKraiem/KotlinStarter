plugins {
    id("compose.mp")
}

kotlin {
    sourceSets.commonMain.dependencies {
        with(compose) {
            api(compose.foundation)
            api(compose.ui)
            api(compose.material3)
            api(components.resources)
        }
    }
}

compose {
    resources {
        publicResClass = true
        packageOfResClass = "resources"
        generateResClass = always
    }
}
