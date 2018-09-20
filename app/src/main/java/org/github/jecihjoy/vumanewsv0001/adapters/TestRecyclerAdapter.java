package org.github.jecihjoy.vumanewsv0001.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.github.jecihjoy.vumanewsv0001.R;
import org.github.jecihjoy.vumanewsv0001.data.model.News;

import java.util.List;

public class TestRecyclerAdapter extends RecyclerView.Adapter<TestRecyclerAdapter.MyViewHolder> {
    private List<News> newsList;
    Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView mCardView;
        public TextView mTextView;
        public MyViewHolder(View v) {
            super(v);

            mCardView = (CardView) v.findViewById(R.id.cardView);
            mTextView = v.findViewById(R.id.author);
        }
    }

    public TestRecyclerAdapter(List<News> newsList, Context context) {
        this.newsList = newsList;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public TestRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_home_news_row, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,  int position) {
        holder.mTextView.setText(newsList.get(position).getAuthor());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}
