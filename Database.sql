-- Step 1: Create the database
CREATE DATABASE IF NOT EXISTS LibraryDB;

-- Step 2: Switch to the newly created database
USE LibraryDB;

-- Step 3: Create the books table
CREATE TABLE IF NOT EXISTS books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    year INT NOT NULL
);

-- Step 4: Insert sample data (optional)
INSERT INTO books (title, author, year) VALUES
('To Kill a Mockingbird', 'Harper Lee', 1960),
('1984', 'George Orwell', 1949),
('The Great Gatsby', 'F. Scott Fitzgerald', 1925);
