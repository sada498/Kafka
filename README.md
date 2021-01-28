# Kafka
 
 
# 1. Command line Kafka Publishing and Consuming Some Data
## 1. Create a kafka topic first.
   kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 3 --partitions 6 --topic inv_purchases_data
## 2. Create a command line  producer
   kafka-console-producer --broker-list localhost:9092 --topic inv_purchases_data
   
## 3. Create a a command line consumer
   kafka-console-consumer --bootstrap-server localhost:9092 --topic inv_purchases_data --from-beginning
   
   done!
