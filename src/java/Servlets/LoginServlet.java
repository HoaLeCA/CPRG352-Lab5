
package Servlets;

import Models.User;
import Services.AccountServices;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author levan
 */
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String logout = request.getParameter("logout");
        if(logout != null){
            session.invalidate();
            session = request.getSession();
            boolean logOutMessage = true;
            request.setAttribute("logOutMessage", logOutMessage);
        }
         String username = (String)session.getAttribute("username");
        if( username != null){
            response.sendRedirect("home");
            return;
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        return;
       
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        User user = new User(username, password);
        
        //validation user input
        if(username == null||username.equals("")||password == null||password.equals("")){
            request.setAttribute("user", user);
            boolean error = true;
            request.setAttribute("error", error);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        
        AccountServices accountService = new AccountServices();
        if(accountService.login(username,password) != null){
            String message = "You have logged in successfully!";
            // user is now logged in
            HttpSession session = request.getSession();
            session.setAttribute("username", username);               
            session.setAttribute("message", message);
             response.sendRedirect("home");
            return;//IMPORTANT;
      
        }else{
             boolean error = true;
            request.setAttribute("error", error);
            request.setAttribute("user", user);
            // -- Null safety checking
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return; //IMPORTANT;
        }
    
        

        

        

      

    }

}
