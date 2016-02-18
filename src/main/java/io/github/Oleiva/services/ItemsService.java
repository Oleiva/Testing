package io.github.Oleiva.services;


import io.github.Oleiva.entity.ItemsEntity;

public interface ItemsService {
//
//    public ItemsEntity addItem(String SKU, String NAME, long PRICE, long AMOUN);
//    public ItemsEntity add(ItemsEntity items);

    ItemsEntity addItems(String SKU, String NAME, long PRICE, long AMOUN);
    long amountItemInStock(long id);
//    void removeFromCredit(long cust, long amount, long item);
      void removeFromStock(long item, long amount);
    public long getAnte(long item,long amount);

}