package com.mohamed.animationstation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.AppViewHolder> {
    ArrayList<Class> mDataList;
    Context mContext;
    OnItemClicked mOnItemClicked;

    AppAdapter(ArrayList<Class> dataList, Context context, OnItemClicked onItemClicked) {
        mDataList = dataList;
        mContext = context;
        mOnItemClicked = onItemClicked;
    }

    @NonNull
    @Override
    public AppViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AppViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AppViewHolder holder, final int position) {
        holder.tv.setText(mDataList.get(position).getSimpleName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClicked.onClick(mDataList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }


    class AppViewHolder extends RecyclerView.ViewHolder {
        TextView tv;

        public AppViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv_name);
        }
    }

    interface OnItemClicked {
        void onClick(Class item);
    }
}
