package com.polinasmogi.explore.ui

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.polinasmogi.explore.R
import com.polinasmogi.ui_atoms.theme.MovinderTheme

@Composable
fun EmptyList() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.width(90.dp).height(90.dp),
            painter = painterResource(id = R.drawable.ic_sad_mask),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground),
            contentDescription = stringResource(com.polinasmogi.strings.R.string.empty_list_icon_content_description)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = stringResource(id = com.polinasmogi.strings.R.string.empty_list_description),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = false)
@Composable
fun EmptyListPreview() {
    MovinderTheme {
        EmptyList()
    }
}