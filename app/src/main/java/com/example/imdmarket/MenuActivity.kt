package com.example.imdmarket

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        // Referenciando os botões
        val btnCadastrar = findViewById<Button>(R.id.btnCadastrar)
        val btnAlterar = findViewById<Button>(R.id.btnAlterar)
        val btnExcluir = findViewById<Button>(R.id.btnExcluir)
        val btnListar = findViewById<Button>(R.id.btnListar)

        // Configurando os botões para abrir novas atividades
        btnCadastrar.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }

        btnAlterar.setOnClickListener {
            val intent = Intent(this, AlteracaoActivity::class.java)
            startActivity(intent)
        }

        btnExcluir.setOnClickListener {
            val intent = Intent(this, ExclusaoActivity::class.java)
            startActivity(intent)
        }

        btnListar.setOnClickListener {
            val intent = Intent(this, ListagemActivity::class.java)
            startActivity(intent)
        }
    }
}
