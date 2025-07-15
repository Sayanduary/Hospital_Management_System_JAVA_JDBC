# Hospital Management System - Java JDBC

A comprehensive console-based Hospital Management System built with Java and JDBC for database connectivity. This application provides essential functionalities for managing patients, doctors, and appointments in a hospital environment.

## 🚀 Features

- **Patient Management**
    - Add new patients with personal details
    - View all registered patients in a formatted table
    - Search patients by ID

- **Doctor Management**
    - View all available doctors with their specializations
    - Doctor availability checking for appointments

- **Appointment System**
    - Book appointments between patients and doctors
    - Check doctor availability for specific dates
    - Prevent double booking on the same date

## 🛠️ Technologies Used

- **Java** - Core programming language
- **JDBC** - Database connectivity
- **MySQL** - Database management system
- **Object-Oriented Programming** - Clean code architecture

## 📁 Project Structure

```
src/
├── HospitalManagementSystem/
│   ├── HospitalManagementSystem.java  # Main application class
│   ├── Patient.java                   # Patient management operations
│   └── Doctor.java                    # Doctor management operations
└── Main.java                          # Alternative entry point
```

## 🗄️ Database Schema

The system uses three main tables:

1. **patients** - Stores patient information (id, name, age, gender)
2. **doctors** - Stores doctor information (id, name, specialization)
3. **appointments** - Stores appointment details (patient_id, doctor_id, appointment_date)

## 🔧 Setup Instructions

### Prerequisites
- Java JDK 8 or higher
- MySQL Server
- MySQL Connector/J driver

### Database Setup
1. Create a MySQL database named `hospitalManagementSystem`
2. Create the required tables:
   ```sql
   CREATE TABLE patients (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(100) NOT NULL,
       age INT NOT NULL,
       gender VARCHAR(10) NOT NULL
   );

   CREATE TABLE doctors (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(100) NOT NULL,
       specialization VARCHAR(100) NOT NULL
   );

   CREATE TABLE appointments (
       id INT AUTO_INCREMENT PRIMARY KEY,
       patient_id INT,
       doctor_id INT,
       appointment_date DATE,
       FOREIGN KEY (patient_id) REFERENCES patients(id),
       FOREIGN KEY (doctor_id) REFERENCES doctors(id)
   );
   ```

### Application Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/Sayanduary/Hospital_Management_System_JAVA_JDBC.git
   ```

2. Update database credentials in `HospitalManagementSystem.java`:
   ```java
   private static final String url = "jdbc:mysql://localhost:3306/hospitalManagementSystem";
   private static final String userName = "your_username";
   private static final String password = "your_password";
   ```

3. Add MySQL Connector/J to your classpath

4. Compile and run:
   ```bash
   javac -cp ".:mysql-connector-java.jar" src/HospitalManagementSystem/*.java
   java -cp ".:mysql-connector-java.jar:src" HospitalManagementSystem.HospitalManagementSystem
   ```

## 💻 Usage

When you run the application, you'll see a menu with the following options:

1. **Add Patient** - Register a new patient
2. **View Patients** - Display all patients in a formatted table
3. **View Doctors** - Display all doctors with their specializations
4. **Book Appointment** - Schedule an appointment between a patient and doctor
5. **Exit** - Close the application

## 🌟 Key Features

- **Input Validation** - Handles invalid inputs gracefully
- **Error Handling** - Comprehensive exception handling for database operations
- **Clean UI** - Formatted table output for better readability
- **Date Validation** - Ensures proper date format for appointments
- **Availability Check** - Prevents scheduling conflicts

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is open source and available under the [MIT License](LICENSE).

## 👤 Author

**Sayan Duary**
- GitHub: [@Sayanduary](https://github.com/Sayanduary)

## 🔮 Future Enhancements

- Web-based GUI using Spring Boot
- Patient medical history tracking
- Billing and payment management
- Report generation
- Email notifications for appointments
- Role-based authentication (Admin, Doctor, Receptionist)

---

⭐ If you found this project helpful, please consider giving it a star on GitHub!