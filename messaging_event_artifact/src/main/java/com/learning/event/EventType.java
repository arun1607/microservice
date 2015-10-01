package com.learning.event;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by amits on 28/09/15.
 */

public enum EventType {
    ORDER_PLACED, ORDER_SUCCESS, ORDER_FAILED, SHIPMENT_CREATED, SHIPMENT_DELIVERED,NONE,INVENTORY_UPDATED;
}
