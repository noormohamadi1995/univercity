package com.example.univercity.model

import androidx.annotation.DrawableRes

data class Food(
    val id : Int? = null,
    val name : String,
    val price : String,
    @DrawableRes val img : Int,
    val type : String,
    val date : String,
    var reserveState : Boolean
)
