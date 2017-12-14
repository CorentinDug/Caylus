package Caylus.Batiment.Prestige;

import Caylus.Batiment.Batiment;

public class Monument extends Batiment {

    /**
     * Constructeur initialisant le nom
     */
    public Monument(){
        super("Monument");
        coutConst[0]=2;
        coutConst[1]=0;
        coutConst[2]=4;
        coutConst[3]=0;
        coutConst[4]=0;
        prestige=14;
    }

}
