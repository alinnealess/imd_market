package com.example.imdmarket

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ExclusaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exclusao)

        // Referenciando os elementos da interface
        val codigoEditText = findViewById<EditText>(R.id.etCodigo)
        val deletarButton = findViewById<Button>(R.id.btnDeletar)
        val limparButton = findViewById<Button>(R.id.btnLimpar)
        val voltarButton = findViewById<Button>(R.id.btnVoltar)

        // Instância do banco de dados
        val db = DatabaseHelper(this)

        // Lógica do botão Deletar
        deletarButton.setOnClickListener {
            val codigo = codigoEditText.text.toString()

            if (codigo.isBlank()) {
                Toast.makeText(this, "Por favor, insira o código do produto.", Toast.LENGTH_SHORT).show()
            } else {
                // Verificar se o produto existe
                if (!db.isProdutoExistente(codigo)) {
                    Toast.makeText(this, "Produto não encontrado!", Toast.LENGTH_SHORT).show()
                } else {
                    // Excluir o produto
                    val result = db.deleteProduto(codigo)
                    if (result > 0) {
                        Toast.makeText(this, "Produto excluído com sucesso!", Toast.LENGTH_SHORT).show()
                        // Voltar ao menu
                        val intent = Intent(this, MenuActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this, "Erro ao excluir o produto!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        // Lógica do botão Limpar
        limparButton.setOnClickListener {
            codigoEditText.text.clear()
        }

        // Lógica do botão Voltar
        voltarButton.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}