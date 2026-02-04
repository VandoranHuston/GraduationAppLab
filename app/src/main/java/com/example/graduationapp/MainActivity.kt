package com.example.graduationapp

import android.media.Image
import android.os.Bundle
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
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.graduationapp.ui.theme.GraduationAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GraduationAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
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
            alpha = 0.7f
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Outlined.Info,
                contentDescription = "Information",
                tint = Color.Blue,
                modifier = Modifier.padding(bottom = 6.dp, end = 2.dp).size(12.dp)
            )
            Text(
                text = "Monday 10am, Golisano Hall 4000",
                fontSize = 20.sp,
                color = Color.Blue
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