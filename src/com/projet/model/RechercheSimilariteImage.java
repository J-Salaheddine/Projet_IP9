package com.projet.model;

import java.io.File;

import com.projet.gestionnaireDossier.LectureSignature;
import com.projet.outiles.Signature;
import com.projet.outiles.StaticValues;

public class RechercheSimilariteImage {
	private Signature objetImage;
	private float tauxDeSimilarite;
	public RechercheSimilariteImage(Signature objetImage,float tauxDeSimilarite){
		super();
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
					
				}
			}
		}

}
}