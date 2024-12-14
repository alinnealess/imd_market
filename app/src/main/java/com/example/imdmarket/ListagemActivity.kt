package com.example.imdmarket

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ListagemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listagem)

        // Referenciando elementos da interface
        val listView = findViewById<ListView>(R.id.lvProdutos)
        val voltarButton = findViewById<Button>(R.id.btnVoltar)

        // Instância do banco de dados
        val db = DatabaseHelper(this)

        // Buscar produtos do banco de dados
        val produtos = db.listAllProdutos()

        // Configurar o adaptador para o ListView
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            produtos.map { produto ->
                """
                ${produto.codigoProduto} - ${produto.nomeProduto}
                Descrição: ${produto.descricaoProduto}
                Quantidade: ${produto.estoque}
                """.trimIndent()
            }
        )
        listView.adapter = adapter

        // Lógica do botão Voltar
        voltarButton.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
            finish()
        }
    }
}
