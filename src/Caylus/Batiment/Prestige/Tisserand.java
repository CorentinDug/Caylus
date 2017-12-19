package Caylus.Batiment.Prestige;

import Caylus.Batiment.Batiment;

public class Tisserand extends Batiment {

    /**
     * Constructeur initialisant le nom, les couts de construction et le nombre de prestiges reçue à la construction
     */
    public Tisserand(){
        super("Tisserand");
        coutConst[0]=1;
        coutConst[1]=0;
        coutConst[2]=0;
        coutConst[3]=0;
        coutConst[4]=3;
        prestige=12;
    }


}
