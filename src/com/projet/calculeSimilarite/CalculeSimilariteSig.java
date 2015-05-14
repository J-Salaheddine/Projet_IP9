package com.projet.calculeSimilarite;

import com.projet.outils.Signature;
import com.projet.outils.StaticValues;
import com.projet.outils.Utiles;


public class CalculeSimilariteSig {
	private Signature signature1;
	private Signature signature2;

	
	public CalculeSimilariteSig(Signature signature, Signature lectureSignature) {
		super();
		this.signature1 = signature;
		this.signature2 = lectureSignature;
	}

	/**
	 * Divise la somme des min par la plus petite somme
	 * @return
	 */
	public float getTauxSimlarite() {
		float tauxDeSimilarite = sommeDesMin(this.signature1, signature2)/plusPetitHistogramme(signature1, signature2);
		return tauxDeSimilarite;
	}

	/**
	 * Prend en parametre deux signature et envoie le resulta de la somme des min
	 * @param oi1
	 * @param oi2
	 * @return
	 */
	private float sommeDesMin(Signature oi1, Signature oi2) {
		float minsumRG = 0;
		float minsumBY = 0;
		float minsumWB = 0;

		minsumRG = calculerMin(oi1, oi2, 0);
		minsumBY = calculerMin(oi1, oi2, 1);
		minsumWB = calculerMin(oi1, oi2, 2);
		float sommeMin = minsumRG + minsumBY + minsumWB;

		return sommeMin;
	}

	

	/**
	 * A partir de deux sigantures cette fonction permet de calculer la somme
	 * des minimums a partir des deux histogramme 
	 * c'est a dire a partir de deux tableau (histogrammes) [1,3,5] et [0,2,6] le resulta est: 0+2+5 = 7
	 * 
	 * @param oi1
	 * @param oi2
	 * @param elementNum
	 * @param numeroTable
	 * @return
	 */
	public int calculerMin(Signature oi1, Signature oi2, int numeroTable) {
		int minumum = 0;
		switch (numeroTable) {
		case 0:
			for (int i = 0; i < StaticValues.NOMBRE_DE_DIVISION_RG; i++) {
				minumum += Utiles.getMin(oi1.getTabRgElement(i),
						oi2.getTabRgElement(i));
			}
			break;
		case 1:
			for (int i = 0; i < StaticValues.NOMBRE_DE_DIVISION_BY; i++) {
				minumum += Utiles.getMin(oi1.getTabByElement(i),
						oi2.getTabByElement(i));
			}
			break;
		case 2:
			for (int i = 0; i < StaticValues.NOMBRE_DE_DIVISION_WB; i++) {
				minumum += Utiles.getMin(oi1.getTabWbElement(i),
						oi2.getTabWbElement(i));
			}
			break;
		default:
			minumum = -1;
			System.out.println("Errore calculerMin classe Utiles !! ");
		}
		return minumum;
	}


	
	public float plusPetitHistogramme(Signature sig1, Signature sig2){
		float sommeTab1 = sommeTab(sig1);
		float sommeTab2 = sommeTab(sig2);
		if(sommeTab1<= sommeTab2){
			return sommeTab1;
		}else{
			return sommeTab2;
		}
	}
	
	public int sommeTab(Signature sig1){
		int tabSomme = 0;
		for (int i = 0; i < StaticValues.NOMBRE_DE_DIVISION_RG; i++) {
			tabSomme += sig1.getTabRgElement(i);
		}
		for (int i = 0; i < StaticValues.NOMBRE_DE_DIVISION_BY; i++) {
			tabSomme += sig1.getTabByElement(i);
		}
		for (int i = 0; i < StaticValues.NOMBRE_DE_DIVISION_WB; i++) {
			tabSomme += sig1.getTabWbElement(i);
		}
		return tabSomme;
	}
}
