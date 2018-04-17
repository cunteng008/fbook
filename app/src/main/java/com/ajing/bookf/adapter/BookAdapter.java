package com.ajing.bookf.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ajing.bookf.R;
import com.ajing.bookf.base.GlobalInfo;
import com.ajing.bookf.entity.Book;
import com.ajing.bookf.ui.book.BookDetailActivity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    private Context mContext;
    private List<Book> mBooks;

    public BookAdapter(Context context){
        mContext = context;
        mBooks = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_book,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Book book = mBooks.get(position);
        Glide.with(mContext).load(GlobalInfo.getInstance().getDomain()+book.getBookImage())
                .placeholder(R.color.placeholder_color)
                .into(holder.ivBook);
        holder.tvName.setText(book.getName());
    }

    @Override
    public int getItemCount() {
        return mBooks.size();
    }

    public void addBooks(List<Book> books){
        mBooks.addAll(books);
        notifyDataSetChanged();
    }
    public void addBook(Book book){
        mBooks.add(book);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivBook;
        TextView tvName;
        public ViewHolder(View itemView) {
            super(itemView);
            ivBook = (ImageView) itemView.findViewById(R.id.iv_book);
            tvName = (TextView) itemView.findViewById(R.id.tv_book_name);

            itemView.setOnClickListener((v)->{
                Intent intent = new Intent(mContext, BookDetailActivity.class);
                mContext.startActivity(intent);
            });
        }
    }
}
