package com.projet.outiles;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjetImage{
	

	private int[] tabRg = new int[StaticValues.NOMBRE_DE_DIVISION_RG] ;
	private int[] tabBy = new int[StaticValues.NOMBRE_DE_DIVISION_BY] ;
	private int[] tabWb = new int[StaticValues.NOMBRE_DE_DIVISION_WB] ;
	private BufferedImage image = null;
	private int rg, by, wb;
	
	private String fileName;
	private String pathImage;
	
	public ObjetImage(String pathImage) {
		this.pathImage = pathImage;
		try {
			image = ImageIO.read(new File(pathImage));
			fileName = Utiles.getFileName(pathImage);
		} catch (IOException e) {
			System.out.println("Fichier introuvable!!");
			e.printStackTrace();
		}
		remplirTableRGB(image);
		affiche();
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


	public int getTabRgElement(int elementNumero) {
		return tabRg[elementNumero];
	}
	public int getTabByElement(int elementNumero) {
		return tabBy[elementNumero];
	}
	public int getTabWbElement(int elementNumero) {
		return tabWb[elementNumero];
	}

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
	
	
	
}
