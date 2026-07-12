# Login and Signup App

## Structure

- Frontend: [frontend](frontend)
- Backend: [backend](backend)

## Frontend

```bash
cd frontend
npm install
npm run dev
```

Open http://localhost:3000

## Backend

1. Create a MySQL database named `authdb`.
2. Update credentials in [backend/src/main/resources/application.properties](backend/src/main/resources/application.properties) if needed.
3. Run:

```bash
cd backend
mvn spring-boot:run
```

The API will be available at http://localhost:8080/api/auth

## API Endpoints

- POST /api/auth/signup
- POST /api/auth/login
