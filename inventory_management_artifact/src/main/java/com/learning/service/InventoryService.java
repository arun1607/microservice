package com.learning.service;

import com.learning.entity.InventoryItem;
import com.learning.entity.InventoryOrder;
import com.learning.entity.OrderStatus;
import com.learning.exception.InsufficientItemStockException;
import com.learning.rest.resource.OrderResource;

/**
 * Created by amits on 28/09/15.
 */
public interface InventoryService {

    InventoryOrder createInventoryOrder(OrderResource orderResource) throws InsufficientItemStockException;

    void updateInventoryOrder(OrderResource orderResource, OrderStatus orderStatus);
}
