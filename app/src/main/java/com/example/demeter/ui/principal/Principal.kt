package com.example.demeter.ui.principal

import android.content.Intent
import android.os.Bundle
import android.widget.CalendarView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.demeter.R
import com.example.demeter.informacion
import com.example.demeter.ui.MainActivity
import com.example.demeter.ui.barradeabajo
import com.example.demeter.ui.informacion.Informacion
import java.util.Calendar

class Principal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        val calendarView = findViewById<CalendarView>(R.id.Calendario)
        // Obtener la fecha actual
        val currentDate = Calendar.getInstance()
        val currentYear = currentDate.get(Calendar.YEAR)
        val currentMonth = currentDate.get(Calendar.MONTH)
        val currentDay = currentDate.get(Calendar.DAY_OF_MONTH)
        val minDate = Calendar.getInstance()
        minDate.set(Calendar.DAY_OF_WEEK, minDate.firstDayOfWeek)
        calendarView.minDate = minDate.timeInMillis

        val maxDate = Calendar.getInstance()
        maxDate.set(Calendar.DAY_OF_WEEK, maxDate.firstDayOfWeek + 6)
        calendarView.maxDate = maxDate.timeInMillis

        // Marcar el día actual
        val currentDayMillis = currentDate.timeInMillis
        calendarView.setDate(currentDayMillis, true, true)

        // Resaltar la semana actual
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val selectedDate = Calendar.getInstance()
            selectedDate.set(year, month, dayOfMonth)

            if (selectedDate.after(minDate) && selectedDate.before(maxDate)) {
                // Resaltar el día seleccionado
                calendarView.setDate(selectedDate.timeInMillis, true, true)

                // Si el día seleccionado es igual al día actual, abrir la actividad de información
                if (dayOfMonth == currentDay && month == currentMonth && year == currentYear) {
                    val intent = Intent(this, barradeabajo::class.java)
                    intent.putExtra("year", year)
                    intent.putExtra("month", month)
                    intent.putExtra("day", dayOfMonth)
                    startActivity(intent)
                }
            } else {
                // Cambiar de mes, entonces volver a resaltar la semana actual
                calendarView.setDate(currentDayMillis, true, true)
            }
        }

        val atras = findViewById<ImageView>(R.id.regresar)
        atras.setOnClickListener {
            val intent1 = Intent(this, MainActivity::class.java)
            startActivity(intent1)
        }
    }
}