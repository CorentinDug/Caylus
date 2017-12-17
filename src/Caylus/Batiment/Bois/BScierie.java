package Caylus.Batiment.Bois;

import Caylus.Batiment.Batiment;

public class BScierie extends Batiment {

    /**
     * Constructeur initialisant le nom
     */
    public BScierie(){
        super("Scierie");
        coutConst[0]=0;
        coutConst[1]=0;
        coutConst[2]=1;
        coutConst[3]=1;
        coutConst[4]=0;
        prestige=2;
    }

    public int active(){
        recompenseOuvrier();
        recompenseProprietaire();
        return 0;
    }

    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public void recompenseOuvrier() {
        ouvrier.recoit("bois", 2);
    }

}
