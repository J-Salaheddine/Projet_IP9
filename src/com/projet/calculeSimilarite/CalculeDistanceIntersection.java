package com.projet.calculeSimilarite;

import com.projet.outils.Signature;
import com.projet.outils.StaticValues;
import com.projet.outils.Utiles;

public class CalculeDistanceIntersection {
	private Signature signature1;
	private Signature signature2;

	
	public CalculeDistanceIntersection(Signature signature, Signature signature2) {
		super();
		this.signature1 = signature;
		this.signature2 = signature2;
	}

	/**
	 * Divise la somme des min par la plus petite somme
	 * @return
	 */
	public float getTauxSimilarite() {
		float tauxDeSimilarite = sommeDesMin(this.signature1, signature2)/sommeDesMax(signature1, signature2);
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
		float sommeMin = (minsumRG + minsumBY + minsumWB) / 3;

		return sommeMin;
	}

	/**
	 * Prend en parametre deux signature et envoie la plus petite somme
	 * @param oi1
	 * @param oi2
	 * @return
	 */
	public float sommeDesMax(Signature oi1, Signature oi2) {
		float minsumRG = 0;
		float minsumBY = 0;
		float minsumWB = 0;

		minsumRG = calculerMax(oi1, oi2, 0);
		minsumBY = calculerMax(oi1, oi2, 1);
		minsumWB = calculerMax(oi1, oi2, 2);
		float plusPetiteSomme = (minsumRG + minsumBY + minsumWB) / 3;

		return plusPetiteSomme;
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

	public int calculerMax(Signature oi1, Signature oi2, int numeroTable) {
		int minumum = 0;
		switch (numeroTable) {
		case 0:
			for (int i = 0; i < StaticValues.NOMBRE_DE_DIVISION_RG; i++) {
				minumum += Utiles.getMax(oi1.getTabRgElement(i),
						oi2.getTabRgElement(i));
			}
			break;
		case 1:
			for (int i = 0; i < StaticValues.NOMBRE_DE_DIVISION_BY; i++) {
				minumum += Utiles.getMax(oi1.getTabByElement(i),
						oi2.getTabByElement(i));
			}
			break;
		case 2:
			for (int i = 0; i < StaticValues.NOMBRE_DE_DIVISION_WB; i++) {
				minumum += Utiles.getMax(oi1.getTabWbElement(i),
						oi2.getTabWbElement(i));
			}
			break;
		default:
			minumum = -1;
			System.out.println("Errore calculerMin classe Utiles !! ");
		}
		return minumum;
	}
}
