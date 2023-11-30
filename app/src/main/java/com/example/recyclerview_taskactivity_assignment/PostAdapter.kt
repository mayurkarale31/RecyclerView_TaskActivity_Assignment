package com.example.recyclerview_taskactivity_assignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(
    private val post : ArrayList<Post>
): RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    interface OnPostClickListener{
        fun onPostClick(position: Int, post: Post, view: View)
    }

    var onPostClickListener : OnPostClickListener? = null

    inner class PostViewHolder(view : View) : RecyclerView.ViewHolder(view) {

        val txtId: TextView
        val txtTitle: TextView
        val txtBody: TextView
        val txtDueDate: TextView
        val txtStatus: TextView

        init {
            txtId = view.findViewById(R.id.txtId)
            txtTitle = view.findViewById(R.id.txtTitle)
            txtBody = view.findViewById(R.id.txtBody)
            txtDueDate = view.findViewById(R.id.txtDueDate)
            txtStatus = view.findViewById(R.id.txtStatus)

            itemView.setOnClickListener {
                if(onPostClickListener != null){
                    onPostClickListener!!.onPostClick(
                        adapterPosition,
                        post[adapterPosition],
                        it
                    )
                }
            }

        }
    }

    override fun getItemCount() = post.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.post_view, null)

        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.txtId.text= post[position].id.toString()
        holder.txtTitle.text = post[position].title
        holder.txtBody.text = post[position].body
        holder.txtDueDate.text = post[position].dueDate
        holder.txtStatus.text = post[position].status
    }
}