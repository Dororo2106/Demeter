package com.example.demeter.ui.principal

import android.content.Intent
import android.os.Bundle
import android.widget.CalendarView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.demeter.R
import com.example.demeter.ui.MainActivity
import com.example.demeter.ui.barradeabajo
import com.example.demeter.ui.informacion.Informacion

class Principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)



        val calendarView = findViewById<CalendarView>(R.id.Calendario)
        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            // Aquí se llama cuando se selecciona un día en el calendario
            val intent = Intent(this@Principal, barradeabajo::class.java)
            // Puedes pasar la fecha seleccionada a la actividad de información si es necesario
            intent.putExtra("year", year)
            intent.putExtra("month", month)
            intent.putExtra("day", dayOfMonth)
            startActivity(intent)
        }

        var atras = findViewById<ImageView>(R.id.regresar)
        atras.setOnClickListener{
            val intent1 = Intent(this, MainActivity::class.java)
            startActivity(intent1)
        }

    }

}
