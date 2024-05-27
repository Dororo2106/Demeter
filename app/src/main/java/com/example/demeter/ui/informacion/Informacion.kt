package com.example.demeter.ui.informacion

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.demeter.R
import com.example.demeter.ui.notas.PresenterNotas
import com.example.demeter.ui.principal.Principal
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class Informacion : Fragment(), InformacionContract.View {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflar el layout del fragmento
        val rootView = inflater.inflate(R.layout.fragment_informacion, container, false)

        // Configurar el botón de retroceso
        val backButton = rootView.findViewById<ImageButton>(R.id.atras5)
        backButton.setOnClickListener {
            val intent = Intent(requireActivity(), Principal::class.java)
            startActivity(intent)
        }

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Puedes realizar cualquier inicialización adicional aquí después de que se haya creado la vista del fragmento
        val presenter = InformacionPresenter(this, requireContext())
        presenter.loadInitialData()

        // Obtener el TextView donde mostrar la fecha
        val fechaTextView: TextView = view.findViewById(R.id.Fecha)

        // Obtener la fecha actual
        val currentDate = Calendar.getInstance().time

        // Formatear la fecha en el formato deseado (por ejemplo, "dd/MM/yyyy")
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val formattedDate = dateFormat.format(currentDate)

        // Establecer la fecha formateada en el TextView
        fechaTextView.text = formattedDate
    }
}
