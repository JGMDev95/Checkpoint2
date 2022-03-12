package com.talma.spotify.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.talma.spotify.R
import com.talma.spotify.models.PlaylistModel


class RecyclerAdapter(
    var context:Context,
    var contacts: MutableList<PlaylistModel>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = contacts.get(position)
        holder.bind(item, context)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.menu_images, parent, false))
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombre = view.findViewById(R.id.tvNombre) as TextView
        val status = view.findViewById(R.id.tvStatus) as TextView
        val phone = view.findViewById(R.id.tvPhone) as TextView
        val image = view.findViewById(R.id.userImage) as ImageView

        fun bind(contact: PlaylistModel, context: Context){
            nombre.text = contact.name
            status.text = contact.status
            phone.text = contact.phone
            image.setImageResource(contact.idImage)

            itemView.setOnClickListener{
                Toast.makeText(context, "Llamando a ${contact.name}", Toast.LENGTH_SHORT).show()
            }
        }
    }


}