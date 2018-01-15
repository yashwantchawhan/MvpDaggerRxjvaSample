package com.yashwant.newsmodule.ui.news;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.mvpdaggerrxjvasample.R;
import com.yashwant.newsmodule.app.NewsApplication;
import com.yashwant.newsmodule.model.Hit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsActivity extends AppCompatActivity implements NewsView, View.OnClickListener {

    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @Inject
    NewsPresenter presenter;
    @BindView(R.id.editSearch)
    EditText editSearch;
    @BindView(R.id.buttonSearch)
    Button buttonSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ((NewsApplication) getApplication()).getAppComponent().inject(this);
        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        presenter.setView(this);

        buttonSearch.setOnClickListener(this);
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showNews(List<Hit> newsList) {
        recyclerView.setAdapter(new NewsAdapter(newsList));
        recyclerView.getAdapter().notifyDataSetChanged();

    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void launchNewsDetail(Hit news) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(news.getUrl()));
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }


    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void onClick(View view) {
        presenter.getNews(editSearch.getText().toString());
    }

    class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {

        private List<Hit> newsList;
        private Date createdAt;

        NewsAdapter(List<Hit> news) {
            this.newsList = news;
        }

        @Override
        public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(NewsActivity.this);
            return new NewsViewHolder(inflater.inflate(R.layout.news_item_layout, parent, false));
        }

        @Override
        public void onBindViewHolder(NewsViewHolder holder, int position) {
            final Hit newsItem = newsList.get(position);
            holder.getTvNewsName().setText(newsItem.getTitle());
            holder.getTvAuthor().setText("By " + newsItem.getHighlightResult().getAuthor().getValue());
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                createdAt=formatter.parse(newsItem.getCreatedAt());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            holder.getTvDateCreated().setText("on " + DateUtils.getRelativeTimeSpanString(createdAt.getTime(), new Date().getTime(), 0L, DateUtils.FORMAT_ABBREV_ALL).toString());
            holder.getContainer().setOnClickListener(view -> launchNewsDetail(newsItem));
        }

        @Override
        public int getItemCount() {
            return newsList.size();
        }
    }


}
