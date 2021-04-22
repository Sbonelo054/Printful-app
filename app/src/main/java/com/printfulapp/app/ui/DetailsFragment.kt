package com.printfulapp.app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.printfulapp.app.R
import com.printfulapp.app.model.BeersItem
import com.squareup.picasso.Picasso

class DetailsFragment : Fragment(){
    private var beer : BeersItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        beer =arguments?.getSerializable("beers") as BeersItem
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        display(view)
    }

    fun display(view:View){
        val name = beer?.name
        val tagline = beer?.tagline
        val description = beer?.description
        val beersTips = beer?.brewers_tips
        val contributor = beer?.contributed_by

        val beerName = view.findViewById<TextView>(R.id.beer_name)
        beerName.text = name
        val beerTagline = view.findViewById<TextView>(R.id.details_tagline)
        beerTagline.text = tagline
        val beerDescription= view.findViewById<TextView>(R.id.details_description)
        beerDescription.text = description
        val beerTips = view.findViewById<TextView>(R.id.details_tips)
        beerTips.text = beersTips
        val beerInventor = view.findViewById<TextView>(R.id.details_contributor)
        beerInventor.text = contributor
        val imageView = view.findViewById<ImageView>(R.id.details_picture)
        Picasso.get().load(beer?.image_url).into(imageView)
    }
}