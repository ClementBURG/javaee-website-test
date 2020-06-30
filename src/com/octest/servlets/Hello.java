package com.octest.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.beans.Author;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set attributes example
		String message = "Au revoir !";
		request.setAttribute("message", message);
		
		request.setAttribute("heure", "jour");
		
		String[] names = {"Mathieu", "Robert", "François"};
		request.setAttribute("names", names);
		
		// Get parameters example
		String name = request.getParameter("name");
		request.setAttribute("name", name);
		
		// Java Beans example
		Author author = new Author();
		author.setFirstName("Théo");
		author.setLastName("Dubois");
		author.setActive(true);
		
		request.setAttribute("author", author);
		
		String variable = "<p>Exemple avec la JSTL !</p>";
		request.setAttribute("variable", variable);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/hello.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
