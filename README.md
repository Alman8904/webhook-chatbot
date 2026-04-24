# webhook-chatbot

A WhatsApp chatbot backend simulation built with Java 21 and Spring Boot for Jarurat Care internship assignment.

## Links
- Live URL: https://webhook-chatbot-b22r.onrender.com
- Swagger UI: https://webhook-chatbot-b22r.onrender.com/swagger-ui/index.html

## Features
- `POST /webhook` — receives simulated WhatsApp messages and returns predefined replies
- `GET /logs` — returns all messages received since the app started
- `GET /` — health check
- Swagger UI for API documentation
- Deployed on Render via Docker

## Tech Stack
- Java 21
- Spring Boot 3.4.x
- Lombok
- SpringDoc OpenAPI (Swagger)
- Docker

## Setup

1. Clone the repo
```bash
   git clone https://github.com/Alman8904/webhook-chatbot.git
   cd webhook-chatbot
```

2. Copy example config
```bash
   cp application-example.properties src/main/resources/application.properties
```

3. Run the app
```bash
   ./mvnw spring-boot:run
```

## API

### POST /webhook
```json
Request:
{ "from": "user1", "message": "hi" }

Response:
{ "to": "user1", "reply": "Hello" }
```

### GET /logs
Returns all messages received since the app started.

### GET /
Returns health check status.

## Supported Messages
| Input | Reply |
|-------|-------|
| hi, hello, hey | Hello |
| bye, goodbye | Goodbye |
| anything else | Default fallback message |
