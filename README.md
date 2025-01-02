# Time Zone Microservices Application

## Overview
The **Time Zone Microservices Application** is a Spring Boot-based project that provides functionality to calculate time differences between regions and convert times across different time zones. This application is designed as a microservice, with features like modularity, scalability, and a clean architecture.

---

## Flow of Services

![Flow Diagram](https://jcp-my.sharepoint.com/:wb:/p/rdas5/EbLNETxk6dJEiPXozVG5SDsBQfEoRzKmRqiOHpMgw-efdQ?e=HHuawg)

---

## Features

1. **Time Difference Calculation**:
   - Calculates the time difference between two regions based on their time zones.
   - Example endpoint:
     ```
     GET /time-difference/between/{region1}/and/{region2}
     ```

2. **Time Conversion**:
   - Converts the input time from one time zone to another.
   - Example endpoint:
     ```
     GET /convert-time/from/{sourceRegion}/to/{destinationRegion}/at/{time}
     ```

3. **Modular Microservice Design**:
   - Separates concerns into different packages (e.g., `controller`, `service`, `repository`).

4. **Spring Boot Framework**:
   - Built using Spring Boot for a streamlined development experience.

5. **Maven for Dependency Management**:
   - Uses Maven to manage project dependencies and build the project.

6. **RESTful API**:
   - Exposes endpoints to interact with the application via HTTP requests.

---

## Tools and Technologies

1. **Backend**:
   - Java 17
   - Spring Boot (2.x)
   - Spring Web
   - Spring Data JPA

2. **Build Tool**:
   - Maven

3. **Database**:
   - H2 Database (or configurable for external DBs)

4. **Version Control**:
   - Git
   - GitHub

5. **IDE**:
   - IntelliJ IDEA

6. **OS**:
   - macOS

---

## Project Structure

### `src/main/java`
- **`controller`**: Handles HTTP requests and interacts with services.
  - Example: `TimeZoneController`, `TimeDifferenceController`
- **`service`**: Contains the business logic of the application.
  - Example: `TimeDifferenceService`, `TimeConversionService`
- **`entity`**: Represents the data structure for entities like `TimeZone`.
- **`repository`**: Contains JPA repositories for database interactions.

### `src/main/resources`
- **`application.properties`**: Contains application configurations (e.g., server port, database settings).
- **`templates` and `static`**: Reserved for UI-related files if needed (not used in this project).

---

## Endpoints

### 1. **Time Difference**
   **URL**: `/time-difference/between/{region1}/and/{region2}`
   - **Method**: GET
   - **Description**: Calculates the time difference between two regions.
   - **Response**:
     ```json
     {
       "region1": "America/New_York",
       "region2": "Europe/London",
       "timeDifference": "5 hours"
     }
     ```

### 2. **Time Conversion**
   **URL**: `/convert-time/from/{sourceRegion}/to/{destinationRegion}/at/{time}`
   - **Method**: GET
   - **Description**: Converts the given time from one time zone to another.
   - **Response**:
     ```json
     {
       "fromRegion": "India",
       "toRegion": "China",
       "inputTime": "07:55 pm",
       "convertedTime": "10:25 pm"
     }
     ```

---

## How to Run the Project

### Prerequisites
1. Java 17 or later installed.
2. Maven installed.
3. IDE (e.g., IntelliJ IDEA) or terminal for running the application.

### Steps to Run
1. **Clone the repository**:
   ```bash
   git clone https://github.com/SURD1618/time-zone-microservice.git
   ```

2. **Navigate to the project directory**:
   ```bash
   cd time-zone-microservice
   ```

3. **Build the project**:
   ```bash
   mvn clean install
   ```

4. **Run the application: To run the application, start the services in sequential order:**:
   ```bash
   1. Start time-zone-service:

      Run the service that handles time zone information.
      Access at `http://localhost:8000/time-zone/region/{region}`.

   2. Start time-difference-service:

      Run the service that calculates time differences between regions.
      Access at `http://localhost:8001/time-difference/between/region1/{region1}/and/region2/{region2}`.

   3. Start time-converter-service:

      Run the service that handles time conversions.
      Access at `http://localhost:8002/time-convert/from/{fromRegion}/to/{toRegion}/time/{time}`.
   ```

---

## How to Push Code to GitHub

### Steps
1. **Initialize Git (if not already initialized)**:
   ```bash
   git init
   ```

2. **Add files to the staging area**:
   ```bash
   git add .
   ```

3. **Commit your changes**:
   ```bash
   git commit -m "Initial commit"
   ```

4. **Push to GitHub**:
   ```bash
   git push origin main
   ```

---

## Known Issues
1. Parsing errors can occur if the input time format is incorrect.
   - Example: `16:30 PM` will throw an error.
   - **Solution**: Ensure the input time format matches `hh:mm a` (e.g., `04:30 PM`).

2. Remote `main` branch conflicts.
   - Ensure you pull the latest changes before pushing:
     ```bash
     git pull origin main --rebase
     ```

---

## Contributors
- **Rohan Das**: Developer

---
