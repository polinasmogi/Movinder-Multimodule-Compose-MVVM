package com.polinasmogi.uikit.buttons


import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.polinasmogi.strings.R

@Composable
fun NoButton(action: () -> Unit, modifier: Modifier) {
    Button(
        onClick = { action.invoke() },
        modifier = modifier
            .height(80.dp)
            .width(80.dp)
    ) {
        Icon(
            imageVector = Icons.Rounded.Clear,
            contentDescription = stringResource(R.string.yes_button_content_description)
        )
    }
}
