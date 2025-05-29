# Simple Full-Stack To-Do App (React + Spring Boot)

This is a basic full-stack To-Do List application built with React for the frontend and Spring Boot (Java) for the backend. It demonstrates CRUD (Create, Read, Update, Delete) operations for managing to-do items.

## Features

*   View a list of to-do items.
*   Add new to-do items.
*   Mark to-do items as completed or incomplete.
*   Delete to-do items.
*   Data is persisted in an H2 in-memory database (restarts with the backend).

## Tech Stack

**Frontend:**
*   React (JavaScript)
*   Axios (for HTTP requests)
*   HTML5 & CSS3
*   Node.js & npm (for development environment)

**Backend:**
*   Spring Boot (Java)
*   Spring Web (for REST APIs)
*   Spring Data JPA (for database interaction)
*   H2 Database (in-memory SQL database)
*   Maven (for project build and dependency management)
*   Lombok (to reduce boilerplate code)

## Project Structure
## Prerequisites

Before you begin, ensure you have the following installed:

*   **Java Development Kit (JDK):** Version 17 or higher (e.g., OpenJDK, Oracle JDK).
*   **Apache Maven:** Version 3.6 or higher.
*   **Node.js:** Version 16.x or higher (which includes npm).
*   **A code editor/IDE:**
    *   For Spring Boot: IntelliJ IDEA (recommended), Eclipse, VS Code with Java extensions.
    *   For React: VS Code (recommended), WebStorm.

## Getting Started

1.  **Clone the repository (if you've pushed it to GitHub):**
    ```bash
    git clone https://github.com/[your-username]/my-fullstack-app.git
    cd my-fullstack-app
    ```
    (If you haven't pushed it yet, just ensure you have the `my-fullstack-app` directory with `backend` and `frontend` subdirectories as created.)

### Backend Setup (Spring Boot)

1.  **Navigate to the backend directory:**
    ```bash
    cd backend
    ```
2.  **Build the project using Maven:**
    ```bash
    mvn clean install
    ```
    (Alternatively, you can import the `backend` folder as a Maven project into your IDE like IntelliJ IDEA, and it will handle dependencies.)

### Frontend Setup (React)

1.  **Navigate to the frontend directory (from the project root):**
    ```bash
    cd frontend
    ```
    (If you are already in the `backend` directory, use `cd ../frontend`)
2.  **Install dependencies:**
    ```bash
    npm install
    ```

## Running the Application

You need to run both the backend and frontend servers simultaneously.

### 1. Run the Backend (Spring Boot)

*   **Using an IDE (Recommended):**
    *   Open the `backend` project in IntelliJ IDEA or your preferred Java IDE.
    *   Locate the `TodoBackendApplication.java` file (usually in `src/main/java/com/example/todobackend/`).
    *   Right-click on the file and select "Run 'TodoBackendApplication.main()'".
*   **Using Maven command line (from the `backend` directory):**
    ```bash
    mvn spring-boot:run
    ```
The backend server will typically start on `http://localhost:8080`.

**Accessing H2 Console (Optional):**
If enabled in `application.properties`, you can access the H2 in-memory database console in your browser:
`http://localhost:8080/h2-console`
*   **JDBC URL:** `jdbc:h2:mem:tododb`
*   **User Name:** `sa`
*   **Password:** (leave blank)

### 2. Run the Frontend (React)

1.  **Ensure your backend server is running.**
2.  **Navigate to the `frontend` directory in a new terminal window:**
    ```bash
    cd frontend
    ```
3.  **Start the React development server:**
    ```bash
    npm start
    ```
This will usually open the application automatically in your default web browser at `http://localhost:3000`. If not, open it manually.

You should now be able to interact with the To-Do List application!

## API Endpoints (Backend)

The backend exposes the following REST API endpoints under the base path `/api/todos`:

*   `GET /api/todos`: Retrieves all to-do items.
*   `POST /api/todos`: Creates a new to-do item.
    *   Request Body Example: `{ "title": "My new task" }`
*   `GET /api/todos/{id}`: Retrieves a specific to-do item by its ID.
*   `PUT /api/todos/{id}`: Updates an existing to-do item.
    *   Request Body Example: `{ "title": "Updated task title", "completed": true }`
*   `DELETE /api/todos/{id}`: Deletes a to-do item by its ID.

## Future Enhancements / To-Do

*   More robust error handling on the frontend.
*   Loading indicators during API calls.
*   User authentication and authorization.
*   Switch to a persistent database (e.g., PostgreSQL, MySQL).
*   Input validation (both frontend and backend).
*   Ability to edit the text of existing to-do items.
*   Filtering to-do items (e.g., all, active, completed).

## Contributing

Contributions are welcome! If you have suggestions or improvements, feel free to fork the repository, make your changes, and submit a pull request.

1.  Fork the Project
2.  Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3.  Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4.  Push to the Branch (`git push origin feature/AmazingFeature`)
5.  Open a Pull Request

## License

This project is licensed under the MIT License - see the `LICENSE.md` file for details (if you choose to add one).
