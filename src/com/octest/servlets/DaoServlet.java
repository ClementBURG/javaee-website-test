package com.octest.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.beans.User;
import com.octest.dao.DaoException;
import com.octest.dao.DaoFactory;
import com.octest.dao.IUserDao;

/**
 * Servlet implementation class DaoServlet
 */
@WebServlet("/DaoServlet")
public class DaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserDao userDao;
       
	public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.userDao = daoFactory.getUserDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("users", userDao.list());
		} catch (DaoException e) {
			request.setAttribute("erreur", e.getMessage());
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/dao.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User user = new User();
			user.setFirstName(request.getParameter("firstName"));
			user.setLastName(request.getParameter("lastName"));
	        
	        userDao.add(user);
	        request.setAttribute("users", userDao.list());
		} catch (Exception e) {
			request.setAttribute("erreur", e.getMessage());
		}
        
		this.getServletContext().getRequestDispatcher("/WEB-INF/dao.jsp").forward(request, response);
	}

}
