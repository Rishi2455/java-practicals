import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class FirstServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String choice = request.getParameter("choice");
        if (choice!=null) {
            String jdbcurl = "jdbc:mysql://localhost:3306/ajp";
            String username = "root";
            String password = "root";
            switch (choice) 
            {
                case "1":
                    out.println("<html><body><form action='FirstServlet'><input type='hidden' name='choice' value='1'><input type='text' name='name' placeholder='Name'><input type='text' name='genre' placeholder='Genre'><input type='number' name='rating' placeholder='Rating'><input type='submit' value='Add Movie'></form></body></html>");
                    String name = request.getParameter("name");
                    String genre = request.getParameter("genre");
                    int rating = Integer.parseInt(request.getParameter("rating"));
                    try {
                        Connection conn = DriverManager.getConnection(jdbcurl, username, password);
                        Statement stmt = conn.createStatement();
                        stmt.executeUpdate("insert into movies(name, genre, rating) values('" + name + "', '" + genre + "', " + rating + ")");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "2":
                    out.println("<html><body><form action='FirstServlet'><input type='hidden' name='choice' value='2'><input type='submit' value='View Movie List'></form></body></html>");
                    try {
                        Connection conn = DriverManager.getConnection(jdbcurl, username, password);
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery("select * from movies");
                        while (rs.next()) {
                            out.println(rs.getString(1) + "||" + rs.getString(2) + "||" + rs.getInt(3) + "<br>");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "3":
                    out.println("<html><body><form action='FirstServlet'><input type='hidden' name='choice' value='3'><input type='text' name='name' placeholder='Name'><input type='text' name='genre' placeholder='Genre'><input type='number' name='rating' placeholder='Rating'><input type='submit' value='Modify Movie'></form></body></html>");
                    name = request.getParameter("name");
                    genre = request.getParameter("genre");
                    rating = Integer.parseInt(request.getParameter("rating"));
                    try {
                        Connection conn = DriverManager.getConnection(jdbcurl, username, password);
                        Statement stmt = conn.createStatement();
                        stmt.executeUpdate("update movies set name = '" + name + "', genre = '" + genre + "', rating = " + rating + " where name = '" + name + "'");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "4":
                    out.println("<html><body><form action='FirstServlet'><input type='hidden' name='choice' value='4'><input type='text' name='name' placeholder='Name'><input type='submit' value='Delete Movie'></form></body></html>");
                    name = request.getParameter("name");
                    try {
                        Connection conn = DriverManager.getConnection(jdbcurl, username, password);
                        Statement stmt = conn.createStatement();
                        stmt.executeUpdate("delete from movies where name = '" + name + "'");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    out.println("<html><body><form action='FirstServlet'><input type='hidden' name='choice' value='0'><input type='submit' value='Invalid choice'></form></body></html>");
                    break;
            }
        } 
        else 
        {
            out.println("<!DOCTYPE html>\r\n" + //
                                "<html lang=\"en\">\r\n" + //
                                "<head>\r\n" + //
                                "    <meta charset=\"UTF-8\">\r\n" + //
                                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                                "    <title>FirstServlet</title>\r\n" + //
                                "</head>\r\n" + //
                                "<body>\r\n" + //
                                "    <form action=\"FirstServlet\" method=\"get\">\r\n" + //
                                "        <fieldset>\r\n" + //
                                "            <legend>Movie Database</legend>\r\n" + //
                                "            <label for=\"choice\">Query :</label>\r\n" + //
                                "            <select name=\"choice\" id=\"choice\">\r\n" + //
                                "                <option value=\"1\">ADD</option>\r\n" + //
                                "                <option value=\"2\" selected>SELECT</option>\r\n" + //
                                "                <option value=\"3\">MODIFY</option>\r\n" + //
                                "                <option value=\"4\">DELETE</option>\r\n" + //
                                "            </select>\r\n" + //
                                "            <input type=\"submit\" value=\"Submit\">\r\n" + //
                                "        </fieldset>\r\n" + //
                                "    </form>\r\n" + //
                                "</body>\r\n" + //
                                "</html>");
        }
    }
}
