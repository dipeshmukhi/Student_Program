package edu.student.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.student.model.User.UserService;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.sendRedirect("/Student_Program/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		ApplicationContext context;
		if(session.getAttribute("context")==null)
		{
			context = new ClassPathXmlApplicationContext("spring.xml");
		}
		else
		{
			context=(ApplicationContext) session.getAttribute("context");
		}
		UserService user= (UserService)context.getBean("userService");		
		edu.student.model.User.User newUser = new edu.student.model.User.User();
		
		newUser.setUserName(request.getParameter("txtUserName"));
		
		newUser.setPassword(request.getParameter("txtPassword"));		
		newUser.setFirstName(request.getParameter("txtFirstName"));
		newUser.setLastName(request.getParameter("txtLastName"));
		newUser.setEmailId(request.getParameter("txtEmailId"));
		newUser.setPhone(request.getParameter("txtPhone"));
		
		
		user.insertUser(newUser);
		session.setAttribute("returnMessage", "Registered Successfully !!!");
		
		response.sendRedirect("/Student_Program/index.jsp");
		
	}

}
