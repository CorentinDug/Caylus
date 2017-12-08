package Caylus.Batiment.Neutre;

import Caylus.Batiment.Batiment;

public class NScierie extends Batiment {

    /**
     * Constructeur initialisant le nom
     */
    public NScierie(){
        super("NScierie");
    }

    public void active(){
        recompenseOuvrier();
    }

    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public void recompenseOuvrier() {
        ouvrier.recoit("bois",1);

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
