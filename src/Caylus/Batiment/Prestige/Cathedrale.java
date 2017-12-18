package Caylus.Batiment.Prestige;

import Caylus.Batiment.Batiment;

public class Cathedrale extends Batiment {

    /**
     * Constructeur initialisant le nom
     */
    public Cathedrale(){
        super("Cathedrale");
        coutConst[0]=3; //or
        coutConst[1]=4; //nourriture
        coutConst[2]=0; //pierre
        coutConst[3]=1; //bois
        coutConst[4]=0; //tissus
        prestige=25;
    }
}
