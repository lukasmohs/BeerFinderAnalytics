<%-- 
    Document   : dashboard.jsp
    Created on : Apr 1, 2017, 3:14:53 PM
    Author     : lukasmohs
--%>

<%@page import="java.util.Date"%>
<%@page import="edu.cmu.lukasmohs.beerfinderanalytics.DashboardModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello to the Beer World!</h1>
        <% for(int i = 0; i < DashboardModel.getActivities().size();i++) { %>
            Date: <%= new Date(DashboardModel.getActivities().get(i).getTimeStamp()) %>
            <br/>
            Answers: <%= new Date(DashboardModel.getActivities().get(i).getNumberOfAnswers()) %>
            <br/>
            Device <%= new Date(DashboardModel.getActivities().get(i).getDevice()) %>
            <br/>
        <% } %>
    </body>
</html>
