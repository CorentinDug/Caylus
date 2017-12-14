package Caylus.Batiment.Pierre;

import Caylus.Batiment.Batiment;

public class PFerme extends Batiment {
    private String[] choix = new String[]{"nourriture","tissu"};
    private String recProprio;
    /**
     * Constructeur initialisant le nom
     */
    public PFerme(){
        super("PFerme");
        coutConst[0]=0;
        coutConst[1]=1;
        coutConst[2]=1;
        coutConst[3]=0;
        coutConst[4]=0;
        prestige=3;
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
        ouvrier.recoit("nourriture", 2);
        ouvrier.recoit("tissu", 1);
    }

    /**
     * Donne la récompense propriétaire dû au joueur
     */
    public boolean recompenseProprietaire() {
        if(proprietaire!=null && proprietaire!=ouvrier)
            proprietaire.recoit("prestige",1);
        recProprio = view.panneauRecompense(choix,mess);
        proprietaire.recoit(recProprio,1);
        return true;
    }

}