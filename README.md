## Demo client app for sending and recieving messages using Apache Kafka

### Usage
1. Start a local instance of Kafka in Vagrant using the kafka machine
```
vagrant up kafka
```
2. Provision the kafka machine using the kafka alias from the local ansible controller machine
```
vagrant up ansible
vagrant ssh
kafka
```
3. Start the demo application
```
cd springboot-kafka-client
mvn clean install
java -jar target/springboot-kafka-client-1.0-SNAPSHOT.jar
```
4. Sent a few messages to Kafka by using the configured http endpoint
```
http://localhost:8080/send
```
The logfile should contain information about the messages:
```
09:10:37.184 [kafka-producer-network-thread | tnt] INFO  se.sbab.kafka.spring.Sender - Sending message='{"timestamp": 1508829036647, "message": "Hello from TnTmessage' succeeded
09:10:37.255 [org.springframework.kafka.KafkaListenerEndpointContainer#0-0-C-1] INFO  se.sbab.kafka.spring.Receiver - received key='Key' message='{"timestamp":age": "Hello from TnT #1"}'
09:10:40.323 [kafka-producer-network-thread | tnt] INFO  se.sbab.kafka.spring.Sender - Sending message='{"timestamp": 1508829040315, "message": "Hello from TnTmessage' succeeded
09:10:40.324 [org.springframework.kafka.KafkaListenerEndpointContainer#0-0-C-1] INFO  se.sbab.kafka.spring.Receiver - received key='Key' message='{"timestamp":age": "Hello from TnT #2"}'
09:10:42.249 [kafka-producer-network-thread | tnt] INFO  se.sbab.kafka.spring.Sender - Sending message='{"timestamp": 1508829042246, "message": "Hello from TnTmessage' succeeded
09:10:42.250 [org.springframework.kafka.KafkaListenerEndpointContainer#0-0-C-1] INFO  se.sbab.kafka.spring.Receiver - received key='Key' message='{"timestamp":age": "Hello from TnT #3"}'
09:10:42.863 [kafka-producer-network-thread | tnt] INFO  se.sbab.kafka.spring.Sender - Sending message='{"timestamp": 1508829042859, "message": "Hello from TnTmessage' succeeded
09:10:42.864 [org.springframework.kafka.KafkaListenerEndpointContainer#0-0-C-1] INFO  se.sbab.kafka.spring.Receiver - received key='Key' message='{"timestamp":age": "Hello from TnT #4"}'
```

### Configuration options
Modify the application.yml to use different Kafka servers:
Local vagrant environment:
bootstrap-servers: "d-kafka01.sbab.se:9092"

Sys environment: (servers from https://stash.sbab.se/projects/AFTO/repos/ansible/browse/inventories/sys/hosts [kafka] group)
bootstrap-servers: "t-kafka01.sbab.se:9092,t-kafka02.sbab.se:9092,t-kafka03.sbab.se:9092"

Modify auto-offset-reset and group-id in application.yml file to change the consumer behaviour to meet your needs 