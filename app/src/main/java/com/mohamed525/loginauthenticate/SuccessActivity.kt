package com.mohamed525.loginauthenticate // package name

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mohamed525.loginauthenticate.ui.theme.LoginAuthenticateTheme

class SuccessActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {  // start of onCreate
        super.onCreate(savedInstanceState)
        setContent {
            LoginAuthenticateTheme {
                // successful login views
                SuccessScreen()
            }
        }
    } // end oncreate

    @Composable
    fun SuccessScreen() {
        // using a column as our screen is vertical
        Column(
            // it will help out Column class to cover whole screen size with padding of 15 dp
            modifier = Modifier

                .fillMaxSize()

                .padding(15.dp),


            // aligning at center vertically
            verticalArrangement = Arrangement.Center,


            // algining horizontally center by spacing from left and right automatically by compose
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // showing user success image so that user can feel that he has logged in successfully
            Image(
                // fetching resource
                painter = painterResource(id = R.drawable.success),
                contentDescription = "Success Image",
                modifier = Modifier.size(128.dp)
            )
            // adding spacer for space between success image and welcome text field
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Welcome Mohamed", fontSize = 24.sp)
        }
    }
}
