package Caylus.Batiment.Bois;

import Caylus.Batiment.Batiment;

public class BFermeNourriture extends Batiment {

    /**
     * Constructeur initialisant le nom
     */
    public BFermeNourriture(){
        super("BFermeNourriture");

    }

    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public void recompenseOuvrier(String choix) {
        if (choix.equals("nourriture")) {
            ouvrier.recoit(choix, 2);
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