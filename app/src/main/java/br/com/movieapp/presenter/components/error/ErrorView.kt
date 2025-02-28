package br.com.movieapp.presenter.components.error

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import br.com.movieapp.presenter.theme.UrbanistFamily
import br.com.movieapp.presenter.theme.white

@Composable
fun ErrorView(
    modifier: Modifier = Modifier,
    message: String,
    retry: () -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = message,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            fontFamily = UrbanistFamily,
            fontSize = 16.sp,
            color = white
        )
        Button(onClick = retry) {
            Text(text = "Recarregar")
        }
    }
}

@Preview
@Composable
fun ErrorScreenPreview() {
    ErrorView(
        message = "Error",
        retry = {}
    )
}