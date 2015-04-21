package com.projet.model;

import com.projet.gestionnaireDossier.GestionnaireSignature;
import com.projet.outiles.Signature;
import com.projet.outiles.StaticValues;
import com.projet.outiles.Utiles;

public class ChargerImage {

	
	public ChargerImage(Signature objetImage){
		super();
		chargerImageBD(objetImage);
	}
	
	public void chargerImageBD(Signature objetImage) {
		
		String cheminDuDossier = objetImage.getPath();
		if (cheminDuDossier.endsWith(".jpg") == true  || cheminDuDossier.endsWith(".png") == true) {
			if (Utiles.copyFile(cheminDuDossier,StaticValues.BDD_IMAGES+objetImage.getFileName()+objetImage.getExtention())) {
				Signature oi = new Signature(cheminDuDossier);
				GestionnaireSignature gs = new GestionnaireSignature(oi);
			}
		}
	}
	
	
	

}
