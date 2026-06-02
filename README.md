# DevPulse

DevPulse is a serverless API health monitoring platform built with Spring Boot and AWS.

Developers can register API endpoints, monitor uptime and response times, store health check history, and receive notifications when services become unavailable.

This project is designed as both a real-world SaaS-style application and a hands-on learning project for mastering AWS serverless services and preparing for the AWS Certified Developer – Associate certification.

---

## 🏗️ Architecture

```text
React Frontend
       │
       ▼
 API Gateway
       │
 Cognito JWT
       │
       ▼
 AWS Lambda (Spring Boot)
       │
       ▼
 DynamoDB
       │
       ▼
 EventBridge Scheduler
       │
       ▼
 Checker Lambda
       │
 ┌─────┴─────┐
 ▼           ▼
DynamoDB    SNS
(Check Logs) Alerts
```

---

## ✨ Features

### Current Features

* Create API monitors
* Retrieve configured monitors
* Store monitor data in DynamoDB
* Spring Boot REST API
* AWS SDK v2 DynamoDB Enhanced Client

### Planned Features

* Delete monitors
* Monitor details endpoint
* Scheduled health checks
* Response time tracking
* Uptime percentage calculation
* CloudWatch metrics
* SNS email alerts
* Cognito authentication
* API Gateway JWT authorization
* React dashboard
* AWS SAM deployment
* CI/CD with GitHub Actions

---

## 🛠️ Tech Stack

### Backend

* Java 21
* Spring Boot 3
* Maven

### AWS Services

* AWS Lambda
* Amazon API Gateway
* Amazon DynamoDB
* Amazon EventBridge
* Amazon SNS
* Amazon Cognito
* Amazon CloudWatch
* AWS SAM

---

## 📂 Project Structure

```text
src/main/java/com/devpulse
│
├── controller/
├── service/
├── repository/
├── model/
├── dto/
├── config/
└── lambda/
```

---

## 📋 Current API Endpoints

### Create Monitor

```http
POST /monitors
```

Request

```json
{
  "name": "Production API",
  "url": "https://api.example.com/health",
  "interval": 1
}
```

Response

```json
{
  "monitorId": "uuid",
  "name": "Production API",
  "url": "https://api.example.com/health",
  "interval": 1
}
```

---

### Get All Monitors

```http
GET /monitors
```

Response

```json
[
  {
    "monitorId": "uuid",
    "name": "Production API",
    "url": "https://api.example.com/health",
    "interval": 1
  }
]
```

---

## 🚀 Running Locally

### Prerequisites

* Java 21
* Maven 3.9+
* AWS CLI configured
* DynamoDB table created

### Configure AWS

```bash
aws configure
```

Verify credentials:

```bash
aws sts get-caller-identity
```

---

### Start Application

```bash
mvn clean install
mvn spring-boot:run
```

Application runs on:

```text
http://localhost:8080
```

---

## 🗄️ DynamoDB Table

### Monitors

| Attribute | Type        |
| --------- | ----------- |
| monitorId | String (PK) |
| name      | String      |
| url       | String      |
| interval  | Number      |

Billing Mode:

```text
On-Demand (PAY_PER_REQUEST)
```

---

## 🎯 Learning Goals

This project covers many of the services and concepts tested in the AWS Certified Developer – Associate exam:

* AWS Lambda
* API Gateway
* DynamoDB
* EventBridge
* SNS
* Cognito
* IAM
* CloudWatch
* Serverless Architecture
* AWS SAM

---

## 🗺️ Roadmap

### Week 1

* [x] Spring Boot Setup
* [x] DynamoDB Integration
* [x] Create Monitor API
* [x] Get Monitors API
* [ ] Delete Monitor API

### Week 2

* [ ] EventBridge Scheduler
* [ ] Checker Lambda
* [ ] Check Logs Table

### Week 3

* [ ] SNS Notifications
* [ ] CloudWatch Metrics

### Week 4

* [ ] Cognito Authentication
* [ ] API Gateway JWT Authorization
* [ ] Frontend Dashboard

---

## 👨‍💻 Author

Built by Hamza Rafique as a serverless AWS learning project and portfolio application.
