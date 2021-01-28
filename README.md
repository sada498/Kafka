# Kafka
[Check out how to install kafka on windows and Ubuntu or Mac](https://github.com/sada498/kafka-java-scala-mariadb)
 
 Index 
 1. [Command line Kafka Publishing and Consuming Some Data](https://github.com/sada498/Kafka#1-command-line-kafka-publishing-and-consuming-some-data)
 2. [Create a kafka producer topic using springboot and Gradle build application.]
# 1. Command line Kafka Publishing and Consuming Some Data
## 1. Create a kafka topic first.
   kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 3 --partitions 6 --topic inv_purchases_data
   
![](https://github.com/sada498/Kafka/blob/main/img/topic.JPG)
## 2. Create a command line  producer
   kafka-console-producer --broker-list localhost:9092 --topic inv_purchases_data
   
![](https://github.com/sada498/Kafka/blob/main/img/cmdkafkaproducer.JPG)   
## 3. Create a a command line consumer
   kafka-console-consumer --bootstrap-server localhost:9092 --topic inv_purchases_data --from-beginning
   
 ![](https://github.com/sada498/Kafka/blob/main/img/consumer.JPG)  
   done!
# 2. Create a kafka producer topic using springboot and Gradle build application

## 1. Clone the git repo code 
    git clone https://github.com/sada498/Kafka.git 
    
> Note: I am using Ubuntu to test code and running kafka. To start kafka on windows. [click](https://github.com/sada498/kafka-java-scala-mariadb/blob/main/README.md#kafka-download-for-windows)
## 2.Start the zookeeper service

    ./bin/zookeeper-server-start.sh ./config/zookeeper.properties 
## 3. Start the kafka service

    ./bin/kafka-server-start.sh ./config/server.properties 
    
## 4. change directory to run an application
     cd Kafka/kafka-simple-producer
    ./gradlew run