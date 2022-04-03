package com.ensta.librarymanager.service;

import java.util.List;

import com.ensta.librarymanager.dao.MembreDaoImpl;
import com.ensta.librarymanager.exception.DaoException;
import com.ensta.librarymanager.exception.ServiceException;
import com.ensta.librarymanager.model.Abonnement;
import com.ensta.librarymanager.model.Membre;

public class MembreServiceImpl implements IMembreService {
	private static MembreServiceImpl instance;

	private MembreServiceImpl() {
	}

	public static MembreServiceImpl getInstance() {
		if (instance == null) {
			instance = new MembreServiceImpl();
		}
		return instance;
	}

	MembreDaoImpl membreDao = MembreDaoImpl.getInstance();
	EmpruntServiceImpl empruntService = EmpruntServiceImpl.getInstance();

	@Override
	public List<Membre> getList() throws ServiceException {
		try {
			List<Membre> list = membreDao.getList();
			return list;
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

	@Override
	public List<Membre> getListMembreEmpruntPossible() throws ServiceException {
		List<Membre> list = getList();

		for(int i =0; i < list.size(); i++)
		{
			if((empruntService.getListCurrentByMembre(list.get(i).getId()).size() >= 2 && list.get(i).getAbonnement() == Abonnement.BASIC)
					|| (empruntService.getListCurrentByMembre(list.get(i).getId()).size() >= 5 && list.get(i).getAbonnement() == Abonnement.PREMIUM)
					|| (empruntService.getListCurrentByMembre(list.get(i).getId()).size() >= 20
							&& list.get(i).getAbonnement() == Abonnement.VIP)) {
				list.remove(i);
			}
		}
		return list;
	}

	@Override
	public Membre getById(int id) throws ServiceException {
		try {
			return membreDao.getById(id);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

	@Override
	public int create(Membre membre) throws ServiceException {
		if (membre.getNom().isEmpty() || membre.getPrenom().isEmpty()) {
			throw new ServiceException();
		}
		try {
			membre.setNom(membre.getNom().toUpperCase());
			return membreDao.create(membre);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

	@Override
	public void update(Membre membre) throws ServiceException {
		if (membre.getNom().isEmpty() || membre.getPrenom().isEmpty()) {
			throw new ServiceException();
		}
		try {
			membreDao.update(membre);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

	@Override
	public void delete(int id) throws ServiceException {
		try {
			membreDao.delete(id);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException();

		}

	}

	@Override
	public int count() throws ServiceException {
		try {
			return membreDao.count();
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException();

		}

	}
}