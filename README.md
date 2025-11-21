## RESTCONF NMS – Spring Boot + Prometheus + Grafana
A complete Network Management System (NMS) simulation built using Spring Boot (Java 21)
with RESTCONF-style APIs, custom metrics, Prometheus monitoring, and Grafana dashboards.
## Project Overview
This project implements:
- RESTCONF-style CRUD API for Network Configurations
- Custom business metrics using Micrometer
- Server metrics via Spring Boot Actuator
- Prometheus-based metrics scraping
- Grafana dashboards (8 professional panels)
## Run Instructions
1. Import & Start Application
Import as Maven project → Run RestconfSpringbootApplication.
2. H2 Database Console
URL: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:restconfdb
## RESTCONF API Endpoints
Base Path: /restconf/data/network-configs
- POST /restconf/data/network-configs
- GET /restconf/data/network-configs
- GET /restconf/data/network-configs/{id}
- PUT /restconf/data/network-configs/{id}
- DELETE /restconf/data/network-configs/{id}
## Metrics & Observability Stack
1. Actuator + Micrometer (Prometheus endpoint: /actuator/prometheus)
2. Custom Metric: nms_network_config_created_count_total
3. Prometheus Config:
scrape_configs:
- job_name: 'restconf_nms'
metrics_path: '/actuator/prometheus'
static_configs:
- targets: ['localhost:8080']
4. Grafana Dashboard (8 Panels):
1) Total Configs Created – Stat
2) API Request Breakdown – Bar
3) Creation Rate – Time series
4) API Latency – Time series
5) Error Rate – Bar chart
6) CPU Usage – Gauge
7) JVM Memory – Time series
8) DB Connections – Bar chart
## Testing Using Postman
- POST /restconf/data/network-configs
{
"name": "Router1",
"ipAddress": "10.0.0.1"
}
- GET /restconf/data/network-configs
Errors for testing: use invalid IDs or invalid JSON.
## Conclusion
This project demonstrates a complete observability-enabled NMS Monitoring System using Spring
Boot, Prometheus, and Grafana.