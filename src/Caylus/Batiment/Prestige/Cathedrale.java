package Caylus.Batiment.Prestige;

import Caylus.Batiment.Batiment;

public class Cathedrale extends Batiment {

    /**
     * Constructeur initialisant le nom
     */
    public Cathedrale(){
        super("Cathédrale");
        coutConst[0]=3;
        coutConst[1]=4;
        coutConst[2]=0;
        coutConst[3]=1;
        coutConst[4]=0;
        prestige=25;
    }
}
