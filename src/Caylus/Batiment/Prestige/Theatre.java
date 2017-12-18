package Caylus.Batiment.Prestige;

import Caylus.Batiment.Batiment;

public class Theatre extends Batiment {

    /**
     * Constructeur initialisant le nom, les couts de construction et le nombre de prestiges reçue à la construction
     */
    public Theatre(){
        super("Theatre");
        coutConst[0]=2;
        coutConst[1]=0;
        coutConst[2]=0;
        coutConst[3]=3;
        coutConst[4]=0;
        prestige=14;
    }

}
