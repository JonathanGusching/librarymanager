package com.ensta.librarymanager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ensta.librarymanager.exception.ServiceException;
import com.ensta.librarymanager.service.EmpruntServiceImpl;
import com.ensta.librarymanager.service.LivreServiceImpl;
import com.ensta.librarymanager.service.MembreServiceImpl;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

	MembreServiceImpl memberService = MembreServiceImpl.getInstance();
	LivreServiceImpl livreService = LivreServiceImpl.getInstance();
	EmpruntServiceImpl empruntService = EmpruntServiceImpl.getInstance();

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			request.setAttribute("countMembre", this.memberService.count());
			request.setAttribute("countLivres", this.livreService.count());
			request.setAttribute("countEmprunts", this.empruntService.count());
			request.setAttribute("emprunts", this.empruntService.getListCurrent());
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/View/dashboard.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
