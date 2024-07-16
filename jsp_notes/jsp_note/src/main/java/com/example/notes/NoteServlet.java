package com.example.notes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/NoteServlet")
public class NoteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Note> notes = (List<Note>) session.getAttribute("notes");

        if (notes == null) {
            notes = new ArrayList<>();
        }

        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            Note note = new Note();
            note.setTitle(title);
            note.setContent(content);
            notes.add(note);

        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            notes.removeIf(note -> note.getId() == id);

        } else if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String title = request.getParameter("title");
            String content = request.getParameter("content");

            for (Note note : notes) {
                if (note.getId() == id) {
                    note.setTitle(title);
                    note.setContent(content);
                    break;
                }
            }
        }

        session.setAttribute("notes", notes);
        response.sendRedirect("index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}       
