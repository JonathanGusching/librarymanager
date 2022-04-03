package com.ensta.librarymanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ensta.librarymanager.exception.DaoException;
import com.ensta.librarymanager.model.Abonnement;
import com.ensta.librarymanager.model.Membre;
import com.ensta.librarymanager.persistence.ConnectionManager;

public class MembreDaoImpl implements IMembreDao {
	private static MembreDaoImpl instance;

	private MembreDaoImpl() {
	}

	public static MembreDaoImpl getInstance() {
		if (instance == null) {
			instance = new MembreDaoImpl();
		}
		return instance;
	}

	@Override
	public List<Membre> getList() throws DaoException {
		try {
			List<Membre> list = new ArrayList<Membre>();
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement pstmt = connection
					.prepareStatement("SELECT id, nom, prenom, adresse, email, telephone, abonnement\n"
							+ "FROM membre\n" + "ORDER BY nom, prenom;");

			ResultSet rs = pstmt.executeQuery();
			do {
				rs.next();

				int id = rs.getInt("id");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String adresse = rs.getString("adresse");
				String email = rs.getString("email");
				String telephone = rs.getString("telephone");
				String abonnementType = rs.getString("abonnement");
				Abonnement abonnement = Abonnement.fromString(abonnementType);

				list.add(new Membre(id, nom, prenom, adresse, email, telephone, abonnement));
			} while (!rs.isLast());

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException();
		}
	}

	@Override
	public Membre getById(int id) throws DaoException {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(
					"SELECT id, nom, prenom, adresse, email, telephone, abonnement FROM membre WHERE id=?");

			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();
			rs.next();

			String nom = rs.getString("nom");
			String prenom = rs.getString("prenom");
			String adresse = rs.getString("adresse");
			String email = rs.getString("email");
			String telephone = rs.getString("telephone");
			String abonnementType = rs.getString("abonnement");
			Abonnement abonnement = Abonnement.fromString(abonnementType);

			return new Membre(id, nom, prenom, adresse, email, telephone, abonnement);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException();
		}
	}

	@Override
	public int create(Membre membre) throws DaoException {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(
					"INSERT INTO membre(nom, prenom, adresse, email, telephone, abonnement) VALUES (?, ?, ?, ?, ?, ?);",
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, membre.getNom());
			pstmt.setString(2, membre.getPrenom());
			pstmt.setString(3, membre.getAdresse());
			pstmt.setString(4, membre.getEmail());
			pstmt.setString(5, membre.getTelephone());
			pstmt.setString(6, membre.getAbonnement().getName());

			pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();

			if (rs.next()) {
				int id = rs.getInt(1);
				membre.setId(id);
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
	public void update(Membre membre) throws DaoException {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(
					"UPDATE membre SET nom = ?, prenom = ?, adresse = ?, email = ?, telephone = ?, abonnement = ? WHERE id = ?;",
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, membre.getNom());
			pstmt.setString(2, membre.getPrenom());
			pstmt.setString(3, membre.getAdresse());
			pstmt.setString(4, membre.getEmail());
			pstmt.setString(5, membre.getTelephone());
			pstmt.setString(6, membre.getAbonnement().getName());
			pstmt.setInt(7, membre.getId());

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
			PreparedStatement pstmt = connection.prepareStatement("DELETE FROM membre WHERE id = ?");

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
			PreparedStatement pstmt = connection.prepareStatement("SELECT COUNT(id) AS count FROM membre");
			ResultSet rs = pstmt.executeQuery();

			rs.next();

			return rs.getInt("count");

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException();
		}
	}

}
