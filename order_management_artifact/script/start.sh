#!/bin/sh

java -jar target/order-management-1.2.6.RELEASE.jar -Dcom.sun.management.jmxremote.port=1103 -Dcom.sun.management.jmxremote.authenticate=false > output.log &
