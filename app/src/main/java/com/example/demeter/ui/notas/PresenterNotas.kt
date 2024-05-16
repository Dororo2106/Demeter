package com.example.demeter.ui.notas

import android.content.Context
import com.example.demeter.data.manager.DataManager
import com.example.demeter.util.SharedPreferencesConnector

class PresenterNotas(
    private val view: ContractNotas.View,
    private val context: Context
) : ContractNotas.Presenter {
    private val connector = SharedPreferencesConnector.getInstance(context)
    private val dataManager = DataManager(context)



}





