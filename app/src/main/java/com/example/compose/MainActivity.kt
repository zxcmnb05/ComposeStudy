package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(text = "Column")
            Text(text = "Hello $name!")
            Text(text = "I'm Compose")
        }
        Row(modifier = Modifier.padding(10.dp)) {
            Text(text = "Row")
            Text(text = "Hello $name!")
            Text(text = "I'm Compose")
        }
        Box(modifier = Modifier.padding(10.dp)) {
            Text(text = "Box")
            Text(text = "Hello $name!")
            Text(text = "I'm Compose")
        }

        ConstraintLayout(modifier = Modifier.padding(10.dp)) {
            val (text1, text2, text3) = createRefs()

            Text(text = "ConstraintLayout", Modifier.constrainAs(text1){})
            Text(text = "Hello $name!", Modifier.constrainAs(text2){
                top.linkTo(text1.bottom)
            })
            Text(text = "I'm Compose", Modifier.constrainAs(text3){
                top.linkTo(text2.bottom)
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTheme {
        Greeting("Android")
    }
}