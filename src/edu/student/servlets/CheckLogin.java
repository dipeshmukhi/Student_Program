package edu.student.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.tag.common.sql.DataSourceWrapper;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.student.model.Connect;
import edu.student.model.User;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		ApplicationContext factory= new ClassPathXmlApplicationContext("spring.xml");
		SqlSessionFactoryBean sqlSessionFactory = (SqlSessionFactoryBean) factory.getBean("sqlSessionFactory");
		
		
		String lUserName=request.getParameter("txtUserName");
		String lPassword=request.getParameter("txtPassword");
		
		response.setContentType("text/html");		
		PrintWriter out=response.getWriter();
		
		DataSourceWrapper myDataSource = null;
		Connection lConnection=null;
		Statement lLoginSql=  null;
		ResultSet lResultSet=null;

		try
		{
			myDataSource= (DataSourceWrapper)session.getAttribute("myDataSource");
			if(myDataSource==null)
			{
				myDataSource = new Connect().getMyDataSource();
				session.setAttribute("myDataSource",myDataSource);
			}
			
			lConnection = myDataSource.getConnection();
			lLoginSql= lConnection.createStatement();
			lResultSet=lLoginSql.executeQuery("select count(*) from user_details where User_Name = '"+lUserName+"' and Password = '"+lPassword+"'");
			lResultSet.first();
			if(lResultSet.getInt(1)>0)
			{
				lResultSet=lLoginSql.executeQuery("select * from user_details where User_Name = '"+lUserName+"' and Password = '"+lPassword+"'");
				lResultSet.first();
				User currentUser=new User();
				
				currentUser.setUserName(lResultSet.getString("User_Name"));
				currentUser.setFirstName(lResultSet.getString("First Name"));
				currentUser.setLastName(lResultSet.getString("Last Name"));
				currentUser.setEmailId(lResultSet.getString("Email"));
				currentUser.setPhone(lResultSet.getString("Phone"));
				
				String lUserType = lResultSet.getString("Type");				
				
				if(lUserType==null || lUserType.isEmpty())
					lUserType="Student";
				
				currentUser.setType(lUserType);				
				request.getSession().setAttribute("currentUser", currentUser);
				
				if(lUserType.equalsIgnoreCase("Student"))
					response.sendRedirect("/Student_Program/Student/StudentMainPage.jsp");
				else
					response.sendRedirect("/Student_Program/Professor/ProfessorMainPage.jsp");
			}
			else
			{
				session.setAttribute("returnMessage","Invalid UserName/Password");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			session.setAttribute("returnMessage","Invalid UserName/Password");
			response.sendRedirect("/Student_Program");
		}
		finally
		{
			try
			{
					lConnection.close();
					lLoginSql.close();
					lResultSet.close();
			}
			catch(Exception e)
			{
				out.println("Error Message"+e.getMessage());
			}
		}
	 }

}
