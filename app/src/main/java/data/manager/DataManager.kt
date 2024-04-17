package data.manager

import android.content.Context
import data.model.UserResponse
import data.remote.api.API
import data.remote.client.ServiceGenerator
import data.util.SharedPreferencesConnector
import rx.Observable

class DataManager(val context: Context) {

    private val connector = SharedPreferencesConnector.getInstance(context)
/*
    fun getName()  : Observable<UserResponse> {

        return ServiceGenerator.createService(API::class.java,context).login()

    }*/


}