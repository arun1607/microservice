#!/bin/sh

java -jar target/inventory-management-1.2.6.RELEASE.jar -Dcom.sun.management.jmxremote.port=1102 -Dcom.sun.management.jmxremote.authenticate=false > output.log &
