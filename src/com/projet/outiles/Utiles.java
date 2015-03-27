package com.projet.outiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;


public class Utiles {
	
	public static int deffinirIntervale(int intervaleTotale, int nbrDeDivision, int nombre){
		int j = 0;
		int inter = intervaleTotale*2/nbrDeDivision;
		for(int i = -intervaleTotale; i <= intervaleTotale; i+= inter){
			if(nombre >= i && nombre <= i+inter){
				i = intervaleTotale;
			}else{
				i++;
				j++;
			}
		}
		return j;
	}

	
	public static int getMin(int num1, int num2){
		if(num1<num2){
			return num1;
		}else{
			return num2;
		}
	}
	
	public static String getFileName(String filePath) {
		String fileName = "";
		for (int i = filePath.length(); i > 0; i--) {

			if (filePath.charAt(i - 1) == '\\') {
				System.out.println("oui");
				i = 0;
			}
			if (i != 0) {
				fileName = filePath.charAt(i - 1) + fileName;
			}
		}
		System.out.println(fileName);
		return fileName;
	}
	
	public static void listerRepertoire(File repertoire) {

		String[] listefichiers;

		int i;
		listefichiers = repertoire.list();
		for (i = 0; i < listefichiers.length; i++) {
			if (listefichiers[i].endsWith(".jpg") == true) {
				System.out.println(listefichiers[i].substring(0,listefichiers[i].length() - 4));
			}
		}
	}
	
	/** copie le fichier source dans le fichier resultat
	 * retourne vrai si cela réussit
	 */
	public static boolean copyFile(String sourcePath, String destPath){

		FileChannel in = null; // canal d'entrée
		FileChannel out = null; // canal de sortie
		 
		try {
		  // Init
		  in = new FileInputStream(sourcePath).getChannel();
		  out = new FileOutputStream(destPath).getChannel();
		 
		  // Copie depuis le in vers le out
		  
		  in.transferTo(0, in.size(), out);
		} catch (Exception e) {
		  e.printStackTrace(); // n'importe quelle exception
		} finally { // finalement on ferme
		  if(in != null) {
		  	try {
			  in.close();
			} catch (IOException e) {}
		  }
		  if(out != null) {
		  	try {
			  out.close();
			} catch (IOException e) {
				return false;
			}
		  }
		}
		return true;
	}
}
