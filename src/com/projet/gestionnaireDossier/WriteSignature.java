package com.projet.gestionnaireDossier;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.projet.outils.Signature;
import com.projet.outils.StaticValues;

public class WriteSignature {

	private Signature objetImage;
	private String sigantureRG ="";
	private String sigantureBY ="";
	private String sigantureWB ="";
	
	/**
	 * Cette classe permet de créer un fichier txt contenant la signature d'une image
	 * @param objetImage
	 */
	public WriteSignature(Signature objetImage) {
		super();
		this.objetImage = objetImage;
		genererSignature();
		publierSignature();
	}
	
	/**
	 * Constiruer un string pour chaque tableau 
	 * [1,2,3,4] => "1 2 3 4"
	 */
	public void genererSignature(){
		for(int i=0; i < StaticValues.NOMBRE_DE_DIVISION_RG ; i++){
			sigantureRG += ""+objetImage.getTabRgElement(i)+" ";
		}
		for(int i=0; i < StaticValues.NOMBRE_DE_DIVISION_BY ; i++){
			sigantureBY += ""+objetImage.getTabByElement(i)+" ";
		}
		for(int i=0; i < StaticValues.NOMBRE_DE_DIVISION_WB ; i++){
			sigantureWB += ""+objetImage.getTabWbElement(i)+" ";
		}
	}

	public String getSigantureRG() {
		return sigantureRG;
	}

	public String getSigantureBY() {
		return sigantureBY;
	}

	public String getSigantureWB() {
		return sigantureWB;
	}

	/**
	 * Constituer et ecrire dans le fichier txt
	 */
	public void publierSignature(){
		File fichier = new File(StaticValues.BDD_SIGANTURE+objetImage.getFileName()+".txt");
		try {
			PrintWriter pw = new PrintWriter (new BufferedWriter (new FileWriter (fichier)),false);
			pw.println (sigantureRG);
			pw.println (sigantureBY);
			pw.println (sigantureWB);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Erreure d'écriture dans le fichier");
		}
	}
	
	
	
}
