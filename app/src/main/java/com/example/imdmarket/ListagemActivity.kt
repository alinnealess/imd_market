package com.example.imdmarket

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ListagemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listagem)

        val voltarButton = findViewById<Button>(R.id.btnVoltar)

        // Configura o botão "Voltar" para retornar à tela de menu
        voltarButton.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
            finish() // Finaliza a activity atual para não acumulá-la na pilha
        }
    }
}
