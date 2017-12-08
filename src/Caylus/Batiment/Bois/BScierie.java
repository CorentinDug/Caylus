package Caylus.Batiment.Bois;

import Caylus.Batiment.Batiment;

public class BScierie extends Batiment {

    /**
     * Constructeur initialisant le nom
     */
    public BScierie(){
        super("BScierie");
    }

    public void active(){
        recompenseOuvrier();
    }

    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public void recompenseOuvrier() {
        ouvrier.recoit("bois", 2);
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
