package com.example.newsify.presentation.composables

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsify.R
import com.example.newsify.util.searchBarBorder
import androidx.compose.ui.text.input.ImeAction.Companion.Search

@Composable
fun NewsifySearchBar (
    modifier: Modifier = Modifier,
    text: String,
    readOnly: Boolean,
    onClick: (() -> Unit)? = null,
    onValueChange: (String) -> Unit,
    onSearch: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isClicked = interactionSource.collectIsPressedAsState().value

    LaunchedEffect(key1 = isClicked) {
        if (isClicked) { onClick?.invoke() }
    }
    Box(modifier = Modifier) {
        TextField (
            modifier = modifier
                .fillMaxWidth()
                .searchBarBorder(),
            value = text,
            onValueChange = onValueChange,
            readOnly = readOnly,
            leadingIcon = {
                Icon (
                    painter = painterResource(R.drawable.icon_search),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = colorResource(R.color.secondary_text)
                )
            },
            placeholder = {
                Text (
                    text = stringResource(R.string.search),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = colorResource(R.color.secondary_text)
                )
            },
            shape = MaterialTheme.shapes.medium,
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = Search),
            keyboardActions = KeyboardActions(onSearch = { onSearch() }),
            interactionSource = interactionSource
        )
    }
}