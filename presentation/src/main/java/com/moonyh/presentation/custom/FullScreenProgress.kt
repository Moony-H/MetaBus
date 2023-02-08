package com.moonyh.presentation.custom

import android.content.Context
import android.util.AttributeSet
import android.widget.ProgressBar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.moonyh.presentation.R
import kotlin.math.roundToInt

class FullScreenProgress : ConstraintLayout {
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {

        this.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        setBackgroundColor(ContextCompat.getColor(context, R.color.black_transparent))

        val wh =
            (80 * context.resources.displayMetrics.density).roundToInt()
        val progressBar = ProgressBar(context)
        progressBar.layoutParams = LayoutParams(wh, wh).apply {
            topToTop = LayoutParams.PARENT_ID
            bottomToBottom = LayoutParams.PARENT_ID
            startToStart = LayoutParams.PARENT_ID
            endToEnd = LayoutParams.PARENT_ID
        }

        this.addView(progressBar)


    }
}