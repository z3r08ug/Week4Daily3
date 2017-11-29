package dev.uublabs.week4daily3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import dev.uublabs.week4daily3.model.Book;

/**
 * Created by Admin on 11/27/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>
{
    List<Book> books = new ArrayList<>();
    Context context;

    public RecyclerAdapter(List<Book> books)
    {
        this.books = books;
//        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_list_item, null);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position)
    {
        Book book = books.get(position);
        if(book != null)
        {
            holder.tvBookInfo.setText(book.getTitle());
            Glide.with(context).load(book.getImageURL()).into(holder.ivBook);
        }
    }

    @Override
    public int getItemCount()
    {
        return books.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private final TextView tvBookInfo;
        private final ImageView ivBook;
        public ViewHolder(View itemView)
        {
            super(itemView);
            tvBookInfo = itemView.findViewById(R.id.tvBookInfo);
            ivBook = itemView.findViewById(R.id.ivBook);
        }
    }
}
