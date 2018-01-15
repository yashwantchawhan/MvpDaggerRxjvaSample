package com.yashwant.newsmodule.ui.news;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mvpdaggerrxjvasample.R;


/**
 * Created by yashwant on 16/10/17.
 */

public class NewsViewHolder extends RecyclerView.ViewHolder {

    private ViewGroup container;
    private TextView tvNewsName;
    private TextView tvAuthor;
    private TextView tvDateCreated;

    NewsViewHolder(View view) {
        super(view);
        container = (ViewGroup) view.findViewById(R.id.container);
        tvNewsName = (TextView) view.findViewById(R.id.tvNewsTittle);
        tvAuthor = (TextView) view.findViewById(R.id.tvAuthor);
        tvDateCreated = (TextView) view.findViewById(R.id.tvDateCreated);


    }

    public ViewGroup getContainer() {
        return container;
    }

    public TextView getTvNewsName() {
        return tvNewsName;
    }

    public TextView getTvAuthor() {
        return tvAuthor;
    }
    public TextView getTvDateCreated() {
        return tvDateCreated;
    }
}

