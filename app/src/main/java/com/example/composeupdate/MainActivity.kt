package com.example.composeupdate

import android.content.ContentValues.TAG
import android.nfc.Tag
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
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
            ElevatedButtonSample()
            OutlinedButtonSample()
            CardSample()
        }
    }
}

@Composable
fun CardSample() {
    Card(Modifier.size(width = 180.dp, height = 100.dp)) {
       CheckboxWithTextSample()
    }
}

@Composable
fun CheckboxWithTextSample() {
    val (checkedState, onStateChange) = remember { mutableStateOf(true) }
    Row(
        Modifier
            .fillMaxWidth()
            .height(56.dp)
            .toggleable(
                value = checkedState,
                onValueChange = { onStateChange(!checkedState) },
                role = Role.Checkbox
            )
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checkedState,
            onCheckedChange = null // null recommended for accessibility with screenreaders
        )
        Text(
            text = "Dale no Dole?",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Composable
fun ElevatedButtonSample() {
    ElevatedButton(
        onClick = {},
        modifier = Modifier ,
        enabled = true,
        shape = ButtonDefaults.elevatedShape,
        colors = ButtonDefaults.elevatedButtonColors(),
        elevation = ButtonDefaults.elevatedButtonElevation(),
        border = null,
        contentPadding = ButtonDefaults.ContentPadding,
    ) {
        Text("Morrer agora");

    }
}



@Composable
fun OutlinedButtonSample() {
    OutlinedButton(onClick = { /* Do something! */ }) { Text("Morrer Depois") }
}



@Preview(showBackground = true, widthDp = 250, heightDp = 350)
@Composable
fun appPreview(){
    app()
}
