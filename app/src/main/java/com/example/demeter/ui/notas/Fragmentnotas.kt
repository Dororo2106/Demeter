package com.example.demeter.ui.notas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.demeter.R

class Fragmentnotas : Fragment(), ContractNotas.View {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflar el layout del fragmento
        return inflater.inflate(R.layout.fragment_notas, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Inicializar el presentador y cargar los datos iniciales aquí si es necesario
        val presenter = PresenterNotas(this, requireContext())
        presenter.loadInitialData()
    }
}
