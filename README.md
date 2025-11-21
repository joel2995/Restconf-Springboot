# restconf-springboot
Spring Boot project (Java 21) with REST endpoints that mimic RESTCONF-style paths.

## Run
- Import into IntelliJ as a Maven project.
- Run `RestconfSpringbootApplication`.
- H2 console: http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:restconfdb)

## API
Base path: /restconf/data/network-configs
- POST /restconf/data/network-configs
- GET /restconf/data/network-configs
- GET /restconf/data/network-configs/{id}
- PUT /restconf/data/network-configs/{id}
- DELETE /restconf/data/network-configs/{id}
