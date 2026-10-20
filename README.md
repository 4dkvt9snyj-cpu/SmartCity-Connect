SmartCity Connect 
Smart City Grievance Management System
SmartCity Connect is a web-based civic grievance management application developed using Java and Spring Boot. It helps citizens report local civic issues and enables staff to manage complaints and track their progress.
 Project Overview
Citizens can submit grievances related to road damage, electricity, water supply, sanitation, and other civic issues. Staff members can access a protected dashboard to review complaints, update their status, and monitor overall grievance statistics.
 Features
•	Citizen Grievance Submission: Submit a complaint with its title, description, location, and category
•	Grievance Tracking: View submitted complaints, assigned departments, and current statuses.
•	Admin Dashboard: Protected staff dashboard for managing grievances.
•	Status Management: Update grievances to Pending, In Progress, or Resolved.
•	Search and Filtering: Search complaints by title or location and filter them by status or category.
•	Dashboard Statistics: View total, pending, and resolved complaint counts.
•	Status Visualization: Display a pie chart showing the distribution of grievance statuses.
•	REST APIs: Create, retrieve, update, and delete grievances.
•	Persistent Storage: Store grievance data using a file-based H2 database.

 Technologies Used
Technology	Purpose
Java	Application programming language
Spring Boot	Backend application framework
Spring MVC	Web request handling
Thymeleaf	Dynamic HTML page rendering
Spring Data JPA	Database access and persistence
H2 Database	Relational database
Spring Security	Authentication and access control
HTML and CSS	Web page structure and styling
JavaScript	Search, filtering, and dashboard interactions
Chart.js	Grievance status chart
Maven	Dependency management and build automation

 Application Structure
The application follows a layered architecture:
•	Entity: Represents a grievance and its associated data.
•	Repository: Provides database operations using Spring Data JPA.
•	Service: Contains grievance management logic.
•	REST Controller: Exposes API endpoints for CRUD operations.
•	Web Controllers: Handle citizen pages and the staff dashboard.
•	Security Configuration: Configures authentication and route access.
•	Thymeleaf Templates: Render the citizen portal and admin dashboard.

REST API Endpoints
HTTP Method	Endpoint	Description
POST	/grievances	Create a grievance
GET	/grievances	Retrieve all grievances
GET	/grievances/{id}	Retrieve a grievance by ID
PUT	/grievances/{id}	Update a grievance
DELETE	/grievances/{id}	Delete a grievance
The API accepts and returns JSON where applicable.
Getting Started
Prerequisites
•	Java Development Kit (JDK) 21
•	Git, if cloning the repository
•	A compatible IDE, such as IntelliJ IDEA

Run the Application on Windows
1.	Clone or download the repository.
2.	Open the project in IntelliJ IDEA.
3.	Allow Maven to load the project dependencies.
4.	Run the GrievanceApplication.java main class.
Alternatively, open a terminal in the project directory and run:
.\mvnw.cmd spring-boot:run
After the application starts, open:
Citizen Portal: http://localhost:8080/
Staff Dashboard: http://localhost:8080/admin
The staff dashboard requires authentication.
Database
The application uses a file-based H2 database to preserve grievance records across application restarts.
Database configuration is maintained in src/main/resources/application.properties.
Local database files are excluded from version control.
Testing
The application has been tested for the following operations:
•	Submitting a grievance
•	Retrieving all grievances
•	Retrieving an individual grievance
•	Updating grievance information and status
•	Deleting a grievance
•	Admin authentication and protected dashboard access
•	Grievance persistence after restarting the application
•	Dashboard search and filtering
 Future Enhancements
Potential future improvements include:
•	An interactive Chennai map with grievance markers
•	Email or SMS notifications when grievance status changes
•	A citizen-facing status lookup page
•	Role-based access for multiple departments
•	Deployment to a cloud hosting platform
 Project Information
Project Name: SmartCity Connect
Project Type: Java Web Application
Domain: Smart Cities and Civic Issue Management

SmartCity Connect aims to make civic complaint management more organized, accessible, and transparent.
