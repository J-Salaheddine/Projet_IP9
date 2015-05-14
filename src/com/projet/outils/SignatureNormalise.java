package com.projet.outils;

public class SignatureNormalise extends Signature{

	private float[] tabRg ;
	private float[] tabBy ;
	private float[] tabWb ;
	
	public SignatureNormalise(Signature sig){
		tabRg = Utiles.normaliserVecteur(sig.getTabRg());
		tabBy = Utiles.normaliserVecteur(sig.getTabBy());
		tabWb = Utiles.normaliserVecteur(sig.getTabWb());
	}
	
	public float getTabRgElementN(int elementNumero) {
		return tabRg[elementNumero];
	}
	public float getTabByElementN(int elementNumero) {
		return tabBy[elementNumero];
	}
	public float getTabWbElementN(int elementNumero) {
		return tabWb[elementNumero];
	}
}
