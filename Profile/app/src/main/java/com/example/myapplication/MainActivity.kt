package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.ColorFilter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileScreen()
        }
    }
}

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(16.dp)
    ) {
        // Top Bar
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            // Custom Back Button
            Image(
                painter = painterResource(id = R.drawable.back),
                contentDescription = "Back",
                modifier = Modifier
                    .size(30.dp)
                    .clickable { /* TODO: Handle back button click */ },
                colorFilter = ColorFilter.tint(Color.White)
            )

            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = "Profile",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.weight(1f)) // Push support button to the right
            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2C2C2C)),
                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.support),
                    contentDescription = "Support Logo",
                    modifier = Modifier.size(19.dp),
                    colorFilter = ColorFilter.tint(Color.White)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text("support", color = Color.White, fontSize = 12.sp)
            }
        }

        // Profile Header
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = "Kazuaki",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                )
                Text(
                    text = "member since Dec, 2020",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Edit,
                    contentDescription = "Edit Profile",
                    tint = Color.White
                )
            }
        }

        // CRED Garage Section
        Card(
            colors = CardDefaults.cardColors(containerColor = Color(0xFF2C2C2C)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.car),
                    contentDescription = "Car Icon",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = "get to know your vehicles, inside out",
                        color = Color.White,
                        fontSize = 14.sp
                    )
                    Text(
                        text = "CRED garage",
                        color = Color(0xFF00FF99),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Filled.ArrowForward,
                    contentDescription = "Go to Garage",
                    tint = Color.White
                )
            }
        }

        // Account Info
        AccountInfoRow(
            label = "credit score",
            value = "757",
            iconId = R.drawable.ruppe,
            isRefreshAvailable = true
        )
        AccountInfoRow(
            label = "lifetime cashback",
            value = "₹3",
            iconId = R.drawable.ruppe
        )
        AccountInfoRow(
            label = "bank balance",
            value = "check",
            iconId = R.drawable.upi
        )

        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "YOUR REWARDS & BENEFITS",
            color = Color.Gray,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        RewardRow(label = "cashback balance", value = "₹0")
        RewardRow(label = "coins", value = "26,46,583")
        RewardRow(label = "win upto ₹ 1000", subLabel = "refer and earn")

        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "TRANSACTIONS & SUPPORT",
            color = Color.Gray,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        TransactionRow(label = "all transactions")
    }
}

@Composable
fun AccountInfoRow(
    label: String,
    value: String,
    @androidx.annotation.DrawableRes iconId: Int,
    isRefreshAvailable: Boolean = false
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f)
        ) {
            Image( // Use Image instead of Icon
                painter = painterResource(id = iconId),
                contentDescription = label,
                modifier = Modifier.size(20.dp),
                colorFilter = ColorFilter.tint(Color.Gray) 
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = label, color = Color.Gray, fontSize = 14.sp)
            if (isRefreshAvailable) {
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "REFRESH AVAILABLE",
                    color = Color(0xFF00FF99),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Text(
            text = value,
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp
        )
        Icon(
            imageVector = Icons.Filled.ArrowForward,
            contentDescription = "See Details",
            tint = Color.Gray,
            modifier = Modifier.size(16.dp)
        )
    }
}

@Composable
fun RewardRow(label: String, value: String? = null, subLabel: String? = null) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = label,
            color = Color.White,
            fontSize = 14.sp,
            modifier = Modifier.weight(1f)
        )
        if (value != null) {
            Text(
                text = value,
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }
        if (subLabel != null) {
            Text(
                text = subLabel,
                color = Color.Gray,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Icon(
            imageVector = Icons.Filled.ArrowForward,
            contentDescription = "See Details",
            tint = Color.Gray,
            modifier = Modifier.size(16.dp)
        )
    }
}

@Composable
fun TransactionRow(label: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = label,
            color = Color.White,
            fontSize = 14.sp,
            modifier = Modifier.weight(1f)
        )
        Icon(
            imageVector = Icons.Filled.ArrowForward,
            contentDescription = "See All Transactions",
            tint = Color.Gray,
            modifier = Modifier.size(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProfileScreen()
}