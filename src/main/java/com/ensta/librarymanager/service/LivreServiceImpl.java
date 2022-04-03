package com.ensta.librarymanager.service;

import java.util.ArrayList;
import java.util.List;

import com.ensta.librarymanager.dao.LivreDaoImpl;
import com.ensta.librarymanager.exception.DaoException;
import com.ensta.librarymanager.exception.ServiceException;
import com.ensta.librarymanager.model.Livre;

public class LivreServiceImpl implements ILivreService {
	private static LivreServiceImpl instance;

	private LivreServiceImpl() {
	}

	public static LivreServiceImpl getInstance() {
		if (instance == null) {
			instance = new LivreServiceImpl();
		}
		return instance;
	}

	LivreDaoImpl livreDao = LivreDaoImpl.getInstance();
	EmpruntServiceImpl empruntService = EmpruntServiceImpl.getInstance();

	@Override
	public List<Livre> getList() throws ServiceException {
		try {
			List<Livre> list = livreDao.getList();
			return list;
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

	@Override
	public List<Livre> getListDispo() throws ServiceException {
		List<Livre> list = getList();
		List<Livre> result = new ArrayList<Livre>();
		for (int i = 0; i < list.size(); i++) {
			if (empruntService.isLivreDispo(list.get(i).getId())) {
				result.add(list.get(i));
			}
		}
		return result;
	}

	@Override
	public Livre getById(int id) throws ServiceException {
		try {
			Livre livre = livreDao.getById(id);
			return livre;
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

	@Override
	public int create(Livre livre) throws ServiceException {
		if (livre.getTitre().isEmpty()) {
			throw new ServiceException();
		}
		try {
			return livreDao.create(livre);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

	@Override
	public void update(Livre livre) throws ServiceException {
		if (livre.getTitre().isEmpty()) {
			throw new ServiceException();
		}
		try {
			livreDao.update(livre);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

	@Override
	public void delete(int id) throws ServiceException {
		try {
			livreDao.delete(id);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

	@Override
	public int count() throws ServiceException {
		try {
			return livreDao.count();
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}

}
