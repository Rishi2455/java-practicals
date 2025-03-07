<%@ page import="java.io.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Movie JSP</title>
</head>

<body>
    <form action="MovieDB.jsp" method="post">
        <fieldset>
            <legend>Movie Database</legend>
            <label for="choice">Query: </label>
            <select name="choice" id="choice">
                <option value="1">ADD</option>
                <option value="2" selected>SELECT</option>
                <option value="3">MODIFY</option>
                <option value="4">DELETE</option>
            </select>
            <input type="submit" value="Submit">
        </fieldset>
    </form>
    <% 
        String choice = request.getParameter("choice");
        if (choice != null) {
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajp", "root", "root");
                Statement stmt = con.createStatement();
                ResultSet rs = null;
                String query = "";
                switch (choice) {
                    case "1":
                        out.println("<fieldset><legend>Input</legend>");
                        out.println("<form action='MovieDB.jsp' method='post'><input type='hidden' name='choice' value='1'><input type='text' name='name' placeholder='Name'><input type='text' name='genre' placeholder='Genre'><input type='number' name='rating' placeholder='Rating'><input type='submit' value='Add Movie'></form>");
                        if (request.getParameter("name") != null) {
                            query = "INSERT INTO movies VALUES ('" + request.getParameter("name") + "', '" + request.getParameter("genre") + "', " + request.getParameter("rating") + ")";
                            stmt.executeUpdate(query);
                            out.println("Movie added successfully");
                        }
                        out.println("</fieldset>");
                    case "2":
                        out.println("<fieldset><legend>Output</legend>");
                        query = "SELECT * FROM movies";
                        rs = stmt.executeQuery(query);
                        out.println("<table border='1'>");
                        out.println("<tr><th>name</th><th>genre</th><th>rating</th></tr>");
                        while (rs.next()) {
                            out.println("<tr>");
                            out.println("<td>" + rs.getString("name") + "</td>");
                            out.println("<td>" + rs.getString("genre") + "</td>");
                            out.println("<td>" + rs.getInt("rating") + "</td>");
                            out.println("</tr>");
                        }
                        out.println("</table>");
                        out.println("</fieldset>");
                        break;
                    case "3":
                        out.println("<fieldset><legend>Input</legend>");
                        out.println("<form action='MovieDB.jsp' method='post'><input type='hidden' name='choice' value='3'><input type='text' name='name' placeholder='Name'><input type='text' name='genre' placeholder='Genre'><input type='number' name='rating' placeholder='Rating'><input type='submit' value='Modify Movie'></form>");
                        if (request.getParameter("name") != null) {
                            query = "UPDATE movies SET genre = '" + request.getParameter("genre") + "', rating = " + request.getParameter("rating") + " WHERE name = '" + request.getParameter("name") + "'";
                            stmt.executeUpdate(query);
                            out.println("Movie modified successfully");
                        }
                        out.println("</fieldset>");
                        break;
                    case "4":
                        out.println("<fieldset><legend>Input</legend>");
                        out.println("<form action='MovieDB.jsp' method='post'><input type='hidden' name='choice' value='4'><input type='text' name='name' placeholder='Name'><input type='submit' value='Delete Movie'></form>");
                        if (request.getParameter("name") != null) {
                            query = "DELETE FROM movies WHERE name = '" + request.getParameter("name") + "'";
                            stmt.executeUpdate(query);
                            out.println("Movie deleted successfully");
                        }
                        out.println("</fieldset>");
                        break;
                }
                con.close();
            } catch (Exception e) {
                out.println(e);
            }
        } 
    %>
</body>
</html>
