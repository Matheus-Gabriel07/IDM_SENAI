package com.example.listadecursos.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Cursos(
    @DrawableRes val imageResourceId : Int,
    @StringRes val stringNomeResourceId : Int,
    val stringCodigoResourceId : Int
)
