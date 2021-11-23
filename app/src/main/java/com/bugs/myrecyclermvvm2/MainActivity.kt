package com.bugs.myrecyclermvvm2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bugs.myrecyclermvvm2.databinding.ActivityMainBinding
import com.bugs.myrecyclermvvm2.databinding.SampelItemBinding

class MainActivity : AppCompatActivity() {
    private var viewManager = LinearLayoutManager(this)
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.btnSubmit.setOnClickListener {
            addData()
        }
        initializeAdapter()
    }

    private fun initializeAdapter(){
        binding.rvSampel.layoutManager = viewManager
        observeData()
    }

    fun observeData(){
        viewModel.list.observe(this, Observer {
            Log.i("data", it.toString())
            binding.rvSampel.adapter = SampelRecyclerAdapter(viewModel, it, this)
        })
    }

    fun addData(){
        val label = binding.etLabel.text.toString()
        if (label.isBlank()){
            Toast.makeText(this, "Enter label name!", Toast.LENGTH_SHORT).show()
        } else {
            val sampel = Sampel(label)
            viewModel.add(sampel)
            binding.etLabel.text.clear()
        }
    }
}