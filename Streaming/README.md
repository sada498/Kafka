# Start a Kafka and Zookeeper

<details><summary>Streaming</summary>
<p>

## 1. Run stream application
    ./gradlew run

## 2. Start console producer for *Sales_Product_data-topic*
    .\bin\windows\kafka-console-producer --broker-list localhost:9092 --topic Sales_Product_data-topic --property parse.key=true --property key.separator=:
## 3. Start console consumer for *Sales_Accounting_data-topic*
    .\bin\windows\kafka-console-consumer --bootstrap-server localhost:9092 --topic Sales_Accounting_data-topic --property print.key=true
## 4. Testing
![](https://github.com/sada498/Kafka/blob/main/Streaming/img/result.JPG)
</p>

</details> 

<details><summary>StatelessTransformations</summary>
<p>

## 1. Run StatelessTransformations main class only 

## 2. Start console producer for *stateless-transformations-purchase-product-input-topic*
    .\bin\windows\kafka-console-producer --broker-list localhost:9092 --topic stateless-transformations-purchase-product-input-topic --property parse.key=true --property key.separator=:
## 3. Start console consumer for *stateless-transformations-Accounting-purchase-data-output-topic*
    .\bin\windows\kafka-console-consumer --bootstrap-server localhost:9092 --topic stateless-transformations-Accounting-purchase-data-output-topic --property print.key=true
## 4. Testing
![]()
</p>
</details> 

<details><summary></summary>
<p>


</p>
</details> 