# User Management Application (Java 17 + MySQL + Docker)

This project is a console-based **User Management application** built with **Java 17** and **Maven**.  
It demonstrates CRUD operations using a **MySQL** database and follows a simple MVC-style architecture.

Originally created as an educational project, it now includes full **Docker support** to provide a real-world, production-ready execution environment.

## 📘 Description
**User Management Application** is a practical demonstration of clean repository structure, modular design, and maintainable Java development. It showcases best practices in project organization, version control, and environment-based configuration.

## 🧰 Technologies
* **Java 17** (tested with BellSoft Liberica 17.0.15)
* **Maven 3.9.9**
* **MySQL 8**
* **Docker & Docker Compose**
* **Maven Shade Plugin**

## 🧪 CI/CD with GitHub Actions

This repository includes a **CI/CD setup based on GitHub Actions**, following DevOps best practices such as code quality validation, automated testing, Docker image building, and secure secret management.

### 🔁 Pipeline Overview

Several workflows are defined under `.github/workflows`:

| Workflow              | Trigger                 | Main Purpose                                                |
|-----------------------|--------------------------|-------------------------------------------------------------|
| `first_ci.yml`        | `pull_request` to `main` | Full pipeline with MySQL integration tests + Docker build   |
| `ci_dummy_test.yml`   | `pull_request` to `main` | Lightweight pipeline with dummy tests + Docker build        |
| `ci_create_image.yml` | `workflow_dispatch`      | Build and push Docker image to GHCR                         |

This separation allows having **fast pipelines for basic validation** and **more complete pipelines** for realistic integration scenarios.

### ✅ Code Quality and Build Validation

All pipelines follow a common **quality job pattern**:

- **Repository checkout** using `actions/checkout@v4`.
- **JDK 17 setup** using `actions/setup-java@v4`.
- **Execution of `mvn verify`** with `-DskipTests` to validate:
    - Project compilation.
    - Dependency resolution.
    - Basic build checks.

This job acts as an **initial quality gate**: if the build fails, subsequent jobs are not executed.

### 🧪 Testing Strategy

Two testing approaches are used:

1. **Unit/Dummy Tests** (`ci_dummy_test.yml` and `ci_create_image.yml`):
    - Selective execution using `mvn test -Dtest=DummyTest`.
    - Useful for quickly validating the pipeline without relying on MySQL.

2. **Integration Tests with a Real MySQL Instance** (`first_ci.yml`):
    - Uses `services.mysql` in GitHub Actions with the `mysql:8.0` image.
    - Credentials are provided via **GitHub Secrets** (`CI_DB_*`).
    - Database schema initialization using `init.sql`.
    - Dynamic generation of `src/main/resources/config.properties` to point the application to the CI database.
    - Execution of `mvn test` against a real MySQL service.

This reflects a DevOps best practice: **fast and cheap tests first**, followed by **deeper integration tests**.

### 🐳 Docker Image Build

Workflows include jobs dedicated to building Docker images:

- **Local CI build** (`first_ci.yml`, `ci_dummy_test.yml`):
    - `docker build -t app_gestionusuarios:ci .`
    - Ensures the `Dockerfile` is consistent with the current codebase.

- **Build and push to GitHub Container Registry** (`ci_create_image.yml`):
    - Login to `ghcr.io` using `docker/login-action@v3` with `GITHUB_TOKEN`.
    - Image name normalization to lowercase.
    - Use of `docker/build-push-action@v5` to:
        - Build the image.
        - Push multiple tags: `1.0`, `latest`, and the commit `SHA`.
    - This enables **traceable versioning** and simplifies deployment workflows.

### 🔐 Secret and Configuration Management

The pipeline makes explicit use of **GitHub Secrets** for:

- Database credentials (`CI_DB_ROOT_PASSWORD`, `CI_DB_NAME`, `CI_DB_USER`, `CI_DB_PASSWORD`).
- Authentication to the container registry (`GITHUB_TOKEN`).

Configuration files are generated dynamically during the pipeline, following **12-factor app principles** and keeping sensitive data out of the repository.

---

## 🧱 Prerequisites
Before running this project, ensure the following tools are installed:
* JDK 17
* Apache Maven 3.9.9
* Git
* Docker & Docker Compose

---

## 🧪 Running Locally (Without Docker)
If you prefer to run the application manually:

1. **Clone the repository**

>    git clone https://github.com/JavierGilAmado/App_GestionUsuarios.git

2. **Build the project**

>    mvn clean install

3. **Run the application**

>   mvn exec:java -Dexec.mainClass="org.example.Main"


---

## 🐳 Running with Docker (Recommended)
The project includes full Dockerization using a multi-stage \`Dockerfile\` and a \`docker-compose\` setup.

**Start the application using Docker Compose:**

docker-compose up --build


**This will:**
* Build the Java application inside a container.
* Start a **MySQL 8** database.
* Automatically initialize the schema using \`init.sql\`.
* Launch the application with environment-based configuration.

> [IMPORTANT]
> Once running, the application will display its interactive menu in the terminal.

---

## ⚙️ Environment Variables
The application reads database configuration from environment variables (automatically provided by \`docker-compose.yml\`):

| Variable | Description |
| :--- | :--- |
| **DB_URL** | JDBC connection string |
| **DB_USER** | Database username |
| **DB_PASSWORD** | Database password |

---

## 📂 Project Structure

```
App_GestionUsuarios/
├── src/
│   ├── main/
│   │   ├── java/com/javier/gestionusuarios/   # Main application source code
│   │   └── resources/                         # Application configuration and resources
│   └── test/
│       └── java/com/javier/gestionusuarios/   # Unit and integration tests
│
├── .github/
│   └── workflows/                             # CI/CD pipelines using GitHub Actions
│       ├── first_ci.yml                       # Full pipeline with MySQL tests + Docker build
│       ├── ci_dummy_test.yml                  # Lightweight pipeline with dummy tests
│       └── ci_create_image.yml                # Docker image build and push to GHCR
│
├── Dockerfile                                 # Docker image definition for the application
├── pom.xml                                    # Maven project configuration
├── init.sql                                   # Database initialization script
└── README.md                                  # Project documentation
```

---

## 🧭 Contribution Guidelines
To maintain high code quality and a clean history, please follow these rules:

### Branching Strategy
We use a **Feature Branch Workflow**. Create a new branch for every task:
* \`feat/<feature-name>\`
* \`fix/<bug-name>\`

### Pull Requests
* All changes must be submitted via a PR.
* Provide a clear description of the changes.
* Link any related issues.
* Keep PRs focused and scoped.

### Commit Message Style
We follow **Conventional Commits**:
* \`feat:\` new features
* \`fix:\` bug fixes
* \`docs:\` documentation updates
* \`refactor:\` code improvements without behavior changes

---

## 🐳 Dockerization Overview
The project includes:
* A **multi-stage Dockerfile** (Maven build → JRE runtime).
* A **docker-compose.yml** orchestrating the app and MySQL.
* An **init.sql** script to bootstrap the database.
* Environment-based configuration following **12-factor app** principles.
* **Maven Shade Plugin** to produce an executable JAR.

This setup makes the project portable, reproducible, and suitable for modern DevOps workflows.

## 📄 License
This project is intended for educational and training purposes.