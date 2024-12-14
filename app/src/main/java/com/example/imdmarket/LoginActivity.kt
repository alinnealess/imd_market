package com.example.imdmarket

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Referências aos campos da interface
        val loginEditText = findViewById<EditText>(R.id.et_username)
        val senhaEditText = findViewById<EditText>(R.id.et_password)
        val loginButton = findViewById<Button>(R.id.btn_login)

        // Instância do DatabaseHelper
        val db = DatabaseHelper(this)

        // Lógica do botão de login
        loginButton.setOnClickListener {
            val login = loginEditText.text.toString()
            val senha = senhaEditText.text.toString()

            if (login.isBlank() || senha.isBlank()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            } else {
                // Validar credenciais no banco de dados
                val isValid = db.validateUser(login, senha)
                if (isValid) {
                    Toast.makeText(this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show()

                    // Redirecionar para a tela de menu
                    val intent = Intent(this, MenuActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Credenciais inválidas!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
