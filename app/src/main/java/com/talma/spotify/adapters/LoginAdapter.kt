package com.talma.spotify.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.BaseAdapter
import android.widget.TextView
import com.talma.spotify.R
import com.talma.spotify.models.LoginModel

class LoginAdapter (private  val context: Context, private val datos : ArrayList<LoginModel>) : BaseAdapter() {
    private val inflater : LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return datos.size
    }

    override fun getItem(position: Int): Any {
        return datos[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.activity_login, parent, false)

        val userName = rowView.findViewById<View>(R.id.txtGetUser) as TextView
         return rowView
    }
}