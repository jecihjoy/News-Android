package org.github.jecihjoy.vumanewsv0001.fragments;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.github.jecihjoy.vumanewsv0001.R;
import org.github.jecihjoy.vumanewsv0001.adapters.GoogleRecyclerViewAdapter;
import org.github.jecihjoy.vumanewsv0001.adapters.HomeRecyclerViewAdapter;
import org.github.jecihjoy.vumanewsv0001.adapters.TestRecyclerAdapter;
import org.github.jecihjoy.vumanewsv0001.data.model.News;
import org.github.jecihjoy.vumanewsv0001.data.netUtils.JsonParser;
import org.github.jecihjoy.vumanewsv0001.data.netUtils.NewsMethods;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    RecyclerView recyclerView;
    List<News> homeList;
    HomeRecyclerViewAdapter recyclerViewAdapter;
    String message;
    public  final String BASEURL = "https://newsapi.org/v1/articles?";
    private RequestQueue requestQueue;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        homeList = new ArrayList<>();

        NewsMethods.handleSSLHandshake();

        recyclerView = view.findViewById(R.id.homeRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(
                view.getContext().getApplicationContext()
        );
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter = new HomeRecyclerViewAdapter(
                getActivity().getApplicationContext(), homeList
        );


        if(isOnline()){
            requestData(NewsMethods.returnUrl(BASEURL,"4b60cb6a7714467494d50d7cca19c7e8","google-news"));
            recyclerView.setAdapter(recyclerViewAdapter);
            // mTextDate.append(message + "\n");
        }else {
            Toast.makeText(getActivity().getApplicationContext(),"Internet not available", Toast.LENGTH_SHORT).show();
        }

        return view;
    }

    protected boolean isOnline(){
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ninfo = cm.getActiveNetworkInfo();
        if(ninfo != null && ninfo.isConnectedOrConnecting()){
            //checking for wifi
            /*if(ninfo.getType() != ConnectivityManager.TYPE_WIFI){
                Toast.makeText(this, "This app doesn't work without WIFI", Toast.LENGTH_LONG).show();
                return false;
            }*/
            return true;
        }else {
            return false;
        }

    }

    public void requestData(String uri){
        StringRequest request = new StringRequest(uri,
                new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        message = response;
                        homeList = JsonParser.parseFeed(message);
                        recyclerViewAdapter.setNewsList(homeList);
                    }
                },
                new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        requestQueue.add(request);

    }

}
