package com.projet.model;

import java.io.File;
import java.io.IOException;

import com.projet.gestionnaireDossier.LectureSignature;
import com.projet.outiles.Signature;
import com.projet.outiles.StaticValues;
import com.projet.outiles.Utiles;

public class RechercheSimilariteImage {
	private Signature objetImage;
	private float tauxDeSimilarite;
	
	/**
	 * Cette fonction permet de trouver les similarit� d'une image importer 
	 * les r�sulta sont les images qui on un taux de similarit� sup�rieure ou egale au taux indiqu�
	 * @param objetImage
	 * @param tauxDeSimilarite
	 */
	public RechercheSimilariteImage(Signature objetImage,float tauxDeSimilarite){
		super();
		Utiles.emptyDirectory(StaticValues.BDD_RES);
		this.objetImage = objetImage;
		this.tauxDeSimilarite = tauxDeSimilarite;
	}
	
	/**
	 * Cette fonction permet de comparer une siganture avec la base de donn�e (txt)
	 */
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
					Float taux = calculSimilariteObd.getTauxSimlarite();
					System.out.println(listefichiers[i]+" avec un taux de similarit� de: "+taux);
					//System.out.println(StaticValues.BDD_IMAGES+Utiles.enleverExtension(listefichiers[i])+".jpg");
					File sourceFile = new File(StaticValues.BDD_IMAGES+Utiles.enleverExtension(listefichiers[i])+".jpg");
					File sourceDest = new File(StaticValues.BDD_RES+Utiles.enleverExtension(listefichiers[i])+"__"+taux+".jpg");
					try {
						Utiles.copyFile(sourceFile, sourceDest);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		}
	}
	public void reperdtoireRes(String s,String s2){
		
		Utiles.copyFile(s, s2);
	}

	


}