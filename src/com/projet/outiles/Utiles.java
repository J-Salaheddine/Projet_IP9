package com.projet.outiles;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;


public class Utiles {
	
	public static void emptyDirectory(String path){
		File folder = new File(path);
		   for(File file : folder.listFiles()){
//		      if(file.isDirectory()){
//		          emptyDirectory(file);
//		      }
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
	 * Cette fcontion permet de r�cup�rer le nom complet du fichier avec l'extansion
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
	
	/**
	 * Cette fonction permet de r�cup�rer le  string de la signature a partir d'un string r�cup�rer de la base de donn�e
	 * [12,56,98,52,5] ------> 12 56 98 52 5
	 * @param s
	 * @return
	 */
	public static String getSignatureFromeStringTab(String s){
		String sig = "";
		for(int i=0; i< s.length(); i++){
			if(s.charAt(i) == ','){
				sig+=" ";
			}
			else if(s.charAt(i) == '[' ){
				
			}else if(s.charAt(i) == ']'){
				i=s.length();
			}else{
				sig+=s.charAt(i);
			}
		}
		return sig;
	}
	
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
	 * retourne vrai si cela r�ussit
	 */
	public static boolean copyFile(String sourcePath, String destPath){

		FileChannel in = null; // canal d'entr�e
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
	
	
	public static void copier(String cheminDuFichier, String cheminDes){
		FileInputStream lecture= null;
		BufferedInputStream tamponLecture = null;
		FileOutputStream copie= null;
		BufferedOutputStream tamponCopie= null;
		try
		{
		    lecture = new FileInputStream(cheminDuFichier);
		    tamponLecture = new BufferedInputStream(lecture);
		     
		    copie = new FileOutputStream(cheminDes);
		    tamponCopie = new BufferedOutputStream(copie);
		     
		    while (true)
		    {
		        int valeurOctet = tamponLecture.read();
		         
		        if (valeurOctet == -1)
		            break;
		         
		        tamponCopie.write(valeurOctet);
		    }
		}
		catch (IOException exception)
		{
		    exception.printStackTrace();
		}
		finally
		{ 
		    try
		    {
		        tamponLecture.close();
		        lecture.close();
		        tamponCopie.flush();
		        tamponCopie.close();
		        copie.close();
		    }
		    catch(IOException exception1)
		    {
		      exception1.printStackTrace();
		    }  
		}
	}
	
}
