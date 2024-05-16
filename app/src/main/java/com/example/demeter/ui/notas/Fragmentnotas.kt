package com.example.demeter.ui.notas

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.demeter.R

class Fragmentnotas: Fragment(), ContractNotas.View {

    private var currentView: View? = null

  /*  private var presenter: ContractNotas? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view?.setcontentview(R.layout.fragment_notas)

        presenter = PresenterNotas(this, this)
        loadInitialdata()

    }*/

    private fun loadInitialdata() {
    }
}