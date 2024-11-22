package com.example.scaffold2

// Importaciones necesarias para trabajar con Jetpack Compose y Material3
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.scaffold2.ui.theme.Scaffold2Theme

// Actividad principal de la aplicación
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Aplica el tema definido en ScaffoldTheme
            Scaffold2Theme {
                // Llama a la función composable principal que define la interfaz
                CustomScaffold()
            }
        }
    }
}

// Define una función Composable que usa el componente Scaffold para crear una pantalla estructurada
// Función Composable que crea un Scaffold personalizado
@Composable
fun CustomScaffold() {
    Scaffold(
        // Barra superior
        topBar = { CustomTopBar() },

        // Barra inferior
        bottomBar = { CustomBottomBar() },

        // Botón flotante personalizado
        floatingActionButton = { CustomFAB() },

        // Contenido principal
        content = { padding ->
            CustomContent(padding)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar() {
    TopAppBar(

        // Título de la barra superior
        title = { Text(text = "Mis Películas") },
        actions = {
            IconButton(onClick = {/*TODO*/}) {
                Icon (
                    imageVector = Icons.Default.Settings,
                    contentDescription = null
                )
            }
        }
    )
}

@Composable
fun CustomBottomBar() {
    BottomAppBar() {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon (
                    imageVector = Icons.Filled.Search,
                    contentDescription = null
                )
            }
            IconButton(onClick = {/*TODO*/}) {
                Icon (
                    imageVector = Icons.Filled.Delete,
                    contentDescription = null
                )
            }
            IconButton(onClick = {/*TODO*/}) {
                Icon (
                    imageVector = Icons.Filled.ThumbUp,
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
fun CustomFAB() {
    FloatingActionButton(onClick = {/*TODO*/}) {
        IconButton(onClick = {/*TODO*/}) {
            Icon (
                imageVector = Icons.Default.Add,
                contentDescription = null
            )
        }
    }
}

@Composable
fun CustomContent(padding: PaddingValues) {
    Column(
        // Modificadores de estilo de la columna
        modifier = Modifier
            // Ocupar todo el espacio disponible
            .fillMaxSize()
            .padding(padding),

        // Contenido de la aplicación
        content = {
            Text(text = "My app content")
        }
    )
}

// Función de vista previa que permite ver cómo se verá la interfaz sin ejecutar la app
@Preview(showBackground = true) // Habilita el fondo para que sea visible
@Composable
fun GreetingPreview() {
    Scaffold2Theme {
        // Llama a la función principal de la interfaz
        CustomScaffold()
    }
}
