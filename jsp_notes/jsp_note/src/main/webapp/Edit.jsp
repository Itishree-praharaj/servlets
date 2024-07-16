<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.notes.Note" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Note</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <h1>Edit Note</h1>

    <%
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
          List<Note> notes = (List<Note>) session.getAttribute("notes");
        Note noteToEdit = null;

        for (Note note : notes) {
            if (note.getId() == id) {
                noteToEdit = note;
                break;
            }
        }
    %>

    <div>
        <form action="NoteServlet" method="post">
            <input type="hidden" name="action" value="edit">
            <input type="hidden" name="id" value="<%= noteToEdit.getId() %>">
            <label for="title">Title:</label>
            <input type="text" id="title" name="title" value="<%= noteToEdit.getTitle() %>" required>
            <br>
            <label for="content">Content:</label>
            <textarea id="content" name="content" required><%= noteToEdit.getContent() %></textarea>
            <br>
            <button type="submit">Save Changes</button>
        </form>
    </div>
</body>
</html>