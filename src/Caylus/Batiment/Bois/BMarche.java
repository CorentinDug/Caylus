package Caylus.Batiment.Bois;

import Caylus.Batiment.Batiment;

public class BMarche extends Batiment {
    private String[] choix = new String[]{"nourriture","tissu","bois","pierre"};
    private String recOuvrier;
    private String mess1 = "Choississez quoi donnez";
    /**
     * Constructeur initialisant le nom
     */
    public BMarche(){
        super("Marche");
        coutConst[0]=0;
        coutConst[1]=1;
        coutConst[2]=0;
        coutConst[3]=1;
        coutConst[4]=0;
        prestige=4;
    }

    public int active(){
        recompenseProprietaire();
        recOuvrier = view.panneauRecompense(choix,mess1);
        if(!recompenseOuvrier(recOuvrier))
            return -1;
        return 0;
    }
    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public boolean recompenseOuvrier(String choix) {
        if(ouvrier.donne(choix,1)){
            ouvrier.recoit("denier", 4);
            return true;
        }
        return false;
    }


}