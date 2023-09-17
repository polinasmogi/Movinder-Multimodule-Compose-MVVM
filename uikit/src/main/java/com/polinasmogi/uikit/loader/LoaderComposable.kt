package com.polinasmogi.uikit.loader

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView


@Composable
fun LoaderComposable() {
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            FullScreenLoader(context, null)
        }
    )
}
