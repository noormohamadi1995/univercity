package com.example.univercity.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.univercity.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FilterFoodsBottomSheetDialog(
    private val onClickItem : (FoodType) -> Unit
): BottomSheetDialogFragment() {
    var containerView : View? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        containerView = inflater.inflate(R.layout.filter_food_list_layout,container,false)
        return containerView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnBreakFast = view.findViewById<Button>(R.id.btnBreakFast)
        val btnLunch = view.findViewById<Button>(R.id.btnLunch)
        val btnDinner = view.findViewById<Button>(R.id.btnDinner)

        btnBreakFast.setOnClickListener {
            onClickItem.invoke(FoodType.BREAKFAST)
            dismiss()
        }

        btnLunch.setOnClickListener {
            onClickItem.invoke(FoodType.LUNCH)
            dismiss()
        }

        btnDinner.setOnClickListener {
            onClickItem.invoke(FoodType.DINNER)
            dismiss()
        }
    }
}


enum class FoodType(val title : String){
    BREAKFAST("صبحانه"),LUNCH("نهار"),DINNER("شام")
}