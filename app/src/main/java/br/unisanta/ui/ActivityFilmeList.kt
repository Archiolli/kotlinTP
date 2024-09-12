package br.unisanta.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.ui.adapter.FilmeAdapter
import br.unisanta.ui.dao.FilmeDao

class ActivityFilmeList : AppCompatActivity() {
    val dao = FilmeDao()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filme_list)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_usuarios)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val filmes = dao.obterFilmes()
        val adapter = FilmeAdapter(filmes)
        recyclerView.adapter = adapter
    }
}