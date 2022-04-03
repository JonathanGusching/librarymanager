package com.ensta.librarymanager.model;

public class Membre {
	private int id;
	private String nom;
	private String prenom;
	private String adresse;
	private String email;
	private String telephone;
	private Abonnement abonnement;
	
	@Override
	public String toString() {
		return "Membre [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", email=" + email
				+ ", telephone=" + telephone + ", abonnement=" + abonnement + "]";
	}
	
	public Membre(int id, String nom, String prenom, String adresse, String email, String telephone,
			Abonnement abonnement) {
		super();
		this.id = id;
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setAdresse(adresse);
		this.setEmail(email);
		this.setTelephone(telephone);
		this.setAbonnement(abonnement);
	}
	
	public Membre(String nom, String prenom, String adresse, String email, String telephone,
			Abonnement abonnement) {
		super();
		this.id = -1; // Par défaut
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setAdresse(adresse);
		this.setEmail(email);
		this.setTelephone(telephone);
		this.setAbonnement(abonnement);
	}
	
	public Membre(String nom, String prenom, String adresse, String email, String telephone) {
		super();
		this.id = -1; // Par défaut
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setAdresse(adresse);
		this.setEmail(email);
		this.setTelephone(telephone);
		this.setAbonnement(Abonnement.BASIC);
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id= id ;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Abonnement getAbonnement() {
		return abonnement;
	}
	public void setAbonnement(Abonnement abonnement) {
		this.abonnement = abonnement;
	}
	
	
}
