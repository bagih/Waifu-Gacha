package com.bagih.waifugacha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bagih.waifugacha.ui.theme.WaifuGachaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WaifuGachaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    WaifuGachaApp()
                }
            }
        }
    }
}

@Composable
fun ButtonGachaWithImage(modifier: Modifier = Modifier){
    var result: Int by remember {
        mutableStateOf(0)
    }
    val imageResult = when(result){
        0 -> R.drawable.placeholder
        1 -> R.drawable.albedo
        2 -> R.drawable.kanade
        3 -> R.drawable.kaori_cicak
        4 -> R.drawable.komi
        5 -> R.drawable.makima
        6 -> R.drawable.nadeshiko
        7 -> R.drawable.nayuta
        8 -> R.drawable.tadano
        else -> R.drawable.placeholder
    }
    val textResult = when(result){
        0 -> R.string.placeholder
        1 -> R.string.albedo
        2 -> R.string.kanade
        3 -> R.string.kaori
        4 -> R.string.komi
        5 -> R.string.makima
        6 -> R.string.nadeshiko
        7 -> R.string.kani
        8 -> R.string.tadano
        else -> R.string.placeholder
    }

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Surface(modifier = Modifier.fillMaxWidth().height(300.dp).padding(start = 8.dp, end = 8.dp)) {
            Image(painter = painterResource(id = imageResult), contentDescription = stringResource(id = textResult))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = stringResource(id = textResult))
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { result = (1..8).random() }) {
            Text(text = stringResource(id = R.string.gacha))
        }
    }
}

@Preview
@Composable
fun WaifuGachaApp(){
    ButtonGachaWithImage(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
}