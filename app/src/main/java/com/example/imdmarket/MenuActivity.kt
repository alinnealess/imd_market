package com.example.imdmarket

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        // Instância do banco de dados
        val db = DatabaseHelper(this)

        // Referenciar os botões da interface
        val btnCadastrar = findViewById<Button>(R.id.btnCadastrar)
        val btnAlterar = findViewById<Button>(R.id.btnAlterar)
        val btnExcluir = findViewById<Button>(R.id.btnExcluir)
        val btnListar = findViewById<Button>(R.id.btnListar)

        // Navegação para as atividades correspondentes
        btnCadastrar.setOnClickListener {
            startActivity(Intent(this, CadastroActivity::class.java))
        }

        btnAlterar.setOnClickListener {
            startActivity(Intent(this, AlteracaoActivity::class.java))
        }

        btnExcluir.setOnClickListener {
            startActivity(Intent(this, ExclusaoActivity::class.java))
        }

        btnListar.setOnClickListener {
            startActivity(Intent(this, ListagemActivity::class.java))
        }
    }
}
