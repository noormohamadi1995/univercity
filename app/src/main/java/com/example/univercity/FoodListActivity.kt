package com.example.univercity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.univercity.adapter.FoodListAdapter
import com.example.univercity.dialog.FilterFoodsBottomSheetDialog
import com.example.univercity.model.Food
import com.google.android.material.appbar.MaterialToolbar

class FoodListActivity : AppCompatActivity() {
    var recyclerView : RecyclerView? = null
    val list = arrayListOf<Food>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_list)

        val toolbar = findViewById<MaterialToolbar>(R.id.mToolbar)
        toolbar.setOnMenuItemClickListener {
            if (it.itemId == R.id.filter){
               val dialog = FilterFoodsBottomSheetDialog {
                   filterFoods(it.title)
               }
                dialog.show(supportFragmentManager,"FilterFoodsBottomSheetDialog")
            }
            true
        }

         recyclerView = findViewById(R.id.foodList)
        val foodListAdapter = FoodListAdapter{
            reserve(id = it)
        }
        recyclerView?.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = foodListAdapter
        }

        fetchData()
    }

    private fun filterFoods(type : String){
        list.filter { it.type == type}.let {
            (recyclerView?.adapter as FoodListAdapter).submitList(
                arrayListOf<Food?>().apply {
                    addAll(it)
                }
            )
        }
    }

    private fun reserve(id:Int?){
        list.find { it.id == id}.let {it?.reserveState = true}
        (recyclerView?.adapter as FoodListAdapter).submitList(
            arrayListOf<Food?>().apply {
                addAll(list)
            }
        )
    }

    private fun fetchData(){
        for (item : Int in 1..30){
            list.add(
                Food(
                    id = item,
                    name = "غذای شماره ".plus(item),
                    price = "1000 تومان",
                    type = if (item % 2 == 0) "صبحانه" else if (item % 3 == 0) "نهار" else "شام",
                    date = "1401-09-22",
                    img = R.drawable.food,
                    reserveState = item % 4 == 0
                )
            )
        }
        (recyclerView?.adapter as FoodListAdapter).submitList(list)

    }
}