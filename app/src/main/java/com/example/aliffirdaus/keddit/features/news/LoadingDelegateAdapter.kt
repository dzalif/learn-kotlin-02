package com.example.aliffirdaus.keddit.features.news

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.aliffirdaus.keddit.R
import com.example.aliffirdaus.keddit.commons.adapter.ViewType
import com.example.aliffirdaus.keddit.commons.adapter.ViewTypeDelegateAdapter
import com.example.aliffirdaus.keddit.commons.extensions.inflate


class LoadingDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup) = TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {

    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item_loading)) {
    }

}