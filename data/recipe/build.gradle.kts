plugins {
    id("data.layer")
}

kotlin {
    sourceSets.commonMain.dependencies {
        implementation(projects.domain.recipeDomain)
        implementation(projects.domain.recipeDetailsDomain)

        implementation(projects.core.database)
        implementation(projects.core.network)
    }
}