package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NombreAdapter(private val produktuak: List<Produktuak>) :
    RecyclerView.Adapter<NombreAdapter.NombreViewHolder>() {

    class NombreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val elizenburua: TextView = itemView.findViewById(R.id.ELIzenburua)
        val elkategorioa: TextView = itemView.findViewById(R.id.ELKategoria)
        val elprezioa: TextView = itemView.findViewById(R.id.ELPrezioa)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NombreViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_produktuak, parent, false)
        return NombreViewHolder(view)
    }

    override fun onBindViewHolder(holder: NombreViewHolder, position: Int) {
        val produktuak = produktuak[position]
        holder.elizenburua.text = "Izena: ${produktuak.izenburua}"
        holder.elkategorioa.text = "Mota: ${produktuak.kategorioa}"
        holder.elprezioa.text = "Prezioa: ${produktuak.prezioa} €"
    }

    override fun getItemCount(): Int {
        return produktuak.size
    }
}