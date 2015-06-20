package jotaemepereira.com.blogandroidfilter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    protected TextView mItemNameTextView;
    protected TextView mItemPriceTextView;

    public ItemViewHolder(View itemView) {
        super(itemView);

        mItemNameTextView = (TextView) itemView.findViewById(R.id.item_name);
        mItemPriceTextView = (TextView) itemView.findViewById(R.id.item_price);
    }

}
