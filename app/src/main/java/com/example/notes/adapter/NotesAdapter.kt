package com.example.notes.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.R
import com.example.notes.R.layout.item_container_note
import com.example.notes.entities.Notes
import kotlinx.android.synthetic.main.item_container_note.view.*

class NotesAdapter(val arrList: List<Notes>) :RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(
            LayoutInflater.from(parent.context).inflate(item_container_note,parent,false)

        )
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.itemView.textTitle.text = arrList[position].title
        holder.itemView.textSubtitle.text = arrList[position].subtitle
        holder.itemView.textDateTime.text = arrList[position].dateTime

        if(arrList[position].color != null){
            holder.itemView.cardView.setCardBackgroundColor(Color.parseColor(arrList[position].color))
        } else{
            holder.itemView.cardView.setCardBackgroundColor(Color.parseColor(R.color.colorPrimary.toString()))

        }
    }

    override fun getItemCount(): Int {
        return arrList.size
    }
    class NotesViewHolder (view: View) : RecyclerView.ViewHolder(view) {


    }
}