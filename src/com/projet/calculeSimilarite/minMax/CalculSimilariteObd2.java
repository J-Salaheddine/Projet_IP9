package com.projet.calculeSimilarite.minMax;

import com.projet.gestionnaireDossier.LectureSignature;
import com.projet.outils.Signature;
import com.projet.outils.StaticValues;
import com.projet.outils.Utiles;

public class CalculSimilariteObd2 {
	
	private Signature signature;
	private LectureSignature lectureSignature;

	/**
	 * Cette classe permet de calculer la similarité entre une signature calculer a partir d'une image et un fichier txt contenant une siganture
	 * @param signature
	 * @param lectureSignature
	 */
	public CalculSimilariteObd2(Signature signature, LectureSignature lectureSignature) {
		super();
		this.signature = signature;
		this.lectureSignature = lectureSignature;
	}

	/**
	 * Divise la somme des min par la plus petite somme
	 * @return
	 */
	public float getTauxSimlarite() {
		float tauxDeSimilarite = sommeDesMin(this.signature, lectureSignature)/sommeDesMax(signature, lectureSignature);
		//System.out.println("Le taux de cimilarité est: "+tauxDeSimilarite);
		return tauxDeSimilarite;
	}

	/**
	 * 
	 * @param oi1
	 * @param lectureSignature
	 * @return
	 */
	private float sommeDesMin(Signature oi1, LectureSignature lectureSignature) {
		float minsumRG = 0;
		float minsumBY = 0;
		float minsumWB = 0;

		minsumRG = calculerMin(oi1, lectureSignature, 0);
		minsumBY = calculerMin(oi1, lectureSignature, 1);
		minsumWB = calculerMin(oi1, lectureSignature, 2);
		float sommeMin = (minsumRG + minsumBY + minsumWB) / 3;

		return sommeMin;
	}

	public float sommeDesMax(Signature oi1, LectureSignature lectureSignature) {
		float maxsumRG = 0;
		float maxsumBY = 0;
		float maxsumWB = 0;

		maxsumRG = calculerMaxHsitogramme(oi1, lectureSignature, 0);
		maxsumBY = calculerMaxHsitogramme(oi1, lectureSignature, 1);
		maxsumWB = calculerMaxHsitogramme(oi1, lectureSignature, 2);
		float plusGrandeSomme = (maxsumRG + maxsumBY + maxsumWB) / 3;

		return plusGrandeSomme;
	}

	/**
	 * A partir de deux objetImage cette fonction permet de calculer la somme
	 * des minimums a partir des deux histogramme c'est a dire que pour chaque
	 * demande, on rend la somme des plus petite valeur des deux tableau
	 * 
	 * @param oi1
	 * @param oi2
	 * @param elementNum
	 * @param numeroTable
	 * @return
	 */
	public int calculerMin(Signature oi1, LectureSignature lectureSignature, int numeroTable) {
		int minumum = 0;
		switch (numeroTable) {
		case 0:
			for (int i = 0; i < StaticValues.NOMBRE_DE_DIVISION_RG; i++) {
				minumum += Utiles.getMin(oi1.getTabRgElement(i),
						lectureSignature.getTabRgElement(i));
			}
			break;
		case 1:
			for (int i = 0; i < StaticValues.NOMBRE_DE_DIVISION_BY; i++) {
				minumum += Utiles.getMin(oi1.getTabByElement(i),
						lectureSignature.getTabByElement(i));
			}
			break;
		case 2:
			for (int i = 0; i < StaticValues.NOMBRE_DE_DIVISION_WB; i++) {
				minumum += Utiles.getMin(oi1.getTabWbElement(i),
						lectureSignature.getTabWbElement(i));
			}
			break;
		default:
			minumum = -1;
			System.out.println("Errore calculerMin classe Utiles !! ");
		}
		return minumum;
	}

	/**
	 * elle somme les valeurs des histogramme et renvoie la plus petite des
	 * valeurs
	 * 
	 * @param oi1
	 * @param oi2
	 */
	public float calculerMaxHsitogramme(Signature oi1, LectureSignature lectureSignature, int numeroTable) {
		int tabSommeMax1 = 0;
		int tabSommeMax2 = 0;
		switch (numeroTable) {
		case 0:
			for (int i = 0; i < StaticValues.NOMBRE_DE_DIVISION_RG; i++) {
				tabSommeMax1 += oi1.getTabRgElement(i);
				tabSommeMax2 += lectureSignature.getTabRgElement(i);
			}
			break;
		case 1:
			for (int i = 0; i < StaticValues.NOMBRE_DE_DIVISION_BY; i++) {
				tabSommeMax1 += oi1.getTabByElement(i);
				tabSommeMax2 += lectureSignature.getTabByElement(i);
			}
			break;
		case 2:
			for (int i = 0; i < StaticValues.NOMBRE_DE_DIVISION_WB; i++) {
				tabSommeMax1 += oi1.getTabWbElement(i);
				tabSommeMax2 += lectureSignature.getTabWbElement(i);

			}
			break;
		}
		float tabSommeMax = Utiles.getMax(tabSommeMax1, tabSommeMax2);
		return tabSommeMax;
	}
}
