<%-- 
    Document   : viewnote
    Created on : Jun 16, 2021, 12:11:51 PM
    Author     : Main
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <p><span style="font-weight: bold;">Title: </span> ${note.getTitle()}</p>
        <p style="font-weight: bold; margin-bottom: 0;">Contents: </p>
        <p style="margin-top: 0">${note.getHtmlContent()}</p>
        
        <a href="/Lab4_SimpleNoteKeeper/note?edit">Edit</a>
    </body>
</html>
