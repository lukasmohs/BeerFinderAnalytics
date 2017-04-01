package edu.cmu.lukasmohs.beerfinderanalytics;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lukasmohs
 */
@WebServlet(name = "BeerFinderAnalytics", urlPatterns = {"/getAnalytics"})
public class BeerFinderAnalytics extends HttpServlet{
    

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        
        // determine what type of device the user has
        String userAgent = request.getHeader("User-Agent");
        
        // prepare the appropriate DOCTYPE for the view pages
        if (userAgent != null && ((userAgent.indexOf("Android") != -1) || (userAgent.indexOf("iPhone") != -1))) {
            request.setAttribute("doctype", "<!DOCTYPE html PUBLIC \"-//WAPFORUM//DTD XHTML Mobile 1.2//EN\" \"http://www.openmobilealliance.org/tech/DTD/xhtml-mobile12.dtd\">");
        } else {
            request.setAttribute("doctype", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
        }
        
        //redirect the user accordingly
        RequestDispatcher view;

        DashboardModel.getActivities();
        view = request.getRequestDispatcher("dashboard.jsp");
        
        view.forward(request, response);
        

    }
}
