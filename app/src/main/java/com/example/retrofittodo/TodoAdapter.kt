package com.example.retrofittodo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofittodo.databinding.ItemTodoBinding

class TodoAdapter(var todolist: List<Todo> = emptyList()) : RecyclerView.Adapter<TodoAdapter
    .ViewHolder>() {

    inner class ViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent,
            false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.binding.apply {
           tvTitle.text = todolist[position].title
           cbDone.isChecked = todolist[position].completed

       }
    }

    override fun getItemCount(): Int {
        return todolist.size
    }
}