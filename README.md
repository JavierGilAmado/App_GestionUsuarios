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

src/
└── main/
├── java/
│    └── org.example/
│         ├── controller/
│         ├── database/
│         ├── model/
│         ├── repository/
│         └── view/
└── resources/
pom.xml
Dockerfile
docker-compose.yml
init.sql


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