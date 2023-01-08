package com.himanshuhc.statistics;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SpendingAdapter extends RecyclerView.Adapter<SpendingAdapter.ViewHolder>{

    private List<SpendingPojo> spendingPojoList;
    private Context context;

    public SpendingAdapter(List<SpendingPojo> arrayList, Context context) {
        this.spendingPojoList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public SpendingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_spending_recyclerview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpendingAdapter.ViewHolder holder, int position) {
        if (position==1){
            holder.itemView.setBackground(context.getDrawable(R.drawable.item_color_background));
            holder.spendingHeadings.setTextColor(context.getColor(R.color.white));
            holder.spendingTime.setTextColor(context.getColor(R.color.white));
            holder.spendingPrice.setTextColor(context.getColor(R.color.white));
        }
        holder.logo.setImageResource(spendingPojoList.get(position).img);
        holder.spendingHeadings.setText(spendingPojoList.get(position).spendingName);
        holder.spendingTime.setText(spendingPojoList.get(position).spendingTime);
        holder.spendingPrice.setText("-$ "+spendingPojoList.get(position).spendingPrice);
    }

    @Override
    public int getItemCount() {
        return spendingPojoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView spendingHeadings, spendingTime, spendingPrice;
        private ImageView logo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            logo = itemView.findViewById(R.id.logo_IV);
            spendingHeadings = itemView.findViewById(R.id.heading_TV);
            spendingTime = itemView.findViewById(R.id.time_TV);
            spendingPrice = itemView.findViewById(R.id.price_TV);
        }
    }
}
