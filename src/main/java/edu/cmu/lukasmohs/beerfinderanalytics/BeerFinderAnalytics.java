package edu.cmu.lukasmohs.beerfinderanalytics;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class extends a HTTPServlet and responds to incoming GET requests.
 * If performs the controller actions in this MVC and invokes the dashboard.jsp View.
 * @author lukasmohs
 */
@WebServlet(name = "BeerFinderAnalytics", urlPatterns = {"/getAnalytics"})
public class BeerFinderAnalytics extends HttpServlet{
    
    
    /**
     * This method is invoked, when the a GET request is sent to the /getAnalytics endpoint.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        // Determine what type of device the user has
        String userAgent = request.getHeader("User-Agent");
        
        // Prepare the appropriate DOCTYPE for the view pages
        if (userAgent != null && ((userAgent.indexOf("Android") != -1) || (userAgent.indexOf("iPhone") != -1))) {
            request.setAttribute("doctype", "<!DOCTYPE html PUBLIC \"-//WAPFORUM//DTD XHTML Mobile 1.2//EN\" \"http://www.openmobilealliance.org/tech/DTD/xhtml-mobile12.dtd\">");
        } else {
            request.setAttribute("doctype", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
        }
        
        // Redirect the user accordingly
        RequestDispatcher view;
        view = request.getRequestDispatcher("dashboard.jsp");
        view.forward(request, response);
    }
}
