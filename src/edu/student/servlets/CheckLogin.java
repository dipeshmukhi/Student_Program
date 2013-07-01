package edu.student.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.student.model.User.User;
import edu.student.model.User.UserService;

/**
 * Servlet implementation class CheckLogin
 */
public class CheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckLogin() {
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
				context= new ClassPathXmlApplicationContext("spring.xml");
				session.setAttribute("context",context);
		}
		else
			context=(ApplicationContext) session.getAttribute("context");
		
		Map<String, String> lCredentials = new HashMap<String, String>();
		lCredentials.put("userName",request.getParameter("txtUserName"));
		lCredentials.put("password",request.getParameter("txtPassword"));
		
		UserService user = (UserService) context.getBean("userService");
		User currentUser = user.getUserLogin(lCredentials);
		
		if(currentUser == null || currentUser.getUserName().isEmpty())
		{
			session.setAttribute("returnMessage","Invalid UserName/Password");
			response.sendRedirect("/Student_Program/index.jsp");
		}
		
		else
		{
			String lUserType = currentUser.getType();				
			
			if(lUserType==null || lUserType.isEmpty())
				lUserType="Student";
			
			currentUser.setType(lUserType);				
			session.setAttribute("currentUser", currentUser);
			
			if(lUserType.equalsIgnoreCase("Student"))
				response.sendRedirect("/Student_Program/Student/StudentMainPage.jsp");
			else
				response.sendRedirect("/Student_Program/Professor/ProfessorMainPage.jsp");
		}
	}
}
