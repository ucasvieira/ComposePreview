package com.example.composeupdate

import android.content.ContentValues.TAG
import android.nfc.Tag
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeupdate.ui.theme.ComposeUpdateTheme
import com.example.composeupdate.ui.theme.DebugButtonColors
import com.example.composeupdate.ui.theme.ErrorButtonColors
import com.example.composeupdate.ui.theme.InfoButtonColors
import com.example.composeupdate.ui.theme.WarningButtonColors
import java.lang.Exception


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeUpdateTheme {
                    app()
            }
        }
    }
}


@Composable
private fun app(){
    Surface(
        modifier =Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Greeting("Jetpack")
            ActionButton(
                text = "Debug",
                buttonColors = DebugButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ){
                Log.i(TAG, "App: Clicou em DEBUG!")
            }
            ActionButton(
                text = "Info",
                buttonColors = InfoButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Log.i(TAG, "App: Clicou em INFO!")
            }
            ActionButton(
                text = "Warning",
                buttonColors = WarningButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Log.i(TAG, "App: Clicou em WARNING!")
            }
            ActionButton(
                text = "Error",
                buttonColors = ErrorButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                try{
                    throw RuntimeException("Clicou em Error!")
                }catch (ex: Exception){
                    Log.e(TAG,"${ex.message}")
                }
            }
        }
    }
}

@Composable
fun ActionButton(
    text: String,
    buttonColors: ButtonColors =ButtonDefaults.buttonColors(),
    modifier: Modifier = Modifier,
    block: () -> Unit
){
    ElevatedButton(
        onClick =block,
        shape = RoundedCornerShape(5.dp),
        colors =buttonColors,
        modifier = modifier
    ) {
        Text(text = text)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Aula de $name!",
        style = MaterialTheme.typography.bodyLarge.copy(
            fontWeight = FontWeight.Bold
        ),
        color = MaterialTheme.colorScheme.secondary
    )
}

@Preview(showBackground = true, widthDp = 200, heightDp = 300)
@Composable
fun appPreview(){
    app()
}

@Preview(showBackground = true, widthDp = 120)
@Composable
fun ButtonDebugPreview(){
    ActionButton(
        text = "Debug",
        buttonColors = DebugButtonColors(),
        modifier = Modifier.fillMaxWidth(0.5f)
    ){
        Log.i(TAG, "App: Clicou em DEBUG!")
    }
}

@Preview(showBackground = true, widthDp = 120)
@Composable
fun ButtonInfoPreview(){
    ActionButton(
        text = "Info",
        buttonColors = InfoButtonColors(),
        modifier = Modifier.fillMaxWidth(0.5f)
    ) {
        Log.i(TAG, "App: Clicou em INFO!")
    }
}

@Preview(showBackground = true, widthDp = 120)
@Composable
fun ButtonWarningPreview(){
    ActionButton(
        text = "Warning",
        buttonColors = WarningButtonColors(),
        modifier = Modifier.fillMaxWidth(0.5f)
    ) {
        Log.i(TAG, "App: Clicou em WARNING!")
    }
}

@Preview(showBackground = true, widthDp = 120)
@Composable
fun ButtonErrorPreview(){
    ActionButton(
        text = "Error",
        buttonColors = ErrorButtonColors(),
        modifier = Modifier.fillMaxWidth(0.5f)
    ) {
        try{
            throw RuntimeException("Clicou em Error!")
        }catch (ex: Exception){
            Log.e(TAG,"${ex.message}")
        }
    }
}

@Preview
@Composable
fun GreetingPreview(){
    Greeting("lucas")
}