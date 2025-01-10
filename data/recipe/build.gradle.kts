plugins {
    id("data.layer")
}

kotlin {
    sourceSets.commonMain.dependencies {
        api(projects.domain.recipeDomain)

        implementation(projects.core.database)
        implementation(projects.core.network)
    }
}
dependencies {
    implementation(project(":domain:recipe_domain"))
}
