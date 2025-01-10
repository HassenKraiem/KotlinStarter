package core.config

import com.softylines.config.BuildConfig

enum class BuildFlavor {
    Dev,
    Staging,
    Release;

    val isDev: Boolean
        get() = this == Dev

    val isStaging: Boolean
        get() = this == Staging

    val isRelease: Boolean
        get() = this == Release
}

val buildFlavor: BuildFlavor by lazy {
    val flavor = BuildConfig.buildFlavor
    when (flavor.lowercase()) {
        "dev" ->
            BuildFlavor.Dev

        "staging" ->
            BuildFlavor.Staging

        "release" ->
            BuildFlavor.Release

        else ->
            BuildFlavor.Dev
    }
}