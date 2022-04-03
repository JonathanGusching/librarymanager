package com.ensta.librarymanager.test;

import com.ensta.librarymanager.exception.ServiceException;
import com.ensta.librarymanager.model.Abonnement;
import com.ensta.librarymanager.model.Livre;
import com.ensta.librarymanager.model.Membre;
import com.ensta.librarymanager.service.EmpruntServiceImpl;
import com.ensta.librarymanager.service.LivreServiceImpl;
import com.ensta.librarymanager.service.MembreServiceImpl;

public class ModuleTest {
	public static void main(String args[]) {
		LivreServiceImpl livreService = LivreServiceImpl.getInstance();
		MembreServiceImpl membreService = MembreServiceImpl.getInstance();
		EmpruntServiceImpl empruntService = EmpruntServiceImpl.getInstance();

		try {
			// Quelques tests de manipulation des services (non exhaustifs)
			// Tests livre
			System.out.println(livreService.getById(1));
			System.out.println(livreService.getList());
			Livre lolita = new Livre("Lolita", "Vladimir NABOKOV", "999-1020304050");
			int id = livreService.create(lolita);
			lolita.setId(id);

			System.out.println(livreService.getById(id));
			// int id_fail=livreService.create("", "Quelqu'un", "000-0000000000");
			livreService.update(lolita);
			System.out.println(livreService.getById(id));
			System.out.println(livreService.count());
			for (int i = 11; i <= 30; i++) {
				livreService.delete(i);
			}
			System.out.println(livreService.getList() + "\n");

			// Tests membre
			System.out.println(membreService.getList());
			System.out.println(membreService.getById(1));
			System.out.println(membreService.count());
			Membre staline = new Membre("DUPONT", "Jean", "Paris", "petitponeyrose@gmail.com", "0302010604",
					Abonnement.BASIC);
			int idMembre = membreService.create(staline);
			staline.setId(idMembre);

			// Tests emprunts
			System.out.println(empruntService.getList());
			System.out.println(empruntService.getListCurrent());
			System.out.println(empruntService.getListCurrentByLivre(2));
			// System.out.println(empruntService.getListCurrentByMembre(1));
			System.out.println("Livres dispos: " + livreService.getListDispo());
			System.out.println(empruntService.getListCurrentByLivre(90));
			System.out.println(empruntService.getListCurrentByLivre(90).isEmpty());
			System.out.println(empruntService.isLivreDispo(90));
			System.out.println(empruntService.isLivreDispo(3));
			System.out.println(empruntService.isLivreDispo(2));

			System.out.println(livreService.getListDispo());

		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
