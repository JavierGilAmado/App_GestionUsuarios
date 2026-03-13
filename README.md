# App User Managment

## Description:
App UserManagment is a demonstration of repository best practices, designed to serve as a real-world implementation example


## Technologies:
Java: BellSoft Liberica 17.0.15
Maven: Version 3.9.9


## Prerequisites:
Before running this project, ensure you have the following installed:
* Java Development Kit (JDK) 17: Specifically tested with BellSoft Liberica 17.0.15
* Apache Maven 3.9.9: Required for dependency management and building the project.
* Git: For version control and repository managment.


## Installation and Usage:

1. Clone the repository
   git clone https://github.com/JavierGilAmado/App_GestionUsuarios.git

2. Build the project:
   mvn clean install

3. Run the app
   mvn exec:java -Dexec.mainClass="org.example.Main"


## Contribution Guidelines:
To maintain high code quality and a clean history, please follow these rules:

- Branching Strategy: We use a Feature Branch workflow. Create a new branch for every task: feat/feature-name or fix/bug-name.

- Pull Requests: All changes must be submitted via a PR. Provide a clear description of the changes and link any related issues.

- Commit Message Style: We strictly follow the Conventional Commits specification:
    * feat: for new features.
    * fix: for bug fixes.
    * docs: for documentation updates.
    * refactor: for code changes that neither fix a bug nor add a feature.