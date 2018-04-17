package com.ajing.bookf.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ajing.bookf.R;
import com.ajing.bookf.entity.MineFunction;

import java.util.List;

public class MineFunctionAdpater extends RecyclerView.Adapter<MineFunctionAdpater.ViewHolder> {
    private Context mContext;
    private List<MineFunction> mFunctions;

    public MineFunctionAdpater(Context context,List<MineFunction> functions){
        mContext = context;
        mFunctions = functions;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_mine_function,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvName.setText(mFunctions.get(position).getmName());
        holder.itemView.setOnClickListener((v)->{
            Intent intent = new Intent(mContext,mFunctions.get(position).getmActivityClass());
            mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return mFunctions.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvName;
        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_mine_function_name);
        }
    }
}
