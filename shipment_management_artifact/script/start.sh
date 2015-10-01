#!/bin/sh

java -jar target/shipment-management-1.2.6.RELEASE.jar -Dcom.sun.management.jmxremote.port=1104 -Dcom.sun.management.jmxremote.authenticate=false > output.log &
