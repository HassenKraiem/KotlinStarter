plugins {
    id("kotlin.mp")
}

kotlin {
    sourceSets.commonMain.dependencies {
        implementation(libs.bundles.ktor)
    }
}
