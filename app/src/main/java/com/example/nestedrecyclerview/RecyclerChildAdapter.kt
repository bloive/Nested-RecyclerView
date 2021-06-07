package com.example.nestedrecyclerview

import android.util.Log.d
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecyclerview.databinding.ChooserItemBinding
import com.example.nestedrecyclerview.databinding.EditableItemBinding
import java.util.*

class RecyclerChildAdapter(private val fields: MutableList<FieldData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val LAYOUT_EDITABLE = 1
        private const val LAYOUT_CHOOSER = 2

        private const val TYPE_EDITABLE = "input"
        private const val TYPE_CHOOSER = "chooser"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        d("viewtype", "$viewType")
        return if (viewType == LAYOUT_EDITABLE) {
            EditableViewHolder(
                EditableItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        } else {
            ChooserViewHolder(
                ChooserItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is EditableViewHolder -> holder.bind()
            is ChooserViewHolder -> holder.bind()
        }
    }

    override fun getItemCount() = fields.size

    override fun getItemViewType(position: Int): Int {

        return when (fields[position].type) {
            TYPE_EDITABLE -> LAYOUT_EDITABLE
            TYPE_CHOOSER -> LAYOUT_CHOOSER
            else -> 0
        }
    }

    inner class EditableViewHolder(private val binding: EditableItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var modelEditable: FieldData
        fun bind() {
            d("TYPE", "$fields")
            modelEditable = fields[adapterPosition]
            binding.editable.hint = modelEditable.hint
            binding.editable.tag = modelEditable.required
        }
    }

    inner class ChooserViewHolder(private val binding: ChooserItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var modelChooser: FieldData
        fun bind() {
            d("child fields size", "${fields.size}")
            modelChooser = fields[adapterPosition]
            binding.chooser.text = modelChooser.hint
            binding.chooser.tag = modelChooser.required
        }
    }
}