package com.octest.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.forms.UploadFileForm;

/**
 * Servlet implementation class FileForm
 */
@WebServlet("/FileForm")
public class FileForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final int TAILLE_TAMPON = 10240;
    public static final String CHEMIN_FICHIERS = "C:/Users/burg_c/Documents/octest_files/";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/fileForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UploadFileForm form = new UploadFileForm();
		
		 form.uploadFile(request);

        this.getServletContext().getRequestDispatcher("/WEB-INF/fileForm.jsp").forward(request, response);
	}
}
