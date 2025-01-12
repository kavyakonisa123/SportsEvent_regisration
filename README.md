# SportsEvent_regisration

# Project Setup and Execution Guide

This document outlines the steps required to set up and run the project, which integrates Apache Kafka, Prometheus, and Grafana with a MySQL database and a Spring Boot application.

## Prerequisites

Ensure you have the following software installed:
- **Spring Tool Suite (STS)**: For managing the Spring Boot project.
- **MySQL**: To manage the database.
- **Kafka**: For event streaming.
- **Prometheus**: For metrics collection.
- **Grafana**: For data visualization.

## Project Setup

### 1. Set Up Spring Boot Project

- Launch **STS** (Spring Tool Suite).
- Import the project from the provided zip file.
- Add **Apache Tomcat** server:
  - Go to `Window -> Show View -> Servers -> New`.
  
### 2. Configure MySQL Data Source

- Open the `application.properties` file.
- Configure your MySQL credentials:
  - Set the `dataSource`, `root`, `password`, and `database` as per your MySQL setup.

### 3. Set Up Kafka, Prometheus, and Grafana

- **Kafka**: Download from [Kafka Downloads](https://kafka.apache.org/downloads).
- **Prometheus**: Download from [Prometheus Downloads](https://prometheus.io/download/).
- **Grafana**: Download from [Grafana Downloads](https://grafana.com/grafana/download/).

### 4. Set Up Kafka

- Navigate to the Kafka download directory and go to the `bin` folder.
- Open 3 separate **Command Prompt** windows (as Administrator) and run the following commands:

  1. Start Zookeeper:
     ```bash
     .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
     ```

  2. Start Kafka Cluster:
     ```bash
     .\bin\windows\kafka-server-start.bat .\config\server.properties
     ```

  3. Create a topic named `user-registrations`:
     ```bash
     .\bin\windows\kafka-topics.bat --create --topic user-registrations --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1
     ```

  4. To listen to the topic:
     ```bash
     .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic user-registrations --from-beginning
     ```

### 5. Set Up MySQL

- Create a database in MySQL as per the settings in `application.properties`.
- Populate the data for the tables once the project is running in STS.

### 6. Run the Spring Boot Project

- In **STS**, right-click on the project.
- Select `Run As -> Spring Boot App`.
- Once the project starts, open your browser and go to `http://localhost:8080/`.
  
The application frontend page will load, and as users register for events, the data will be updated in the database, Kafka topic, and CSV files. The CSV data will be displayed in visualizations on the dashboard page.

### 7. Access Metrics

- To view metrics, navigate to: `http://localhost:8080/actuator/metrics`.

### 8. Set Up Prometheus

- Modify the `prometheus.yml` configuration file to include:
  ```yaml
  metrics_path: '/actuator/prometheus'
  static_configs:
    - targets: ["localhost:8080"]
