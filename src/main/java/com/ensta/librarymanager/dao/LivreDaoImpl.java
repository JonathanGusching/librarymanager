package com.ensta.librarymanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ensta.librarymanager.exception.DaoException;
import com.ensta.librarymanager.model.Livre;
import com.ensta.librarymanager.persistence.ConnectionManager;

public class LivreDaoImpl implements ILivreDao {
	private static LivreDaoImpl instance;

	private LivreDaoImpl() {
	}

	public static LivreDaoImpl getInstance() {
		if (instance == null) {
			instance = new LivreDaoImpl();
		}
		return instance;
	}

	@Override
	public List<Livre> getList() throws DaoException {
		try {
			List<Livre> list = new ArrayList<Livre>();
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement pstmt = connection
					.prepareStatement("SELECT id, titre, auteur, ISBN FROM livre ORDER BY id");

			ResultSet rs = pstmt.executeQuery();
			do {
				rs.next();

				int id = rs.getInt("id");
				String titre = rs.getString("titre");
				String auteur = rs.getString("auteur");
				String isbn = rs.getString("ISBN");
				list.add(new Livre(id, titre, auteur, isbn));
			} while (!rs.isLast());

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException();
		}
	}

	@Override
	public Livre getById(int id) throws DaoException {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement pstmt = connection.prepareStatement("SELECT titre, auteur, ISBN FROM livre WHERE id=?");

			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();

			String titre = rs.getString("titre");
			String auteur = rs.getString("auteur");
			String isbn = rs.getString("ISBN");

			return new Livre(id, titre, auteur, isbn);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException();
		}
	}

	@Override
	public int create(Livre livre) throws DaoException {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(
					"INSERT INTO livre(titre, auteur, isbn) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, livre.getTitre());
			pstmt.setString(2, livre.getAuteur());
			pstmt.setString(3, livre.getIsbn());

			pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();

			if (rs.next()) {
				int id = rs.getInt(1);
				livre.setId(id);

				return id;
			} else {
				throw new DaoException();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException();
		}
	}

	@Override
	public void update(Livre livre) throws DaoException {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(
					"UPDATE livre SET titre = ?, auteur = ?, isbn = ? WHERE id = ?", Statement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, livre.getTitre());
			pstmt.setString(2, livre.getAuteur());
			pstmt.setString(3, livre.getIsbn());
			pstmt.setInt(4, livre.getId());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException();
		}

	}

	@Override
	public void delete(int id) throws DaoException {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement pstmt = connection.prepareStatement("DELETE FROM livre WHERE id = ?");

			pstmt.setInt(1, id);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException();
		}
	}

	@Override
	public int count() throws DaoException {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement pstmt = connection.prepareStatement("SELECT COUNT(id) AS count FROM livre");
			ResultSet rs = pstmt.executeQuery();

			rs.next();

			return rs.getInt("count");

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException();
		}
	}

}
