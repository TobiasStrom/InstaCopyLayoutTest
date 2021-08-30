package com.tobiasstrom.insta.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.tobiasstrom.insta.R
import com.tobiasstrom.insta.databinding.HomeFragmentBinding
import com.tobiasstrom.insta.model.HomeItem

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }
    private val list: List<HomeItem> = listOf(
        HomeItem("TobiasStrom", "23 likes", "dette er det beste bilde", R.drawable.profil_picture, R.drawable.climbing),
        HomeItem("TobiasStrom", "23 likes", "dette er det beste bilde", R.drawable.profil_picture, R.drawable.climbing)
    )

    private lateinit var viewModel: HomeViewModel
    private var _binding: HomeFragmentBinding? = null
    private val binding get() = _binding!!
    private val adapter = HomeListAdapter(list)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = HomeFragmentBinding.inflate(inflater,container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.homeRecyclerView.layoutManager = LinearLayoutManager(activity)
        binding.homeRecyclerView.adapter = adapter
    }

}