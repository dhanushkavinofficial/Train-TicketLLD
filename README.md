# Train-TicketLLD
🚆 Train Ticket Booking System (LLD + DSA + Math)
📌 Overview

This project is a Low-Level Design (LLD) of a Train Ticket Booking System, built in Java with a mix of:

DSA Concepts → Graphs, Arrays, HashMaps, Priority Queues.

Mathematics → Combinatorics, Probability, and Optimization.

OOP Principles → Encapsulation, Abstraction, Polymorphism, Design Patterns.

The goal is to simulate how a real train reservation system works:

Booking tickets.

Managing seat allocation efficiently.

Handling waiting lists.

Optimizing resource allocation using both DSA + Math.

This is designed as a study project for placements & interviews at product-based companies (Google, Meta, Amazon, Zoho, etc.).

🎯 Features

🚉 Train & Coach management (multiple trains, multiple classes).

👥 Passenger booking & cancellation.

🪑 Smart Seat Allocation → Uses Greedy + Graph traversal + Math optimization.

🕒 Waiting List with Queue Data Structure.

📊 Math-based seat distribution (minimizing wastage, maximizing utilization).

🔍 Searching trains by route (Graph BFS/DFS).

⚡ Optimized algorithms for time & space efficiency.

🛠️ Tech & Concepts Used

Language: Java
DSA:

Arrays & HashMaps (storing trains, seats, bookings).

Graphs (train routes & connectivity).

Priority Queues (waitlist management).

Dynamic Programming (optimizing seat allocation).

Math:

Probability for ticket confirmation chances.

Combinatorics for seat allocation strategies.

Modular arithmetic for unique ID generation.

OOP & LLD:

Classes: Train, Coach, Seat, Passenger, BookingSystem.

Relationships: Composition + Aggregation.

Design Patterns: Singleton (BookingSystem), Factory (Train creation).

📂 Project Structure
/train-ticket-system
│── Train.java
│── Coach.java
│── Seat.java
│── Passenger.java
│── BookingSystem.java
│── Main.java
│── README.md

🚀 How It Works

Create trains & coaches → Each train has a fixed no. of seats.

Passenger books ticket → System checks seat availability.

If seat available → Assigns seat.

If no seat → Adds to waiting list (Queue).

On cancellation → Seat reassigned to next waiting passenger.

Math Engine optimizes distribution → balances coach load & predicts waitlist clearing probability.

📊 Example Flow

Add Train #101 with 3 coaches (each 10 seats).

Book 25 tickets.

First 30 → Confirmed.

Next 5 → Waitlisted.

Cancel 1 ticket → Automatically assigned to first waitlisted passenger.
