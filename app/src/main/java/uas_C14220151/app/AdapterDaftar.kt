package uas_C14220151.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import paba.c14220151.cobafirebase.R
import uas_C14220151.app.database.DaftarKesehatan

class AdapterDaftar(private val daftarKesehatan: MutableList<DaftarKesehatan>) :
    RecyclerView.Adapter<AdapterDaftar.ListViewHolder>() {

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTanggal: TextView = itemView.findViewById(R.id.tvTanggal)
        var tvBeratBadan: TextView = itemView.findViewById(R.id.tvBeratBadan)
        var tvTekananDarah: TextView = itemView.findViewById(R.id.tvTekanan)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_data, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val daftar = daftarKesehatan[position]
        holder.tvTanggal.text = daftar.tanggal
        holder.tvBeratBadan.text = daftar.berat
        holder.tvTekananDarah.text = daftar.tekanan
    }

    override fun getItemCount(): Int {
        return daftarKesehatan.size
    }

    fun isiData(daftar: List<DaftarKesehatan>) {
        daftarKesehatan.clear()
        daftarKesehatan.addAll(daftar)
        notifyDataSetChanged()
    }
}