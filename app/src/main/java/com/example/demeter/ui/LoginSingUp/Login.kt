package com.example.demeter.ui.LoginSingUp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import com.example.demeter.R
import com.example.demeter.databinding.ActivityRegisterBinding
import com.example.demeter.ui.MainActivity
import com.google.firebase.auth.FirebaseAuth
import java.security.Principal


class Login : AppCompatActivity() {

    private var auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val olvidocontra = findViewById<TextView>(R.id.olvidocontra)
        val content = SpannableString("Olvido su contraseña")
        content.setSpan(UnderlineSpan(), 0, content.length, 0)
        olvidocontra.text = content

       /* val signUpTextView = findViewById<TextView>(R.id.txtSignUp)
        signUpTextView.setOnClickListener {
            // Intent para iniciar MainActivity_SignUp
            val intent = Intent(this, MainActivity_SignUp::class.java)
            startActivity(intent)
        }*/

        val emailText = findViewById<TextView>(R.id.email)
        val passwordText = findViewById<TextView>(R.id.contraseñai)
        val button1 = findViewById<Button>(R.id.botoniniciosesion)

        button1.setOnClickListener{
            val email = emailText.text.toString()
            val password = passwordText.text.toString()

            if (email.isEmpty()) {
                Toast.makeText(this, "Ingresar Email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                Toast.makeText(this, "Ingresar Contraseña", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(applicationContext, "Se inicio sesion correctamente ", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@Login, com.example.demeter.ui.principal.Principal::class.java)
                        startActivity(intent)
                        finish()

                    } else {
                        Toast.makeText(
                            this@Login,
                            "La contraseña o correo no son correctas.",
                            Toast.LENGTH_SHORT,
                        ).show()
                    }
                }



        }

        var atras = findViewById<ImageView>(R.id.atras1)
        atras.setOnClickListener{
            val intent1 = Intent(this, MainActivity::class.java)
            startActivity(intent1)
        }
        }
    }
