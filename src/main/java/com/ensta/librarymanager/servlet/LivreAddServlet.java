package com.ensta.librarymanager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ensta.librarymanager.exception.ServiceException;
import com.ensta.librarymanager.model.Livre;
import com.ensta.librarymanager.service.LivreServiceImpl;

@WebServlet("/livre_add")
public class LivreAddServlet extends HttpServlet {

	LivreServiceImpl livreService = LivreServiceImpl.getInstance();

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/WEB-INF/View/livre_add.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String titre = request.getParameter("titre");
		String auteur = request.getParameter("auteur");
		String isbn = request.getParameter("isbn");

		Livre livre = new Livre(titre, auteur, isbn);
		try {
			livreService.create(livre);
			response.sendRedirect("livre_details" + "?id=" + livre.getId());
			return;
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new ServletException();
		}
		
	}

}
