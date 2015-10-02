#!/bin/sh

echo "Stopping customer management service with ID : `cat customer_management_artifact/PID`"

kill -9 `cat customer_management_artifact/PID`

rm -rf customer_management_artifact/PID

echo "Stopping inventory management service with ID : `cat inventory_management_artifact/PID`"

kill -9 `cat inventory_management_artifact/PID`

rm -rf inventory_management_artifact/PID

echo "Stopping order management service with ID : `cat order_management_artifact/PID`"

kill -9 `cat order_management_artifact/PID`

rm -rf order_management_artifact/PID

echo "Stopping shipment management service with ID : `cat shipment_management_artifact/PID`"

kill -9 `cat shipment_management_artifact/PID`

rm -rf shipment_management_artifact/PID
