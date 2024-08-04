package com.mohamed525.loginauthenticate // package name

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.text.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mohamed525.loginauthenticate.ui.theme.LoginAuthenticateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { // start of onCreate
        super.onCreate(savedInstanceState)
        setContent {
            LoginAuthenticateTheme {
                // calling compose funciton for login fields
                LoginScreen()

            }
        }
    } // end of onCreate

    @Composable
    fun LoginScreen() {

        // creating two variables of mutable type so that to hold changes for username and password
        var username by remember { mutableStateOf("") }

        var password by remember { mutableStateOf("") }

        var passwordVisible by remember { mutableStateOf(false) }


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


            // displaying text field to user so that user can see what type of screen it is
            Text(text = "Hey! Welcome to Login Screen", fontSize = 28.sp)



            // Adding a spacer between text fields for better view
            Spacer(modifier = Modifier.height(20.dp))



            // outlined text field will be having green border color
            OutlinedTextField(
                value = username,
                // to get changes in user username fields
                onValueChange = { username = it },
                label = { Text("Enter UserName:") },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black)
            )


            // adding a spacer for vertical distance between username and password textfields
            Spacer(modifier = Modifier.height(16.dp))


            // using same outline text field but it will be password specific
            OutlinedTextField(
                value = password,
                // to get changes in user password field
                onValueChange = { password = it },
                label = { Text("Enter Password:") },
                textStyle = TextStyle(color = Color.Red),
                // it will help us to type passwords in astericks

                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if (passwordVisible) {
                        Icons.Filled.Visibility
                    } else {
                        Icons.Filled.VisibilityOff
                    }

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(imageVector = image, contentDescription = null)
                    }
                },
                modifier = Modifier.fillMaxWidth()

            )

            Spacer(modifier = Modifier.height(16.dp)) // space is added here again for distance between password field and login button


            Button(
                //  onclick event where username password will be compare
                onClick = {


                    // credentials for login
                    val user = "Mohamed"
                    val pass = "300752525"

                    if (username == user  && password == pass)
                    {
                        val intent = Intent(this@MainActivity, SuccessActivity::class.java)
                        startActivity(intent)
                    }
                    // in case of any wrong field, user will be shown Login Failed via Toast class
                    else
                    {
                        Toast.makeText(this@MainActivity, "Login Failed", Toast.LENGTH_SHORT).show()
                    }
                },

                // this ensures border corners are circular
                shape = RoundedCornerShape(50),

                // color is green
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF77A450)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Login")
            }
        }
    }
}
