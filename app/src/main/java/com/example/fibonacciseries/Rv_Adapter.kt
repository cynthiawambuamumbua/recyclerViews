package com.example.fibonacciseries

//noinspection SuspiciousImport
import android.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class Rv_Adapter(private val numbers: List<Int>) : RecyclerView.Adapter<Rv_Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Rv_Adapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Rv_Adapter.ViewHolder, position: Int) {
        holder.tvNumber.text = numbers[position].toString()
    }

    override fun getItemCount(): Int {
        return numbers.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNumber: TextView = itemView.findViewById(R.id.text1)
    }
}