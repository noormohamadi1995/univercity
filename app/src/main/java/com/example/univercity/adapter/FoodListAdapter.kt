package com.example.univercity.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.univercity.R
import com.example.univercity.model.Food

val diffUtil = object : DiffUtil.ItemCallback<Food>() {
    override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean {
        return oldItem == newItem
    }
}

class FoodListAdapter(
    val reserveItem: (id: Int?) -> Unit
) : ListAdapter<Food, FoodViewHolder>(diffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val viewHolder = inflater.inflate(
            R.layout.item_food, parent, false
        )
        return FoodViewHolder(viewHolder,reserveItem)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}

class FoodViewHolder(itemView: View,val reserveItem: (id: Int?) -> Unit) : RecyclerView.ViewHolder(itemView) {
    fun bind(food: Food) {
        val txtName = itemView.findViewById<TextView>(R.id.food_name)
        val txtPrice = itemView.findViewById<TextView>(R.id.food_price)
        val txtType = itemView.findViewById<TextView>(R.id.food_type)
        val txtDate = itemView.findViewById<TextView>(R.id.food_data)
        val img = itemView.findViewById<ImageView>(R.id.food_img)
        val btnReserve = itemView.findViewById<Button>(R.id.btnReserve)

        txtName.text = food.name
        txtPrice.text = food.price
        txtType.text = food.type
        txtDate.text = food.date
        img.setImageDrawable(ContextCompat.getDrawable(itemView.context, food.img))
        btnReserve.text = if (food.reserveState) "رزرو شده" else "رزرو"
        btnReserve.isEnabled = food.reserveState.not()

        btnReserve.setOnClickListener {
            reserveItem.invoke(food.id)
        }
    }

}