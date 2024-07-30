Product App
A simple and clean Android app designed to display products fetched from an API. The app follows a clean architecture pattern with separate layers for domain, data, and presentation, and utilizes modern Android development practices.

Features
MVVM Architecture: Ensures separation of concerns, making the app easier to maintain and test.
MVI Pattern: Manages state efficiently, ensuring a consistent UI.
Clean Architecture: Follows a layered architecture approach (Domain, Data, App) to keep the business logic separate from other aspects of the app.
Dependency Injection (DI): Utilizes DI for managing dependencies, improving modularity and testability.
Use Cases: Encapsulate business logic to keep the codebase clean and maintainable.
XML Layouts: Used for defining the UI, ensuring a flexible and responsive design.
Architecture Overview
The app is structured into three main layers:

Domain Layer: Contains business logic and use cases.
Data Layer: Manages data operations, including network and database operations.
App Layer: Handles the UI and user interactions.
Key Components
ViewModel: Manages UI-related data and handles user interactions.
Repository: Acts as a mediator between data sources and the rest of the app.
Use Cases: Encapsulate specific business logic to keep the ViewModel clean.
Screenshots
Loading Screen
<img src="https://github.com/user-attachments/assets/b164f9ed-12db-477b-8d48-1d7205470aab" alt="loading" width="200">
Product List
<img src="https://github.com/user-attachments/assets/3a15c409-eef5-4ec6-8a09-12085a5c7288" alt="products" width="200">
