package com.ensta.librarymanager.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ensta.librarymanager.exception.ServiceException;
import com.ensta.librarymanager.model.Livre;
import com.ensta.librarymanager.model.Membre;
import com.ensta.librarymanager.service.EmpruntServiceImpl;
import com.ensta.librarymanager.service.LivreServiceImpl;
import com.ensta.librarymanager.service.MembreServiceImpl;

@WebServlet("/emprunt_add")
public class EmpruntAddServlet extends HttpServlet {

	MembreServiceImpl memberService = MembreServiceImpl.getInstance();
	LivreServiceImpl livreService = LivreServiceImpl.getInstance();
	EmpruntServiceImpl empruntService = EmpruntServiceImpl.getInstance();

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			List<Livre> livresDispo = livreService.getListDispo();
			request.setAttribute("livresDisponibles", livresDispo);
			List<Membre> membresDispo = memberService.getListMembreEmpruntPossible();
			request.setAttribute("membresDisponibles", membresDispo);
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new ServletException();
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/View/emprunt_add.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int idLivre = Integer.parseInt(request.getParameter("idLivre"));
		int idEmprunteur = Integer.parseInt(request.getParameter("idMembre"));
		try {
			empruntService.create(idEmprunteur, idLivre, LocalDate.now());
			response.sendRedirect("emprunt_list");
			return;
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new ServletException();
		}

	}

}
