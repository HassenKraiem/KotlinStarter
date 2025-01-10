plugins {
    `kotlin-multiplatform`
    id("android.lib")
}

kotlin {
    applyHierarchyTemplate()

    applyTargets()

    setupKotlinMp()
}