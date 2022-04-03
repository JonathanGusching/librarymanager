package com.ensta.librarymanager.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ensta.librarymanager.exception.DaoException;
import com.ensta.librarymanager.model.Abonnement;
import com.ensta.librarymanager.model.Emprunt;
import com.ensta.librarymanager.model.Livre;
import com.ensta.librarymanager.model.Membre;
import com.ensta.librarymanager.persistence.ConnectionManager;

public class EmpruntDaoImpl implements IEmpruntDao {
	private static EmpruntDaoImpl instance;

	private EmpruntDaoImpl() {
	}

	public static EmpruntDaoImpl getInstance() {
		if (instance == null) {
			instance = new EmpruntDaoImpl();
		}
		return instance;
	}

	@Override
	public List<Emprunt> getList() throws DaoException {
		try {
			List<Emprunt> list = new ArrayList<Emprunt>();
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement pstmt = connection
					.prepareStatement("SELECT e.id AS id, idMembre, nom, prenom, adresse, email,\n"
							+ "telephone, abonnement, idLivre, titre, auteur, isbn, dateEmprunt,\n" + "dateRetour\n"
							+ "FROM emprunt AS e\n" + "INNER JOIN membre ON membre.id = e.idMembre\n"
							+ "INNER JOIN livre ON livre.id = e.idLivre\n" + "ORDER BY dateRetour DESC;");

			ResultSet rs = pstmt.executeQuery();
			do {
				rs.next();

				int idLivre = rs.getInt("idLivre");
				int id = rs.getInt("id");
				int idMembre = rs.getInt("idMembre");
				String titre = rs.getString("titre");
				String auteur = rs.getString("auteur");
				String isbn = rs.getString("ISBN");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String adresse = rs.getString("adresse");
				LocalDate dateEmprunt = rs.getDate("dateEmprunt").toLocalDate();
				Date dateRetourGlobal = rs.getDate("dateRetour");
				LocalDate dateRetour = null;
				if (dateRetourGlobal != null)
					dateRetour = dateRetourGlobal.toLocalDate();
				String telephone = rs.getString("telephone");
				String email = rs.getString("email");
				String abonnementType = rs.getString("abonnement");
				Abonnement abonnement = Abonnement.fromString(abonnementType);

				Membre membre = new Membre(idMembre, nom, prenom, adresse, email, telephone, abonnement);
				Livre livre = new Livre(idLivre, titre, auteur, isbn);

				list.add(new Emprunt(id, dateEmprunt, dateRetour, livre, membre));
			} while (!rs.isLast());

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException();
		}
	}

	@Override
	public List<Emprunt> getListCurrent() throws DaoException {
		try {
			List<Emprunt> list = new ArrayList<Emprunt>();
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement pstmt = connection
					.prepareStatement("SELECT e.id AS id, idMembre, nom, prenom, adresse, email,\n"
							+ "telephone, abonnement, idLivre, titre, auteur, isbn, dateEmprunt,\n" + "dateRetour\n"
							+ "FROM emprunt AS e\n" + "INNER JOIN membre ON membre.id = e.idMembre\n"
							+ "INNER JOIN livre ON livre.id = e.idLivre\n" + "WHERE dateRetour IS NULL;");

			ResultSet rs = pstmt.executeQuery();
			do {
				rs.next();

				int idLivre = rs.getInt("idLivre");
				int id = rs.getInt("id");
				int idMembre = rs.getInt("idMembre");
				String titre = rs.getString("titre");
				String auteur = rs.getString("auteur");
				String isbn = rs.getString("ISBN");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String adresse = rs.getString("adresse");
				LocalDate dateEmprunt = rs.getDate("dateEmprunt").toLocalDate();
				Date dateRetourGlobal = rs.getDate("dateRetour");
				LocalDate dateRetour = null;
				if (dateRetourGlobal != null)
					dateRetour = dateRetourGlobal.toLocalDate();
				String telephone = rs.getString("telephone");
				String email = rs.getString("email");
				String abonnementType = rs.getString("abonnement");
				Abonnement abonnement = Abonnement.fromString(abonnementType);

				Membre membre = new Membre(idMembre, nom, prenom, adresse, email, telephone, abonnement);
				Livre livre = new Livre(idLivre, titre, auteur, isbn);

				list.add(new Emprunt(id, dateEmprunt, dateRetour, livre, membre));
			} while (!rs.isLast());

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException();
		}
	}

	@Override
	public List<Emprunt> getListCurrentByMembre(int idMembre) throws DaoException {
		try {
			List<Emprunt> list = new ArrayList<Emprunt>();
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement pstmt = connection
					.prepareStatement("SELECT e.id AS id, idMembre, nom, prenom, adresse, email,\n"
							+ "telephone, abonnement, idLivre, titre, auteur, isbn, dateEmprunt,\n" + "dateRetour\n"
							+ "FROM emprunt AS e\n" + "INNER JOIN membre ON membre.id = e.idMembre\n"
							+ "INNER JOIN livre ON livre.id = e.idLivre\n"
							+ "WHERE dateRetour IS NULL AND membre.id = ?;");

			pstmt.setInt(1, idMembre);
			ResultSet rs = pstmt.executeQuery();

			do {
				if (rs.next() == false)
					break;
				int idLivre = rs.getInt("idLivre");
				int id = rs.getInt("id");
				String titre = rs.getString("titre");
				String auteur = rs.getString("auteur");
				String isbn = rs.getString("ISBN");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String adresse = rs.getString("adresse");
				LocalDate dateEmprunt = rs.getDate("dateEmprunt").toLocalDate();
				Date dateRetourGlobal = rs.getDate("dateRetour");
				LocalDate dateRetour = null;
				if (dateRetourGlobal != null)
					dateRetour = dateRetourGlobal.toLocalDate();
				String telephone = rs.getString("telephone");
				String email = rs.getString("email");
				String abonnementType = rs.getString("abonnement");
				Abonnement abonnement = Abonnement.fromString(abonnementType);

				Membre membre = new Membre(idMembre, nom, prenom, adresse, email, telephone, abonnement);
				Livre livre = new Livre(idLivre, titre, auteur, isbn);

				list.add(new Emprunt(id, dateEmprunt, dateRetour, livre, membre));
			} while (!rs.isLast());

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException();
		}
	}

	@Override
	public List<Emprunt> getListCurrentByLivre(int idLivre) throws DaoException {
		try {
			List<Emprunt> list = new ArrayList<Emprunt>();
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement pstmt = connection
					.prepareStatement("SELECT e.id AS id, idMembre, nom, prenom, adresse, email,\n"
							+ "telephone, abonnement, idLivre, titre, auteur, isbn, dateEmprunt,\n" + "dateRetour\n"
							+ "FROM emprunt AS e\n" + "INNER JOIN membre ON membre.id = e.idMembre\n"
							+ "INNER JOIN livre ON livre.id = e.idLivre\n"
							+ "WHERE dateRetour IS NULL AND livre.id = ?;");

			pstmt.setInt(1, idLivre);
			ResultSet rs = pstmt.executeQuery();

			do {
				if (rs.next() == false) {
					break;
				}
				int id = rs.getInt("id");
				int idMembre = rs.getInt("idMembre");
				String titre = rs.getString("titre");
				String auteur = rs.getString("auteur");
				String isbn = rs.getString("ISBN");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String adresse = rs.getString("adresse");
				LocalDate dateEmprunt = rs.getDate("dateEmprunt").toLocalDate();
				LocalDate dateRetour = null;
				String telephone = rs.getString("telephone");
				String email = rs.getString("email");
				String abonnementType = rs.getString("abonnement");
				Abonnement abonnement = Abonnement.fromString(abonnementType);

				Membre membre = new Membre(idMembre, nom, prenom, adresse, email, telephone, abonnement);
				Livre livre = new Livre(idLivre, titre, auteur, isbn);

				list.add(new Emprunt(id, dateEmprunt, dateRetour, livre, membre));

			} while (!rs.isLast());

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException();
		}
	}

	@Override
	public Emprunt getById(int id) throws DaoException {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement pstmt;
			pstmt = connection.prepareStatement("SELECT e.id AS idEmprunt, idMembre, nom, prenom, adresse, email,\n"
					+ "telephone, abonnement, idLivre, titre, auteur, isbn, dateEmprunt,\n" + "dateRetour\n"
					+ "FROM emprunt AS e\n" + "INNER JOIN membre ON membre.id = e.idMembre\n"
					+ "INNER JOIN livre ON livre.id = e.idLivre\n" + "WHERE e.id = ?;");

			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();

			int idMembre = rs.getInt("idMembre");
			int idLivre = rs.getInt("idLivre");
			String titre = rs.getString("titre");
			String auteur = rs.getString("auteur");
			String isbn = rs.getString("ISBN");
			String nom = rs.getString("nom");
			String prenom = rs.getString("prenom");
			String adresse = rs.getString("adresse");
			LocalDate dateEmprunt = rs.getDate("dateEmprunt").toLocalDate();
			Date dateRetourGlobal = rs.getDate("dateRetour");
			LocalDate dateRetour = null;
			if (dateRetourGlobal != null)
				dateRetour = dateRetourGlobal.toLocalDate();
			String telephone = rs.getString("telephone");
			String email = rs.getString("email");
			String abonnementType = rs.getString("abonnement");
			Abonnement abonnement = Abonnement.fromString(abonnementType);

			Membre membre = new Membre(idMembre, nom, prenom, adresse, email, telephone, abonnement);
			Livre livre = new Livre(idLivre, titre, auteur, isbn);

			return new Emprunt(id, dateEmprunt, dateRetour, livre, membre);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void create(int idMembre, int idLivre, LocalDate dateEmprunt) throws DaoException {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(
					"INSERT INTO emprunt(idMembre, idLivre, dateEmprunt, dateRetour) VALUES (?, ?, ?, ?);",
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setInt(1, idMembre);
			pstmt.setInt(2, idLivre);
			pstmt.setDate(3, java.sql.Date.valueOf(dateEmprunt));
			pstmt.setDate(4, null);
			pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();

			if (!rs.next()) {
				throw new DaoException();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException();
		}

	}

	@Override
	public void update(Emprunt emprunt) throws DaoException {
		try {
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement pstmt = connection.prepareStatement("UPDATE emprunt\n"
					+ "SET idMembre = ?, idLivre = ?, dateEmprunt = ?, dateRetour = ?\n" + "WHERE id = ?;",
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setInt(1, emprunt.getMembre().getId());
			pstmt.setInt(2, emprunt.getLivre().getId());
			pstmt.setDate(3, java.sql.Date.valueOf(emprunt.getDateEmprunt()));
			pstmt.setDate(4, java.sql.Date.valueOf(emprunt.getDateRetour()));
			pstmt.setInt(5, emprunt.getId());

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
			PreparedStatement pstmt = connection.prepareStatement("SELECT COUNT(id) AS count FROM emprunt;");
			ResultSet rs = pstmt.executeQuery();

			rs.next();

			return rs.getInt("count");

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException();
		}
	}

}
