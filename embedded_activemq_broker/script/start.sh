#!/bin/sh

java -jar target/customer-management-1.2.6.RELEASE.jar -Dcom.sun.management.jmxremote.port=1101 -Dcom.sun.management.jmxremote.authenticate=false > output.log &
