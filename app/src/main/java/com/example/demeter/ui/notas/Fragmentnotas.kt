package com.example.demeter.ui.notas

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.demeter.R
import com.example.demeter.ui.principal.Principal

class Fragmentnotas : Fragment(), ContractNotas.View {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflar el layout del fragmento
        val rootView = inflater.inflate(R.layout.fragment_notas, container, false)

        // Configurar el botón de retroceso
        val atras = rootView.findViewById<ImageButton>(R.id.atras3)
        atras.setOnClickListener {
            val intent1 = Intent(requireActivity(), Principal::class.java)
            startActivity(intent1)
        }

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Inicializar el presentador y cargar los datos iniciales aquí si es necesario
        val presenter = PresenterNotas(this, requireContext())
        presenter.loadInitialData()



    }
}
