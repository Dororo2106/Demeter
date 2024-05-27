package com.example.demeter.ui.sintomas

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.demeter.R
import com.example.demeter.ui.MainActivity
import com.example.demeter.ui.principal.Principal

class Sintomas: Fragment(), ContractSintomas.View {

    private var currentView: View? = null
    private var presenter: ContractSintomas.Presenter? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (currentView != null) {
            return currentView

        }else{
            currentView = inflater.inflate(R.layout.fragment_sintomas, container, false)
            val atras = currentView?.findViewById<ImageButton>(R.id.atras)
            atras?.setOnClickListener {
                val intent1 = Intent(requireActivity(), Principal::class.java)
                startActivity(intent1)
            }

            return currentView
        }

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = context?.let { PresenterSintomas(this, it) }
    }

    private fun hideEmptyState(){
    }

}