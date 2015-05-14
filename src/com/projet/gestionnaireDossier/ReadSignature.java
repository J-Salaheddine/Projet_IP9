package com.projet.gestionnaireDossier;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.projet.outils.Signature;
import com.projet.outils.StaticValues;

public class ReadSignature extends Signature{

	private int[] tabRg = new int[StaticValues.NOMBRE_DE_DIVISION_RG];
	private int[] tabBy = new int[StaticValues.NOMBRE_DE_DIVISION_BY];
	private int[] tabWb = new int[StaticValues.NOMBRE_DE_DIVISION_WB];

	
	public ReadSignature(String filePath) {
		super();
		lireFicher(filePath);
	}
	
	/**
	 * remplir les trois tableau a partir d'un fichier texte
	 * @param filePath
	 */
	public void lireFicher(String filePath) {
		Scanner scanner;
		try {
			scanner = new Scanner(new File(filePath));
			// On boucle sur chaque champ detecté
			int calculator = 0;
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (calculator == 0) {
					lireLineRG(line);
				} else if (calculator == 1) {
					lireLineBy(line);
				} else if (calculator == 2) {
					lireLineWb(line);
				} else {
					System.out.println("le fichier contien des lines en plus !!");
				}
				calculator++;
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void lireLineRG(String line) {
		String numText = "";
		int compteur = 0;
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == ' ' && compteur != tabRg.length) {
				tabRg[compteur] = (Integer.parseInt(numText));
				compteur++;
				numText = "";
			} else {
				numText += line.charAt(i);
			}
		}
	}

	private void lireLineBy(String line) {
		String numText = "";
		int compteur = 0;
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == ' ' && compteur != tabBy.length) {
				tabBy[compteur] = (Integer.parseInt(numText));
				compteur++;
				numText = "";
			} else {
				numText += line.charAt(i);
			}
		}
	}

	private void lireLineWb(String line) {
		String numText = "";
		int compteur = 0;
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == ' ' && compteur != tabWb.length) {
				tabWb[compteur] = (Integer.parseInt(numText));
				compteur++;
				numText = "";
			} else {
				numText += line.charAt(i);
			}
		}
	}

	public void affiche() {
		for (int i = 0; i < tabRg.length; i++) {
			System.out.println("valeur numero " + i + " : " + tabRg[i]);
		}
		System.out.println("******************************");
		for (int i = 0; i < tabBy.length; i++) {
			System.out.println("valeur numero " + i + " : " + tabBy[i]);
		}
		System.out.println("******************************");
		for (int i = 0; i < tabWb.length; i++) {
			System.out.println("valeur numero " + i + " : " + tabWb[i]);
		}
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
	
	
}
