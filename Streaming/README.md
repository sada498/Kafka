# Start a Kafka and Zookeeper

## 1. Run stream application
    ./gradlew run

## 2. Start console producer for *Sales_Product_data-topic*
    .\bin\windows\kafka-console-producer --broker-list localhost:9092 --topic Sales_Product_data-topic --property parse.key=true --property key.separator=:
## 3. Start console consumer for *Sales_Accounting_data-topic*
    .\bin\windows\kafka-console-consumer --bootstrap-server localhost:9092 --topic Sales_Accounting_data-topic --property print.key=true
## 4. Testing
[]()