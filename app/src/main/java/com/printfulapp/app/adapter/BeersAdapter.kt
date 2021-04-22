package com.printfulapp.app.adapter
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.printfulapp.app.adapter.BeersAdapter.BeersViewHolder
import com.printfulapp.app.model.BeersItem
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.printfulapp.app.R
import com.squareup.picasso.Picasso
import android.widget.TextView
import androidx.navigation.Navigation
import java.util.ArrayList

class BeersAdapter : RecyclerView.Adapter<BeersViewHolder>() {
    private var beers: List<BeersItem> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeersViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.beer_item, parent, false)
        return BeersViewHolder(view)
    }

    fun setData(beers: List<BeersItem>) {
        this.beers = beers
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: BeersViewHolder, position: Int) {
        val beers:BeersItem = beers[position]
        val beerName = "Name : ${beers.name}"
        val beerTagline = "Tagline : ${beers.tagline}"
        val beerVolume = "Volume : ${beers.volume.value} Liters"
        val beerInventor = "Inventor : ${beers.contributed_by}"
        holder.name.text = beerName
        holder.tagline.text = beerTagline
        holder.volume.text = beerVolume
        holder.inventor.text = beerInventor
        Picasso.get().load(beers.image_url).into(holder.image)
        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("beers",beers)
            Navigation.findNavController(it).navigate(R.id.action_HomeFragment_to_DetailsFragment,bundle)
        }
    }

    override fun getItemCount(): Int {
        return beers.size
    }

    inner class BeersViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.beer_icon)
        var name: TextView = itemView.findViewById(R.id.beer_name)
        var tagline: TextView = itemView.findViewById(R.id.beer_tag_name)
        var volume: TextView = itemView.findViewById(R.id.beer_volume)
        var inventor: TextView = itemView.findViewById(R.id.beer_brewed)
    }
}