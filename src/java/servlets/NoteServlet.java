/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Note;
import java.io.File;
import java.io.FileWriter;
import javax.servlet.ServletContext;

/**
 *
 * @author Main
 */
public class NoteServlet extends HttpServlet
{

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        ServletContext servletContext = getServletContext();
        String contextPath = servletContext.getRealPath("/WEB-INF/note.txt");
        
        File textFile = new File(contextPath);
        Scanner scan = new Scanner(textFile);
        
        Note note = new Note(scan.nextLine(), scan.nextLine());
        
        request.setAttribute("note", note);
        
        if(request.getParameterMap().containsKey("edit"))
        {
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        }
        else
        {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        Note note = new Note(request.getParameter("title"), request.getParameter("content"));
        
        ServletContext servletContext = getServletContext();
        String contextPath = servletContext.getRealPath(File.separator);
        
        File textFile = new File(getServletContext().getRealPath("/WEB-INF/note.txt"));
        
        FileWriter writer = new FileWriter(textFile);
        
        writer.write(note.getTitle() + "\n");
        writer.write(note.getHtmlContent());
        writer.close();
        
        //request.setAttribute("note", note);
        
        //getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        
        response.sendRedirect("note");
    }
}