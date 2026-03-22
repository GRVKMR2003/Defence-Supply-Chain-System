# Defence Supply Chain System

A Spring Boot web application that visualizes route planning across major Indian cities using Dijkstra's algorithm.

## Live Demo

https://defence-supply-system.onrender.com/

## Project Highlights

- Interactive map-based shortest path visualization
- Dijkstra algorithm simulation with step-by-step progress
- Threat-aware rerouting by blocking cities (nodes) and routes (edges)
- Final route and total distance calculation
- REST API for city data and shortest-path execution

## Tech Stack

- Java 17
- Spring Boot 2.5.5
- Thymeleaf
- Vanilla JavaScript
- Google Maps JavaScript API
- Maven
- Docker (optional)

## How It Works

1. The frontend fetches city coordinates from the backend.
2. A weighted graph is created by connecting each city to its nearest neighbors.
3. The frontend sends start city, end city, and graph details to the API.
4. The backend runs Dijkstra's algorithm and returns step-by-step states.
5. The frontend animates exploration, updates, and final route.
6. If threats are marked, blocked nodes/routes are skipped during pathfinding.

## API Endpoints

### 1) Get Cities

- Method: GET
- Path: /api/dijkstra/cities
- Response: JSON array of city objects with name, latitude, and longitude

### 2) Find Shortest Path

- Method: POST
- Path: /api/dijkstra/shortestpath
- Request body example:

```json
{
  "start": "Mumbai",
  "end": "Delhi",
  "graph": {
    "Mumbai": { "Pune": 120.5, "Surat": 265.3 },
    "Pune": { "Mumbai": 120.5 }
  },
  "skippedNodes": ["Nagpur"],
  "skippedRoutes": ["Mumbai-Surat"]
}
```

- Response: ordered list of algorithm steps containing:
  - type (explore, update, finish)
  - current, neighbor
  - distances map
  - previous-node map

## Run Locally

### Prerequisites

- JDK 17
- Maven 3.6+

### Start the app

Windows:

```bash
mvnw.cmd spring-boot:run
```

macOS/Linux:

```bash
./mvnw spring-boot:run
```

Then open:

http://localhost:8080/

## Build and Run JAR

```bash
mvnw.cmd clean package
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

## Docker

Build:

```bash
docker build -t defence-supply-system .
```

Run:

```bash
docker run -p 8080:8080 defence-supply-system
```

## CORS Note

The backend currently allows API requests from:

- http://127.0.0.1:5500

If you deploy frontend and backend on different origins, update CORS settings in the backend configuration.

## Google Maps API Key Note

The Google Maps script is included in the HTML template with a key value. For production, move the key to secure configuration and restrict it to your allowed domains.

## Project Structure (Main)

- src/main/java/com/example/demo
  - DemoApplication.java
  - HomeController.java
  - DijkstraController.java
  - DijkstraAlgorithm.java
  - CorsConfig.java
- src/main/resources
  - templates/demo.html
  - static/script.js
  - static/styles.css

## Screenshot

If present in this repository, you can use image.png as the project preview image in GitHub.

## License

This project currently has no explicit license file.
