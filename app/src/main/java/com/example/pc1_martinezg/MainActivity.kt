package com.example.pc1_martinezg

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etFinal: EditText = findViewById(R.id.et_final)
        val etParcial: EditText = findViewById(R.id.et_parcial)
        val etPEP:EditText = findViewById(R.id.et_pep)

        val notaFinal_String = etFinal.text.toString()
        val notaParcial_String = etParcial.text.toString()
        val notaPep_String = etPEP.text.toString()

        val notaFinal = notaFinal_String.toDoubleOrNull() ?: 0.0
        val notaParcial = notaParcial_String.toDoubleOrNull() ?: 0.0
        val notaPep = notaPep_String.toDoubleOrNull() ?: 0.0

        val promedio = (notaFinal + notaParcial + notaPep) / 3

        val promedioString = promedio.toString()

        val btn_calc : Button = findViewById(R.id.btn_calcular)
        btn_calc.setOnClickListener{
            this.enviar_resultado(promedioString)
        }




    }

    public fun enviar_resultado(prom: String){
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("param",prom)
        startActivity(intent)
    }
}