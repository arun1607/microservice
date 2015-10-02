#!/bin/sh


if [ -f customer_management_artifact/PID ]; then
	echo "Do you want to stop customer management service : y/n" 
	read custom_service_input

	if [ $custom_service_input == "y" ]; then
	
		pid=`cat customer_management_artifact/PID`

		echo "Stopping customer management service with ID : $pid"

		kill -9 $pid

		rm -rf customer_management_artifact/PID
	fi
fi

if [ -f inventory_management_artifact/PID ]; then
	echo ""
	echo  "Do you want to stop inventory management service : y/n" 
	read inventory_service_input

	if [ $inventory_service_input == "y" ]; then
			
		pid=`cat inventory_management_artifact/PID`
	
		echo "Stopping inventory management service with ID : $pid"

		kill -9 $pid

		rm -rf inventory_management_artifact/PID
	fi
	
fi

if [ -f order_management_artifact/PID ]; then
	echo ""
	echo  "Do you want to stop order management service : y/n" 
	read order_service_input

	if [ $order_service_input == "y" ]; then

		pid=`cat order_management_artifact/PID`
	
		echo "Stopping order management service with ID : $pid"

		kill -9 $pid

		rm -rf order_management_artifact/PID
	fi
fi

if [ -f shipment_management_artifact/PID ]; then
	echo ""
	echo  "Do you want to stop shipment management service : y/n" 
	read shipment_service_input

	if [ $shipment_service_input == "y" ]; then
		
		pid=`cat shipment_management_artifact/PID`
	
		echo "Stopping shipment management service with ID : $pid"

		kill -9 $pid

		rm -rf shipment_management_artifact/PID
	fi
fi


