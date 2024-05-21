# Gym Management System

Welcome to the Gym Management System, a comprehensive application developed in Java to streamline the management of gym operations. This system facilitates effective management of budgets, employees, customers, and products.

## Table of Contents

- [Features](#features)
- [Project Structure](#project-structure)
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Features

- **Monthly Budget Management**: Track and manage the gym's monthly budget.
- **Employee Management**: Add, remove, and manage employee details.
- **Customer Management**: Register new customers, remove inactive ones, and maintain customer information.
- **Product Management**: Manage gym products, including adding and removing items.
- **Training Schedule Management**: Allow trainers to assign training times and dates to registered customers.

## Project Structure

The project follows a well-organized structure to maintain clarity and separation of concerns:

data
├── src
│ ├── assets
│ ├── controller
│ │ ├── AylikButceController.java
│ │ ├── CalisanController.java
│ │ ├── MusteriController.java
│ │ └── UrunController.java
│ ├── model
│ │ ├── AylikButce.java
│ │ ├── Calisan.java
│ │ ├── Musteri.java
│ │ └── Urun.java
│ ├── util
│ │ ├── ComponentFactory.java
│ │ └── DosyalIslemleri.java
│ ├── view
│ │ ├── AnaPanel.java
│ │ ├── AylikButcePaneli.java
│ │ ├── CalisanCikarmaPaneli.java
│ │ ├── CalisanEklemePaneli.java
│ │ ├── DersSaatiAyarlamaPaneli.java
│ │ ├── GirisPaneli.java
│ │ ├── MusteriCikarmaPaneli.java
│ │ ├── MusteriEklemePaneli.java
│ │ ├── MusteriOdemePaneli.java
│ │ ├── UrunCikarmaPaneli.java
│ │ └── UrunEklemePaneli.java
│ └── Main.java
└── README.md


### Detailed Description

- **controller**: Contains controllers for managing budgets, employees, customers, and products.
- **model**: Houses the core data models used throughout the system.
- **util**: Includes utility classes and general-purpose components like file operations.
- **view**: Contains the user interface panels for interacting with the system.
- **Main.java**: The main entry point of the application.

## Installation

Follow these steps to set up and run the project on your local machine:

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/gym-management-system.git
    ```

2. Navigate to the project directory:
    ```bash
    cd gym-management-system
    ```

3. Open the project in your preferred Java IDE (such as IntelliJ IDEA, Eclipse, etc.).

4. Build the project to resolve dependencies.

## Usage

To start using the application:

1. Run the `Main.java` file to launch the application.
2. Use the various panels provided to manage budgets, employees, customers, and products efficiently.

## Contributing

We welcome contributions from the community! If you wish to contribute:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/YourFeature`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature/YourFeature`).
5. Open a pull request.

For significant changes, please open an issue first to discuss your ideas.

## License

This project is licensed under the MIT License. For more details, please refer to the [LICENSE](LICENSE) file.
