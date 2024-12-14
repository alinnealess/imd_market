package com.example.imdmarket

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AlteracaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alteracao)

        // Referenciando os elementos da interface
        val codigoEditText = findViewById<EditText>(R.id.etCodigo)
        val nomeEditText = findViewById<EditText>(R.id.etNome)
        val descricaoEditText = findViewById<EditText>(R.id.etDescricao)
        val estoqueEditText = findViewById<EditText>(R.id.etEstoque)
        val salvarButton = findViewById<Button>(R.id.btnSalvar)
        val limparButton = findViewById<Button>(R.id.btnLimpar)
        val voltarButton = findViewById<Button>(R.id.btnVoltar)

        // Instância do banco de dados
        val db = DatabaseHelper(this)

        // Lógica do botão Salvar
        salvarButton.setOnClickListener {
            val codigo = codigoEditText.text.toString()
            val nome = nomeEditText.text.toString().ifBlank { null }
            val descricao = descricaoEditText.text.toString().ifBlank { null }
            val estoque = estoqueEditText.text.toString().toIntOrNull()

            if (codigo.isBlank()) {
                Toast.makeText(this, "O código do produto é obrigatório!", Toast.LENGTH_SHORT).show()
            } else if (!db.isProdutoExistente(codigo)) {
                Toast.makeText(this, "Produto não encontrado!", Toast.LENGTH_SHORT).show()
            } else {
                // Atualizar o produto
                val produto = Produto(
                    codigoProduto = codigo,
                    nomeProduto = nome ?: "",
                    descricaoProduto = descricao ?: "",
                    estoque = estoque ?: 0
                )
                val result = db.updateProduto(produto)
                if (result > 0) {
                    Toast.makeText(this, "Produto alterado com sucesso!", Toast.LENGTH_SHORT).show()
                    // Voltar ao menu
                    val intent = Intent(this, MenuActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Erro ao alterar o produto!", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Lógica do botão Limpar
        limparButton.setOnClickListener {
            limparCampos(codigoEditText, nomeEditText, descricaoEditText, estoqueEditText)
        }

        // Lógica do botão Voltar
        voltarButton.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun limparCampos(
        codigoEditText: EditText,
        nomeEditText: EditText,
        descricaoEditText: EditText,
        estoqueEditText: EditText
    ) {
        codigoEditText.text.clear()
        nomeEditText.text.clear()
        descricaoEditText.text.clear()
        estoqueEditText.text.clear()
    }
}
