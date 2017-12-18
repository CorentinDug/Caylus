package Caylus.Batiment.Prestige;

import Caylus.Batiment.Batiment;

public class Cathedrale extends Batiment {

    /**
     * Constructeur initialisant le nom, les couts de construction et le nombre de prestiges reçue à la construction
     */
    public Cathedrale(){
        super("Cathedrale");
        coutConst[0]=3;
        coutConst[1]=0;
        coutConst[2]=4;
        coutConst[3]=1;
        coutConst[4]=0;
        prestige=25;
    }
}
