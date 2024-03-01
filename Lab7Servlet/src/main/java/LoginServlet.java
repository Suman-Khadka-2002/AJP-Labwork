import java.io.IOException; 
import java.io.PrintWriter; 
import java.net.http.HttpResponse; 
import jakarta.servlet.ServletException; 
import jakarta.servlet.ServletResponse; 
import jakarta.servlet.annotation.WebServlet; 
import jakarta.servlet.http.HttpServlet; 
import jakarta.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpServletResponse; 

@WebServlet("/LoginServlet") 
public class LoginServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L; 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{ 
		 // Retrieve user input from the login form 
		 String username = request.getParameter("username"); 
		 String password = request.getParameter("password"); 
		 
		 // Set content type of the response 
		 response.setContentType("text/html"); 
		 
		 // Get PrintWriter object to write HTML response 
		 PrintWriter out = response.getWriter(); 
		 
		 // Hardcoded values for username and password 
		 String validUsername = "suman"; 
		 String validPassword = "password"; 
		 
		 // Check if the entered username and password match the hardcoded values 
		 if (validUsername.equals(username) && validPassword.equals(password)) { 
			 
			 // Authentication successful 
			 out.println("<html><body>"); 
			 out.println("<h2>Login Successful</h2>"); 
			 out.println("<p>Welcome, " + username + "!</p>"); 
			 out.println("</body></html>"); 
		 } else { 
			 // Authentication failed 
			 out.println("<html><body>"); 
			 out.println("<h2>Login Failed</h2>"); 
			 out.println("<p>Invalid username or password.</p>"); 
			 out.println("</body></html>"); 
		 	} 
	} 
} 