# EVO-Backend

A Spring Boot backend for an event planning/marketplace platform that connects customers, suppliers, and admins. It provides REST APIs, WebSocket-based messaging, JWT authentication, and MySQL persistence with sample seed data.

## Tech Stack

- Java 17, Spring Boot 3.4.3
- Spring Web (MVC), Spring Data JPA, Spring Security (JWT)
- WebSocket (STOMP) for real-time chat
- Spring WebFlux/WebClient for outbound HTTP calls
- MySQL (via `mysql-connector-j`)
- Lombok, ModelMapper
- OpenAPI/Swagger UI via springdoc-openapi
- Test: Spring Boot Test, Mockito
- Apache POI (Excel parsing)

## Project Structure

```
src/main/java/edu/icet
├─ Main.java                         # Spring Boot entry point
├─ config/                           # Cross-cutting app configuration
│  ├─ SecurityConfig.java            # JWT, CORS, stateless sessions
│  ├─ WebConfig.java                 # Global CORS for MVC
│  ├─ WebClientConfig.java           # WebClient for Facebook Graph API
│  ├─ WebSocketConfig.java           # STOMP endpoints and broker
│  └─ logFileConfiguration/          # HTTP request/response logging -> logs/http
├─ controller/
│  ├─ auth/AuthController.java       # Register/login & JWT issuance
│  ├─ system/                        # System features (notifications, reviews, terms, message APIs)
│  └─ supplier/WhatsappMessageController.java
├─ security/                         # JWT utilities & filters
├─ dto/, entity/, repository/, service/, util/  # Domain and services
└─ resources/
   ├─ application.yml                # DB, JPA, JWT settings
   └─ data.sql                       # Seed data (locations, users, venues)
```

## Configuration

Edit `src/main/resources/application.yml`:

- Database
  - `spring.datasource.url`: `jdbc:mysql://localhost:3306/evo_db?createDatabaseIfNotExist=true`
  - `spring.datasource.username`: `root`
  - `spring.datasource.password`: `1234`
- JPA
  - `spring.jpa.hibernate.ddl-auto`: `create` (use `update`/`validate` in non-dev environments)
- JWT
  - `jwt.secret`: HS256 key (min 32 bytes)
  - `jwt.expiration`: milliseconds (e.g., 172800000 for 2 days)

Important: Move secrets (DB creds, `jwt.secret`, access tokens) to environment variables or an external config (e.g., profiles) before production.

## Running Locally

Prereqs: Java 17+, Maven, MySQL running with a user that can create `evo_db`.

Build and run:

```powershell
mvn clean spring-boot:run
```

Default port: 8080 (no explicit override in config).

The app will auto-create schema and insert seed data from `data.sql` because `ddl-auto: create` and SQL init is enabled.

## API Overview

### Auth (`/api/auth`)
- POST `/register-customer` — register a new customer
- POST `/register-admin` — register a new admin
- POST `/register-supplier` — register a new supplier
- POST `/login` — authenticate by email/password and receive a JWT

JWT claims include: `role`, `user_id`, `username`, `profile_image`.

### System (`/system`)
- Transaction History
  - POST `/transaction-history/save-transaction-history`
  - GET `/transaction-history/getAll-transaction-history`
  - GET `/transaction-history/get-transaction-byId/{id}`
  - GET `/transaction-history/get-transaction-history-byDate/{date}`
  - GET `/transaction-history/get-transaction-history-byUserId/{id}`
  - DELETE `/transaction-history/delete-transaction-history-ById/{id}`
- Notifications
  - POST `/notification/create-notification`
  - GET `/notification/get-all-notifications`
  - DELETE `/notification/delete-notification/{notificationId}`
  - PUT `/notification/update-notification`
  - GET `/notification/search-by-notificationId/{notificationId}`
  - GET `/notification/search-notification-by-type/{type}`
  - GET `/notification/search-notification-by-status/{status}`
  - GET `/notification/search-by-delivery/{deliveryMethod}`
  - GET `/notification/search-by-user/{usertype}/{userId}`
  - PUT `/notification/mark-as-read/{notificationId}`
  - GET `/notification/get-unread-notification`
- Reviews
  - POST `/review/addReview`
  - GET `/review/searchByReviewId/{id}`
  - GET `/review/getReviewsBySupplierId/{id}`
  - PUT `/review/updateByReviewId/{id}`
  - GET `/review/get-all-reviews`
  - DELETE `/review/deleteByReviewId/{id}`
- Search History
  - POST `/search-history/save-search-history`
  - DELETE `/search-history/delete-search-history/{id}`
  - GET `/search-history/get-search-history-by-id/{id}`
  - GET `/search-history/get-all-search-history`
  - GET `/search-history/get-all-search-history-by-title/{title}`
- Terms
  - POST `/terms/add-terms`
  - PUT `/terms/update-terms`
  - GET `/terms/get-terms-by-id/{id}`
  - GET `/terms/profile/{profileId}`
  - DELETE `/terms/delete-term-by-id/{id}`
  - GET `/term/active/{profileId}`

### Locations (`/location`)
- GET `/all` — list all locations

### Supplier WhatsApp (`/api/supplier/whatsapp`)
- POST `/message?message=...` — send a message through Facebook Graph API (WhatsApp)
- POST `/notification?id=...` — send notification by supplier id

## Real-time Messaging (WebSocket/STOMP)

- Endpoint: `ws://<host>:8080/ws` (allowed origin: `http://localhost:4200`)
- App destination prefix: `/app`
- Broker prefix: `/topic`

Channels:
- Customer ↔ Supplier
  - Send: `/app/chat/{customerId}/{supplierId}`
  - Subscribe: `/topic/messages/{customerId}/{supplierId}`
- Admin ↔ Supplier
  - Send: `/app/chat/admin-supplier/{supplierId}/{adminId}`
  - Subscribe: `/topic/chat/{supplierId}/{adminId}`

## Security

- Stateless JWT security with a custom `JwtAuthenticationFilter` and `CustomUserDetailsService`.
- Public endpoints include `/api/auth/**`, Swagger UI, and `/api/supplier/add` (see `SecurityConfig`).
- CORS allowed origins (dev): `http://localhost:4200`, `http://localhost:8080`.

## HTTP Logging

- A servlet filter (`RequestResponseLoggingFilter`) logs requests/responses into monthly files under `logs/http` (e.g., `http-YYYY-MM.log`).

## Swagger/OpenAPI

- springdoc-openapi starter is included; typical paths:
  - JSON: `/v3/api-docs`
  - UI: `/swagger-ui/index.html`

## Outbound Integrations

- `WebClientConfig` defines a `WebClient` preconfigured for Facebook Graph API `v18.0` for WhatsApp messaging.
  - Note: Replace the hardcoded page access token with a secure configuration.

## Database and Seed Data

- Entities for events, suppliers, customers, admins, and system data.
- `data.sql` preloads locations, sample users, and venues.

## Build

```powershell
mvn -q -DskipTests clean package
```

## Development Tips

- Swap `ddl-auto` to `update` to preserve schema during local iterations.
- Always externalize secrets for non-local environments.
- Prefer `--rebase` when syncing your branch: `git pull --rebase origin main`.

## License

This repository currently does not declare a license. Add one if you plan to share or distribute.
