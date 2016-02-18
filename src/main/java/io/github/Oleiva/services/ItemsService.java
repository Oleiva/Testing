package io.github.Oleiva.services;


import io.github.Oleiva.entity.ItemsEntity;

public interface ItemsService {
//
//    public ItemsEntity addItem(String SKU, String NAME, long PRICE, long AMOUN);
//    public ItemsEntity add(ItemsEntity items);
    public ItemsEntity addItems(String SKU, String NAME, long PRICE, long AMOUN);
    public long amountItemInStock(long id);
    public void removeFromStock(long item, long amount);
}