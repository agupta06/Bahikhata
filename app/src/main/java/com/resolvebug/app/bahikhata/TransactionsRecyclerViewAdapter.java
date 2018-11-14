package com.resolvebug.app.bahikhata;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TransactionsRecyclerViewAdapter extends RecyclerView.Adapter<TransactionsRecyclerViewAdapter.RecyclerViewHolder> {

    private Context context;
    private List<CardItems> cardItemsList;

    public TransactionsRecyclerViewAdapter(Context context, List<CardItems> cardItemsList) {
        this.context = context;
        this.cardItemsList = cardItemsList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.transactions_cardview_layout, null);
        return new RecyclerViewHolder(view);
    }


    // "final" is added just because of image view. in case it creates any problem in future, remove image view and remove "final"
    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, int position) {
        final CardItems cardItems = cardItemsList.get(position);
        holder.itemAmount.setText(String.valueOf(cardItems.getAmount()));
        holder.itemMessage.setText(cardItems.getMessage());
        holder.item_date.setText(cardItems.getDate());
        holder.important.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (cardItems.getImportant().equals("0")) {
                    holder.important.setImageResource(R.drawable.ic_baseline_favorite_24px);
                }
                else{
                    holder.important.setImageResource(R.drawable.ic_baseline_favorite_border_24px);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return cardItemsList.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView itemAmount;
        TextView itemMessage;
        TextView item_date;
        ImageView important;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            itemAmount = itemView.findViewById(R.id.item_amount);
            itemMessage = itemView.findViewById(R.id.item_message);
            important = itemView.findViewById(R.id.important);
            item_date = itemView.findViewById(R.id.item_date);
        }
    }

}
