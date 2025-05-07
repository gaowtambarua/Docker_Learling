import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Database connection parameters
//    private static final String URL = "jdbc:mysql://127.0.0.1:3306/userinfo";
//    private static final String URL = "jdbc:mysql://host.docker.internal/userinfo";
//    private static final String URL = "jdbc:mysql://172.17.0.2:3306/userinfo";
    private static final String URL = "jdbc:mysql://mysqldb/userinfo"; //for network
//    private static final String USER = "root";   //docker run -d --env MYSQL_ROOT_PASSWORD=Nabela2@4 --env MYSQL_DATABASE=userinfo --name mysqldb mysql
    private static final String USER = "Nabela";   //docker run -d --name mysqldb -e MYSQL_ROOT_PASSWORD=Nabela2@4 -e MYSQL_USER=Nabela -e MYSQL_PASSWORD=Nabela2@4 -e MYSQL_DATABASE=userinfo mysql
    private static final String PASSWORD = "Nabela2@4";

    public static void main(String[] args) {
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                 Scanner scanner = new Scanner(System.in)) {

                createTable(connection);
                displayMenu(connection, scanner);

            }
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }

    private static void displayMenu(Connection connection, Scanner scanner) throws SQLException {
        while (true) {
            System.out.println("\n==== Name Database Menu ====");
            System.out.println("1. Add a name");
            System.out.println("2. Show all names");
            System.out.println("3. Quit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addName(connection, scanner);
                    break;
                case "2":
                    showNames(connection);
                    break;
                case "3":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS names (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(255) NOT NULL)";

        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    private static void addName(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter a name: ");
        String name = scanner.nextLine().trim();

        if (!name.isEmpty()) {
            insertName(connection, name);
            System.out.printf("Name '%s' added successfully!%n", name);
        } else {
            System.out.println("Name cannot be empty!");
        }
    }

    private static void insertName(Connection connection, String name) throws SQLException {
        String sql = "INSERT INTO names (name) VALUES (?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.executeUpdate();
        }
    }

    private static void showNames(Connection connection) throws SQLException {
        List<String> names = fetchAllNames(connection);

        if (names.isEmpty()) {
            System.out.println("No names found in the database.");
        } else {
            System.out.println("\n=== Stored Names ===");
            for (String name : names) {
                System.out.println("- " + name);
            }
        }
    }

    private static List<String> fetchAllNames(Connection connection) throws SQLException {
        List<String> names = new ArrayList<>();
        String sql = "SELECT name FROM names";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                names.add(resultSet.getString("name"));
            }
        }
        return names;
    }
}
