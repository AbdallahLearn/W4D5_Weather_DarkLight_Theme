package com.example.w4d5_materialdesign

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.w4d5_materialdesign.ui.theme.W4D5_MaterialDesignTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            W4D5_MaterialDesignTheme { // Apply the custom theme
                WeatherApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherApp() {
    val context = LocalContext.current
    val isRtl = context.resources.configuration.layoutDirection == View.LAYOUT_DIRECTION_RTL

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.app_name), style = MaterialTheme.typography.titleLarge) }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MainWeatherCard(temp = "25°C", condition = stringResource(id = R.string.sunny))
            Spacer(modifier = Modifier.height(20.dp))
            ForecastSection(isRtl)
        }
    }
}


@Composable
fun MainWeatherCard(temp: String, condition: String) {
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(id = R.string.current_weather), fontSize = 18.sp, color = Color.White)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = temp, fontSize = 32.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Text(text = condition, fontSize = 20.sp, color = Color.White)
        }
    }
}

@Composable
fun ForecastSection(isRtl: Boolean) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = R.string.forecast), fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(10.dp))
        ForecastCard(day = stringResource(id = R.string.monday), temp = "22°C", condition = stringResource(id = R.string.cloudy), isRtl)
        ForecastCard(day = stringResource(id = R.string.tuesday), temp = "20°C", condition = stringResource(id = R.string.rainy), isRtl)
        ForecastCard(day = stringResource(id = R.string.wednesday), temp = "24°C", condition = stringResource(id = R.string.clear), isRtl)
    }
}

@Composable
fun ForecastCard(day: String, temp: String, condition: String, isRtl: Boolean) {
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp, horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = if (isRtl) Arrangement.Start else Arrangement.SpaceAround
        ) {
            Text(text = day, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Text(text = temp, fontSize = 16.sp, color = Color.White)
            Text(text = condition, fontSize = 16.sp, color = Color.White)
        }
    }
}
