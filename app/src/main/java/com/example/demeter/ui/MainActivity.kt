package com.example.demeter.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.demeter.R
import com.example.demeter.ui.LoginSingUp.Login
import com.example.demeter.ui.LoginSingUp.Register
import com.example.demeter.ui.principal.Principal
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity(), MainContract.View {
    var auth = FirebaseAuth.getInstance()



    private var presenter: MainPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var sesion = findViewById<Button>(R.id.sesion)
        sesion.setOnClickListener{
            val intent1 = Intent(this, Login::class.java)
            startActivity(intent1)
        }

        var registrarse = findViewById<Button>(R.id.Registrarse)
        registrarse.setOnClickListener {
            val intent2 = Intent(this, Register::class.java)
            startActivity(intent2)
        }
    }

}