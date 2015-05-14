package com.projet.model;

import com.projet.gestionnaireDossier.WriteSignature;
import com.projet.outils.Signature;
import com.projet.outils.StaticValues;
import com.projet.outils.Utiles;

public class ChargerImage {

	/**
	 * Cette classe permet d'ajouter une image dans la base de donnée
	 * @param objetImage
	 */
	public ChargerImage(Signature objetImage){
		super();
		chargerImageBD(objetImage);
	}
	
	public void chargerImageBD(Signature objetImage) {
		String cheminDuDossier = objetImage.getPath();
		if (cheminDuDossier.endsWith(".jpg") == true  || cheminDuDossier.endsWith(".png") == true) {
			if (Utiles.copyFile(cheminDuDossier,StaticValues.BDD_IMAGES+objetImage.getFileName()+objetImage.getExtention())) {
				Signature oi = new Signature(cheminDuDossier);
				new WriteSignature(oi);
			}
		}
	}
	
	
	

}
