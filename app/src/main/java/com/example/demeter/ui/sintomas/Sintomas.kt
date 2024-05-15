package com.example.demeter.ui.sintomas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demeter.R
import com.example.demeter.ui.notas.ContractNotas
import com.example.demeter.ui.notas.PresenterNotas

class Sintomas: Fragment(), ContractSintomas.View {

    private var currentView: View? = null
    private var presenter: ContractSintomas.Presenter? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (currentView != null) {
            return currentView
        }else{
            currentView = inflater.inflate(R.layout.fragment_sintomas, container, false)
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