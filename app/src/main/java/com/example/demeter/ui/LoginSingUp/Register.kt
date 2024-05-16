package com.example.demeter.ui.LoginSingUp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.example.demeter.R
import com.example.demeter.databinding.ActivityRegisterBinding
import com.example.demeter.ui.MainActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore
import java.security.Principal

class Register : AppCompatActivity() {
    var auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        /*val signInTextView = findViewById<TextView>(R.id.txtSign)
        signInTextView.setOnClickListener {
            // Intent para iniciar MainActivity_SignUp
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }*/

        val emailText = findViewById<TextView>(R.id.numcel)
        val contra = findViewById<TextView>(R.id.contraseñaprim)
        val confirmarcontra = findViewById<TextView>(R.id.confirmcontra)
        val button = findViewById<Button>(R.id.botonregistrarse)


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
}