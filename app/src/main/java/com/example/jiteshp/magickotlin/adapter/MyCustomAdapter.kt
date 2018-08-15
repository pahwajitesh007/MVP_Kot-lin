package com.example.jiteshp.magickotlin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jiteshp.magickotlin.R
import com.example.jiteshp.magickotlin.bean.Movies
import kotlinx.android.synthetic.main.item.view.*
import org.jetbrains.anko.toast

class MyCustomAdapter(var context: Context, var list: List<Movies>) : RecyclerView.Adapter<MyCustomAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var v = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.text = list.get(position).original_title
        holder.tvId.text = list.get(position).id.toString()
        holder.tvDesc.text = list.get(position).overview
        holder.tvDate.text = list.get(position).release_date

        holder.card_view.setOnClickListener {
            context.toast("" + list.get(position).original_title)
        }


    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName = itemView.tvName
        val tvId = itemView.tvId
        val tvDesc = itemView.tvDesc
        val tvDate = itemView.tvDate
        val card_view = itemView.card_view
    }
}