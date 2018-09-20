package org.github.jecihjoy.vumanewsv0001.data.netUtils;

import org.github.jecihjoy.vumanewsv0001.data.model.News;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jecihjoy on 6/10/2018.
 */

public class JsonParser {

    public static List<News> parseFeed(String content){

        try {
            JSONObject myDataObject = new JSONObject(content);
            JSONArray array = myDataObject.getJSONArray("articles");
            List<News> allnews = new ArrayList<>();

            //objects and arrays. json array does not implement the iterable interface
            //hence foreach cannot be used

            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                News mynewsa = new News();
                mynewsa.setUrl(object.getString("url"));
                mynewsa.setAuthor(object.getString("author"));
                mynewsa.setTitle(object.getString("title"));
                mynewsa.setDescription(object.getString("description"));
                mynewsa.setPublishedAt(object.getString("publishedAt"));
                mynewsa.setUrlToImage(object.getString("urlToImage"));

                allnews.add(mynewsa);
            }
            return allnews;
        }catch (JSONException e){
            e.printStackTrace();
            return  null;
        }

    }
}