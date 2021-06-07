package com.example.nestedrecyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecyclerview.databinding.DetailsViewBinding

class RecyclerDetailsAdapter(private val fields: List<String>) :
    RecyclerView.Adapter<RecyclerDetailsAdapter.DetailsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerDetailsAdapter.DetailsViewHolder {
        Log.d("viewtype", "$viewType")
        return DetailsViewHolder(
            DetailsViewBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = fields.size


    inner class DetailsViewHolder(private val binding: DetailsViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var item: String
        fun bind() {
            Log.d("TYPE", "$fields")
            item = fields[adapterPosition]
            binding.tvDetail.text = item
        }
    }
}