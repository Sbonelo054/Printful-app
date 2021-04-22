package com.printfulapp.app.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.printfulapp.app.R
import com.printfulapp.app.adapter.BeersAdapter
import com.printfulapp.app.viewmodel.BeersViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HomeFragment : Fragment() {
    private val viewModel by sharedViewModel<BeersViewModel>()
    private  var adapter: BeersAdapter?=null
    private var recyclerView : RecyclerView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView = view.findViewById(R.id.recycler_view) as RecyclerView
        recyclerView?.setHasFixedSize(true)
        adapter = BeersAdapter()
        recyclerView?.adapter = adapter
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView?.layoutManager = layoutManager
        viewModel.getBeers()?.observe(viewLifecycleOwner){
            if(it!=null){
                adapter?.setData(it)
            }
        }
        return view
    }



}