package controller.viewsServelt;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.tools.HomeTools;
import model.entities.Users;
import model.utils.UtilsAccount;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Users user = null;
     
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("appTitle", HomeTools.getAppTilte());
		
		user = (Users) request.getAttribute("User");
		if(UtilsAccount.notEmpty(user)) {
			request.setAttribute("User", user);
			request.getRequestDispatcher("JSP/dashboard.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("pwd");
		try {
			user = HomeTools.logUser(login, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("User", user);
		doGet(request, response);
	}

}
