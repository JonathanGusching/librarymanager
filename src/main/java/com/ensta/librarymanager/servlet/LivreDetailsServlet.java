package com.ensta.librarymanager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ensta.librarymanager.exception.ServiceException;
import com.ensta.librarymanager.model.Emprunt;
import com.ensta.librarymanager.model.Livre;
import com.ensta.librarymanager.service.EmpruntServiceImpl;
import com.ensta.librarymanager.service.LivreServiceImpl;

@WebServlet("/livre_details")
public class LivreDetailsServlet extends HttpServlet {
	LivreServiceImpl livreService = LivreServiceImpl.getInstance();
	EmpruntServiceImpl empruntService = EmpruntServiceImpl.getInstance();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String idLivre = request.getParameter("id");
			if(!idLivre.isEmpty())
			{
				Livre livre=livreService.getById(Integer.parseInt(idLivre));
				List<Emprunt> emprunts = empruntService.getListCurrentByLivre(Integer.parseInt(idLivre));
				request.setAttribute("livre", livre);
				request.setAttribute("emprunts", emprunts);
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/View/livre_details.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String idLivre = request.getParameter("id");

			if (!idLivre.isEmpty()) {
				Livre livre = livreService.getById(Integer.parseInt(idLivre));
				String titre = request.getParameter("titre");
				
				String auteur = request.getParameter("auteur");
				String isbn = request.getParameter("isbn");
				
				livre.setAuteur(auteur);
				livre.setTitre(titre);
				livre.setIsbn(isbn);
				
				livreService.update(livre);
			}
		} catch (NumberFormatException | ServiceException e) {
			e.printStackTrace();
			throw new ServletException();
		}
		this.doGet(request, response);
	}

}
