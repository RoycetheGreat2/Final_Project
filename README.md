#THIS MAY NOT RUN IN GITHUB BECAUSE OF COMPLICATIONS WITH SQL AND JAVA CONNECTIVITY
# Library Management System

This project is a simple Library Management System built using Java and MySQL. The application allows users to perform basic CRUD (Create, Read, Update, Delete) operations on a library database, which stores book information. The program interacts with a MySQL database to manage a collection of books and allows the user to:

- Add a new book to the library.
- View all books in the library.
- Update the details of an existing book.
- Delete a book from the library.

## Database Setup

The system uses a MySQL database to store book information. The `init.sql` file contains the necessary SQL commands to create the database schema and insert some initial data into the `books` table.

### Database Structure

1. **Database Name**: `LibraryDB`
2. **Table Name**: `books`
3. **Table Structure**:
   - `id` (INT): Auto-incremented primary key.
   - `title` (VARCHAR): Title of the book.
   - `author` (VARCHAR): Author of the book.
   - `year` (INT): Year of publication.

### Sample Data

The `books` table is populated with the following sample data:

- `To Kill a Mockingbird`, by `Harper Lee`, published in `1960`.
- `1984`, by `George Orwell`, published in `1949`.
- `The Great Gatsby`, by `F. Scott Fitzgerald`, published in `1925`.

## Functionality

### 1. Add a Book
The user can add a new book to the library by providing the title, author, and year of publication. The book is then inserted into the `books` table in the MySQL database.

### 2. View All Books
This option allows the user to see a list of all books stored in the library's database. It displays the book's `id`, `title`, `author`, and `year`.

### 3. Update a Book
The user can update the details of an existing book by specifying the book's `id`. The user can modify the book's title, author, and year of publication. The system will then update the corresponding record in the database.

### 4. Delete a Book
The user can delete a book from the library by providing the `id` of the book they wish to remove. The system will delete the record from the `books` table.

## Technology Stack

- **Java**: The application is built using Java, with JDBC (Java Database Connectivity) to interact with the MySQL database.
- **MySQL**: The backend database used to store book records.
- **JDBC**: Java Database Connectivity is used to connect to the MySQL database and perform CRUD operations.

## Summary

The Library Management System provides a simple and efficient way to manage a library's collection of books using a command-line interface. The system allows for easy interaction with a MySQL database, enabling users to manage books, update their details, and delete them as needed. The application demonstrates basic CRUD operations, making it a useful example of working with databases in Java.
