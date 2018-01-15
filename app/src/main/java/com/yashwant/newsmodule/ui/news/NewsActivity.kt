package com.yashwant.newsmodule.ui.news

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast


import com.mvpdaggerrxjvasample.R
import com.yashwant.newsmodule.app.NewsApplication
import com.yashwant.newsmodule.model.Hit

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date

import javax.inject.Inject

import butterknife.BindView
import butterknife.ButterKnife

class NewsActivity : AppCompatActivity(), NewsView, View.OnClickListener {

    @BindView(R.id.progressBar)
    internal var progressBar: ProgressBar? = null
    @BindView(R.id.recyclerView)
    internal var recyclerView: RecyclerView? = null
    @Inject
    internal var presenter: NewsPresenter? = null
    @BindView(R.id.editSearch)
    internal var editSearch: EditText? = null
    @BindView(R.id.buttonSearch)
    internal var buttonSearch: Button? = null

    override val context: Context
        get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        (application as NewsApplication).appComponent!!.inject(this)
        ButterKnife.bind(this)

        recyclerView!!.layoutManager = LinearLayoutManager(this)
        recyclerView!!.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        presenter!!.setView(this)

        buttonSearch!!.setOnClickListener(this)
        progressBar!!.visibility = View.GONE

    }

    override fun showLoading() {
        progressBar!!.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar!!.visibility = View.GONE
    }

    override fun showNews(newsList: List<Hit>) {
        recyclerView!!.adapter = NewsAdapter(newsList)
        recyclerView!!.adapter.notifyDataSetChanged()

    }

    override fun showErrorMessage() {
        Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
    }

    override fun launchNewsDetail(news: Hit) {
        try {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(news.url)
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            e.printStackTrace()
        }


    }

    override fun onClick(view: View) {
        presenter!!.getNews(editSearch!!.text.toString())
    }

    internal inner class NewsAdapter(private val newsList: List<Hit>) : RecyclerView.Adapter<NewsViewHolder>() {
        private var createdAt: Date? = null

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
            val inflater = LayoutInflater.from(this@NewsActivity)
            return NewsViewHolder(inflater.inflate(R.layout.news_item_layout, parent, false))
        }

        override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
            val newsItem = newsList[position]
            holder.tvNewsName.text = newsItem.title
            holder.tvAuthor.text = "By " + newsItem.highlightResult!!.author!!.value!!
            try {
                val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                createdAt = formatter.parse(newsItem.createdAt)
            } catch (e: ParseException) {
                e.printStackTrace()
            }

            holder.tvDateCreated.text = "on " + DateUtils.getRelativeTimeSpanString(createdAt!!.time, Date().time, 0L, DateUtils.FORMAT_ABBREV_ALL).toString()
            holder.container.setOnClickListener { view -> launchNewsDetail(newsItem) }
        }

        override fun getItemCount(): Int {
            return newsList.size
        }
    }


}
