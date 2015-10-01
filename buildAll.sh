#!/bin/sh

build_module (){
	cd $1
	rm -rf build.output
	echo "Building module $1"
	mvn -T 1C clean install -DskipTests=true -DdownloadSources=false >> ../build.output 
	cd ..
}

rm -rf build.output

build_module "messaging_event_artifact"
build_module "embedded_activemq_broker" &
build_module "customer_management_artifact" &
build_module "inventory_management_artifact" &
build_module "order_management_artifact" &
build_module "shipment_management_artifact" &



