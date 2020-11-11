package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAL.EmployeeDAO;
import model.Employee;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String password = request.getParameter("password");
		System.out.println(id+"001"+password);
		EmployeeDAO empDAO = new EmployeeDAO();
		try {
			String destPage = "login.jsp";
			Employee emp = empDAO.getEmpAccount(id, password);
			System.out.println(id+"002"+password);
			if(emp!= null) {
				HttpSession session = request.getSession();
	            session.setAttribute("user", emp);
	            destPage = "roomList";
			}
			else {
                String message = "Invalid email/password";
                request.setAttribute("message", message);
                System.out.println(message);
            }
			request.getRequestDispatcher(destPage).forward(request, response);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
