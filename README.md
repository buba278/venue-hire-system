# Venue Hire System

Welcome to the Venue Hire System repository! This project is a simple terminal-driven interface designed to help a venue hire company manage their venues and bookings. 

## Features

The system allows staff members to:
- View details of all the venues
- Create new venues
- View details of all the bookings for a venue
- Create new bookings for a venue
- Add catering, music, and floral services to a booking
- View the invoice for a booking

## Command Menu

The system is controlled through a menu of commands, which can be selected by typing the command code and any required arguments. The available commands are:

- `PRINT_VENUES`    [no args]       Print details of all the venues
- `CREATE_VENUE`    [4 arguments]   Create a new venue with the given `<VENUE_NAME>`, `<VENUE_CODE>`, `<VENUE_CAPACITY>`, and `<HIRE_FEE>`
- `SET_DATE`        [1 argument]    Set the system's date to the specified date in DD/MM/YYYY format
- `PRINT_DATE`      [no args]       Print the system's current date
- `MAKE_BOOKING`    [no args]       Request a new booking
- `PRINT_BOOKINGS`  [1 argument]    Print all bookings for the specified `<VENUE_CODE>`
- `ADD_CATERING`    [1 argument]    Add catering service to the specified `<BOOKING_REFERENCE>`
- `ADD_MUSIC`       [1 argument]    Add music service to the specified `<BOOKING_REFERENCE>`
- `ADD_FLORAL`      [1 argument]    Add floral service to the specified `<BOOKING_REFERENCE>`
- `VIEW_INVOICE`    [1 argument]    View full invoice details for the specified `<BOOKING_REFERENCE>`
- `HELP`            [no args]       Print usage
- `EXIT`            [no args]       Exit the application

## Installation

1. Clone this repository to your local machine:
   ```sh
   git clone https://github.com/buba278/venue-hire-system.git
   ```
2. Navigate to the project directory:
   ```sh
   cd venue-hire-system
   ```
3. Ensure you have Java installed, then use the maven wrapper:

   If on Windows
   ```sh
   .\mvnw.cmd clean compile exec:java@run
   ```

   If on Unix/Mac OS
   ```sh
   ./mvnw clean compile exec:java@run
   ```

## Usage

1. Start the application by running the maven wrapper.
2. The terminal will display the command menu.
3. Type the command code and any required arguments to perform an action.
4. Follow any additional prompts to complete the command.

## Implementation

The system is implemented using Object-Oriented Programming (OOP). The main components include:
- `Venue`: A class representing a venue with attributes such as name, code, capacity, and hire fee.
- `Booking`: A class representing a booking with attributes such as date, venue, and services.
- `Service`: A base class for services like catering, music, and floral.
- `Invoice`: A class to calculate and display booking invoices.
