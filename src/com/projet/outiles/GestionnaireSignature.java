package com.projet.outiles;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GestionnaireSignature {

	private ObjetImage objetImage;
	private String sigantureRG ="";
	private String sigantureBY ="";
	private String sigantureWB ="";
	
	public GestionnaireSignature(ObjetImage objetImage) {
		super();
		this.objetImage = objetImage;
		genererSignature();
		publierSignature();
	}
	
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
		System.out.println(objetImage.getFileName());
		System.out.println(sigantureRG);
		System.out.println(sigantureBY);
		System.out.println(sigantureWB);
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
