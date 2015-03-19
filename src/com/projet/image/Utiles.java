package com.projet.image;

public class Utiles {

	public static int deffinirIntervalRG(int nombre){
		if(-256 <= nombre && nombre >= -192){
			return 0;
		}else if(-191 <= nombre && nombre >= -127){
			return 1;
		}else if(-126 <= nombre && nombre >= -62){
			return 2;
		}else if(-61 <= nombre && nombre >= 0){
			return 3;
		}else if(1 <= nombre && nombre >= 61){
			return 4;
		}else if(62 <= nombre && nombre >= 126){
			return 5;
		}else if(127 <= nombre && nombre >= 191){
			return 6;
		}else if(191 <= nombre && nombre >= 256){
			return 7;
		}else{
			System.out.println("La définition de l'intervale a echoué RG");
			return -1;
		}
	}
}
