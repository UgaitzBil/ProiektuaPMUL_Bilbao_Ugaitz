package com.example.myapplication

import Produktuak
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NombreAdapter(private var produktuak: List<Produktuak>) :
    RecyclerView.Adapter<NombreAdapter.NombreViewHolder>() {

    private val selectedItems = mutableSetOf<Produktuak>() // Almacena los productos seleccionados

    class NombreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val elizenburua: TextView = itemView.findViewById(R.id.ELIzenburua)
        val elkategorioa: TextView = itemView.findViewById(R.id.ELKategoria)
        val elprezioa: TextView = itemView.findViewById(R.id.ELPrezioa)
        val checkBox: CheckBox = itemView.findViewById(R.id.checkBox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NombreViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_produktuak, parent, false)
        return NombreViewHolder(view)
    }

    override fun onBindViewHolder(holder: NombreViewHolder, position: Int) {
        val produktua = produktuak[position]

        // Configurar los valores de los TextView
        holder.elizenburua.text = "Izena: ${produktua.izenburua}"
        holder.elkategorioa.text = "Mota: ${produktua.kategoria}"
        holder.elprezioa.text = "Prezioa: ${produktua.prezioa} €"

        // Configurar el CheckBox
        holder.checkBox.setOnCheckedChangeListener(null) // Elimina el listener previo para evitar conflictos
        holder.checkBox.isChecked = selectedItems.contains(produktua) // Estado del CheckBox

        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                selectedItems.add(produktua) // Añadir a la lista seleccionada
            } else {
                selectedItems.remove(produktua) // Eliminar de la lista seleccionada
            }
        }
    }

    override fun getItemCount(): Int {
        return produktuak.size
    }

    // Método para obtener los productos seleccionados
    fun getSelectedItems(): List<Produktuak> {
        return selectedItems.toList()
    }

    // Método para actualizar los datos del adaptador
    fun updateData(newData: List<Produktuak>) {
        produktuak = newData // Actualiza la lista de productos
        notifyDataSetChanged() // Notifica al RecyclerView que los datos han cambiado
    }
}