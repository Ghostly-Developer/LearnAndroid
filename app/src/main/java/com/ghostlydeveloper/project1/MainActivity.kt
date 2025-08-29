package com.ghostlydeveloper.project1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ghostlydeveloper.project1.ui.theme.Project1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Project1Theme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    GreetingImage(
                        name = stringResource(R.string.name_test),
                        by = stringResource(R.string.owner_text)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingImage(name: String, by: String, modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.bg)
    Box{
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Greeting(
            name = name,
            by = by,
            modifier = modifier
        )
    }
}

@Composable
fun Greeting(name: String, by: String, modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ){
        Text(
            text = "Good Morning $name!",
            fontSize = 50.sp,
            lineHeight = 50.sp,
            textAlign = TextAlign.Center,
            color = Color.Black,
            modifier = modifier.padding(top = 20.dp)
        )
        Text(
            text = "By $by",
            fontSize = 30.sp,
            color = Color.Blue,
            modifier = modifier
                .padding(end = 10.dp)
                .align(Alignment.End)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Project1Theme {
        GreetingImage("Aman","Me")
    }
}