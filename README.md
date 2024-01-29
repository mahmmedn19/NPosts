![image](https://github.com/mahmmedn19/NPosts/assets/100851080/51e67055-687c-4d3b-b615-f2f6c6fca894)
![image](https://github.com/mahmmedn19/NPosts/assets/100851080/a8edb1e5-28d2-4f50-b32f-4b46cc63d19c)

# Fake Posts Android Application

## Objective
Create an Android application that fetches fake posts data from a remote API and displays them in a RecyclerView. Implement navigation to a second screen to display post details.

## Features
- Fetch fake posts data from [JSONPlaceholder](https://jsonplaceholder.typicode.com/posts) API.
- Display posts in a RecyclerView.
- Implement onItemClick functionality to navigate to a second screen displaying post details.
- Handle network calls and manage successful & unsuccessful responses.
- Use Dagger Hilt for dependency injection.
- Utilize RecyclerView with DiffUtil to efficiently display data.
- Implement clean architecture principles for project structure.

## Technologies Used
- Kotlin
- XML for UI design
- Dagger Hilt for dependency injection
- Retrofit for network calls
- RecyclerView with DiffUtil

## Project Structure
- **app:** Contains main application code.
  - **data:** Contains data-related classes such as data models and repository.
  - **domain:** Contains business logic and use cases.
  - **presentation:** Contains UI-related classes including ViewModels and UI states.
  - **di:** Contains Dagger Hilt related classes for dependency injection.


## Usage
1. Clone the project from GitHub repository.
2. Open the project in Android Studio.
3. Build and run the application on an Android device or emulator.

