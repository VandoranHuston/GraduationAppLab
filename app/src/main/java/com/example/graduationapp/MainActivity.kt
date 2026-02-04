package com.example.graduationapp

import android.media.Image
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.example.graduationapp.ui.theme.GraduationAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GraduationAppTheme {
                val context = LocalContext.current
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    text = "Graduation RSVP-RIT"
                                )},
                            colors = topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.primary
                            )
                        )
                    },
                    floatingActionButton = {
                        FloatingActionButton(onClick = {
                            Toast.makeText(context, "FAB Clicked!", Toast.LENGTH_SHORT).show()
                        }) {
                            Icon(Icons.Default.Add, contentDescription = "Add action")
                        }
                    }) { innerPadding ->
                    GradScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun GradScreen(modifier: Modifier = Modifier) {
    var isChecked by remember {mutableStateOf(true)}
    val message = if (isChecked) "I'll be there!" else "Sorry I can't be there."
    Column (horizontalAlignment = Alignment.CenterHorizontally){
        Text(
            text = "Graduation Announcement",
            fontSize = 50.sp,
            lineHeight = 50.sp,
            color = Color.Red,
            textAlign = TextAlign.Center,
            modifier = modifier
        )
        Image(
            painter = painterResource(R.drawable.grad_cap),
            contentDescription = "Graduation cap",
            alpha = 0.7f,
            modifier = Modifier.padding(bottom = 75.dp).size(250.dp)
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Outlined.Info,
                contentDescription = "Information",
                tint = Color.Blue,
                modifier = Modifier.padding(bottom = 21.dp, end = 2.dp).size(12.dp)
            )
            Text(
                text = "Monday 10am, Golisano Hall 4000",
                fontSize = 20.sp,
                color = Color.Blue,
                modifier = Modifier.padding(bottom = 15.dp)
            )
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Switch(
                checked = isChecked,
                onCheckedChange = {
                    isChecked = it
                }
            )
            Text(
                text = message,
                fontSize = 30.sp
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GradPreview() {
    GraduationAppTheme {
        GradScreen()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GraduationAppTheme {
        Greeting("Android")
    }
}