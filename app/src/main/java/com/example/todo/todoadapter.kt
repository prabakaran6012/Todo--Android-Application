package com.example.todo

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.text.style.StrikethroughSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.items_todo.view.*


class todoadapter(
    private val todos:MutableList<todo>
) : RecyclerView.Adapter<todoadapter.todoviewholder>(){

    class todoviewholder(a: View):RecyclerView.ViewHolder(a)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): todoviewholder {
        return todoviewholder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.items_todo,
                parent,
                false
            )
        )
    }

    fun addtodo(g: todo){
        todos.add(g)
        notifyItemInserted(todos.size-1)
    }
    fun deletedone(){
        todos.removeAll { todo ->
            todo.ischecked
        }
        notifyDataSetChanged()
    }


private fun striker(p:TextView,q:Boolean){
    if (q){

        p.paintFlags=p.paintFlags or STRIKE_THRU_TEXT_FLAG
    } else{
        p.paintFlags=p.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
    }
}
    override fun onBindViewHolder(holder: todoviewholder, position: Int) {

        val x=todos[position]
        holder.itemView.apply {
            tvtooltitle.text=x.title
            cbdone.isChecked=x.ischecked
            striker(tvtooltitle,x.ischecked)
            cbdone.setOnCheckedChangeListener { _, ischecked ->
                striker(tvtooltitle,ischecked)
                x.ischecked=!x.ischecked
            }

        }

    }

    override fun getItemCount(): Int {

        return todos.size

    }
}