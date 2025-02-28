import java.sql.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws ClassNotFoundException {
        String jdbcurl = "jdbc:mysql://localhost:3306/ajp";
        String username = "root";
        String password = "root";
        try {
            Connection conn = DriverManager.getConnection(jdbcurl, username, password);
            System.out.println("Connected to the database successfully!");
            Statement stmt = conn.createStatement();
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("Enter 1 to add movie\nEnter 2 to view movie\nEnter 3 to modify movie\nEnter 4 to delete movie\nEnter 5 to exit\n");
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Genre: ");
                        String Genre = sc.nextLine();
                        System.out.print("Enter rating: ");
                        int rating = Integer.parseInt(sc.nextLine());
                        stmt.executeUpdate("insert into movies(name, Genre, rating) values('" + name + "', '" + Genre + "', " + rating + ")");
                        break;
                    case 2:
                        ResultSet rs = stmt.executeQuery("select * from movies");
                        System.out.println();
                        while (rs.next()) {
                            System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getInt(3));
                        }
                        System.out.println();
                        break;
                    case 3:
                        System.out.print("Enter Name: ");
                        name = sc.nextLine();
                        System.out.print("Enter Genre: ");
                        Genre = sc.nextLine();
                        System.out.print("Enter rating: ");
                        rating = Integer.parseInt(sc.nextLine());
                        stmt.executeUpdate("update movies set name = '" + name + "', Genre = '" + Genre + "', rating = " + rating);
                        break;
                    case 4:
                        System.out.print("Enter Name: ");
                        name = sc.nextLine();
                        stmt.executeUpdate("delete from movies where name = '" + name + "'");
                        break;
                    case 5:
                        sc.close();
                        conn.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }   
    }
}
