package com.ensta.librarymanager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ensta.librarymanager.exception.ServiceException;
import com.ensta.librarymanager.model.Abonnement;
import com.ensta.librarymanager.model.Emprunt;
import com.ensta.librarymanager.model.Membre;
import com.ensta.librarymanager.service.EmpruntServiceImpl;
import com.ensta.librarymanager.service.MembreServiceImpl;

@WebServlet("/membre_details")
public class MembreDetailsServlet extends HttpServlet {
	MembreServiceImpl membreService = MembreServiceImpl.getInstance();
	EmpruntServiceImpl empruntService = EmpruntServiceImpl.getInstance();

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String idMembre = request.getParameter("id");
			if (!idMembre.isEmpty()) {
				Membre membre = membreService.getById(Integer.parseInt(idMembre));
				List<Emprunt> emprunts = empruntService.getListCurrentByMembre(Integer.parseInt(idMembre));
				request.setAttribute("membre", membre);
				request.setAttribute("emprunts", emprunts);
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new ServletException();
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/View/membre_details.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String idMembre = request.getParameter("id");

			if (!idMembre.isEmpty()) {
				Membre membre = membreService.getById(Integer.parseInt(idMembre));
				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				String aboString = request.getParameter("abonnement");
				Abonnement abonnement = Abonnement.fromString(aboString);
				String adresse = request.getParameter("adresse");
				String email = request.getParameter("email");
				String telephone = request.getParameter("telephone");

				membre.setAbonnement(abonnement);
				membre.setAdresse(adresse);
				membre.setEmail(email);
				membre.setNom(nom);
				membre.setPrenom(prenom);
				membre.setTelephone(telephone);
				membreService.update(membre);
			}
		} catch (NumberFormatException | ServiceException e) {
			e.printStackTrace();
			throw new ServletException();
		}
		this.doGet(request, response);
	}

}
