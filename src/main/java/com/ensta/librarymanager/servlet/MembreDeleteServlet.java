package com.ensta.librarymanager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ensta.librarymanager.exception.ServiceException;
import com.ensta.librarymanager.model.Membre;
import com.ensta.librarymanager.service.MembreServiceImpl;

@WebServlet("/membre_delete")
public class MembreDeleteServlet extends HttpServlet {

	MembreServiceImpl membreService = MembreServiceImpl.getInstance();

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String idMembre = request.getParameter("id");
			if (!idMembre.isEmpty()) {
				Membre membre = membreService.getById(Integer.parseInt(idMembre));
				request.setAttribute("membre", membre);
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new ServletException();
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/View/membre_delete.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String idMembre = request.getParameter("id");
			if (!idMembre.isEmpty()) {
				membreService.delete(Integer.parseInt(idMembre));
				response.sendRedirect("membre_list");
				return;
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new ServletException();
		}

		this.doGet(request, response);
	}

}
