plugins {
    id("data.layer")
}

kotlin {
    sourceSets.commonMain.dependencies {
        api(projects.domain.userDomain)

        implementation(projects.core.database)
        implementation(libs.sqldelight.coroutinesExtensions)
    }
}
