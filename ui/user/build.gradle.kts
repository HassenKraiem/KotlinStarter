plugins {
    id("compose.mp")
    alias(libs.plugins.kotlinx.serialization)
}

kotlin {
    sourceSets.commonMain.dependencies {
        with(libs.kotlinx) {
            implementation(coroutines.core)
            implementation(serialization.json)
        }

        with(projects) {
            implementation(data.userData)
            implementation(core.ui)
            implementation(core.utils)
        }
    }
}
