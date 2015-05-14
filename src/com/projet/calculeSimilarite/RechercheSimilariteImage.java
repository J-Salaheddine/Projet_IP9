package com.projet.calculeSimilarite;

import java.io.File;
import java.io.IOException;

import com.projet.gestionnaireDossier.ReadSignature;
import com.projet.outils.Signature;
import com.projet.outils.StaticValues;
import com.projet.outils.Utiles;

public class RechercheSimilariteImage {
	private Signature objetImage;
	private float tauxDeSimilarite;
	
	/**
	 * Cette fonction permet de trouver les similarité d'une image importer 
	 * les résulta sont les images qui on un taux de similarité supérieure ou egale au taux indiqué
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
	 * Cette fonction permet de comparer une siganture avec la base de donnée (txt)
	 */
	public void listerRepertoire() {
		File repertoire = new File(StaticValues.BDD_SIGANTURE);
		String[] listefichiers;
		int i;
		listefichiers = repertoire.list();
		for (i = 0; i < listefichiers.length; i++) {
			if (listefichiers[i].endsWith(".txt") == true) {
				ReadSignature lectureSignature = new ReadSignature(StaticValues.BDD_SIGANTURE+listefichiers[i]);
				CalculeSimilariteSig calculSimilariteObd = new CalculeSimilariteSig(objetImage, lectureSignature);
				//CalculSimilariteObd calculSimilariteObd = new CalculSimilariteObd(objetImage, lectureSignature);
				if(calculSimilariteObd.getTauxSimlarite() >= this.tauxDeSimilarite){
					Float taux = calculSimilariteObd.getTauxSimlarite();
					System.out.println(listefichiers[i]+" avec un taux de similarité de: "+taux);
					//System.out.println(StaticValues.BDD_IMAGES+Utiles.enleverExtension(listefichiers[i])+".jpg");
					File sourceFile = new File(StaticValues.BDD_IMAGES+Utiles.enleverExtension(listefichiers[i])+".jpg");
					File sourceDest = new File(StaticValues.BDD_RES+taux+"__"+Utiles.enleverExtension(listefichiers[i])+".jpg");
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
	
	/**
	 * Cette fonction permet de comparer une siganture avec la base de donnée (txt)
	 */
	public void listerRepertoireDI() {
		File repertoire = new File(StaticValues.BDD_SIGANTURE);
		String[] listefichiers;
		int i;
		listefichiers = repertoire.list();
		for (i = 0; i < listefichiers.length; i++) {
			if (listefichiers[i].endsWith(".txt") == true) {
				ReadSignature lectureSignature = new ReadSignature(StaticValues.BDD_SIGANTURE+listefichiers[i]);
				CalculeDistanceIntersection calculSimilariteObd = new CalculeDistanceIntersection(objetImage, lectureSignature);
				//CalculeDistanceIntersectionImgbd calculSimilariteObd = new CalculeDistanceIntersectionImgbd(objetImage, lectureSignature);
				Float taux = calculSimilariteObd.getTauxSimilarite();
				if(taux >= this.tauxDeSimilarite){
					
					System.out.println(listefichiers[i]+" avec un taux de similarité de: "+taux);
					//System.out.println(StaticValues.BDD_IMAGES+Utiles.enleverExtension(listefichiers[i])+".jpg");
					File sourceFile = new File(StaticValues.BDD_IMAGES+Utiles.enleverExtension(listefichiers[i])+".jpg");
					File sourceDest = new File(StaticValues.BDD_RES+taux+"__"+Utiles.enleverExtension(listefichiers[i])+".jpg");
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