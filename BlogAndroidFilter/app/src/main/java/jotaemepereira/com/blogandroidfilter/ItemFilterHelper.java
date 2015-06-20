package jotaemepereira.com.blogandroidfilter;

import java.util.List;

import java8.util.stream.Collectors;
import java8.util.stream.StreamSupport;

public class ItemFilterHelper {

    public static List<Item> filterItemsByItemName(List<Item> items, String filterString) {
        if (filterString == null || filterString.length() == 0) {
            return items;
        }

        String filterStringLowerCase = filterString.toLowerCase();

        return StreamSupport.stream(items).
                filter(item -> item.getName().toLowerCase().
                        startsWith(filterStringLowerCase)).collect(Collectors.toList());
    }
}
