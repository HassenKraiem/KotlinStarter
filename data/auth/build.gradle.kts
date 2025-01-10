plugins {
    id("data.layer")
}

kotlin {
    sourceSets.commonMain.dependencies {
        api(projects.domain.authDomain)

        implementation(projects.core.database)
        implementation(projects.core.network)
    }
}
