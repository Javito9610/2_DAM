package com.example.ejerciciosyejemplos

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun textoGrande(){
    Text("Hola mundooo",
        fontSize = 30.sp,
        color=Color.Red,
        modifier = Modifier.padding(30.dp))

}