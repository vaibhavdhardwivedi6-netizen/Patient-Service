# 🏥 Patient Service

[![Spring Boot](https://img.shields.io/badge/Spring--Boot-3.x-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue.svg)](https://www.postgresql.org/)
[![Eureka Client](https://img.shields.io/badge/Eureka-Client-yellow.svg)](https://spring.io/projects/spring-cloud-netflix)

The **Patient Service** is a microservice within the **Hospital Management System (HMS)** ecosystem. It handles patient registration, personal medical records, disease diagnostics info, and age details.

---

## 🛠️ Architecture & Tech Stack

- **Java Version**: 17+
- **Framework**: Spring Boot 3.x with Spring Data JPA & Hibernate
- **Database**: PostgreSQL (`PostgreSQLDialect`)
- **Service Discovery**: Netflix Eureka Client (`PATIENT-SERVICE`)
- **Utilities**: Lombok, Maven

---

## ⚙️ Configuration & Environment Variables

### Environment Variables

Set the following database credentials before launching the microservice:

| Variable | Description | Example |
|---|---|---|
| `URL` | PostgreSQL JDBC Connection String | `jdbc:postgresql://localhost:5432/hms_patient_db` |
| `USERNAME` | Database username | `postgres` |
| `PASSWORD` | Database password | `postgres` |

### Server Port
- **Port**: `8082`

---

## 📋 Data Model (`Patient`)

| Field Name | Type | Description |
|---|---|---|
| `id` | `Long` | Primary Key (Auto Generated) |
| `name` | `String` | Patient full name |
| `disease` | `String` | Medical condition / diagnosed disease |
| `age` | `Integer` | Patient age |

---

## 🚀 REST API Endpoints

### Base Path: `/api/v1/patient`

#### 1. Get All Patients
- **Method**: `GET`
- **Path**: `/api/v1/patient`
- **Response**: `200 OK`
```json
[
  {
    "id": 1,
    "name": "Michael Scott",
    "disease": "Hypertension",
    "age": 45
  }
]
```

#### 2. Create Patient Record
- **Method**: `POST`
- **Path**: `/api/v1/patient`
- **Request Body**:
```json
{
  "name": "Michael Scott",
  "disease": "Hypertension",
  "age": 45
}
```
- **Response**: `201 Created`

#### 3. Get Patient by ID
- **Method**: `GET`
- **Path**: `/api/v1/patient/{id}`
- **Response**: `200 OK`

#### 4. Delete Patient
- **Method**: `DELETE`
- **Path**: `/api/v1/patient/{id}`
- **Response**: `200 OK`

---

## 🚦 Getting Started

### 1. Prerequisites
- Java 17+
- PostgreSQL database
- Eureka Discovery Server (`Hospital-Server`) running on port `8761`

### 2. Run Locally

```bash
# Clone repository
git clone https://github.com/vaibhavdhardwivedi6-netizen/Patient-Service.git
cd Patient-Service

# Set Environment Variables (PowerShell)
$env:URL="jdbc:postgresql://localhost:5432/hms_patient"
$env:USERNAME="postgres"
$env:PASSWORD="postgres"

# Build & Run
./mvnw spring-boot:run
```