# MetroSystem

A Java-based project designed to simulate a metro system using advanced data structures. This project includes an Admin Panel for managing stations and a User Panel for displaying metro information.

## Features
- Admin Panel for managing metro stations.
- User Panel for displaying station information.
- Efficient use of data structures for managing connections.

## Technologies
- Java
- VSCode

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/MetroSystem.git

### System Architecture
The MetroSystem project utilizes several key data structures to achieve its functionality:

- **Data Structures Used**:
  - **Graph**: The core structure representing the metro network. Nodes in the graph represent metro stations, and edges represent the connections between them. This allows for efficient traversal and management of the network.
  - **Priority Queue**: Used to handle operations or tasks that require prioritization. For instance, it could be used to manage tasks in the admin panel or prioritize certain queries.
  - **HashMap**: Provides fast access to station and connection data by using keys (such as station IDs) to quickly retrieve information.
  - **Stack**: Utilized for operations that involve a last-in, first-out (LIFO) order, such as maintaining history or undoing actions.
  - **Set**: Ensures that each station or connection is unique and manages collections of elements without duplicates.

- **System Components**:
  - **Admin Panel**: This component allows administrators to manage the metro system. Features include adding new stations, removing existing stations, updating station details, and managing connections between stations. The admin panel ensures the network reflects the current operational state.
  - **User Panel**: Provides users with an interface to interact with the metro system. Users can view a list of stations, see connections between stations, and receive real-time updates on the network. The user panel is designed to be intuitive and user-friendly.

### How It Works
- **Admin Panel Features**:
  - **Add Station**: Administrators can add new stations to the system by providing relevant details such as station name and location. This updates the graph and other associated data structures.
  - **Remove Station**: Allows for the removal of stations from the system. This also removes any connections associated with the station and updates the network.
  - **Update Station**: Administrators can modify existing station details, such as updating names or locations. This ensures that the data in the system remains accurate and up-to-date.
  - **Manage Connections**: Administrators can create new connections between stations or update existing ones. This feature is crucial for reflecting changes in the metro network.

- **User Panel Features**:
  - **View Stations**: Users can view a comprehensive list of all available stations in the metro system.
  - **View Connections**: Displays the connections between stations, showing direct routes and possible indirect paths.
  - **Real-Time Updates**: Provides up-to-date information about the metro system, including recent changes or operational status.

### Design Decisions
- **Choice of Data Structures**:
  - **Graph**: Chosen for its capability to represent and manage complex networks efficiently, making it ideal for modeling metro stations and their connections.
  - **Priority Queue**: Useful for managing tasks or operations that require prioritization, such as handling user queries or admin tasks.
  - **HashMap**: Provides fast access to data, making it suitable for scenarios where quick retrieval of station or connection information is needed.
  - **Stack**: Useful for maintaining a history of operations or managing undo actions in the system.
  - **Set**: Ensures that collections of elements, such as stations or connections, are unique and free of duplicates.
  
### Output 
<img width="693" alt="image" src="https://github.com/user-attachments/assets/a2020d20-a714-44a4-991e-d2f2ce930edb">
<img width="616" alt="image" src="https://github.com/user-attachments/assets/c223edd3-6950-42d7-a898-28ad2d70e29c">
<img width="562" alt="image" src="https://github.com/user-attachments/assets/c6b8d5e5-a137-4883-82e0-8188d69ffe48">
<img width="524" alt="image" src="https://github.com/user-attachments/assets/2df53e57-681d-4a52-ae2e-49cd9ff9f2c8">
<img width="617" alt="image" src="https://github.com/user-attachments/assets/86081ed9-b151-4598-938a-7c2f63f800c9">
<img width="453" alt="image" src="https://github.com/user-attachments/assets/2f98f828-e281-44fd-8da5-5bc68aefb1a6">
<img width="443" alt="image" src="https://github.com/user-attachments/assets/cdecec4a-065b-4525-b61d-0b4bbde09b28">
<img width="449" alt="image" src="https://github.com/user-attachments/assets/a4658d09-d40b-4319-85be-e45249686986">
<img width="473" alt="image" src="https://github.com/user-attachments/assets/5edc9cb7-b969-44e0-8ff4-d7a8938c500a">
<img width="608" alt="image" src="https://github.com/user-attachments/assets/0826e8c4-bab6-48b9-9e86-1fc3aeb7abe4">












### Setup and Configuration
- **Environment Setup**:
  - Install the Java Development Kit (JDK) to compile and run the project. Download the JDK from [Oracle’s JDK page](https://www.oracle.com/java/technologies/javase-downloads.html) or use OpenJDK.
  - Configure Visual Studio Code (VSCode) with the necessary Java extensions to facilitate development and debugging.

- **Dependencies**:
  - The project uses standard Java libraries and does not have additional external dependencies. Ensure that your development environment is set up with the required Java runtime and build tools.

### Troubleshooting
- **Common Issues**:
  - **Compilation Errors**: Ensure that all Java files are properly named and located in the correct directory. Check for syntax errors or missing imports.
  - **Runtime Errors**: Verify that input data is correctly formatted and check for logical errors in the code.

- **Resolving Issues**:
  - **Rebuild the Project**: Clean and rebuild the project in VSCode to resolve any build issues.
  - **Consult Documentation**: Refer to project documentation and code comments for additional guidance.

### Future Work
- **Additional Features**:
  - **Route Optimization**: Develop algorithms to find the shortest or most efficient routes between stations.
  - **Enhanced User Interface**: Improve the user experience by enhancing the design and functionality of the Admin and User Panels.
  - **Real-Time Data Integration**: Integrate with real-time data sources to provide live updates and improve system accuracy.

### Acknowledgments
- **Contributors**: Thanks to everyone who contributed to the development of this project, including mentors, collaborators, and peers.
- **Libraries and Resources**: Acknowledge any external resources or tools that were instrumental in the development of the project.

