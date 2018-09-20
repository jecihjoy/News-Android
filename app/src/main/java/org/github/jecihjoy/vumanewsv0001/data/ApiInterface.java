package org.github.jecihjoy.vumanewsv0001.data;

import org.github.jecihjoy.vumanewsv0001.data.model.News;
import org.github.jecihjoy.vumanewsv0001.data.model.NewsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Jecihjoy on 6/10/2018.
 */

public interface ApiInterface {

    @GET("articles?apiKey=4b60cb6a7714467494d50d7cca19c7e8&source=google-news")
    Call<List<NewsModel>> getNews();
}
