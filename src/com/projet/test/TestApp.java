package com.projet.test;

import com.projet.controleur.Controleur;

public class TestApp {

	Controleur controleur;
	
	public TestApp(){
		controleur = new Controleur();
	}
	
	public void chargerImage(String imagePath){
		controleur.chargerImage(imagePath);
		System.out.println("Chargement d'image terminé!");
	}
	
	public void chargerRepertoire(String repertoirePath){
		System.out.println("Chargement de répértoir en cours...");
		controleur.chargerRepertoire(repertoirePath);
		System.out.println("Chargement de repértoire terminé!!");
	}
	
	public void rechercheImageSimlaire(String imagePath, float taux){
		controleur.rechercheImageSimlaire(imagePath, taux);
	}
	
	public void rechercheImageSimlaire2(String imagePath, float taux){
		controleur.rechercheImageSimlaireDI(imagePath, taux);
	}
	

}
