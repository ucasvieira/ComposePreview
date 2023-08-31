package com.example.composeupdate

import android.content.ContentValues.TAG
import android.nfc.Tag
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeupdate.ui.theme.ComposeUpdateTheme
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
            FormLayoutFilled()

        }
    }
}


@Preview(showBackground = true, widthDp = 300, heightDp = 3000)
@Composable
fun appPreview(){
    app()
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormLayoutFilled() {
    val focusManager = LocalFocusManager.current
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        LazyColumn(
            modifier = Modifier.widthIn(max = 480.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(vertical = 24.dp)
        ) {
            item {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Surface(
                        onClick = { /* TODO */ },
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        shape = CircleShape
                    ) {
                        Box(
                            modifier = Modifier.size(96.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.AccountCircle,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                    Text("Adicionar foto")
                }
            }
            item {
                var imageUrl = remember { mutableStateOf<String?>(null) }
                Box(Modifier.fillMaxWidth()) {

                }
            }
            item {
                var text by remember { mutableStateOf("") }
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    label = { Text("Primeiro nome") },
                    value = text,
                    onValueChange = { text = it },
                    singleLine = true,
                    trailingIcon = {
                        AnimatedVisibility(
                            visible = text.isNotBlank(),
                            enter = fadeIn(),
                            exit = fadeOut()
                        ) {
                            IconButton(onClick = { text = "" }) {
                                Icon(Icons.Outlined.Close, "Clear")
                            }
                        }
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next,
                        capitalization = KeyboardCapitalization.Words
                    ),
                    keyboardActions = KeyboardActions {
                        focusManager.moveFocus(FocusDirection.Next)
                    }
                )

            }
            item {
                var text by remember { mutableStateOf("") }
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    label = { Text("Ultimo nome") },
                    value = text,
                    onValueChange = { text = it },
                    singleLine = true,
                    trailingIcon = {
                        AnimatedVisibility(
                            visible = text.isNotBlank(),
                            enter = fadeIn(),
                            exit = fadeOut()
                        ) {
                            IconButton(onClick = { text = "" }) {
                                Icon(Icons.Outlined.Close, "Clear")
                            }
                        }
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next,
                        capitalization = KeyboardCapitalization.Words
                    ),
                    keyboardActions = KeyboardActions {
                        focusManager.moveFocus(FocusDirection.Next)
                    }
                )
            }
            item { Spacer(Modifier.height(4.dp)) }
            item {
                var text by remember { mutableStateOf("") }
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    label = { Text("Número de Telefone") },
                    value = text,
                    onValueChange = { text = it },
                    trailingIcon = {
                        AnimatedVisibility(
                            visible = text.isNotBlank(),
                            enter = fadeIn(),
                            exit = fadeOut()
                        ) {
                            IconButton(onClick = { text = "" }) {
                                Icon(Icons.Outlined.Close, "Clear")
                            }
                        }
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Phone,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions {
                        focusManager.moveFocus(FocusDirection.Next)
                    },
                    singleLine = true,
                )
            }
            item { Spacer(Modifier.height(4.dp)) }
            item {
                var text by remember { mutableStateOf("") }
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    label = { Text("Email") },
                    value = text,
                    onValueChange = { text = it },
                    trailingIcon = {
                        AnimatedVisibility(
                            visible = text.isNotBlank(),
                            enter = fadeIn(),
                            exit = fadeOut()
                        ) {
                            IconButton(onClick = { text = "" }) {
                                Icon(Icons.Outlined.Close, "Clear")
                            }
                        }
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions {
                        focusManager.clearFocus()
                    },
                    singleLine = true,
                )
            }
            item { Spacer(Modifier.height(4.dp)) }
            item {
                var text by remember { mutableStateOf("") }
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    value = text,
                    onValueChange = {
                        text = it
                    },
                    label = { Text("País") },
                    trailingIcon = {
                        AnimatedVisibility(
                            visible = text.isNotBlank(),
                            enter = fadeIn(),
                            exit = fadeOut()
                        ) {
                            IconButton(onClick = { text = "" }) {
                                Icon(Icons.Outlined.Close, "Clear")
                            }
                        }
                    },
                )
            }
            item {
                var text by remember { mutableStateOf("") }
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    label = { Text("Endereço") },
                    value = text,
                    onValueChange = { text = it },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions {
                        focusManager.moveFocus(FocusDirection.Next)
                    },
                    singleLine = true,
                    trailingIcon = {
                        AnimatedVisibility(
                            visible = text.isNotBlank(),
                            enter = fadeIn(),
                            exit = fadeOut()
                        ) {
                            IconButton(onClick = { text = "" }) {
                                Icon(Icons.Outlined.Close, "Clear")
                            }
                        }
                    },
                )
            }
            item {
                var text by remember { mutableStateOf("") }
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    label = { Text("Cidade") },
                    value = text,
                    onValueChange = { text = it },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions {
                        focusManager.moveFocus(FocusDirection.Next)
                    },
                    singleLine = true,
                    trailingIcon = {
                        AnimatedVisibility(
                            visible = text.isNotBlank(),
                            enter = fadeIn(),
                            exit = fadeOut()
                        ) {
                            IconButton(onClick = { text = "" }) {
                                Icon(Icons.Outlined.Close, "Clear")
                            }
                        }
                    },
                )
            }
            item {
                var text by remember { mutableStateOf("") }
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    label = { Text("CEP") },
                    value = text,
                    onValueChange = { text = it },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions {
                        focusManager.clearFocus()
                    },
                    singleLine = true,
                    trailingIcon = {
                        AnimatedVisibility(
                            visible = text.isNotBlank(),
                            enter = fadeIn(),
                            exit = fadeOut()
                        ) {
                            IconButton(onClick = { text = "" }) {
                                Icon(Icons.Outlined.Close, "Clear")
                            }
                        }
                    },
                )
            }
            item {
                Text(
                    text = "Grupos",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 24.dp,
                        bottom = 8.dp
                    )
                )
            }
            item {
                var selected by remember { mutableStateOf<Int?>(null) }
                val options = listOf("Familia", "Amigos", "Trabalho", "Outro")
                Column {
                    options.forEachIndexed { i, option ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(24.dp),
                            modifier = Modifier
                                .clickable { selected = i }
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            RadioButton(
                                selected = selected == i,
                                onClick = null
                            )
                            Text(text = option)
                        }

                    }
                }
            }
            item {
                Text(
                    text = "Opções de Notificação",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 24.dp,
                        bottom = 8.dp
                    )
                )
            }
            item {
                var selected by remember { mutableStateOf(false) }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(24.dp),
                    modifier = Modifier
                        .clickable { selected = selected.not() }
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Checkbox(
                        checked = selected,
                        onCheckedChange = null
                    )
                    Text(text = "Não Perturbe")
                }
            }
            item {
                var selected by remember { mutableStateOf(false) }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(24.dp),
                    modifier = Modifier
                        .clickable { selected = selected.not() }
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Checkbox(
                        checked = selected,
                        onCheckedChange = null
                    )
                    Text(text = "Bloquear Chamadas desse contato")
                }
            }

            item {
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
                    Text("Confirmar");

                }
            }
        }
    }
}