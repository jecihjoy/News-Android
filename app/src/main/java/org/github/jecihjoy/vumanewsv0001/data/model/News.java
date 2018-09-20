package org.github.jecihjoy.vumanewsv0001.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Jecihjoy on 6/9/2018.
 */

public class News {
    @SerializedName("name")
    private String title;
    private String author;
    private String description;
    private  String url;
    private String urlToImage;
    private String publishedAt;

    public News() {
    }

    public News(String title, String author, String description, String url, String urlToImage, String publishedAt) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }
}
