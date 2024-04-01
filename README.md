# Intelligence Plane Spring Kafka message system

Spring Boot + Kafka project to demonstrate intelligence plane communication.

## Setup

 1. Clone the repository:<br/> `git clone https://github.com/sandeepSbudhya/producer.git`
 2. This project requires **Java 17** (openjdk version "17.0.10"), **docker version 25.0.3** and **Apache Maven 3.8.7**. Install these packages using any package manager.<br/>Sample command for Arch Linux<br/>`sudo pacman -Syu maven docker jdk17-openjdk`
 3. download and extract Apache kafka Version 3.7.0 binaries from <br/>https://downloads.apache.org/kafka/3.7.0/kafka_2.12-3.7.0.tgz<br/> and extract it to a folder called **"kafka**" under the **root** folder.<br/> The folder structure should look as follows:<br/>.
├── kafka
│   ├── bin
│   │   └── windows
│   ├── config
│   │   └── kraft
│   ├── libs
│   ├── licenses
│   ├── logs
│   └── site-docs
├── spring-kafka-producer
│   ├── src
│   │   ├── main
│   │   │   ├── java
│   │   │   │   └── com
│   │   │   │       └── springbootkafka
│   │   │   │           └── producer
│   │   │   │               ├── controllers
│   │   │   │               ├── services
│   │   │   │               └── types
│   │   │   └── resources
│   │   └── test
│   │       └── java
│   │           └── com
│   │               └── springbootkafka
│   │                   └── producer
│   └── wrapper
└── target
    ├── classes
    ├── generated-sources
    │   └── annotations
    ├── generated-test-sources
    │   └── test-annotations
    └── test-classes
    
 4. from **root** directory change directory to **"spring-kafka-producer"**:<br/>`cd spring-kafka-producer`<br/>and run:<br/>`mvn clean package`<br/>This will generate a jar package in the **target** tolder.
 5. from the **root** directory run<br/>`sudo docker build -t producer:latest`<br/>to build a **container image** of the app.
 6. from the **root** directory run:<br/>`sudo docker run --rm --net=host -t producer:latest`<br/>This will **run** the containerized application locally.
## APIs available
### Ports
Ports exposed when the containerized application is running:
http://localhost:8080 This is the port that the spring boot applications controllers receives requests on.
http://localhost:9092 This is the port for the Apache Kafka broker.
http://localhost:2181 This is the port for Zookeeper.
### Endpoints
http://localhost:8080/create-topic<br/>

 7. send a **POST** message to  this endpoint  with json body:<br/>{<br/>&emsp;"topic":"performance-messages"<br/>}<br/>To create the performance message topic and with json body:
{<br/>&emsp;"topic":"progress-messages"<br/>}<br/>To create the progress message topic.<br/>

8. Send **POST** message to the following urls with json bodies similar to the sample to push a message into the respective topics in kafka.<br/>http://localhost:8080/producemessage/performance<br/>{
&emsp;"accuracy"  :  0.579,
&emsp;"fmeasure"  :  0.67,
&emsp;"precision"  :  0.55,
&emsp;"recall"  :  0.67,
&emsp;"jobId"  :  "1"
}
http://localhost:8080/producemessage/progress<br/>{
&emsp;"epochsCompleted"  :  1,
&emsp;"totalEpochs"  :  2,
&emsp;"days"  :  1,
&emsp;"hours"  :  2,
&emsp;"minutes"  :  3,
&emsp;"jobId"  :  1
}
