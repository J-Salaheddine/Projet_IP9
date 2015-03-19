package com.projet.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class ImageWindows2 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int[] tabRg = new int[8] ;
	int[] tabBy = new int[16] ;
	int[] tabWb = new int[16] ;
	private BufferedImage image = null;
	int rg, by, wb;
	
	
	public ImageWindows2(String pathImage) {
		try {
			image = ImageIO.read(new File(pathImage));
		} catch (IOException e) {
			System.out.println("Fichier introuvable!!");
			e.printStackTrace();
		}
		remplirTableRGB(image);
		initUI(image);
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
				tabRg[Utiles.deffinirIntervalRG(rg)]++;
			}
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

	private void initUI(BufferedImage image) {
		setTitle("Images view");
		Surface surface = new Surface(image);
		add(surface);
		setSize(image.getHeight(), image.getWidth());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
}
