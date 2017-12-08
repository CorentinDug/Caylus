package Caylus.Batiment.Bois;

import Caylus.Batiment.Batiment;

public class BFermeNourriture extends Batiment {
    private String[] choix = new String[]{"2 Nourriture", "tissu"};
    private String recOuvrier;

    /**
     * Constructeur initialisant le nom
     */
    public BFermeNourriture(){
        super("BFermeNourriture");

    }

    public void active(){
        recOuvrier = view.panneauRecompense(choix,mess);
        recompenseOuvrier(recOuvrier);
    }

    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public void recompenseOuvrier(String choix) {
        if (choix.equals("2nourriture")) {
            ouvrier.recoit("nourriture", 2);
        }else{
            ouvrier.recoit(choix,1);
        }
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