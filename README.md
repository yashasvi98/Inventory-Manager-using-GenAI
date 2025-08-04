# Inventory-Manager-using-GenAI

# Inventory Manager

A robust, production-grade Java Spring Boot backend for inventory management. Built with best practices for reliability, maintainability, and testability.

---

## Features
- **RESTful API:** Comprehensive endpoints for items, batches, categories, locations, suppliers, reservations, transfers, stock adjustments, and low stock alerts.
- **Layered Architecture:** Controllers, Services, Repositories, Entities, DTOs, Mappers for clean separation of concerns.
- **Validation:** Jakarta Bean Validation for strong data integrity.
- **Logging:** SLF4J for structured, contextual logging.
- **Global Exception Handling:** Consistent, informative error responses across the API.
- **Lombok:** Minimal boilerplate with `@Builder`, `@Data`, etc.
- **Spring Data JPA:** Robust persistence with easy extensibility.

---

## Getting Started

### Prerequisites
- Java 17+
- Maven (or `./mvnw`)
- Database (H2, PostgreSQL, MySQL, etc.)

### Build & Run
```sh
# Run all tests
mvn test

# Build the application
mvn clean package

# Run the application
mvn spring-boot:run
```
Or with Maven Wrapper:
```sh
./mvnw spring-boot:run
```

### Configuration
- Configure your database and other properties in `src/main/resources/application.properties`.

### API Documentation
- Project is ready for Swagger/OpenAPI integration.
- All DTOs and entities are JavaDoc-annotated for API doc generation.

---

## Project Structure
```
src/main/java/com/example/inventory/
├── controller/   # REST controllers
├── service/      # Business logic
├── repository/   # Spring Data JPA repositories
├── entity/       # JPA entities
├── dto/          # Data Transfer Objects
├── mapper/       # Entity/DTO mappers
├── config/       # Global config & exception handling
└── InventoryManagementApplication.java
```

---

## Distributed Tracing & Correlation IDs

Every incoming HTTP request is assigned a unique **correlation ID** (UUID), or you can supply your own via the `X-Correlation-Id` header. This correlation ID is:
- Available in all logs for that request (via SLF4J MDC as `correlationId`).
- Returned in every API response header as `X-Correlation-Id`.
- Included in all error responses as the `correlationId` property.

**How to use:**
- To trace a request, include `X-Correlation-Id` in your client request headers, or use the value returned in the response for subsequent requests.
- All logs and error responses for a request will share the same correlation ID, making debugging and distributed tracing straightforward.
- For multi-service architectures, propagate this header to downstream services for full traceability.

---

## Testing & Quality
- **Comprehensive test coverage:**
  - **Controllers:** Integration tests for all endpoints (success, validation, error cases).
  - **Services:** Unit tests with full edge case and error path coverage.
  - **Repositories:** `@DataJpaTest` for CRUD and custom queries.
  - **DTOs & Entities:** Validation, builder, and property tests.
  - **Mappers:** Unit tests for all mapping logic and null safety.
  - **Global Exception Handling:** Fully tested for validation and generic errors.
- **No placeholders or TODOs**—all tests are actionable and executable.


---

## Contribution Guidelines
- Follow JavaDoc and code style conventions.
- Use `@Builder` and validation annotations for new DTOs/entities.
- Add unit/integration tests for new features.
- Maintain consistent logging and error handling.
- All PRs must pass tests and maintain code quality.

---

## License
This project is provided as-is for educational or internal use. Add your license as appropriate.

---

## Authors & Acknowledgments
- Initial codebase and best practice refactor: Yashasvi Singh
- Powered by Spring Boot, Lombok, SLF4J, and Jakarta Bean Validation.

---

## Troubleshooting
- Ensure Maven is installed and on your PATH (`mvn -v`).
- Configure your database connection in `src/main/resources/application.properties`.
- For Windows, use `mvnw.cmd` if present.

---

## Example API Requests & Responses

### Create Item
**Request:**
```http
POST /api/items
Content-Type: application/json
X-Correlation-Id: 1a2b3c4d-1234-5678-9abc-abcdef123456

{
  "name": "Widget",
  "sku": "WGT-001",
  "categoryId": 1,
  "supplierId": 2,
  "description": "A sample widget"
}
```
**Response Headers (excerpt):**
```
X-Correlation-Id: 1a2b3c4d-1234-5678-9abc-abcdef123456
```
**Response Body:**
```json
{
  "id": 101,
  "name": "Widget",
  "sku": "WGT-001",
  "categoryId": 1,
  "supplierId": 2,
  "description": "A sample widget",
  "createdAt": "2025-08-04T12:00:00Z",
  "updatedAt": "2025-08-04T12:00:00Z"
}
```

### Get All Items
**Request:**
```http
GET /api/items
X-Correlation-Id: 1a2b3c4d-1234-5678-9abc-abcdef123456
```
**Response Headers (excerpt):**
```
X-Correlation-Id: 1a2b3c4d-1234-5678-9abc-abcdef123456
```
**Response Body:**
```json
[
  {
    "id": 101,
    "name": "Widget",
    "sku": "WGT-001",
    "categoryId": 1,
    "supplierId": 2,
    "description": "A sample widget",
    "createdAt": "2025-08-04T12:00:00Z",
    "updatedAt": "2025-08-04T12:00:00Z"
  }
]
```

### Create Reservation
**Request:**
```http
POST /api/reservations
Content-Type: application/json
X-Correlation-Id: 1a2b3c4d-1234-5678-9abc-abcdef123456

{
  "itemId": 101,
  "quantity": 5,
  "reservedFor": "John Doe"
}
```
**Response Headers (excerpt):**
```
X-Correlation-Id: 1a2b3c4d-1234-5678-9abc-abcdef123456
```
**Response Body:**
```json
{
  "id": 201,
  "itemId": 101,
  "quantity": 5,
  "reservedFor": "John Doe"
}
```

### Example Error Response (Validation Failure)
**Request:**
```http
POST /api/items
Content-Type: application/json
X-Correlation-Id: 1a2b3c4d-1234-5678-9abc-abcdef123456

{
  "name": "",
  "sku": ""
}
```
**Response Headers (excerpt):**
```
X-Correlation-Id: 1a2b3c4d-1234-5678-9abc-abcdef123456
```
**Response Body:**
```json
{
  "timestamp": "2025-08-04T12:00:00Z",
  "status": 400,
  "error": "Validation Failed",
  "message": {
    "name": "must not be blank",
    "sku": "must not be blank"
  },
  "path": "N/A",
  "correlationId": "1a2b3c4d-1234-5678-9abc-abcdef123456"
}
```


