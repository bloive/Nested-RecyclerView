package com.example.nestedrecyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nestedrecyclerview.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    private lateinit var retrievedMap : Map<String, List<String>>

    private val items = mutableListOf<Item>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()
        init()
    }

    private fun init() {
        //TODO
        //To be imported with parcelizable not viewModel

//        if (fieldsViewModel._finalMap.value != null) {
//            retrievedMap = fieldsViewModel._finalMap.value!!
//            binding.recyclerDetails.adapter = adapter
//            binding.recyclerDetails.layoutManager = LinearLayoutManager(requireActivity())
//            adapter = RecyclerDetailsAdapter(listOf("ds", "As", "ds"))
//            d("LLLLLLL", finalList.toString())
        }


    private fun setData() {
        //TODO
        //To be imported with parcelizable not viewModel

//        val hint = fieldsViewModel._finalMap.value?.get("hint")
//        val required: fieldsViewModel._finalMap.value?.get("required")
//        val text: String? = null
//        items.add(ProfileFields(fieldsViewModel._finalMap.value[]))
    }
}