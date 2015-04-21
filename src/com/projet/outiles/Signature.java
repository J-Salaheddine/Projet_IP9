package com.projet.outiles;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Signature {


	private int[] tabRg = new int[StaticValues.NOMBRE_DE_DIVISION_RG] ;
	private int[] tabBy = new int[StaticValues.NOMBRE_DE_DIVISION_BY] ;
	private int[] tabWb = new int[StaticValues.NOMBRE_DE_DIVISION_WB] ;
	
//	private String tabRgString;
//	private String tabByString;
//	private String tabWbString;
	
	private BufferedImage image = null;
	private int rg, by, wb;
	
	private String fileName;
	private String pathImage;
	
	public Signature(File imageFile){
		try {
			image = ImageIO.read(imageFile);
		} catch (IOException e) {
			System.out.println("Fichier introuvable!!");
			e.printStackTrace();
		}
		remplirTableRGB(image);
	}
	
	public Signature(String pathImage) {
		this.pathImage = pathImage;
		try {
			image = ImageIO.read(new File(pathImage));
			fileName = Utiles.enleverCheminDuFichier(pathImage);
		} catch (IOException e) {
			System.out.println("Fichier introuvable!!");
			e.printStackTrace();
		}
		remplirTableRGB(image);
		//affiche();
	}
	
//	public Signature(String rg, String by, String wb){
//		tabRgString = Utiles.getSignatureFromeStringTab(rg);
//		tabByString = Utiles.getSignatureFromeStringTab(by);
//		tabWbString = Utiles.getSignatureFromeStringTab(wb);
//		lireLineRG(tabRgString);
//		lireLineBy(tabByString);
//		lireLineWb(tabWbString);
//	}

	public Signature(int[] tabRg, int[] tabBy, int[] tabWb) {
		super();
		this.tabRg = tabRg;
		this.tabBy = tabBy;
		this.tabWb = tabWb;
	}

	/**
	 * Récupérer les valeurs rgb de chaque pixele de l'image
	 * stocker les valeurs dans 3 tableaux differants
	 * @param image
	 * @throws Exception 
	 */
	public void remplirTableRGB(BufferedImage image) {
		int w = image.getWidth();
		int h = image.getHeight();
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				/* Accéder au rgb pixel (i, j) */
				int rgb = image.getRGB(i, j);
				int r = (rgb >> 16) & 0xff;
				int g = (rgb >> 8) & 0xff;
				int b = rgb & 0xff;

				calculerValeur(r, g, b);
				tabRg[Utiles.deffinirIntervale(StaticValues.INTERVALE_RG, StaticValues.NOMBRE_DE_DIVISION_RG, rg)]++;
				tabBy[Utiles.deffinirIntervale(StaticValues.INTERVALE_BY, StaticValues.NOMBRE_DE_DIVISION_BY,by)]++;
				tabWb[Utiles.deffinirIntervale(StaticValues.INTERVALE_WB, StaticValues.NOMBRE_DE_DIVISION_WB,wb)]++;
			}
		}
	}
	
	public void affiche(){
		for(int i=0; i<tabRg.length ; i++){
			System.out.println("valeur numero "+i+" : "+tabRg[i]);
		}
		System.out.println("******************************");
		for(int i=0; i<tabBy.length ; i++){
			System.out.println("valeur numero "+i+" : "+tabBy[i]);
		}
		System.out.println("******************************");
		for(int i=0; i<tabWb.length ; i++){
			System.out.println("valeur numero "+i+" : "+tabWb[i]);
		}
	}
	
	
	/**
	 * calcule des valeur de rg by et wb avec les formules suivantes;
	 * rg = r - g;
	 * by = 2*b-r-g;
	 * wb = r + g + b;
	 * @param r
	 * @param g
	 * @param b
	 */
	private void calculerValeur(int r, int g, int b){
		rg = r - g;
		by = 2*b-r-g;
		wb = r + g + b;
	}

//	private void lireLineRG(String line) {
//		String numText = "";
//		int compteur = 0;
//		for (int i = 0; i < line.length(); i++) {
//			if (line.charAt(i) == ' ' && compteur != tabRg.length) {
//				tabRg[compteur] = (Integer.parseInt(numText));
//				compteur++;
//				numText = "";
//			} else {
//				numText += line.charAt(i);
//			}
//		}
//	}
//
//	private void lireLineBy(String line) {
//		String numText = "";
//		int compteur = 0;
//		for (int i = 0; i < line.length(); i++) {
//			if (line.charAt(i) == ' ' && compteur != tabBy.length) {
//				tabBy[compteur] = (Integer.parseInt(numText));
//				compteur++;
//				numText = "";
//			} else {
//				numText += line.charAt(i);
//			}
//		}
//	}
//
//	private void lireLineWb(String line) {
//		String numText = "";
//		int compteur = 0;
//		for (int i = 0; i < line.length(); i++) {
//			if (line.charAt(i) == ' ' && compteur != tabWb.length) {
//				tabWb[compteur] = (Integer.parseInt(numText));
//				compteur++;
//				numText = "";
//			} else {
//				numText += line.charAt(i);
//			}
//		}
//	}

	public int getTabRgElement(int elementNumero) {
		return tabRg[elementNumero];
	}
	public int getTabByElement(int elementNumero) {
		return tabBy[elementNumero];
	}
	public int getTabWbElement(int elementNumero) {
		return tabWb[elementNumero];
	}
	
//	public String getTabRgString() {
//		return tabRgString;
//	}
//
//	public String getTabByString() {
//		return tabByString;
//	}
//
//	public String getTabWbString() {
//		return tabWbString;
//	}

	public String getFileName() {
		return fileName.substring(0,fileName.length() - 4);
	}
	
	public String getPath(){
		return this.pathImage;
	}
	
	public String getExtention(){
		String ext = getPath().substring(getPath().lastIndexOf("."));
		return ext;
	}

	public int[] getTabRg() {
		return tabRg;
	}

	public int[] getTabBy() {
		return tabBy;
	}

	public int[] getTabWb() {
		return tabWb;
	}
	
	
	
}
