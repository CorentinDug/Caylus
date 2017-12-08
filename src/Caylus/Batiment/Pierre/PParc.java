package Caylus.Batiment.Pierre;

import Caylus.Batiment.Batiment;

public class PParc extends Batiment {

    /**
     * Constructeur initialisant le nom
     */
    public PParc(){
        super("PParc");

    }

    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public void recompenseOuvrier() {
        ouvrier.recoit("bois", 2);
        ouvrier.recoit("nourriture", 2);
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