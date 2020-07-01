package com.octest.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.Names;
import com.octest.beans.User;

/**
 * Servlet implementation class SqlServlet
 */
@WebServlet("/SqlServlet")
public class SqlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SqlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Names tableNames = new Names();
        request.setAttribute("users", tableNames.recupererUtilisateurs());
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/sql.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
        
        Names tableNames = new Names();
        tableNames.ajouterUtilisateur(user);
        
        request.setAttribute("users", tableNames.recupererUtilisateurs());
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/sql.jsp").forward(request, response);
	}

}
