package ru.samsung.itschool.mdev.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.json.responseJson
import com.github.kittinunf.result.Result
import ru.samsung.itschool.mdev.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           MainView()
        }
    }
}

@Composable
fun MainView() {
    var agent by remember {
        mutableStateOf("")
    }
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
            Text(text = agent)
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
            Button(onClick = {
                val httpAsync = "https://httpbin.org/get"
                    .httpGet()
                    .responseJson { request, response, result ->
                        when (result) {
                            is Result.Failure-> {
                                val ex = result.getException()
                                println(ex)
                            }
                            is Result.Success -> {
                                val resObj = result.get().obj()
                                agent = resObj.getJSONObject("headers").getString("User-Agent").toString()
                            }
                        }
                    }

                httpAsync.join()
            }) {

            }
        }
    }
}

