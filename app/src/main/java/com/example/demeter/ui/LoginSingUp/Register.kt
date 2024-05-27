package com.example.demeter.ui.LoginSingUp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.demeter.R
import com.example.demeter.databinding.ActivityRegisterBinding
import com.example.demeter.ui.MainActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore
import java.security.Principal

class Register : AppCompatActivity() {
    var auth = FirebaseAuth.getInstance()
    private var lastPeriodDate: String? = null // Variable para almacenar la fecha del último día del periodo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val emailText = findViewById<TextView>(R.id.numcel)
        val contra = findViewById<TextView>(R.id.contraseñaprim)
        val confirmarcontra = findViewById<TextView>(R.id.confirmcontra)
        val button = findViewById<Button>(R.id.botonregistrarse)
        button.setOnClickListener {
            showLastPeriodDateDialog()
        }

        button.setOnClickListener{
            val email = emailText.text.toString()
            val password = contra.text.toString()

            if (email.isEmpty()) {
                Toast.makeText(this, "Ingresar Email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                Toast.makeText(this, "Ingresar Contraseña", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(
                            this@Register,
                            "Cuenta Creada.",
                            Toast.LENGTH_SHORT
                        ).show()
                        val intent = Intent(this@Register, com.example.demeter.ui.principal.Principal::class.java)
                        startActivity(intent)
                        finish()

                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(
                            this@Register,
                            "Creacion de cuenta fallida.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }

        var atras = findViewById<ImageButton>(R.id.atras2)
        atras.setOnClickListener{
            val intent1 = Intent(this, MainActivity::class.java)
            startActivity(intent1)
        }
    }
    private fun showLastPeriodDateDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Ingresa la fecha de tu último periodo")

        val datePicker = DatePicker(this)
        datePicker.maxDate = System.currentTimeMillis() // Para que no pueda seleccionar fechas futuras

        builder.setView(datePicker)

        builder.setPositiveButton("Aceptar") { _, _ ->
            val day = datePicker.dayOfMonth
            val month = datePicker.month + 1 // Los meses en DatePicker comienzan desde 0
            val year = datePicker.year

            lastPeriodDate = "$day/$month/$year"

            // Ahora puedes hacer lo que quieras con lastPeriodDate
            // Por ejemplo, puedes iniciar la actividad principal aquí
            val intent = Intent(this@Register, MainActivity::class.java)
            intent.putExtra("lastPeriodDate", lastPeriodDate)
            startActivity(intent)
        }

        builder.setNegativeButton("Cancelar") { dialog, _ ->
            dialog.cancel()
        }

        builder.show()
    }
}