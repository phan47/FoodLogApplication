package food_log_app.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food_log_app.dao.UserDAO;
import food_log_app.model.UserProfile;

/**
 * Servlet implementation class UpdateProfile
 */
@WebServlet("/UpdateProfile")
public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    /* public UpdateProfile() {
        super();
        // TODO Auto-generated constructor stub
    } */
	public void init() {
		userDAO = new UserDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd = null;
		String firstName = request.getParameter("firstname");
		String userName = request.getParameter("username");
		int height = Integer.parseInt(request.getParameter("height"));
		int weight = Integer.parseInt(request.getParameter("weight"));
		String gender = request.getParameter("gender");
		int tWeight = Integer.parseInt(request.getParameter("tweight"));
		UserProfile newProfile = new UserProfile(userName,height,weight,gender,tWeight);
		boolean result = userDAO.updateUserProfile(newProfile);
		if(result == true) {
			rd = request.getRequestDispatcher("updateProfileSuccess.jsp");
			request.setAttribute("name", "firstName");
			rd.forward(request, response);
			//response.sendRedirect("success.html");
		} else {
			rd = request.getRequestDispatcher("updateProfileFailure.jsp");
			request.setAttribute("username", "userName");
			request.setAttribute("firstname", "firstName");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
