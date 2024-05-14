package com.example.demeter

import android.content.Intent
import com.example.demeter.ui.MainActivity
import com.github.terrakok.cicerone.androidx.ActivityScreen

object Screens {

    fun Main() = ActivityScreen {
        Intent(it, MainActivity::class.java)
    }

}