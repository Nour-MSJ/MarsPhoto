import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.marsphotos.marsphotos.ui.screens.MarsUiState
import com.example.marsphotos.marsphotos.ui.theme.MarsPhotosTheme


@Composable
fun HomeScreen(
    marsUiState: MarsUiState,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    ResultScreen(marsUiState, modifier.padding(top = contentPadding.calculateTopPadding()))
}

/**
 * ResultScreen displaying number of photos retrieved.
 */
@Composable
fun ResultScreen(photos: MarsUiState, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        when(photos) {
            is MarsUiState.Success -> Text(text = photos.toString())
            is MarsUiState.Error -> Text(text = photos.toString())
            is MarsUiState.Loading -> Text(text = photos.toString())
        }
        Text(text = photos.toString())
    }
}

@Preview(showBackground = true)
@Composable
fun ResultScreenPreview() {
    MarsPhotosTheme {
        //ResultScreen(stringResource(R.string.placeholder_result))
    }
}