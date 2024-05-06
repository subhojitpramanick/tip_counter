package com.example.testforme

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testforme.ui.theme.TestFORmeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestFORmeTheme {
                MyApp()
            }
        }
    }
/*
the main activity cotains a
*/


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestFORmeTheme (darkTheme = true){
            MyApp()
    }
}
// this composable is used for the main activity
@Composable
fun MyApp() {
    var moneyCounter by remember {
        mutableStateOf(0)
    }
// this surface contains the text and the button
    Surface(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        color = Color(0xFF1B7466),
    ) {
        // this box contains the text and the button
        Box (modifier = Modifier.fillMaxSize().padding(30.dp)
            .padding(horizontal = 0.dp, vertical = 20.dp
            ),
            contentAlignment = Alignment.TopCenter) {
            Text(text="MONEY COUNTER",
                color = Color.DarkGray,
                fontSize = 45.sp,
                textAlign = TextAlign.Center,
                lineHeight = 40.sp,
                fontFamily = FontFamily.Monospace)
        }
        // this column contains the text and the button that
        // is inside the box display the money counter
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text="$moneyCounter $", style = TextStyle(color = Color.White,
                fontWeight = FontWeight.Bold,fontSize = 45.sp,
                fontFamily = FontFamily.Cursive))
            Spacer(modifier = Modifier.height((140.dp)))
            CreateCircle("TAP",
                MoneyCounter=moneyCounter,
                ){
                    newMoneyCounter ->
                moneyCounter = newMoneyCounter
            }
            if(moneyCounter>300){
                Text(text="lots of money",
                    style = TextStyle(color = Color.White,
                        fontWeight = FontWeight.Bold,fontSize = 45.sp,
                        fontFamily = FontFamily.Cursive))
                if(moneyCounter>350){
                    moneyCounter=0
            }
        }
    }
}}
// composable function for creating the circle
@Composable
fun CreateCircle(name: String = "TAP",
                 MoneyCounter: Int = 0,
                 updateMoneyCounter: (Int) -> Unit) {

    Card(
        modifier = Modifier
            .padding(3.dp)
            .size(150.dp)
            .clickable {
                updateMoneyCounter(MoneyCounter + 10)
                //                moneyCounter += 100
                Log.d("Tap", "Tap $MoneyCounter")
            },
        colors = CardDefaults.cardColors(Color.LightGray),
        shape = CircleShape,
        content = {
            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center){
                    Text(text="$name",
                        color = Color.DarkGray,
                        textAlign = TextAlign.Center,
                        fontSize = 35.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight= FontWeight.Bold)
            }
        }
    )
}}

