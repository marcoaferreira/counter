

package com.marcoaferreira.counter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marcoaferreira.vm_counter.ui.theme.Vm_counterTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<ClickCountViewModel> ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Vm_counterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ClickCount(viewModel = viewModel)
                }
            }
        }
    }
}

@androidx.compose.runtime.Composable
fun ClickCount(
    modifier: Modifier = Modifier,
    viewModel: ClickCountViewModel
) {
    var count by remember { mutableIntStateOf(viewModel.getCount()) }

    Column (
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            fontSize = 34.sp,
            text = count.toString()
        )

        Button(onClick = {
            viewModel.increment()
            count = viewModel.getCount()
        }) {
            Text(text = "Increment")
        }
    }
}
