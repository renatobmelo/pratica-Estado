package com.example.galeria

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ImageScreen()
        }
    }
}

@Composable
fun ImageScreen() {
    // Lista de dados das imagens
    val imageDataList = listOf(
        ImageData(R.drawable.image1, "Arte 1", "Aristides I"),
        ImageData(R.drawable.image2, "Arte 2", "Arthur II"),
        ImageData(R.drawable.image3, "Arte 3", "Catatau III")

        // Adicione mais imagens conforme necessário
    )

    // Estado para armazenar o índice da imagem atual
    var currentIndex by remember { mutableStateOf(0) }

    // Obtém os dados da imagem atual com base no índice
    val currentImageData = imageDataList[currentIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Exibe a imagem
        Image(
            painter = painterResource(id = currentImageData.imageId),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp) // Ajuste o tamanho conforme necessário
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Título da imagem
        Text(
            text = currentImageData.title
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Nome do artista
        Text(
            text = currentImageData.artistName
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botões de navegação
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                // Navega para a imagem anterior, se possível
                if (currentIndex > 0) {
                    currentIndex--
                }
            }) {
                Text("Previous")
            }

            Button(onClick = {
                // Navega para a próxima imagem, se possível
                if (currentIndex < imageDataList.size - 1) {
                    currentIndex++
                }
            }) {
                Text("Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewImageScreen() {
    ImageScreen()
}