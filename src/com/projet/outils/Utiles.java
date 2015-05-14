package com.projet.outils;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;


public class Utiles {
	
	public static BufferedImage copyImage(BufferedImage source){
	    BufferedImage b = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
	    Graphics g = b.getGraphics();
	    g.drawImage(source, 0, 0, null);
	    g.dispose();
	    return b;
	}
	
	/**
	 * Cette fonction permet de vider un dossier
	 * @param path
	 */
	public static void emptyDirectory(String path){
		File folder = new File(path);
		   for(File file : folder.listFiles()){
		       file.delete();
		   }
	}
	
	/**
	 * Cette fonction permet d'obtenir le nom du fichier
	 * @param path
	 * @return
	 */
	public static String getFileName(String path){
		String fileName = "";
		fileName = enleverExtension(path);
		fileName = enleverCheminDuFichier(fileName);
		return fileName;
	}
	
	/**
	 * Cette fonction permet d'nelever l'extension enleverExtension 
	 * @param path
	 * @return
	 */
	public static String enleverExtension(String path) {
		String fileName = path.substring(0,path.length() - 4);
		return fileName;
	}
	
	/**
	 * Cette fcontion permet de récupérer le nom complet du fichier avec l'extansion
	 * @param filePath
	 * @return
	 */
	public static String enleverCheminDuFichier(String filePath) {
		String fileName = "";
		for (int i = filePath.length(); i > 0; i--) {
			if (filePath.charAt(i - 1) == '\\') {
				i = 0;
			}
			if (i != 0) {
				fileName = filePath.charAt(i - 1) + fileName;
			}
		}
		return fileName;
	}
	
//	/**
//	 * Cette fonction permet de récupérer le  string de la signature a partir d'un string récupérer de la base de donnée
//	 * [12,56,98,52,5] ------> 12 56 98 52 5
//	 * @param s
//	 * @return
//	 */
//	public static String getSignatureFromeStringTab(String s){
//		String sig = "";
//		for(int i=0; i< s.length(); i++){
//			if(s.charAt(i) == ','){
//				sig+=" ";
//			}
//			else if(s.charAt(i) == '[' ){
//				
//			}else if(s.charAt(i) == ']'){
//				i=s.length();
//			}else{
//				sig+=s.charAt(i);
//			}
//		}
//		return sig;
//	}
	
	/**
	 * Cette fonction permet de définir l'intervale dans le quelle se situe la valeur de pixel analysé
	 * @param intervaleTotale
	 * @param nbrDeDivision
	 * @param nombre
	 * @return
	 */
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
	
	public static int deffinirIntervaleBW(int intervaleTotale, int nbrDeDivision, int nombre){
		int j = 0;
		int inter = intervaleTotale*2/nbrDeDivision;
		for(int i = 0; i <= intervaleTotale; i+= inter){
			if(nombre >= i && nombre <= i+inter){
				i = intervaleTotale;
			}else{
				i++;
				j++;
			}
		}
		return j;
	}

	/**
	 * Récupérer le min de deux valeurs
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static int getMin(int num1, int num2){
		if(num1<num2){
			return num1;
		}else{
			return num2;
		}
	}
	
	/**
	 * Récupérer le min de deux valeurs
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static int getMax(int num1, int num2){
		if(num1>num2){
			return num1;
		}else{
			return num2;
		}
	}
	
	/**
	 * Récupérer le min de deux valeurs
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static float getMinf(float num1, float num2){
		if(num1<num2){
			return num1;
		}else{
			return num2;
		}
	}
	
	/**
	 * Récupérer le min de deux valeurs
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static float getMaxf(float num1, float num2){
		if(num1>num2){
			return num1;
		}else{
			return num2;
		}
	}

	/**
	 * Cette fonction permet de récupérer fichier par fichier les elements contenus dans un dossier
	 * @param repertoire
	 */
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
	public static boolean copyFile(String sourcePath, String destPath) {
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
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					return false;
				}
			}
		}
		return true;
	}
	
	    public static void copyFile(File sourceFile, File destFile)
	            throws IOException {
	        if (!destFile.exists()) {
	            destFile.createNewFile();
	        }

	        FileChannel source = null;
	        FileChannel destination = null;
	        try {
	            source = new FileInputStream(sourceFile).getChannel();
	            destination = new FileOutputStream(destFile).getChannel();

	           destination.transferFrom(source, 0, source.size());
	          
	        } finally {
	            if (source != null) {
	                source.close();
	            }
	            if (destination != null) {
	                destination.close();
	            }
	        }
	    }
	    
	    public static float[] normaliserVecteur(int[] v) {
	    	float[] vResult = new float[v.length];
			for (int i = 0; i < v.length; i++){
				vResult[i] = v[i] / LongeurVecteur(v);
			}
			return vResult; 
		}

		private static float LongeurVecteur(int[] v) {
			float somme = 0;
			for (int i = 0; i < v.length; i++)
			{
				somme += Math.pow( v[i],2);
			}
			return (float) Math.sqrt(somme);
		}


	
}
