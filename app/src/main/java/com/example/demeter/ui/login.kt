package com.example.demeter.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import com.example.demeter.R
import com.example.demeter.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth


class login : AppCompatActivity() {

    private lateinit var  binding:ActivityRegisterBinding
    private lateinit var  firebaseAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth =  FirebaseAuth.getInstance()

        binding.botonregistrarse.setOnClickListener{
            val email = binding.email.text.toString()
            val contra = binding.contraseAprim.text.toString()

            if(email.isNotEmpty() && contra.isNotEmpty()){
                    firebaseAuth.signInWithEmailAndPassword(email,contra).addOnCompleteListener{
                        if(it.isSuccessful){
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                        }else
                        {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                else{
                    Toast.makeText(this, "Contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                }
        }
        var atras = findViewById<ImageView>(R.id.atras1)
        atras.setOnClickListener{
            val intent1 = Intent(this, MainActivity::class.java)
            startActivity(intent1)
        }
        }
    }
