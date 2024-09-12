package br.unisanta.ui.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.ui.R
import br.unisanta.ui.model.Filme

class FilmeAdapter(private val filmes: List<Filme>) :
    RecyclerView.Adapter<FilmeAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txvTitulo: TextView = itemView.findViewById(R.id.titulo)
        val txvDesc: TextView = itemView.findViewById(R.id.desc)
        val txvNota: TextView = itemView.findViewById(R.id.nota)
        val videolink: VideoView = itemView.findViewById(R.id.videoView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.filme_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val usuario = filmes[position]
        holder.txvTitulo.text = usuario.titulo
        holder.txvDesc.text = usuario.desc
        holder.txvNota.text = usuario.nota
        val videoUri: Uri = Uri.parse(usuario.link)
        holder.videolink.setVideoURI(
            videoUri
        )
        holder.videolink.start()
    }

    override fun getItemCount(): Int {
        return filmes.size
    }
}