package com.example.nestedrecyclerview

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.children
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecyclerview.databinding.FragmentMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: RecyclerParentAdapter
    private val fieldsViewModel by lazy {
        ViewModelProvider(requireActivity()).get(FieldsViewModel::class.java)
    }
    private lateinit var finalList: MutableList<MutableList<FieldData>>
    private val finalMap = mutableMapOf<String, List<String?>>()

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
        fieldsViewModel.init()
        binding.btnRegister.setOnClickListener {
            collectData()
            findNavController().navigate(R.id.action_mainFragment_to_detailsFragment)
        }
    }

    private fun initRecycler() {
        adapter = RecyclerParentAdapter()
        binding.parentRecycler.layoutManager = LinearLayoutManager(requireActivity())
        binding.parentRecycler.adapter = adapter
    }

    private fun observe() {
        fieldsViewModel._fieldsLiveData.observe(viewLifecycleOwner, {
            finalList = adapter.setData(it.toMutableList())
            d("main fragment", it.toString())
            d("FINALLIST", finalList.toString())
        })
//        fieldsViewModel._finalMap.observe(viewLifecycleOwner, {
//            finalMap
//        })
    }

    private fun collectData() {
        binding.parentRecycler.children.forEach { it ->
            it.findViewById<RecyclerView>(R.id.childRecycler).children.forEach {
                if (it is EditText) {
                    val key = it.hint.toString()
                    val valueRequired = it.tag.toString()
                    val valueText = it.text.toString().trim()
                    if (valueText.isNotEmpty()) {
                        finalMap[key] = listOf(valueRequired, valueText)
                    } else {
                        finalMap[key] = listOf(valueRequired, null)
                    }
                    d("siiiizeeee", "${valueText.length}")
                    d("valueeeeeeeeee", valueText)

                } else if(it is Button) {
                    //TODO
                }
            }
        }
        d("finalllllllllMMAAAAAPPP", finalMap.toString())
    }
}
