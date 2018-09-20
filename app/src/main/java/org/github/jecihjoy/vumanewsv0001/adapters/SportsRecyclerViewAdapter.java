package org.github.jecihjoy.vumanewsv0001.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.github.jecihjoy.vumanewsv0001.NewsDetailActivity;
import org.github.jecihjoy.vumanewsv0001.R;
import org.github.jecihjoy.vumanewsv0001.data.model.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jecihjoy on 6/9/2018.
 */

public class SportsRecyclerViewAdapter extends RecyclerView.Adapter<SportsRecyclerViewAdapter.NewsViewHolder> {
    private Context context;
    private List<News> sportsNews;

    public SportsRecyclerViewAdapter(Context context, List<News> sportsNews) {
        this.context = context;
        this.sportsNews = sportsNews;
    }
    public void setNewsList(List<News> sNews) {
        this.sportsNews = sNews;
        notifyDataSetChanged();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        private ImageView imageView;
        private TextView txt_title;
        private TextView txt_author;
        private TextView txt_date;
        private  TextView txt_desc;
        private Button btn_readmore;
        private ImageView btn_share;
        private ImageView btn_save;
        public NewsViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            imageView = itemView.findViewById(R.id.imageView);
            txt_title = itemView.findViewById(R.id.title);
            txt_author = itemView.findViewById(R.id.author);
            txt_date = itemView.findViewById(R.id.date);
            txt_desc = itemView.findViewById(R.id.description);
            btn_readmore = itemView.findViewById(R.id.readmore);
            btn_share = itemView.findViewById(R.id.btn_share);
            btn_save = itemView.findViewById(R.id.btn_save);
        }
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_home_news_row,parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        Log.e("","ARRAYSIZE  :: :::"+sportsNews.size());
        holder.txt_title.setText(sportsNews.get(position).getTitle());
        holder.txt_author.setText("Author: "+sportsNews.get(position).getAuthor());
        holder.txt_date.setText(""+sportsNews.get(position).getPublishedAt());
        holder.txt_desc.setText(sportsNews.get(position).getDescription());

        Picasso.with(context)
                .load(sportsNews.get(holder.getAdapterPosition()).getUrlToImage())
                .into(holder.imageView);

        holder.btn_readmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startDetailActivityIntent = new Intent(context, NewsDetailActivity.class);
                startDetailActivityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startDetailActivityIntent.putExtra("url",sportsNews.get(position).getUrl() );
                context.startActivity(startDetailActivityIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.e("","ARRAYSIZE  :: :::"+sportsNews.size());
        return sportsNews.size();
    }
}
