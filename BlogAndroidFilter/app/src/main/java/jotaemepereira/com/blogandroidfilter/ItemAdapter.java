package jotaemepereira.com.blogandroidfilter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private List<Item> mItems;

    public ItemAdapter(List<Item> items) {
        mItems = items;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.layout_item_item, parent, false);

        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.mItemNameTextView.setText(mItems.get(position).getName());
        holder.mItemPriceTextView.setText(mItems.get(position).getPrice().toString());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
