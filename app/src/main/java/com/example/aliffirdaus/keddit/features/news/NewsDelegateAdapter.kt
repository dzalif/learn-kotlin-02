package com.example.aliffirdaus.keddit.features.news

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.aliffirdaus.keddit.R
import com.example.aliffirdaus.keddit.commons.adapter.ViewType
import com.example.aliffirdaus.keddit.commons.adapter.ViewTypeDelegateAdapter
import com.example.aliffirdaus.keddit.commons.extensions.getFriendlyTime
import com.example.aliffirdaus.keddit.commons.extensions.inflate
import com.example.aliffirdaus.keddit.commons.extensions.loadImg
import com.example.aliffirdaus.keddit.models.RedditNewsItem
import kotlinx.android.synthetic.main.news_item.view.*


class NewsDelegateAdapter: ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return TurnsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as TurnsViewHolder
        holder.bind(item as RedditNewsItem)
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.news_item)) {
        @SuppressLint("SetTextI18n")
        fun bind(item: RedditNewsItem) = with(itemView) {
            //Picasso.with(itemView.context).load(item.thumbnail).into(img_thumbnail)
            img_thumbnail.loadImg(item.thumbnail)
            description.text = item.title
            author.text = item.author
            comments.text = "${item.numComments} comments"
            time.text = item.created.getFriendlyTime()
        }
    }

}
