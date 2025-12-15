# Automated Transport Attendance System (BSc Project)

## Project Summary

This repository contains the full source code and documentation for a functional Automated Transport Attendance System. This system was designed to replace manual, paper-based tracking of student/employee ridership on dedicated transport vehicles. The solution utilizes mobile or RFID technology for fast, accurate check-in/check-out, combined with a centralized database and web interface for real-time monitoring and reporting.

This project demonstrates core skills in full-stack development, database management, and IoT/embedded systems integration (if RFID/mobile scanning hardware was involved).

## System Architecture & Technical Focus 

This project highlights expertise in modern data management and application development:

* Data Integrity and Automation: Eliminated manual errors and provided instant, timestamped attendance records, crucial for safety and compliance reporting.

* Database Design: Developed a structured relational database (e.g., MySQL or PostgreSQL) schema capable of handling high transaction volumes (check-in/out logs) and maintaining driver, route, and passenger details.

* Real-Time Reporting: Implemented a web dashboard allowing administrators to view current vehicle occupancy, route adherence, and historical attendance data.

* User Experience: Designed intuitive interfaces for both the scanner/check-in application (or driver application) and the administrative reporting portal.

## Technical Scope & Components 

The project typically involves multiple interconnected layers:

* Backend/API: Python (Flask/Django) or Node.js (Express), handling business logic and database communication.

* Database: SQL (e.g., MySQL, PostgreSQL, or SQLite for embedded prototype).

* Frontend/Reporting: HTML, CSS, JavaScript (React/Angular/Vue or Vanilla), for the administrative dashboard.

* Mobile/Check-in App: Python script for Raspberry Pi/Microcontroller, or a simple Android/Web application for attendance scanning (e.g., QR/RFID reading).

* Core Functionality: User/Passenger Registration, Route Management, Check-in/Check-out Logging, and Reporting.

## Key Professional Learnings 

* Full-Stack Development: Gained experience managing a project across the database, server logic, and client interfaces.

* Transaction Management: Handled critical data (attendance records) ensuring accuracy, atomicity, and concurrency in the database layer.

* System Integration: Successfully integrated hardware/mobile input (simulated or real-world) with a centralized software application.
