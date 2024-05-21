package com.example.demeter.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.demeter.R
import com.example.demeter.informacion
import com.example.demeter.ui.informacion.Informacion
import com.example.demeter.ui.notas.Fragmentnotas
import com.example.demeter.ui.sintomas.Sintomas
import com.google.android.material.bottomnavigation.BottomNavigationView

class barradeabajo : AppCompatActivity(), MainContract.View
{

    var bottomNav : BottomNavigationView? = null
    private var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barra_de_abajo)
        bottomNav = findViewById<BottomNavigationView>(R.id.navigation)

        presenter = MainPresenter(this,this)
        loadInitialdata()
    }

    private fun loadInitialdata() {
        //  presenter?.getWeather()
        bottomNav?.setOnItemSelectedListener {
            when(it.itemId){
                R.id.item1 -> {
                    loadFragment(Informacion())
                    true
                }
                R.id.item2 -> {
                    loadFragment(Sintomas())
                    true
                }
                R.id.item3 -> {
                    loadFragment(Fragmentnotas())
                    true
                }

                else -> {
                    //  loadFragment(HomeFragment())
                    true
                }
            }
        }

        bottomNav!!.selectedItemId = R.id.item2

    }


    private fun loadFragment (fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_container, fragment)
        transaction.commit()
    }
}