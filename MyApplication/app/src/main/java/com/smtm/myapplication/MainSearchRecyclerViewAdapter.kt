package com.smtm.myapplication

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_main.view.*


class MainSearchRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    data class Item(var name: String?, var description: String?, var acatar_url: String?)

    class ItemsHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
    ) {
        fun onBind(item: Item) {
            itemView.run {
                repo_name.setText(item.name);
                repo_detail.setText(item.description);
                Glide.with(context).load(item.acatar_url).into(repo_image_view);
            }
        }
    }

    private val ItemList = ArrayList<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ItemsHolder(parent)

    override fun getItemCount() = ItemList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? ItemsHolder)?.onBind(ItemList[position])
    }

    fun addItem(name: String?, description: String?, acatar_url: String?) {
        ItemList.add(Item(name, description, acatar_url))
    }

    fun clearItem() {
        ItemList.clear()
    }
}