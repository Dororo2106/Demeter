package com.example.demeter.ui.LoginSingUp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.example.demeter.R
import com.example.demeter.databinding.ActivityRegisterBinding
import com.example.demeter.ui.MainActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore
import java.security.Principal

class Register : AppCompatActivity() {
    private lateinit var  binding:ActivityRegisterBinding
    private lateinit var  firebaseAuth : FirebaseAuth
    val db = Firebase.firestore



    override fun onCreate(savedInstanceState: Bundle?) {
        var principal = findViewById<Button>(R.id.botonregistrarse)
        principal.setOnClickListener{
            val intent2 = Intent(this, Principal::class.java)
            startActivity(intent2)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth =  FirebaseAuth.getInstance()

        binding.botonregistrarse.setOnClickListener{
            val email = binding.email.text.toString()
            val contra = binding.contraseAprim.text.toString()
            val confirmacontra = binding.confirmcontra.text.toString()

            if(email.isNotEmpty() && contra.isNotEmpty() && confirmacontra.isNotEmpty()){
                if(contra.equals(confirmacontra)){
                    firebaseAuth.createUserWithEmailAndPassword(email,contra).addOnCompleteListener{
                        if(it.isSuccessful){
                            val intent = Intent(this, login::class.java)
                            startActivity(intent)
                        }else
                        {
                            Toast.makeText(this, it.exception.toString(),Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                else{
                    Toast.makeText(this, "Contraseñas no coinciden",Toast.LENGTH_SHORT).show()
                }
            }else
            {
                Toast.makeText(this, "Dejo un espacio vacio",Toast.LENGTH_SHORT).show()
            }


        }
        var atras = findViewById<ImageButton>(R.id.atras2)
        atras.setOnClickListener{
            val intent1 = Intent(this, MainActivity::class.java)
            startActivity(intent1)
        }
    }
}