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

        // Referenciando os elementos da interface
        val codigoEditText = findViewById<EditText>(R.id.etCodigo)
        val nomeEditText = findViewById<EditText>(R.id.etNome)
        val descricaoEditText = findViewById<EditText>(R.id.etDescricao)
        val estoqueEditText = findViewById<EditText>(R.id.etEstoque)
        val salvarButton = findViewById<Button>(R.id.btnSalvar)
        val limparButton = findViewById<Button>(R.id.btnLimpar)
        val voltarButton = findViewById<Button>(R.id.btnVoltar)

        // Lógica do botão Salvar
        salvarButton.setOnClickListener {
            val codigo = codigoEditText.text.toString()
            val nome = nomeEditText.text.toString()
            val descricao = descricaoEditText.text.toString()
            val estoque = estoqueEditText.text.toString()

            // Verificar se todos os campos estão preenchidos
            if (codigo.isBlank() || nome.isBlank() || descricao.isBlank() || estoque.isBlank()) {
                Toast.makeText(this, "Todos os campos são obrigatórios!", Toast.LENGTH_SHORT).show()
            } else {
                // Exibir mensagem de sucesso
                Toast.makeText(this, "Produto cadastrado com sucesso!", Toast.LENGTH_SHORT).show()

                // Redirecionar automaticamente para a tela de menu
                val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        // Lógica do botão Limpar
        limparButton.setOnClickListener {
            codigoEditText.text.clear()
            nomeEditText.text.clear()
            descricaoEditText.text.clear()
            estoqueEditText.text.clear()
        }

        // Lógica do botão Voltar
        voltarButton.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
