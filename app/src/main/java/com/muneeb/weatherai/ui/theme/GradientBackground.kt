package com.muneeb.weatherai.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import com.muneeb.weatherai.R


@Composable
fun GradientBackground(content: @Composable () -> Unit) {
    val context = LocalContext.current
    val grad1 = ContextCompat.getColor(context, R.color.grad1)
    val grad2 = ContextCompat.getColor(context, R.color.grad2)
    val grad3 = ContextCompat.getColor(context, R.color.grad3)

    val colorStops = listOf(
        0.0f to Color(grad1),
        0.8f to Color(grad2),
        1.0f to Color(grad3)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    colorStops = colorStops.toTypedArray(),
                    start = Offset(0f, 0f),
                    end = Offset(1500f, 1500f)
                )
            )
    ) {
        content() // Now it wraps the child composables
    }
}
