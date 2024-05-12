# MyVelib README

## Overview

This project, developed as part of the Object-Oriented Software Engineering course at CentraleSupélec, entails creating a bike-sharing application, MyVelib, designed to facilitate urban mobility in metropolitan areas.

## Professors

- Paolo BALLARINI - paolo.ballarini@centralesupelec.fr
- Arnault LAPITRE - arnault.lapitre@centralesupelec.fr

## Author

- Louis LHOTTE (louis.lhotte@student-cs.fr)

## Academic Year

2022/2023 - 2nd Semester

## Repository

[GitHub Repository](https://github.com/louislhotte/myVelib)

## Project Structure

### Introduction

The project uses object-oriented programming principles to manage complex interactions between various system components such as users, bicycles, docking stations, and more.

### Task Distribution

- **Osman MONLA**: Focused on the planning function, Park Bike method, User and Station Balances, and Station Sorting policies.
- **Louis LHOTTE**: Worked on the Cost method using the Observer Pattern, Rent Bike method, JUnit tests, and base case scenarios.

### Classes

#### Core Classes

- **User**: Handles user information and operations.
- **Bicycle**: Abstract class for different types of bicycles.
- **MechanicalBicycle and ElectricalBicycle**: Subclasses of Bicycle with specific attributes.
- **ParkingSlot**: Manages parking slot status within docking stations.
- **Terminal**: Central class for user interactions.
- **DockingStation**: Manages a collection of parking slots and terminal operations.

### Ride Costs

Details the methods and logic used to calculate the cost of bike rentals, accommodating various user card types and bicycle types.

### Planner

Describes various planning policies used to suggest optimal routes and docking stations for users, utilizing a Strategy Pattern to manage diverse planning algorithms.

### Bike Rent and Bike Park

Covers functionalities related to renting and parking bikes within the system, ensuring proper tracking and management.

### Statistics

- **UserBalance and StationBalance**: Tracks and updates significant statistics related to user activities and docking station operations.
- **SortingPolicy**: Implements different sorting strategies for docking stations based on activity levels.

### JUnit Tests

Explains the implementation of JUnit tests to verify the system's functionality and reliability across different components.

### Command Line User Interface (CLUI)

- **MyVelib Network**: Manages overall network operations.
- **Commands**: Lists all available CLI commands for network setup, user management, bike rental, and other operations.

## Additional Information

For a complete understanding, refer to the UML diagrams and detailed class descriptions provided within the project documentation.

