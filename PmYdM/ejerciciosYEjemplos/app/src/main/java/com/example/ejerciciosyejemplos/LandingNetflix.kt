package com.example.ejerciciosyejemplos


import android.R.attr.shape
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.PasswordVisualTransformation



val strangerThingsFontFamily= FontFamily(
    Font(R.font.strangerthings_regular)
)
@Composable
fun landingNetflix(){
    var usuario by remember { mutableStateOf("") }
    var password by remember{mutableStateOf("")}

    Box(modifier=Modifier.fillMaxSize().background(Color(32, 32, 32))) {

        Image(
            painter = painterResource(R.drawable.wallpaperbetter),
            contentDescription = "Fondo netflix",
            modifier=Modifier.
            fillMaxSize(),
            contentScale = ContentScale.Fit

        )

        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "Logo de Netflix",
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.TopStart)
                .padding(start = 16.dp, top = 32.dp)
        )

        Image(painter=painterResource(R.drawable.stranger),
            contentDescription = "Stranger Things",
            modifier=Modifier.
            align(Alignment.Center).
            padding(bottom = 400.dp).
            size(250.dp)
        )

        Text("Disfuta de la nueva temporada",
            color = Color(231, 37, 40),
            fontSize =22.sp,
            fontFamily = strangerThingsFontFamily,
            modifier=Modifier.
            align(Alignment.TopCenter).
            padding(top = 160.dp)

        )

        Column(modifier= Modifier.
            align (Alignment.BottomCenter).
            padding(bottom = 100.dp).
            width(IntrinsicSize.Max)
        ){
            Text("Inicia sesión o regístrate:",
                color = Color.White,
                fontSize = 15.sp,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier.
                align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(4.dp))

            TextField(value = usuario,
                onValueChange = {usuario=it},
                placeholder = {Text("Usuario")},
                modifier = Modifier.
                height(50.dp),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(15.dp))

            TextField(value = password,
                onValueChange = {password=it},
                placeholder = {Text("Password")},
                modifier=Modifier.
                height(50.dp),
                singleLine = true,
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.height(15.dp))

            Row(modifier= Modifier.
            fillMaxWidth()) {

                Button(
                    onClick = {
                        println("Log in")
                    },
                    modifier = Modifier.
                    height(50.dp).
                    width(100.dp),
                    enabled = true,
                    colors = ButtonDefaults.
                    buttonColors(
                        containerColor = Color(231, 37, 40),
                        contentColor = Color.White,
                        disabledContainerColor = Color.Gray
                    ),
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(2.dp, Color.White),
                    contentPadding = PaddingValues(
                        horizontal = 24.dp,
                        vertical = 12.dp
                    ),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 8.dp,
                        pressedElevation = 2.dp
                    )
                ){Text("Log in")}

                Spacer(modifier = Modifier.weight(1f))

                Button(
                    onClick = {
                        println("Sing in")
                    },
                    modifier = Modifier.
                    height(50.dp).
                    width(100.dp),
                    enabled = true,
                    colors = ButtonDefaults.
                    buttonColors(
                        containerColor = Color(231, 37, 40),
                        contentColor = Color.White,
                        disabledContainerColor = Color.Gray
                    ),
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(2.dp, Color.White),
                    contentPadding = PaddingValues(
                        horizontal = 24.dp,
                        vertical = 12.dp
                    ),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 8.dp,
                        pressedElevation = 2.dp,
                    )
                ){Text("Sing in")}
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text("¿Has olvidado la contraseña?",
                color = Color.White,
                fontSize = 15.sp,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier.
                align(Alignment.CenterHorizontally).
                clickable{
                    println("Has olvidado la contraseña")
                }
            )
        }
    }
}
