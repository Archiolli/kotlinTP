package br.unisanta.ui.dao

import br.unisanta.ui.model.Filme

class FilmeDao {
    companion object{
        private val filmes = mutableListOf<Filme>()
    }
    fun adicionarFilmes(filme: Filme){
        Companion.filmes.add(filme)
    }
    fun obterFilmes():List<Filme>{
        return Companion.filmes
    }
}