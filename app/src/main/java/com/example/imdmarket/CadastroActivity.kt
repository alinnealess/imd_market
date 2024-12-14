package com.example.imdmarket

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        // Instância do banco de dados
        val db = DatabaseHelper(this)

        // Referenciar elementos da interface
        val codigoEditText = findViewById<EditText>(R.id.etCodigo)
        val nomeEditText = findViewById<EditText>(R.id.etNome)
        val descricaoEditText = findViewById<EditText>(R.id.etDescricao)
        val estoqueEditText = findViewById<EditText>(R.id.etEstoque)
        val salvarButton = findViewById<Button>(R.id.btnSalvar)
        val limparButton = findViewById<Button>(R.id.btnLimpar)
        val voltarButton = findViewById<Button>(R.id.btnVoltar)

        // Lógica para salvar produto
        salvarButton.setOnClickListener {
            val codigo = codigoEditText.text.toString()
            val nome = nomeEditText.text.toString()
            val descricao = descricaoEditText.text.toString()
            val estoque = estoqueEditText.text.toString().toIntOrNull()

            if (codigo.isBlank() || nome.isBlank() || descricao.isBlank() || estoque == null) {
                Toast.makeText(this, "Todos os campos são obrigatórios!", Toast.LENGTH_SHORT).show()
            } else {
                val produto = Produto(codigo, nome, descricao, estoque)
                val result = db.saveProduto(produto)

                if (result > 0) {
                    Toast.makeText(this, "Produto cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
                    limparCampos(codigoEditText, nomeEditText, descricaoEditText, estoqueEditText)
                } else {
                    Toast.makeText(this, "Erro ao cadastrar produto! Verifique o código.", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Lógica para limpar campos
        limparButton.setOnClickListener {
            limparCampos(codigoEditText, nomeEditText, descricaoEditText, estoqueEditText)
        }

        // Lógica para voltar ao menu
        voltarButton.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
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
