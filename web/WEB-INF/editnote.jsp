<%-- 
    Document   : editnote
    Created on : Jun 16, 2021, 12:12:00 PM
    Author     : Main
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Note</title>
    </head>
    <body>
        
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <form method="post">
            <p>Title: <input type="text" name="title" value="${note.getTitle()}"></p>
            <p>Content: <textarea name="content">${note.getContent()}</textarea></p>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
