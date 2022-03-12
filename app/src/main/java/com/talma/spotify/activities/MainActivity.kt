package com.talma.spotify.activities


import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ListView
import android.widget.Toast
import com.talma.spotify.R
import com.talma.spotify.adapters.RecyclerAdapter
import com.talma.spotify.models.PlaylistModel

class MainActivity : AppCompatActivity(  ) {
    private lateinit var mAdapter : RecyclerAdapter
    private lateinit var getDAtos : MutableList<PlaylistModel>
    private lateinit var listView: ListView
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)

        setUpRecyclerView()

        listView.setOnClickListener { view ->
            val intent = Intent(this,RecuperaPassActivity::class.java)
            startActivityForResult(intent,1)

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int,data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {

                val contact = data!!.getParcelableExtra<PlaylistModel>("new_contact")
                PlaylistModel.add(0,contact)
                mAdapter.notifyItemInserted(0)
                Toast.makeText(this,"Contacto agregado!", Toast.LENGTH_SHORT).show()


            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }

    private fun setUpRecyclerView(){
        //LoginActivity.setHasFixedSize(true)
        //nuestro layout va a ser de una sola columna
        //recyclerContacts.layoutManager = LinearLayoutManager(this)
        //seteando los datos
        data = getData()
        //seteando el Adapter
        mAdapter = RecyclerAdapter( this,PlaylistModel)
        //asignando el Adapter al RecyclerView
        recyclerContacts.adapter = mAdapter
    }

    private fun getData(): MutableList<PlaylistModel>{
        var contacts:MutableList<PlaylistModel> = ArrayList()

        contacts.add(PlaylistModel("Pablo Perez", "disponible", "5535576823",R.drawable.cumbias))
        contacts.add(PlaylistModel("Juan Magaña", "on smash", "553552432",R.drawable.cumbias))
        contacts.add(PlaylistModel("Leticia Pereda", "disponible", "5553454363",R.drawable.cumbias))
        contacts.add(PlaylistModel("Manuel Lozano", "livin' la vida loca", "9613245432",R.drawable.cumbias))
        contacts.add(PlaylistModel("Ricardo Belmonte", "disponible", "6332448739",R.drawable.cumbias))
        contacts.add(PlaylistModel("Rosalina", "lookin' to the stars", "7546492750",R.drawable.cumbias))
        contacts.add(PlaylistModel("Thalía Fernandez", "no fear", "5587294655",R.drawable.cumbias))
        contacts.add(PlaylistModel("Sebastián Cárdenas", "no molestar", "4475655578",R.drawable.cumbias))

        return contacts
    }

}


