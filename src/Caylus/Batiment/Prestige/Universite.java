package Caylus.Batiment.Prestige;

import Caylus.Batiment.Batiment;

public class Universite extends Batiment {

    /**
     * Constructeur initialisant le nom, les couts de construction et le nombre de prestiges reçue à la construction
     */
    public Universite(){
        super("Universite");
        coutConst[0]=2;
        coutConst[1]=0;
        coutConst[2]=3;
        coutConst[3]=0;
        coutConst[4]=0;
        prestige=14;
    }

}
