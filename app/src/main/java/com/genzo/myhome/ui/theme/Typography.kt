package com.genzo.myhome.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.genzo.myhome.R

private val Circe = FontFamily(
    Font(R.font.circe_regular, FontWeight.Normal),
    Font(R.font.circe_extra_bold, FontWeight.ExtraBold),
    Font(R.font.circe_bold, FontWeight.Bold),
    Font(R.font.circe_light, FontWeight.Light),
    Font(R.font.circe_thin, FontWeight.Thin),
)

private val LargeTitle = TextStyle(
    fontFamily = Circe,
    fontWeight = FontWeight.Normal,
    fontSize = 21.sp
)

private val TitleMedium = TextStyle(
    fontFamily = Circe,
    fontWeight = FontWeight.Normal,
    fontSize = 17.sp,
)

private val TitleSmall = TextStyle(
    fontFamily = Circe,
    fontWeight = FontWeight.Light,
    fontSize = 17.sp,
)

private val BodyMedium = TextStyle(
    fontFamily = Circe,
    fontWeight = FontWeight.Normal,
    fontSize = 17.sp,
)


val MyHomeTypography = Typography(
    titleLarge = LargeTitle,
    titleMedium = TitleMedium,
    titleSmall = TitleSmall,
    bodyMedium = BodyMedium,
)
