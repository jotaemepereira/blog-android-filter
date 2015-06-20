package jotaemepereira.com.blogandroidfilter;

import android.support.v7.widget.RecyclerView;

import java.math.BigDecimal;

public class Item {

    private String name;
    private BigDecimal price;

    public Item() {

    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal itemPrice) {
        this.price = itemPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String itemName) {
        this.name = itemName;
    }
}
