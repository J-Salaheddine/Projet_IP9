package com.projet.controleur;

import java.io.File;

import com.projet.model.ChargerImage;
import com.projet.model.ChargerRepertoire;
import com.projet.model.RechercheSimilariteImage;
import com.projet.outiles.CalculeSimilariteSig;
import com.projet.outiles.Signature;
import com.projet.outiles.StaticValues;
import com.projet.outiles.Utiles;

public class Controleur {

	public Controleur(){
		super();
	}
	
	public void chargerImage(String imagePath){
		Signature objetImage = new Signature(imagePath);
		ChargerImage ci = new ChargerImage(objetImage);
	}
	
	public void chargerRepertoire(String repertoirePath){
		ChargerRepertoire cr = new ChargerRepertoire(repertoirePath);
	}
	
	public Signature calculerSignature(File imageFile){
		Signature sig = new Signature(imageFile);
		return sig;
	}
	
	public void rechercheImageSimlaire(String imagePath, float taux){
		Signature oi1 = new Signature(imagePath);
		RechercheSimilariteImage rechercheSimilariteImage = new RechercheSimilariteImage(oi1, taux);
		rechercheSimilariteImage.listerRepertoire();
	}
	
	/**
	 * Fonction permetant de calculer la similarité entre de signature
	 * @param sig1
	 * @param sig2
	 * @return
	 */
	public static float calculerDeSimilarite(Signature sig1, Signature sig2){
		CalculeSimilariteSig css = new CalculeSimilariteSig(sig1, sig2);
		return css.getTauxSimlarite();
	}
	
	
	/**
	 * Elle retourn un objet signature a partir d'un fichier image
	 * @param path
	 * @return
	 */
	public static Signature getSignature(String path){
		Signature signature = new Signature(path);
		return signature;
	}
	
	/**
	 * elle retourn une signature a partire de trois string récupérer depuis la BDD
	 * @param rg
	 * @param by
	 * @param wb
	 * @return
	 */
//	public static Signature getSignature(String rg, String by, String wb){
//		Signature signature = new Signature(rg, by, wb);
//		return signature;
//	}
//	
	public double calculerSimilarite(Signature sig1, Signature sig2){
		double tauxDeSmimilarite;
		CalculeSimilariteSig css = new CalculeSimilariteSig(sig1, sig2);
		tauxDeSmimilarite =(double) css.getTauxSimlarite();
		return tauxDeSmimilarite;
	}
	

	
}
