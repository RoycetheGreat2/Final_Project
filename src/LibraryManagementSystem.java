import java.sql.*;
import java.util.Scanner;

public class LibraryManagementSystem {
    private static final String URL = "jdbc:mysql://localhost:3306/LibraryDB";
    private static final String USER = "royce123541";
    private static final String PASSWORD = "royce123541";

    private static Connection connection = null;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish the connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected successfully!");
            
            System.out.println("Welcome to Library Management System!");
            
            // Menu loop
            while (true) {
                System.out.println("\n--- Menu ---");
                System.out.println("1. Add Book");
                System.out.println("2. View All Books");
                System.out.println("3. Update Book");
                System.out.println("4. Delete Book");
                System.out.println("5. Exit");
                
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                
                switch (choice) {
                    case 1:
                        addBook();
                        break;
                    case 2:
                        viewBooks();
                        break;
                    case 3:
                        updateBook();
                        break;
                    case 4:
                        deleteBook();
                        break;
                    case 5:
                        if (connection != null) {
                            connection.close();
                        }
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid option!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addBook() throws SQLException {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter publication year: ");
        int year = scanner.nextInt();
        
        String sql = "INSERT INTO books (title, author, year) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, title);
        preparedStatement.setString(2, author);
        preparedStatement.setInt(3, year);
        
        int rowsInserted = preparedStatement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Book added successfully!");
        }
    }

    private static void viewBooks() throws SQLException {
        String sql = "SELECT * FROM books";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        
        System.out.println("\nBooks in Library:");
        System.out.println("ID | Title | Author | Year");
        System.out.println("------------------------");
        
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            int year = resultSet.getInt("year");
            
            System.out.printf("%d | %s | %s | %d%n", id, title, author, year);
        }
    }

    private static void updateBook() throws SQLException {
        System.out.print("Enter book ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Enter new title: ");
        String title = scanner.nextLine();
        System.out.print("Enter new author: ");
        String author = scanner.nextLine();
        System.out.print("Enter new year: ");
        int year = scanner.nextInt();
        
        String sql = "UPDATE books SET title=?, author=?, year=? WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, title);
        preparedStatement.setString(2, author);
        preparedStatement.setInt(3, year);
        preparedStatement.setInt(4, id);
        
        int rowsUpdated = preparedStatement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Book updated successfully!");
        } else {
            System.out.println("Book not found!");
        }
    }

    private static void deleteBook() throws SQLException {
        System.out.print("Enter book ID to delete: ");
        int id = scanner.nextInt();
        
        String sql = "DELETE FROM books WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        
        int rowsDeleted = preparedStatement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Book deleted successfully!");
        } else {
            System.out.println("Book not found!");
        }
    }
}