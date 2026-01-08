package com.example.ejerciciosyejemplos

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun textosSeguidosColum(){
    Column(modifier=Modifier.fillMaxSize()
        .padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Text("Hola")
        Text("Mundo")
        Text("Hola")
    }
}