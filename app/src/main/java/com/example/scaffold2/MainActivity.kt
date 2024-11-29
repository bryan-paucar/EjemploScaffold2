package com.example.scaffold2

// Importaciones necesarias para trabajar con Jetpack Compose y Material3
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
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
        /*
        // Botón flotante personalizado
        floatingActionButton = { CustomFAB() },

         */

        // Contenido principal
        content = { padding ->
            CustomContent(padding)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar() {
    var expanded by remember { mutableStateOf(false) } // Controla si el menú está desplegado
    TopAppBar(
        // Colores personalizados para la barra superior
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF009688), // Color de fondo
            titleContentColor = Color.White, // Color del texto del título
            navigationIconContentColor = Color.White, // Color del icono de navegación
            actionIconContentColor = Color.White // Color de los iconos de acción
        ),
        // Título de la barra superior
        title = {
            // Contenedor para centrar el texto
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                Text(text = "Mis Películas") // Texto centrado
            }
        },
        navigationIcon = {
            // Ícono del menú desplegable a la izquierda
            IconButton(onClick = { expanded = true }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menú desplegable"
                )
            }
        },
        actions = {
            IconButton(onClick = {/*TODO*/}) {
                Icon (
                    imageVector = Icons.Default.DateRange,
                    contentDescription = null
                )
            }
            IconButton(onClick = {/*TODO*/}) {
                Icon (
                    imageVector = Icons.Default.Settings,
                    contentDescription = null
                )
            }
        }
    )
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false }
    ) {
        DropdownMenuItem(
            text = { Text("Opción 1") },
            onClick = { expanded = false } // Acciones si se selecciona algo
        )
        DropdownMenuItem(
            text = { Text("Opción 2") },
            onClick = { expanded = false }
        )
        DropdownMenuItem(
            text = { Text("Opción 3") },
            onClick = { expanded = false }
        )
    }
}

@Composable
fun CustomBottomBar() {
    BottomAppBar(
        containerColor = Color(0xFF009688), // Cambiar el color de fondo
        contentColor = Color.White // Cambiar el color de los íconos
    ) {
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
            FloatingActionButton(onClick = {/*TODO*/},shape=MaterialTheme.shapes.extraLarge) {
                IconButton(onClick = {/*TODO*/}) {
                    Icon (
                        imageVector = Icons.Default.Add,
                        contentDescription = null
                    )
                }
            }
        }
    }
}

/*
@Composable
fun CustomFAB() {
    FloatingActionButton(onClick = {/*TODO*/},shape=MaterialTheme.shapes.extraLarge) {
        IconButton(onClick = {/*TODO*/}) {
            Icon (
                imageVector = Icons.Default.Add,
                contentDescription = null
            )
        }
    }
}

 */

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
