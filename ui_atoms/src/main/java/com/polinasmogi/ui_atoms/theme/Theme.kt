package com.polinasmogi.ui_atoms.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = DarkColorPrimary,
    secondary = DarkColorSecondary,
    tertiary = DarkColorTertiary,
    error = DarkColorError,
    background = DarkColorBackground,
    surface = DarkColorSurface,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
)

private val LightColorScheme = lightColorScheme(
    primary = ColorPrimary,
    onPrimary = Color.White,
    secondary = ColorSecondary,
    onSecondary = Color.White,
    tertiary = ColorTertiary,
    background = Color.White,
    onBackground = Color.Black,
    surface = ColorSurface,
    onSurface = Color.Black,
    error = ColorError,
    onError = Color.White
)

@Composable
fun MovinderTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}