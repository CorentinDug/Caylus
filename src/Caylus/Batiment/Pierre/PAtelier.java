package Caylus.Batiment.Pierre;

import Caylus.Batiment.Batiment;

public class PAtelier extends Batiment {

    /**
     * Constructeur initialisant le nom
     */
    public PAtelier(){
        super("PAtelier");

    }

    public void active(){
        recompenseOuvrier();
    }

    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public void recompenseOuvrier() {
        ouvrier.recoit("pierre", 2);
        ouvrier.recoit("tissu", 1);
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