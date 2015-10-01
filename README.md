## Sample microservices based application in Spring Boot



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
