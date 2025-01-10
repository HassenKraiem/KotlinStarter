package core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import core.ui.theme.color.backgroundDark
import core.ui.theme.color.backgroundLight
import core.ui.theme.color.errorContainerDark
import core.ui.theme.color.errorContainerLight
import core.ui.theme.color.errorDark
import core.ui.theme.color.errorLight
import core.ui.theme.color.inverseOnSurfaceDark
import core.ui.theme.color.inverseOnSurfaceLight
import core.ui.theme.color.inversePrimaryDark
import core.ui.theme.color.inversePrimaryLight
import core.ui.theme.color.inverseSurfaceDark
import core.ui.theme.color.inverseSurfaceLight
import core.ui.theme.color.onBackgroundDark
import core.ui.theme.color.onBackgroundLight
import core.ui.theme.color.onErrorContainerDark
import core.ui.theme.color.onErrorContainerLight
import core.ui.theme.color.onErrorDark
import core.ui.theme.color.onErrorLight
import core.ui.theme.color.onPrimaryContainerDark
import core.ui.theme.color.onPrimaryContainerLight
import core.ui.theme.color.onPrimaryDark
import core.ui.theme.color.onPrimaryLight
import core.ui.theme.color.onSecondaryContainerDark
import core.ui.theme.color.onSecondaryContainerLight
import core.ui.theme.color.onSecondaryDark
import core.ui.theme.color.onSecondaryLight
import core.ui.theme.color.onSurfaceDark
import core.ui.theme.color.onSurfaceLight
import core.ui.theme.color.onSurfaceVariantDark
import core.ui.theme.color.onSurfaceVariantLight
import core.ui.theme.color.onTertiaryContainerDark
import core.ui.theme.color.onTertiaryContainerLight
import core.ui.theme.color.onTertiaryDark
import core.ui.theme.color.onTertiaryLight
import core.ui.theme.color.outlineDark
import core.ui.theme.color.outlineLight
import core.ui.theme.color.outlineVariantDark
import core.ui.theme.color.outlineVariantLight
import core.ui.theme.color.primaryContainerDark
import core.ui.theme.color.primaryContainerLight
import core.ui.theme.color.primaryDark
import core.ui.theme.color.primaryLight
import core.ui.theme.color.scrimDark
import core.ui.theme.color.scrimLight
import core.ui.theme.color.secondaryContainerDark
import core.ui.theme.color.secondaryContainerLight
import core.ui.theme.color.secondaryDark
import core.ui.theme.color.secondaryLight
import core.ui.theme.color.surfaceBrightDark
import core.ui.theme.color.surfaceBrightLight
import core.ui.theme.color.surfaceContainerDark
import core.ui.theme.color.surfaceContainerHighDark
import core.ui.theme.color.surfaceContainerHighLight
import core.ui.theme.color.surfaceContainerHighestDark
import core.ui.theme.color.surfaceContainerHighestLight
import core.ui.theme.color.surfaceContainerLight
import core.ui.theme.color.surfaceContainerLowDark
import core.ui.theme.color.surfaceContainerLowLight
import core.ui.theme.color.surfaceContainerLowestDark
import core.ui.theme.color.surfaceContainerLowestLight
import core.ui.theme.color.surfaceDark
import core.ui.theme.color.surfaceDimDark
import core.ui.theme.color.surfaceDimLight
import core.ui.theme.color.surfaceLight
import core.ui.theme.color.surfaceVariantDark
import core.ui.theme.color.surfaceVariantLight
import core.ui.theme.color.tertiaryContainerDark
import core.ui.theme.color.tertiaryContainerLight
import core.ui.theme.color.tertiaryDark
import core.ui.theme.color.tertiaryLight
import core.ui.theme.shape.Shapes

val LightColorScheme =
    lightColorScheme(
        primary = primaryLight,
        onPrimary = onPrimaryLight,
        primaryContainer = primaryContainerLight,
        onPrimaryContainer = onPrimaryContainerLight,
        secondary = secondaryLight,
        onSecondary = onSecondaryLight,
        secondaryContainer = secondaryContainerLight,
        onSecondaryContainer = onSecondaryContainerLight,
        tertiary = tertiaryLight,
        onTertiary = onTertiaryLight,
        tertiaryContainer = tertiaryContainerLight,
        onTertiaryContainer = onTertiaryContainerLight,
        error = errorLight,
        onError = onErrorLight,
        errorContainer = errorContainerLight,
        onErrorContainer = onErrorContainerLight,
        background = backgroundLight,
        onBackground = onBackgroundLight,
        surface = surfaceLight,
        onSurface = onSurfaceLight,
        surfaceVariant = surfaceVariantLight,
        onSurfaceVariant = onSurfaceVariantLight,
        outline = outlineLight,
        outlineVariant = outlineVariantLight,
        scrim = scrimLight,
        inverseSurface = inverseSurfaceLight,
        inverseOnSurface = inverseOnSurfaceLight,
        inversePrimary = inversePrimaryLight,
        surfaceDim = surfaceDimLight,
        surfaceBright = surfaceBrightLight,
        surfaceContainerLowest = surfaceContainerLowestLight,
        surfaceContainerLow = surfaceContainerLowLight,
        surfaceContainer = surfaceContainerLight,
        surfaceContainerHigh = surfaceContainerHighLight,
        surfaceContainerHighest = surfaceContainerHighestLight,
    )

val DarkColorScheme =
    darkColorScheme(
        primary = primaryDark,
        onPrimary = onPrimaryDark,
        primaryContainer = primaryContainerDark,
        onPrimaryContainer = onPrimaryContainerDark,
        secondary = secondaryDark,
        onSecondary = onSecondaryDark,
        secondaryContainer = secondaryContainerDark,
        onSecondaryContainer = onSecondaryContainerDark,
        tertiary = tertiaryDark,
        onTertiary = onTertiaryDark,
        tertiaryContainer = tertiaryContainerDark,
        onTertiaryContainer = onTertiaryContainerDark,
        error = errorDark,
        onError = onErrorDark,
        errorContainer = errorContainerDark,
        onErrorContainer = onErrorContainerDark,
        background = backgroundDark,
        onBackground = onBackgroundDark,
        surface = surfaceDark,
        onSurface = onSurfaceDark,
        surfaceVariant = surfaceVariantDark,
        onSurfaceVariant = onSurfaceVariantDark,
        outline = outlineDark,
        outlineVariant = outlineVariantDark,
        scrim = scrimDark,
        inverseSurface = inverseSurfaceDark,
        inverseOnSurface = inverseOnSurfaceDark,
        inversePrimary = inversePrimaryDark,
        surfaceDim = surfaceDimDark,
        surfaceBright = surfaceBrightDark,
        surfaceContainerLowest = surfaceContainerLowestDark,
        surfaceContainerLow = surfaceContainerLowDark,
        surfaceContainer = surfaceContainerDark,
        surfaceContainerHigh = surfaceContainerHighDark,
        surfaceContainerHighest = surfaceContainerHighestDark,
    )

@Composable
fun KotlinStarterTheme(
    isDark: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = if (isDark) DarkColorScheme else LightColorScheme,
        shapes = Shapes,
        content = content,
    )
}
