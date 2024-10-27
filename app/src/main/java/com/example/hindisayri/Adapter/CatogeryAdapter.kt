package com.hindi.hindisayri.Adapter

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hindi.hindisayri.HomeActivity
import com.hindi.hindisayri.MainActivity
import com.hindi.hindisayri.Model.CategoryModel
import com.hindi.hindisayri.databinding.ItemCategoryBinding

class CatogeryAdapter(val mainActivity: MainActivity, val list: ArrayList<CategoryModel>) :
    RecyclerView.Adapter<CatogeryAdapter.CatViewHolder>() {

    // color arraylist
    val colorList = arrayListOf(
        "#98DED9", "#B7B7B5", "#7E60BF", "#629584",
        "#697565", "#2480b9", "#3498db"
    )

    // use binding
    class CatViewHolder(val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        return CatViewHolder(
            ItemCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        // Use modulo to cycle through colorList
        holder.binding.itemCard.setBackgroundColor(Color.parseColor(colorList[position % colorList.size]))

        // Bind the data to the view
        holder.binding.itemText.text = list[position].name

        // Click on recyclerview item
        holder.binding.root.setOnClickListener {
            val intent = Intent(mainActivity, HomeActivity::class.java).apply {
                putExtra("id", list[position].id)
                putExtra("name", list[position].name)
            }
            mainActivity.startActivity(intent)
        }
    }

    // Move getItemCount() outside of onBindViewHolder
    override fun getItemCount(): Int = list.size
}
