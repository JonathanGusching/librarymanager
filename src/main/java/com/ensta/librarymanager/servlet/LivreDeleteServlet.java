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

@WebServlet("/livre_delete")
public class LivreDeleteServlet extends HttpServlet {

	LivreServiceImpl livreService = LivreServiceImpl.getInstance();

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String idLivre = request.getParameter("id");
			if(!idLivre.isEmpty())
			{
				Livre livre=livreService.getById(Integer.parseInt(idLivre));
				request.setAttribute("livre", livre);
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/View/livre_delete.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String idLivre = request.getParameter("id");
			if(!idLivre.isEmpty())
			{
				livreService.delete(Integer.parseInt(idLivre));
				response.sendRedirect("livre_list");
				return;
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new ServletException();
		}

		this.doGet(request, response);
	}

}
