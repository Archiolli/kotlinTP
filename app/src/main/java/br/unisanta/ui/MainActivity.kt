package br.unisanta.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.unisanta.ui.dao.FilmeDao
import br.unisanta.ui.model.Filme
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    val dao = FilmeDao()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)
        val edtTitulo = findViewById<TextInputLayout>(R.id.edt_titulo)
        val edtDesc = findViewById<TextInputLayout>(R.id.edt_desc)
        val edtNota = findViewById<TextInputLayout>(R.id.edt_nota)
        val edtLink = findViewById<TextInputLayout>(R.id.edt_link)
        val btnCadastrar = findViewById<Button>(R.id.btn_cadastrar)
        val fabAvanca = findViewById<TextView>(R.id.listar)

        btnCadastrar.setOnClickListener {
            val titulo = edtTitulo?.editText?.text.toString()
            val desc = edtDesc?.editText?.text.toString()
            val nota = edtNota?.editText?.text.toString()
            val link = edtLink?.editText?.text.toString()
            val filme = Filme(titulo, desc, nota, link)
            dao.adicionarFilmes(filme)
            Toast.makeText(this, "Filme Cadastrado Com Sucesso!", Toast.LENGTH_LONG).show()

        }
        fabAvanca.setOnClickListener {

            val intent = Intent(this,ActivityFilmeList::class.java)
            startActivity(intent)
        }
    }
}