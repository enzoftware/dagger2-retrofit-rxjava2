package com.projects.enzoftware.krazyposts.ui.list

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.projects.enzoftware.krazyposts.R
import com.projects.enzoftware.krazyposts.model.Post

class ListAdapter (private val context: Context, private val list: MutableList<Post>, fragment: Fragment):
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    private val listener : ListAdapter.OnItemClickListener

    init {
        this.listener = fragment as ListAdapter.OnItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =  LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return ListAdapter.ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = list[position]
        holder.bind(post)
        holder.layout.setOnClickListener {
            listener.itemDetail(post.id.toString())
        }
    }

    fun removeAt(position: Int){
        list.removeAt(position)
        notifyItemRemoved(position)
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var layout = itemView.findViewById<ConstraintLayout>(R.id.item_layout)!!
        val title = itemView.findViewById<TextView>(R.id.item_title)!!
        val body = itemView.findViewById<TextView>(R.id.item_body)!!

        fun bind(item: Post) {
            title.text = item.title
            body.text = item.body
        }
    }

    interface OnItemClickListener {
        fun itemRemoveClick (item: Post)
        fun itemDetail (postId: String)
    }
}