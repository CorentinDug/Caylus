package Caylus.Batiment.Pierre;

import Caylus.Batiment.Batiment;

public class PEglise extends Batiment {

    /**
     * Constructeur initialisant le nom
     */
    public PEglise(){
        super("PEglise");
    }

    public void active(){
        recompenseOuvrier();
        recompenseProprietaire();
    }


    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public void recompenseOuvrier() {
        ouvrier.recoit("prestige",3);
        ouvrier.donne("deniers", 2);
    }

    /**
     * Donne la récompense propriétaire dû au joueur
     */
    public void recompenseProprietaire() {
        proprietaire.recoit("prestige",4);
        proprietaire.donne("deniers", 3);
    }

    /**
     * Donne la récompense de prestige dû au joueur
     */
    public void recompensePrestige() {

    }
}
