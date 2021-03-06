package com.example.aliffirdaus.keddit.commons.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.aliffirdaus.keddit.commons.adapter.ViewType


interface ViewTypeDelegateAdapter {
    fun onCreateViewHolder(parent : ViewGroup): RecyclerView.ViewHolder
    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType)
}