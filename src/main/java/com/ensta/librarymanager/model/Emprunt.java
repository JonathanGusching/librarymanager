package com.ensta.librarymanager.model;

import java.time.LocalDate;

public class Emprunt {
	private int id;
	private LocalDate dateEmprunt;
	private LocalDate dateRetour;
	private Livre livre;
	private Membre membre;

	@Override
	public String toString() {
		return "Emprunt [id=" + id + ", dateEmprunt=" + dateEmprunt + ", dateRetour=" + dateRetour + ", livre=" + livre
				+ ", membre=" + membre + "]";
	}

	public Emprunt(int id, LocalDate dateEmprunt, LocalDate dateRetour, Livre livre, Membre membre) {
		this.id = id;
		this.dateEmprunt = dateEmprunt;
		this.dateRetour = dateRetour;
		this.setLivre(livre);
		this.setMembre(membre);
	}

	public Emprunt(Emprunt toCopy) {
		id = toCopy.getId();
		dateEmprunt = toCopy.getDateEmprunt();
		dateRetour = toCopy.getDateRetour();
		livre = toCopy.getLivre();
		membre = toCopy.getMembre();
	}

	public LocalDate getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(LocalDate dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public LocalDate getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(LocalDate dateRetour) {
		this.dateRetour = dateRetour;
	}

	public int getId() {
		return id;
	}

	public Membre getMembre() {
		return membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

}
