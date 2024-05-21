package com.example.demeter.ui.informacion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.demeter.R
import com.example.demeter.ui.notas.PresenterNotas

class Informacion : Fragment(), InformacionContract.View {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflar el layout del fragmento
        return inflater.inflate(R.layout.fragment_informacion, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Puedes realizar cualquier inicialización adicional aquí después de que se haya creado la vista del fragmento
        val presenter = InformacionPresenter(this, requireContext())
        presenter.loadInitialData()
   }
}
