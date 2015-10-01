package com.learning.entity;

import com.learning.exception.InsufficientItemStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Created by amits on 22/09/15.
 */
@Entity
@Getter
@Setter
public class InventoryItem extends BaseEntity{

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer quantity;

    public void addItems(Integer itemCount) {
        quantity += itemCount;
    }

    public void reduceItemStock(Integer itemCount) throws InsufficientItemStockException {
        quantity -= itemCount;
    }
}
