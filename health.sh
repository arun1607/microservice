#!/bin/sh

shipment_service_status=`curl -sL -w "%{http_code}\\n" "http://localhost:9093/health" -o /dev/null`

if [ $shipment_service_status == "200" ]; then
	echo "Shipment service is running fine"
else
	echo "Shipment service is not up"
fi

order_service_status=`curl -sL -w "%{http_code}\\n" "http://localhost:9092/health" -o /dev/null`

if [ $order_service_status == "200" ]; then
	echo "Order service is running fine"
else
	echo "Order service is not up"
fi

inventory_service_status=`curl -sL -w "%{http_code}\\n" "http://localhost:9091/health" -o /dev/null`

if [ $inventory_service_status == "200" ]; then
	echo "Inventory service is running fine"
else
	echo "Inventory service is not up"
fi
customer_service_status=`curl -sL -w "%{http_code}\\n" "http://localhost:9090/health" -o /dev/null`

if [ $customer_service_status == "200" ]; then
	echo "Customer service is running fine"
else
	echo "Customer service is not up"
fi
