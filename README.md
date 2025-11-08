Project Management API

A Spring Boot REST API for managing users, projects, and tasks.  
Each user can create projects, add tasks, and manage their completion status.  
The project uses Spring Security Basic Authentication for protection.

Tech Stack :

Spring Boot 3.x — Backend framework
Spring Security (Basic Auth) — Authentication
Spring Data JPA (Hibernate) — ORM and database operations
PostgreSQL — Database
Maven — Build tool
ModelMapper — DTO to Entity mapping
Java 17+ — Programming language


Features:

- User Management
  - Register and login using username & password.
  - Each user owns multiple projects.

- Project Management
  - Create, view, update, and delete projects.
  - Prevents deletion if any task is not completed.
  - Checks for duplicate project names per user.

- Task Management
  - Add, update, and delete tasks within a project.
  - Prevents deletion if the task is not marked as "COMPLETED".

- Security
  - Uses Spring Security Basic Authentication.

