package com.example.aliffirdaus.keddit.models

import com.example.aliffirdaus.keddit.commons.adapter.AdapterConstants
import com.example.aliffirdaus.keddit.commons.adapter.ViewType


data class RedditNewsItem(
        val author: String,
        val title: String,
        val numComments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String
        ) : ViewType {
    override fun getViewType() = AdapterConstants.NEWS
}