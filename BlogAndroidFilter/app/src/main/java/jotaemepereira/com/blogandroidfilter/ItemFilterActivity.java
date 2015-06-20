package jotaemepereira.com.blogandroidfilter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.AbsListView;
import android.widget.EditText;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ItemFilterActivity extends AppCompatActivity {

    private RecyclerView mItemsRecyclerView;
    private EditText mSearchEditText;
    private ItemSearchFilter mItemSearchFilter;
    private List<Item> mItems = new ArrayList<>();
    private ItemAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_filter);

        initializeItemsList();
        setupItemsRecyclerView();
        setupSearchEditText();
    }

    private void setupItemsRecyclerView() {
        mItemsRecyclerView = (RecyclerView) findViewById(R.id.item_list);
        mItemsRecyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mItemsRecyclerView.setLayoutManager(linearLayoutManager);
        mItemsRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    private void setupSearchEditText() {
        mSearchEditText = (EditText) findViewById(R.id.search_edit_text);
        mSearchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable stringFilter) {
                mItemSearchFilter.filter(stringFilter);
            }
        });
    }

    private void createItemsSearchFilter() {
        mItemSearchFilter = new ItemSearchFilter(new ArrayList<>(mItems), this::refreshAdapter);
    }

    private void refreshAdapter(List<Item> items) {
        mItems.clear();
        mItems.addAll(items);
        mAdapter.notifyDataSetChanged();
    }

    private void initializeItemsList() {
        for (int i=0; i < 10; i++) {
            Item item = new Item();
            item.setName("Item " + i);
            item.setPrice(new BigDecimal(i));
            mItems.add(item);
        }

        createItemsSearchFilter();
        createAdapter();
    }

    private void createAdapter() {
        mAdapter = new ItemAdapter(mItems);
    }

}
