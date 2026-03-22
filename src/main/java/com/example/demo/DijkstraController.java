package com.example.demo;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/dijkstra")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class DijkstraController {

    @PostMapping("/shortestpath")
    public List<Map<String, Object>> findShortestPath(@RequestBody Map<String, Object> request) {
        String start = (String) request.get("start");
        String end = (String) request.get("end");
        @SuppressWarnings("unchecked")
        Map<String, Map<String, Double>> graph = (Map<String, Map<String, Double>>) request.get("graph");
        
        @SuppressWarnings("unchecked")
        List<String> skippedNodesList = (List<String>) request.get("skippedNodes");
        java.util.Set<String> skippedNodes = skippedNodesList != null ? new java.util.HashSet<>(skippedNodesList) : new java.util.HashSet<>();

        @SuppressWarnings("unchecked")
        List<String> skippedRoutesList = (List<String>) request.get("skippedRoutes");
        java.util.Set<String> skippedRoutes = skippedRoutesList != null ? new java.util.HashSet<>(skippedRoutesList) : new java.util.HashSet<>();

        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        return dijkstra.findShortestPathWithSteps(start, end, skippedNodes, skippedRoutes);
    }

    @GetMapping(value = "/cities", produces = "application/json")
    public String getCities() {
        return """
        [
            { "name": "Mumbai", "latitude": 19.0760, "longitude": 72.8777 },
            { "name": "Delhi", "latitude": 28.7041, "longitude": 77.1025 },
            { "name": "Bangalore", "latitude": 12.9716, "longitude": 77.5946 },
            { "name": "Hyderabad", "latitude": 17.3850, "longitude": 78.4867 },
            { "name": "Ahmedabad", "latitude": 23.0225, "longitude": 72.5714 },
            { "name": "Chennai", "latitude": 13.0827, "longitude": 80.2707 },
            { "name": "Kolkata", "latitude": 22.5726, "longitude": 88.3639 },
            { "name": "Surat", "latitude": 21.1702, "longitude": 72.8311 },
            { "name": "Pune", "latitude": 18.5204, "longitude": 73.8567 },
            { "name": "Jaipur", "latitude": 26.9124, "longitude": 75.7873 },
            { "name": "Lucknow", "latitude": 26.8467, "longitude": 80.9462 },
            { "name": "Kanpur", "latitude": 26.4499, "longitude": 80.3319 },
            { "name": "Nagpur", "latitude": 21.1458, "longitude": 79.0882 },
            { "name": "Indore", "latitude": 22.7196, "longitude": 75.8577 },
            { "name": "Thane", "latitude": 19.2183, "longitude": 72.9781 },
            { "name": "Bhopal", "latitude": 23.2599, "longitude": 77.4126 },
            { "name": "Visakhapatnam", "latitude": 17.6868, "longitude": 83.2185 },
            { "name": "Pimpri-Chinchwad", "latitude": 18.6298, "longitude": 73.7997 },
            { "name": "Patna", "latitude": 25.5941, "longitude": 85.1376 },
            { "name": "Vadodara", "latitude": 22.3072, "longitude": 73.1812 },
            { "name": "Guwahati", "latitude": 26.1445, "longitude": 91.7362 },
            { "name": "Ranchi", "latitude": 23.3441, "longitude": 85.3096 },
            { "name": "Shimla", "latitude": 31.1048, "longitude": 77.1734 },
            { "name": "Dehradun", "latitude": 30.3165, "longitude": 78.0322 },
            { "name": "Thiruvananthapuram", "latitude": 8.5241, "longitude": 76.9366 },
            { "name": "Gandhinagar", "latitude": 23.2156, "longitude": 72.6369 },
            { "name": "Raipur", "latitude": 21.2514, "longitude": 81.6296 },
            { "name": "Panaji", "latitude": 15.4909, "longitude": 73.8278 },
            { "name": "Imphal", "latitude": 24.8170, "longitude": 93.9368 },
            { "name": "Shillong", "latitude": 25.5788, "longitude": 91.8933 },
            { "name": "Aizawl", "latitude": 23.7271, "longitude": 92.7176 },
            { "name": "Kohima", "latitude": 25.6751, "longitude": 94.1077 },
            { "name": "Bhubaneswar", "latitude": 20.2961, "longitude": 85.8245 },
            { "name": "Gangtok", "latitude": 27.3314, "longitude": 88.6138 },
            { "name": "Agartala", "latitude": 23.8315, "longitude": 91.2868 },
            { "name": "Itanagar", "latitude": 27.0844, "longitude": 93.6053 },
            { "name": "Dispur", "latitude": 26.1433, "longitude": 91.7898 },
            { "name": "Amaravati", "latitude": 16.5412, "longitude": 80.5173 },
            { "name": "Chandigarh", "latitude": 30.7333, "longitude": 76.7794 }
        ]
        """;
    }
}