package com.projet.image;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Surface extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BufferedImage image;	
	
	public Surface(BufferedImage image){
		this.image = image;
	}

	private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
       
        g2d.drawString("Java 2D", 50, 50);
        g2d.drawImage(image, 1, 1, null);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

public class ImageWindows extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int[] tabR = new int[256] ;
	int[] tabG = new int[256] ;
	int[] tabB = new int[256] ;
	
	int[] HisCumuler = new int[256] ;
	
	public ImageWindows(String pathImage) {
		BufferedImage image = null;
		try {
		 image = ImageIO.read(new File(pathImage));
		} 
		catch (IOException e) {
		 e.printStackTrace();
		}

		
		remplirTableRGB(image);
		calculeHistogrammeCumuler();
		affiche();
		
		/*
		 * Calcule des valuers: rg, by et wb
		 * on utilise la longeure du tableau R (tout les tableau ont la même longeure
		 */
		int rg, by,wb;
		for(int i=0; i<tabR.length ;i++){
			
		}
		

		
	     
		initUI(image);
	}

	/**
	 * Récupérer les valeurs rgb de chaque pixele de l'image
	 * stocker les valeurs dans 3 tableaux differants
	 * @param image
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

				tabR[r]++;
				tabG[g]++;
				tabG[b]++;
			}
		}
	}
	
	/**
	 * Calcule de l'histogramme cumuler
	 */
	public void calculeHistogrammeCumuler(){
		//rermplissage de l'histogramme cumuler
		//valeur i des trois tableau stocker dans le 4eme
		for(int i=0; i<tabR.length ;i++){
			HisCumuler[i] = tabR[i] + tabG[i] + tabB[i];
		}
	}
	
	public void affiche(){
		for(int i=0; i<tabR.length ; i++){
			System.out.print("R: "+i+" :"+tabR[i]);
			System.out.print("   G:"+i+" :"+tabG[i]);
			System.out.print("   B "+i+" :"+tabB[i]);
			System.out.println("       Cumulée: "+HisCumuler[i]);
		}
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
