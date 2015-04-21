package com.projet.model;

import java.io.File;

import com.projet.outiles.Signature;

public class ChargerRepertoire {

	
	public ChargerRepertoire(String cheminDuDossier){
		super();
		listerRepertoire(cheminDuDossier);
	}
	
	public void listerRepertoire(String cheminDuDossier) {
		File repertoire = new File(cheminDuDossier);
		String[] listefichiers;

		int i;
		listefichiers = repertoire.list();
		for (i = 0; i < listefichiers.length; i++) {
			if (listefichiers[i].endsWith(".jpg") == true) {
				Signature objetImage = new Signature(cheminDuDossier+"\\"+listefichiers[i]);
				ChargerImage ci = new ChargerImage(objetImage);
			}
		}
	}
}