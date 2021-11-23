package com.bugs.myrecyclermvvm2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bugs.myrecyclermvvm2.databinding.SampelItemBinding

class SampelRecyclerAdapter(
    val mainViewModel: MainViewModel,
    val arrayList: ArrayList<Sampel>,
    val context: Context
) : RecyclerView.Adapter<SampelRecyclerAdapter.SampelViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampelViewHolder {
        val binding = SampelItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SampelViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SampelViewHolder, position: Int) {
        holder.bind(arrayList[position])
    }

    override fun getItemCount(): Int {
        if (arrayList.size == 0) {
            Toast.makeText(context, "List is empty", Toast.LENGTH_SHORT).show()
        }
        return arrayList.size
    }

    inner class SampelViewHolder(val binding: SampelItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(sampel: Sampel) {
            binding.tvLabelItem.text = sampel.label
            binding.deleteItem.setOnClickListener{
                mainViewModel.remove(sampel)
                notifyItemRemoved(arrayList.indexOf(sampel))
            }
        }
    }
}