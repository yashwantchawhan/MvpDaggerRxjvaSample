package com.yashwant.newsmodule.ui.news

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.mvpdaggerrxjvasample.R


/**
 * Created by yashwant on 16/10/17.
 */

class NewsViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {

    val container: ViewGroup
    val tvNewsName: TextView
    val tvAuthor: TextView
    val tvDateCreated: TextView

    init {
        container = view.findViewById<View>(R.id.container) as ViewGroup
        tvNewsName = view.findViewById<View>(R.id.tvNewsTittle) as TextView
        tvAuthor = view.findViewById<View>(R.id.tvAuthor) as TextView
        tvDateCreated = view.findViewById<View>(R.id.tvDateCreated) as TextView


    }
}

