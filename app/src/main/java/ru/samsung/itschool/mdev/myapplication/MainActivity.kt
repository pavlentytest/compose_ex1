package ru.samsung.itschool.mdev.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import ru.samsung.itschool.mdev.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Row( modifier = Modifier
                .background(Color.Green)
                .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly) {
                Column(
                    modifier = Modifier
                        .background(Color.Red)
                        .fillMaxHeight(0.3f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center

                ) {
                    Text(text = "Hello")
                    Text(text = "Madrid")
                    Text(text = "Hello")
                    Text(text = "Madrid")
                }

                Column(
                    modifier = Modifier
                        .background(Color.Blue)
                        .fillMaxHeight(0.5f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center

                ) {
                    Text(text = "Hello")
                    Text(text = "Madrid")
                    Text(text = "Hello")
                    Text(text = "Madrid")
                }
            }


        }
    }

}
