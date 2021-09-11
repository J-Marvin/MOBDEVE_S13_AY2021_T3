package com.mobdeve.s13.group1.budgetbuilder

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.badlogic.gdx.utils.Null
import com.mobdeve.s13.group1.budgetbuilder.dao.RoomModel
import java.io.IOException
import java.lang.NullPointerException

class GalleryAdapter(context: Context, private val dataSet: ArrayList<RoomModel>): RecyclerView.Adapter<GalleryViewHolder>() {
    private val context = context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.room_item, parent, false)
        val holder = GalleryViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        var currRoom = dataSet[position]

//        holder.setImg(currRoom.img!!)
        try {
            val ims = context.assets.open(currRoom.path!!)
            holder.setImg(Drawable.createFromStream(ims, null))
            ims.close()
        } catch (ex: IOException) {
            holder.setImg(currRoom.img!!)
        } catch (ex: NullPointerException) {
            Toast.makeText(context, "no path", Toast.LENGTH_SHORT).show()
        }
        holder.setName(currRoom.name!!)
    }

    override fun getItemCount() = dataSet.size

}
