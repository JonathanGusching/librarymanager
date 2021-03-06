package com.ensta.librarymanager.model;

public class Livre {
	private int id;
	private String titre;
	private String auteur;
	private String isbn;

	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", auteur=" + auteur + ", isbn=" + isbn + "]";
	}

	public Livre(int id, String titre, String auteur, String isbn) {
		super();
		this.setId(id);
		this.setTitre(titre);
		this.setAuteur(auteur);
		this.setIsbn(isbn);
	}

	public Livre(String titre, String auteur, String isbn) {
		super();
		this.setId(-1);
		this.setTitre(titre);
		this.setAuteur(auteur);
		this.setIsbn(isbn);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
}
