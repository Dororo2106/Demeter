package data.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.demeter.R

class MainActivity : AppCompatActivity(),MainContract.View {

    //private var presenter: MainPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        var sesion = findViewById<Button>(R.id.sesion)
        sesion.setOnClickListener{
            val intent1 = Intent(this,login::class.java)
            startActivity(intent1)
        }

        var registrarse = findViewById<Button>(R.id.Registrarse)
        registrarse.setOnClickListener{
            val intent2 = Intent(this,Register::class.java)
            startActivity(intent2)
        }

        /*     presenter = MainPresenter(this,this)
        loadInitialdata()
    }

    private fun loadInitialdata() {
        presenter?.getWeather()
    }*/


        /*override fun showWeather(climate: String) {
        findViewById<TextView>(R.id.climaActual).text = climate
    }*/
    }

}