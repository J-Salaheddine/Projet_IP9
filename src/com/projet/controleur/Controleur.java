package com.projet.controleur;

import com.projet.model.ChargerImage;
import com.projet.model.ChargerRepertoire;
import com.projet.outiles.ObjetImage;

public class Controleur {

	public Controleur(){
		super();
	}
	
	public void chargerImage(String imagePath){
		ObjetImage objetImage = new ObjetImage(imagePath);
		ChargerImage ci = new ChargerImage(objetImage);
	}
	
	public void chargerRepertoire(String repertoirePath){
		ChargerRepertoire cr = new ChargerRepertoire(repertoirePath);
	}
}
