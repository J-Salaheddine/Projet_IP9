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

	private String pathImage;
	
	public ImageWindows(String pathImage) {
		BufferedImage image = null;
		try {
		 image = ImageIO.read(new File(pathImage));
		} 
		catch (IOException e) {
		 e.printStackTrace();
		}
		int[] tabR = new int[256] ;
		int[] tabG = new int[256] ;
		int[] tabB = new int[256] ;
		
		int w = image.getWidth();
		int h = image.getHeight();
		for(int i=0; i<w; i++){
		 for(int j=0; j<h; j++){
		  /* Accéder au rgb pixel (i, j) */
		  int rgb = image.getRGB(i,j);
		    int r = (rgb >> 16) & 0xff;
		    int g = (rgb >> 8) & 0xff;
		    int b = rgb & 0xff;

		    tabR[r]++;
		    tabG[g]++;
		    tabG[b]++;
		 }
		}
		
		for(int i=0; i<tabR.length ; i++){
			System.out.println("Nombre de pixel "+i+" :"+tabG[i]);
		}
		
	    // Transformer le tableau en liste
	    List listeR = Arrays.asList(tabR);
	    List listeG = Arrays.asList(tabG);
	    List listeB = Arrays.asList(tabB);
	 
	    // Utiliser la liste comme le paramètre du vecteur
	    Vector vecR = new Vector(listeR);   // La conversion se fait ici
	    Vector vecG = new Vector(listeG);   // La conversion se fait ici
	    Vector vecB = new Vector(listeB);   // La conversion se fait ici
	 
	    // Afficher maintenant le vecteur
	    for(int i=0; i<vecR.size();i++){
	    	System.out.println(vecR.get(i));
	    }
		
		    
		    
		initUI(image);
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
