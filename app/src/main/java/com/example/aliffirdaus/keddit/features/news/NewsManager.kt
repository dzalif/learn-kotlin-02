package com.example.aliffirdaus.keddit.features.news

import com.example.aliffirdaus.keddit.api.RestAPI
import com.example.aliffirdaus.keddit.models.RedditNewsItem
import rx.Observable
import rx.Observable.create

class NewsManager(private val api: RestAPI = RestAPI()) {
    fun getNews(limit: String = "10"): Observable<List<RedditNewsItem>> {
        return create {
            subscriber ->
            val callResponse = api.getNews("", limit)
            val response = callResponse.execute()

            if (response.isSuccessful) {
                val news = response.body()?.data?.children?.map {
                    val item = it.data
                    RedditNewsItem(item.author, item.title, item.num_comments, item.created, item.thumbnail, item.url)
                }
                subscriber.onNext(news)
                subscriber.onCompleted()
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }
}
