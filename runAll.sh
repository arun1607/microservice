#!/bin/sh 


#echo  "Do you want to start embedded broker: y/n"
#read embedded_broker_input
#if [ $embedded_broker_input == "y" ]; then
#	echo "Starting embedded broker"
#	java -jar ./embedded_activemq_broker/target/activemq-broker-1.2.6.RELEASE.jar  > embedded_broker.log 2>&1 &
#	echo $! >> services.pid
#fi

echo "Do you want to start customer management service : y/n" 
read custom_service_input

if [ $custom_service_input == "y" ]; then
	if [ -f customer_management_artifact/PID ]; then
		echo "Process customer management service is already running"
	else
		echo "Starting customer management service"
		rm -rf customer_management_artifact/PID
		java -jar ./customer_management_artifact/target/customer-management-1.2.6.RELEASE.jar -Dcom.sun.management.jmxremote.port=1101 -Dcom.sun.management.jmxremote.authenticate=false > customer_management.log 2>&1 &
		echo $! > customer_management_artifact/PID
	fi
fi

echo ""
echo  "Do you want to start inventory management service : y/n" 
read inventory_service_input

if [ $inventory_service_input == "y" ]; then
	if [ -f inventory_management_artifact/PID ]; then
		echo "Process inventory management service is already running"
	else
		echo "Starting inventory management service"
		rm -rf inventory_management_artifact/PID
		java -jar ./inventory_management_artifact/target/inventory-management-1.2.6.RELEASE.jar -Dcom.sun.management.jmxremote.port=1102 -Dcom.sun.management.jmxremote.authenticate=false > inventory_management.log 2>&1 &
		echo $! > inventory_management_artifact/PID
	fi
fi

echo ""
echo  "Do you want to start order management service: y/n" 
read order_service_input

if [ $order_service_input == "y" ]; then
	if [ -f order_management_artifact/PID ]; then
		echo "Process order management service is already running"
	else
		echo "Starting order management service"
		rm -rf order_management_artifact/PID
		java -jar ./order_management_artifact/target/order-management-1.2.6.RELEASE.jar -Dcom.sun.management.jmxremote.port=1103 -Dcom.sun.management.jmxremote.authenticate=false > order_management.log 2>&1 &
		echo $! > order_management_artifact/PID
	fi	
fi

echo ""
echo  "Do you want to start shipment management service: y/n"
read shipment_service_input

if [ $shipment_service_input == "y" ]; then
	if [ -f shipment_management_artifact/PID ]; then
		echo "Process shipment management service is already running"
	else
		echo "Starting shipment management service"
		rm -rf shipment_management_artifact/PID
		java -jar ./shipment_management_artifact/target/shipment-management-1.2.6.RELEASE.jar -Dcom.sun.management.jmxremote.port=1104 -Dcom.sun.management.jmxremote.authenticate=false > shipment_management.log 2>&1 &
		echo $! > shipment_management_artifact/PID
	fi	
fi


