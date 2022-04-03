package com.ensta.librarymanager.service;

import java.time.LocalDate;
import java.util.List;

import com.ensta.librarymanager.dao.EmpruntDaoImpl;
import com.ensta.librarymanager.exception.DaoException;
import com.ensta.librarymanager.exception.ServiceException;
import com.ensta.librarymanager.model.Emprunt;
import com.ensta.librarymanager.model.Membre;

public class EmpruntServiceImpl implements IEmpruntService {
	private static EmpruntServiceImpl instance;

	private EmpruntServiceImpl() {
	}

	public static EmpruntServiceImpl getInstance() {
		if (instance == null) {
			instance = new EmpruntServiceImpl();
		}
		return instance;
	}

	EmpruntDaoImpl empruntDao = EmpruntDaoImpl.getInstance();

	@Override
	public List<Emprunt> getList() throws ServiceException {
		try {
			List<Emprunt> list = empruntDao.getList();
			return list;
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

	@Override
	public List<Emprunt> getListCurrent() throws ServiceException {
		try {
			List<Emprunt> list = empruntDao.getListCurrent();
			return list;
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

	@Override
	public List<Emprunt> getListCurrentByMembre(int idMembre) throws ServiceException {
		try {
			List<Emprunt> list = empruntDao.getListCurrentByMembre(idMembre);
			return list;
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

	@Override
	public List<Emprunt> getListCurrentByLivre(int idLivre) throws ServiceException {
		try {
			List<Emprunt> list = empruntDao.getListCurrentByLivre(idLivre);
			return list;
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

	@Override
	public Emprunt getById(int id) throws ServiceException {
		try {
			return empruntDao.getById(id);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

	@Override
	public void create(int idMembre, int idLivre, LocalDate dateEmprunt) throws ServiceException {
		try {
			empruntDao.create(idMembre, idLivre, dateEmprunt);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException();
		}

	}

	@Override
	public void returnBook(int id) throws ServiceException {
		try {
			Emprunt newEmprunt = new Emprunt(empruntDao.getById(id));
			LocalDate dateRetour = LocalDate.now();
			newEmprunt.setDateRetour(dateRetour);
			empruntDao.update(newEmprunt);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException();
		}

	}

	@Override
	public int count() throws ServiceException {
		try {
			return empruntDao.count();
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

	@Override
	public boolean isLivreDispo(int idLivre) throws ServiceException {
		try {
			List<Emprunt> livres = empruntDao.getListCurrentByLivre(idLivre); // TODO faire fonctionner ça..
			return (livres.isEmpty());
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

	@Override
	public boolean isEmpruntPossible(Membre membre) throws ServiceException {
		try {
			List<Emprunt> emprunts = empruntDao.getListCurrentByMembre(membre.getId());
			int count = emprunts.size();
			return (count < membre.getAbonnement().getLimit());
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

}
