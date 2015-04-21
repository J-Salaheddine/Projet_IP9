package com.projet.model;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.projet.gestionnaireDossier.LectureSignature;
import com.projet.outiles.Signature;
import com.projet.outiles.StaticValues;
import com.projet.outiles.Utiles;

public class RechercheSimilariteImage {
	private Signature objetImage;
	private float tauxDeSimilarite;
	public RechercheSimilariteImage(Signature objetImage,float tauxDeSimilarite){
		super();
		reperdtoireRes();
		this.objetImage = objetImage;
		this.tauxDeSimilarite = tauxDeSimilarite;
	}
	
	
	public void listerRepertoire() {
		File repertoire = new File(StaticValues.BDD_SIGANTURE);
		String[] listefichiers;

		int i;
		listefichiers = repertoire.list();
		for (i = 0; i < listefichiers.length; i++) {
			if (listefichiers[i].endsWith(".txt") == true) {
				LectureSignature lectureSignature = new LectureSignature(StaticValues.BDD_SIGANTURE+listefichiers[i]);
				CalculSimilariteObd calculSimilariteObd = new CalculSimilariteObd(objetImage, lectureSignature);
				if(calculSimilariteObd.getTauxSimlarite() >= this.tauxDeSimilarite){
					System.out.println(listefichiers[i]+" avec un taux de similarité de: "+calculSimilariteObd.getTauxSimlarite());
					recupererFichierDeSignature(listefichiers[i]);
					
					}
				}
			}
		}

	public void reperdtoireRes(){
		Utiles.emptyDirectory(StaticValues.BDD_RES);
	
	}
	
	public void recupererFichierDeSignature(String nomSignature){
		String fichierSansEx = Utiles.enleverExtension(nomSignature);
		if(new File(StaticValues.BDD_IMAGES+fichierSansEx+".jpg").exists()){
			Utiles.copyFile(new File(StaticValues.BDD_IMAGES+fichierSansEx+".jpg"), StaticValues.BDD_RES);
			System.out.println("hha");
		}else if(new File(StaticValues.BDD_IMAGES+fichierSansEx+".png").exists()){
			Utiles.copyFile(new File(StaticValues.BDD_IMAGES+fichierSansEx+".png"), StaticValues.BDD_RES);
		}
	}

}