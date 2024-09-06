package com.example.retrofittodo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofittodo.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var todoAdapter: TodoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        todoAdapter = TodoAdapter()
        binding.rvTodo.adapter = todoAdapter
        binding.rvTodo.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launchWhenCreated {
            binding.progressBar.isVisible = true
            val response = RetrofitInstance.api.getTodos()

            withContext(Dispatchers.Main)
            {
                todoAdapter.todolist = response
                todoAdapter.notifyDataSetChanged()
            }
            binding.progressBar.isVisible = false
        }


    }
    }
