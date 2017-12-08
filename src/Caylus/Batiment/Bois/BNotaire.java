package Caylus.Batiment.Bois;

import Caylus.Batiment.Batiment;

public class BNotaire extends Batiment {
    private String[] choix = new String[]{"1 Denier et 1 tissu","Plan résidence"};
    private String recOuvrier;
    /**
     * Constructeur initialisant le nom
     */
    public BNotaire(){
        super("BNotaire");

    }

    public void active(){
        //recompenseOuvrier();
    }


    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public void recompenseOuvrier(String choix) {
            //ouvrier.recoit("denier",1);
           // ouvrier.recoit("tissu",1);
    }

    /**
     * Donne la récompense propriétaire dû au joueur
     */
    public void recompenseProprietaire() {

    }

    /**
     * Donne la récompense de prestige dû au joueur
     */
    public void recompensePrestige() {

    }
}
