package io.github.Oleiva.dto.pojo;

import io.github.Oleiva.entity.OrdersEntity;
import io.github.Oleiva.entity.TransactionsEntity;

import java.util.List;

/**
 * Created by OleIva on 19.02.2016.
 */
public class OrderPojo {

    private List<TransactionsEntity> listOfItems ;

    private long coinsTotal;

    public List<TransactionsEntity> getListOfItems() {
        return listOfItems;
    }

    public void setListOfItems(List<TransactionsEntity> listOfItems) {
        this.listOfItems = listOfItems;
    }

    public long getCoinsTotal() {
        return coinsTotal;
    }

    public void setCoinsTotal(long coinsTotal) {
        this.coinsTotal = coinsTotal;
    }
}
