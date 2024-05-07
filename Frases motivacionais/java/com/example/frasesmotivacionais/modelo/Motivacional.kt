package com.example.frasesmotivacionais.modelo

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Motivacional(
    @StringRes val stringResourceId : Int,
    @DrawableRes val imageResourceId : Int
)