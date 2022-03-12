package com.talma.spotify.models

import android.os.Parcel
import android.os.Parcelable

data class PlaylistModel(
    var name: String?,
    var status: String?,
    var phone: String?,
    var idImage: Int
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(status)
        parcel.writeString(phone)
        parcel.writeInt(idImage)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PlaylistModel> {
        override fun createFromParcel(parcel: Parcel): PlaylistModel {
            return PlaylistModel(parcel)
        }

        override fun newArray(size: Int): Array<PlaylistModel?> {
            return arrayOfNulls(size)
        }
    }
}

/*companion object {
    val data
        get() = listOf(
            PlaylistModel(
                1,
                "10 Tips Para Estudiar",
                "Descubre cómo aumentar tu productividad al estudiar"/*,
                R.drawable.learning1*/
            ),
            PlaylistModel(
                2,
                "Guía para escribir tu primer cuento",
                "Incursiona en el mundo de la narración infantil"/*,
                R.drawable.learning2*/
            ),
            PlaylistModel(
                3,
                "Optimizar trabajos grupales",
                "Aplica estas estrategias para mejorar tus trabajos en grupo"/*,
                R.drawable.learning3*/
            ),
            PlaylistModel(
                4,
                "Libros que nunca habías escuchado",
                "Te presentamos la lista de los libros más raros"/*,
                R.drawable.learning4*/
            ),
            PlaylistModel(
                5,
                "Cómo mejorar en la universidad",
                "En este artículo una actitud adecuada para la U"/*,
                R.drawable.learning5*/
            ),
            PlaylistModel(
                6,
                "40 buscadores de artículos científicos",
                "Descubre los buscadores más importantes para cada área del conocimiento"/*,
                R.drawable.learning6*/
            ),
            PlaylistModel(
                7,
                "Pautas para escribir un ensayo",
                "Karla te explica un marco de trabajo para hace ensayos"/*,
                R.drawable.learning7*/
            ),
            PlaylistModel(
                8,
                "Crear un ambiente de estudio para llegar a \"la zona\"",
                "Aprende a modificar tu entorno para sacar el máximo beneficio de tu mente"/*,
                R.drawable.learning8*/
            ),
            PlaylistModel(
                9,
                "Estudiar 80 horas semanales",
                "Como Carlos logró estudiar 80 horas sin agotarse"/*,
                R.drawable.learning9*/
            ),
            PlaylistModel(
                10,
                "Lo que tu tutor de tesis no te dice",
                "Consejos para terminar trabajos de grado rápido"/*,
                R.drawable.learning10*/
            )
        )
}*/