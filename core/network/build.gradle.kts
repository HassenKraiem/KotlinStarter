plugins {
    id("kotlin.mp")
    id("koin")
    alias(libs.plugins.kotlinx.serialization)
}

kotlin {

    sourceSets.commonMain.dependencies {
        implementation(libs.kotlinx.coroutines.core)
        implementation(libs.kotlinx.serialization.json)

        implementation(libs.multiplatform.settings.no.arg)

        implementation(libs.bundles.ktor)
    }

    sourceSets.androidMain.dependencies {
        implementation(libs.ktor.engine.okhttp)
    }

    sourceSets.desktopMain.dependencies {
        implementation(libs.ktor.engine.okhttp)
        implementation(libs.logback)
    }

    sourceSets.iosMain.dependencies {
        implementation(libs.ktor.engine.darwin)
    }
}
