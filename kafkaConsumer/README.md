## producer test(before kafka and zookeeper running)
## 1.Create a topic to use for testing
    kafka-topics --bootstrap-server localhost:9092 --create --topic test_count --partitions 2 --replication-factor 1
## 2. run *kafkaProducerApplication*

## 2.Verify that the expected data appears in the output topic
    kafka-console-consumer --bootstrap-server localhost:9092 --topic test_count --property print.key=true --from-beginning
    
   <br>
   </br>
   
## Consumer test
<br> </br>

## 1. Create two test topics to consume
    kafka-topics --bootstrap-server localhost:9092 --create --topic test_topic1 --partitions 2 --replication-factor 1
    
    kafka-topics --bootstrap-server localhost:9092 --create --topic test_topic2 --partitions 2 --replication-factor 1
## 2. Run *KafkaConsumerApplication*

## 3. Open a new shell, and run a console producer.
    kafka-console-producer --broker-list localhost:9092 --topic test_topic1
## 4. Open another new shell, and run a second console producer.
    kafka-console-producer --broker-list localhost:9092 --topic test_topic2
   
   Note: enter some data in producer console to see consumer data
    
 done :)
