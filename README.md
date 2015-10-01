## Sample microservices based application in Spring Boot

#### Infrastructure Setup

1. Download activemq from http://www.apache.org/dyn/closer.cgi?path=/activemq/5.12.0/apache-activemq-5.12.0-bin.tar.gz
2. Untar the downloaded assembly and go to base directory of activemq which should be something similar to `apache-activemq-5.12.0`
3. Under base directory run `bin/activemq start` to start activemq
4. Access ActiveMQ at http://localhost:8161/admin/ with credential `admin/admin`
5. Select `Topic` in navigation bar and create new topic with name `microservice`

#### Application Setup

1. Create databases according to `application.propeties` present in respective modules.
2. Provide database credential in `application.properties`
3. Build all modules using `buildAll.sh`
4. All build logs are appended to `build.output`
5. Run all services along with message broker using `startAll.sh`
6. All running logs are appended to log files generated in root project.
7. Populate databases using `sample_data.sql` present under `src/main/resources` in each module.
8. Try to send following request from command line to generate order:
 `  curl -i -X POST -H "Content-Type:application/json" -d '{ "productId":"1", "customerId": "1", "billingAddressId":"1","quantity":"15" }' http://localhost:9092/order
`
9. You should be able to see messages in log files generated in project root directory corresponding to each component.
10. The shipment process automatically clears off all the shipments with status IN_TRANSIT and generates shipment success event.
11. To stop all processes including message broker use `killAll.sh`
