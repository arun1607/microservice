package com.learning.rest.resource.shipment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * {"id":1,"shipmentAddress":{"id":1,"locality":"Baner","city":"Pune","state":"Maharastra","pinCode":"411045"},"status":"COMPLETED","shipmentOrder":{"id":1,"orderId":1,"product":{"id":1,"productId":null,"name":"Maharaja Whiteline","description":"First order"},"vendor":"Maharaja Electronics Pvt Ltd","payment":3000.0},"logistic":{"id":1,"name":"E-Kart Logistic LTD","email":"ekart@gmail.com"}}
 */

@Getter
@Setter
public class ShipmentBean {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("shipmentAddress")
    private ShipmentAddressBean shipmentAddress;
    @JsonProperty("status")
    private String status;
    @JsonProperty("shipmentOrder")
    private ShipmentOrderBean shipmentOrder;
    @JsonProperty("logistic")
    private ShipmentLogisticBean logistic;
}











