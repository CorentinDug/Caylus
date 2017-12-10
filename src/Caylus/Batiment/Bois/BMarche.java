package Caylus.Batiment.Bois;

import Caylus.Batiment.Batiment;

public class BMarche extends Batiment {
    private String[] choix = new String[]{"nourriture","tissu","bois","pierre","or"};
    private String recOuvrier;
    private String mess1 = "Choississez quoi donnez";
    /**
     * Constructeur initialisant le nom
     */
    public BMarche(){
        super("BMarché");

    }

    public int active(){
        recOuvrier = view.panneauRecompense(choix,mess1);
        if(!recompenseOuvrier(recOuvrier))
            return 1;
        recompenseProprietaire();
        return -1;
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