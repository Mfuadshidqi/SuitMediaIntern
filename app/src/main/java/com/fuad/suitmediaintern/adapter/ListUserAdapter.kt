package com.fuad.suitmediaintern.adapter


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fuad.suitmediaintern.R
import com.fuad.suitmediaintern.databinding.CardUserBinding
import com.fuad.suitmediaintern.local.entity.Users
import com.fuad.suitmediaintern.ui.main.MainActivity


class ListUserAdapter:
    PagingDataAdapter<Users, ListUserAdapter.MyViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = CardUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    class MyViewHolder(private val binding: CardUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(context: Context, data: Users) {
            binding.apply {
                tvFirstName.text = data.firstname
                tvLastName.text = data.lastname
                tvItemEmail.text = data.email
                itemView.setOnClickListener {
                    val intent = Intent(context, MainActivity::class.java)
                    intent.putExtra(MainActivity.EXTRA_DATA, data)
                    context.startActivity(intent)
                }
            }
            Glide.with(itemView.context)
                .load(data.avatar)
                .placeholder(R.drawable.image_loading)
                .error(R.drawable.image_error)
                .into(binding.imgItemPhoto)
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = getItem(position)
        if (data != null) {
            holder.bind(holder.itemView.context, data)
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Users>() {
            override fun areItemsTheSame(oldItem: Users, newItem: Users): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Users, newItem: Users): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}