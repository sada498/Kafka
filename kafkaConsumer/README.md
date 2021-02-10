## producer test(before kafka and zookeeper running)
## 1.Create a topic to use for testing
    kafka-topics --bootstrap-server localhost:9092 --create --topic test_count --partitions 2 --replication-factor 1
## 2. run *kafkaProducerApplication*

## 2.Verify that the expected data appears in the output topic
    kafka-console-consumer --bootstrap-server localhost:9092 --topic test_count --property print.key=true --from-beginning