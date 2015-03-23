package com.projet.image;

public class Utiles {

	public static int deffinirIntervalRG(int nombre){
		int j = 10;
		if(nombre > -256  && nombre < -192){
			return j;
		}else if(-191 <= nombre && nombre <= -127){
			return 1;
		}else if(-126 <= nombre && nombre <= -62){
			return 2;
		}else if(-61 <= nombre && nombre <= 0){
			return 3;
		}else if(1 <= nombre && nombre <= 61){
			return 4;
		}else if(62 <= nombre && nombre <= 126){
			return 5;
		}else if(127 <= nombre && nombre <= 191){
			return 6;
		}else if(191 <= nombre && nombre <= 256){
			return 7;
		}else{
			System.out.println("La définition de l'intervale a echoué RG");
			return -1;
		}
	}
	
	public static int deffinirIntervalBY(int nombre) {
		if (-1024 <= nombre && nombre <= -896) {
			return 0;
		} else if (-895 <= nombre && nombre <= -767) {
			return 1;
		} else if (-766 <= nombre && nombre <= -638) {
			return 2;
		} else if (-637 <= nombre && nombre <= -509) {
			return 3;
		} else if (-508 <= nombre && nombre <= -380) {
			return 4;
		} else if (-379 <= nombre && nombre <= -251) {
			return 5;
		} else if (-250 <= nombre && nombre <= -122) {
			return 6;
		} else if (-121 <= nombre && nombre <= -1) {
			return 7;
		} else if (0 <= nombre && nombre <= 121) {
			return 8;
		} else if (122 <= nombre && nombre <= 250) {
			return 9;
		} else if (251 <= nombre && nombre <= 379) {
			return 10;
		} else if (380 <= nombre && nombre <= 508) {
			return 11;
		} else if (509 <= nombre && nombre <= 637) {
			return 12;
		} else if (638 <= nombre && nombre <= 766) {
			return 13;
		} else if (767 <= nombre && nombre <= 895) {
			return 14;
		} else if (896 <= nombre && nombre <= 1024) {
			return 15;
		} else {
			System.out.println("La définition de l'intervale a echoué BY");
			return -1;
		}
	}
	
	public static int deffinirIntervalWB(int nombre) {
		if (-769 <= nombre && nombre <= -679) {
			return 0;
		} else if (-678 <= nombre && nombre <= -679) {
			return 1;
		} else if (-768 <= nombre && nombre <= -582) {
			return 2;
		} else if (-581 <= nombre && nombre <= -485) {
			return 3;
		} else if (-484 <= nombre && nombre <= -388) {
			return 4;
		} else if (-387 <= nombre && nombre <= -291) {
			return 5;
		} else if (-290 <= nombre && nombre <= -194) {
			return 6;
		} else if (-193 <= nombre && nombre <= -97) {
			return 7;
		} else if (-96 <= nombre && nombre <= -1) {
			return 8;
		} else if (0 <= nombre && nombre <= 96) {
			return 9;
		} else if (97 <= nombre && nombre <= 193) {
			return 10;
		} else if (194 <= nombre && nombre <= 290) {
			return 11;
		} else if (291 <= nombre && nombre <= 387) {
			return 12;
		} else if (388 <= nombre && nombre <= 484) {
			return 13;
		} else if (485 <= nombre && nombre <= 581) {
			return 14;
		} else if (582 <= nombre && nombre <= 678) {
			return 15;
		} else if (679 <= nombre && nombre <= 768) {
			return 15;
		} else {
			System.out.println("nombre:"+nombre);
			System.out.println("La définition de l'intervale a echoué WB");
			return -1;
		}
	}
	
	public static float calculerDistance(ObjetImage oi1, ObjetImage oi2){
		float intersectionRg =0, minsumRg;
		float intersectionBy;
		float intersectionWb;

		float res=1;
		minsumRg = 0;
		for(int i=0; i<8; i++){
			minsumRg += calculerMin(oi1, oi2, i);
		}
		for(int i=0; i<8; i++){
			intersectionRg += oi2.getTabRgElement(i);
		}
		System.out.println(minsumRg);
		System.out.println(intersectionRg);
		res = division(minsumRg,intersectionRg);
		return res;
	}
	
	public static float division(float i, float j){
		if(i<j){
			return i/j;
		}else return j/i;
	}
	
	public static int calculerMin(ObjetImage oi1, ObjetImage oi2, int elementNum){
		if(oi1.getTabRgElement(elementNum) <= oi2.getTabRgElement(elementNum)){
			return oi1.getTabRgElement(elementNum);
		}else
		return oi2.getTabRgElement(elementNum);
	}
	
}
