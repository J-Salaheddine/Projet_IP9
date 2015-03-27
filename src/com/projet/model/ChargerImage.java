package com.projet.model;

import com.projet.outiles.GestionnaireSignature;
import com.projet.outiles.ObjetImage;
import com.projet.outiles.StaticValues;
import com.projet.outiles.Utiles;

public class ChargerImage {

	
	public ChargerImage(ObjetImage objetImage){
		super();
		chargerImageBD(objetImage);
	}
	
	public void chargerImageBD(ObjetImage objetImage) {
		
		String cheminDuDossier = objetImage.getPath();
		
		if (cheminDuDossier.endsWith(".jpg") == true) {
			if (Utiles.copyFile(cheminDuDossier,StaticValues.BDD_IMAGES+objetImage.getFileName()+objetImage.getExtention())) {
				
				ObjetImage oi = new ObjetImage(cheminDuDossier);
				GestionnaireSignature gs = new GestionnaireSignature(oi);
			}
		}
	}
	

}
