package jotaemepereira.com.blogandroidfilter;

import android.widget.Filter;

import java.util.List;

import static jotaemepereira.com.blogandroidfilter.ItemFilterHelper.filterItemsByItemName;

public class ItemSearchFilter extends Filter {

    private List<Item> mItemsList;
    private ItemSearchFilterInteraction mItemSearchFilterInteraction;

    public ItemSearchFilter(List<Item> items, ItemSearchFilterInteraction itemSearchFilterInteraction) {
        mItemsList = items;
        mItemSearchFilterInteraction = itemSearchFilterInteraction;
    }

    public void setItemsList(List<Item> items) {
        mItemsList = items;
    }

    @Override
    protected Filter.FilterResults performFiltering(CharSequence constraint) {
        Filter.FilterResults results = new Filter.FilterResults();
        List<Item> mFilteredItemList = filterItemsByItemName(mItemsList, constraint.toString());

        results.values = mFilteredItemList;
        results.count = mFilteredItemList.size();

        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, Filter.FilterResults results) {
        mItemSearchFilterInteraction.refreshDataSet((List<Item>) results.values);
    }

    public interface ItemSearchFilterInteraction {
        void refreshDataSet(List<Item> items);
    }
}
