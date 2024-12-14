package com.example.imdmarket

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "IMDMarketDB", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            """
            CREATE TABLE produtos (
                codigo INTEGER PRIMARY KEY,
                nome TEXT NOT NULL,
                descricao TEXT NOT NULL,
                estoque INTEGER NOT NULL
            )
            """
        )
        db?.execSQL(
            """
            CREATE TABLE usuarios (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                login TEXT NOT NULL UNIQUE,
                senha TEXT NOT NULL
            )
            """
        )
        db?.execSQL(
            """
            INSERT INTO usuarios (login, senha) VALUES ('admin', 'admin')
            """
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS produtos")
        db?.execSQL("DROP TABLE IF EXISTS usuarios")
        onCreate(db)
    }

    fun saveProduto(produto: Produto): Long {
        val db = writableDatabase
        val values = ContentValues()
        values.put("codigo", produto.codigoProduto.toInt())
        values.put("nome", produto.nomeProduto)
        values.put("descricao", produto.descricaoProduto)
        values.put("estoque", produto.estoque)

        val result = db.insert("produtos", null, values)
        db.close()
        return result
    }

    fun updateProduto(produto: Produto): Int {
        val db = writableDatabase
        val values = ContentValues()
        values.put("nome", produto.nomeProduto)
        values.put("descricao", produto.descricaoProduto)
        values.put("estoque", produto.estoque)

        val result = db.update("produtos", values, "codigo = ?", arrayOf(produto.codigoProduto))
        db.close()
        return result
    }

    fun deleteProduto(codigo: String): Int {
        val db = writableDatabase
        val result = db.delete("produtos", "codigo = ?", arrayOf(codigo))
        db.close()
        return result
    }

    fun listAllProdutos(): ArrayList<Produto> {
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM produtos ORDER BY codigo ASC", null) // Ordenado por codigo
        val produtos = ArrayList<Produto>()

        if (cursor.count > 0) {
            cursor.moveToFirst()
            do {
                val codigo = cursor.getInt(cursor.getColumnIndexOrThrow("codigo")).toString()
                val nome = cursor.getString(cursor.getColumnIndexOrThrow("nome"))
                val descricao = cursor.getString(cursor.getColumnIndexOrThrow("descricao"))
                val estoque = cursor.getInt(cursor.getColumnIndexOrThrow("estoque"))
                produtos.add(Produto(codigo, nome, descricao, estoque))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return produtos
    }

    fun validateUser(login: String, senha: String): Boolean {
        val db = readableDatabase
        val cursor = db.rawQuery(
            "SELECT * FROM usuarios WHERE login = ? AND senha = ?",
            arrayOf(login, senha)
        )
        val isValid = cursor.count > 0
        cursor.close()
        db.close()
        return isValid
    }

    fun isProdutoExistente(codigo: String): Boolean {
        val db = readableDatabase
        val cursor = db.rawQuery(
            "SELECT * FROM produtos WHERE codigo = ?",
            arrayOf(codigo)
        )
        val exists = cursor.count > 0
        cursor.close()
        db.close()
        return exists
    }
    fun getProdutoByCodigo(codigo: String): Produto? {
        val db = readableDatabase
        val cursor = db.rawQuery(
            "SELECT * FROM produtos WHERE codigo = ?",
            arrayOf(codigo)
        )

        return if (cursor.moveToFirst()) {
            val produto = Produto(
                codigoProduto = cursor.getInt(cursor.getColumnIndexOrThrow("codigo")).toString(),
                nomeProduto = cursor.getString(cursor.getColumnIndexOrThrow("nome")),
                descricaoProduto = cursor.getString(cursor.getColumnIndexOrThrow("descricao")),
                estoque = cursor.getInt(cursor.getColumnIndexOrThrow("estoque"))
            )
            cursor.close()
            db.close()
            produto
        } else {
            cursor.close()
            db.close()
            null
        }
    }
}
