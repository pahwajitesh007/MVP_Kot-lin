package com.example.jiteshp.magickotlin.utils

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

class ListItemDecorations(var specing: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        if (outRect != null && parent != null) {
            var position = parent.getChildAdapterPosition(view)
            outRect.left = specing
            outRect.right = specing
            outRect.bottom = specing
            if (position < 1) outRect.top = specing
        }
    }
}