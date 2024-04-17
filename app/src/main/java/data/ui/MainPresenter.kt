package data.ui

import android.content.Context
import data.manager.DataManager
import data.util.SharedPreferencesConnector
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainPresenter(
    private val view: MainContract.View,
    private val context: Context
) : MainContract.Presenter {
    private val connector = SharedPreferencesConnector.getInstance(context)
    private val dataManager = DataManager(context)


    /*override fun getWeather() {
        val observable = dataManager.getName()
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Subscriber<WeatherResponse>() {

                override fun onError(e: Throwable?) {
                    e?.printStackTrace()
                }

                override fun onNext(t: WeatherResponse) {
                    view.showWeather(t.main!!.feels_like.toString())
                    view.showWeather(t.main!!.temp_max.toString())
                }

                override fun onCompleted() {
                    // no necesario
                }
            })*/
    }
