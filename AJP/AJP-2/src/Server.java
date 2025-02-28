import java.sql.*;
import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException {
        try {
            ServerSocket ss = new ServerSocket(9000);
            System.out.println("Server started...");
            while (true) {
                Socket s = ss.accept();
                System.out.println("Client connected...");
                DataInputStream dataInputStream = new DataInputStream(s.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(s.getOutputStream());
                String name = dataInputStream.readUTF();
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AJP", "root", "root");
                Statement stmt = con.createStatement();
                String query = "select * from movies where name = '" + name + "'";
                ResultSet rs = stmt.executeQuery(query);
                String result = "Movie not found!";
                while (rs.next()) {
                    result = "Name: " + rs.getString(1) + "\nGenre: " + rs.getString(2) + "\nRating: " + rs.getString(3);
                }
                dataOutputStream.writeUTF(result);
                System.out.println("Request for movie: " + name);
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
