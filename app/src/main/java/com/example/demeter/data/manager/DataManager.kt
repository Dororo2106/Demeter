package com.example.demeter.data.manager

import android.content.Context
import com.example.demeter.data.model.UserResponse
import com.example.demeter.data.remote.api.API
import com.example.demeter.data.remote.client.ServiceGenerator
import com.example.demeter.util.SharedPreferencesConnector
import rx.Observable

class DataManager(val context: Context) {

    private val connector = SharedPreferencesConnector.getInstance(context)
/*
    fun getName()  : Observable<UserResponse> {

        return ServiceGenerator.createService(API::class.java,context).login()

    }*/


}