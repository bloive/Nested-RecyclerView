package com.example.nestedrecyclerview

import android.content.res.Resources
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nestedrecyclerview.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: RecyclerAdapter
    private val itemViewModel by lazy {
        ViewModelProvider(requireActivity()).get(ItemViewModel::class.java)
    }
    private val items = listOf("Title", "Description", "ImageUrl")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        observe()
        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_detailsFragment)
        }
    }

    private fun initRecycler() {
        adapter = RecyclerAdapter()
        binding.parentRecycler.layoutManager = LinearLayoutManager(requireActivity())
        binding.parentRecycler.adapter = adapter
    }

    private fun observe() {
        //TODO
    }
}
