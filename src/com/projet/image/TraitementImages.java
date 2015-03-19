package com.projet.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TraitementImages {

	
	public TraitementImages(){
		/* Chemin vers l'image à charger */
		String pathImage = "C:\\image.jpg";

		BufferedImage image;
		try {
		 image = ImageIO.read(new File(pathImage));
		} 
		catch (IOException e) {
		 e.printStackTrace();
		}
	}
	

	
}
