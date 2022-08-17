package com.example.netronic.ui.users

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.netronic.R

class UserItemDecoration: RecyclerView.ItemDecoration() {

    private var itemMargin: Int? = null

    override fun getItemOffsets(outRect: Rect,
                                view: View,
                                parent: RecyclerView,
                                state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        if (itemMargin == null) {
            itemMargin = view.context.resources.getDimension(R.dimen.margin_item_menu_item).toInt()
        }

        val pos = parent.getChildAdapterPosition(view)
        val top = if (pos == 0) itemMargin!! else 0

        outRect.set(itemMargin!!, top, itemMargin!!, itemMargin!!)
    }
}