package Caylus.Batiment.Pierre;

import Caylus.Batiment.Batiment;

public class PBanque extends Batiment {

    /**
     * Constructeur initialisant le nom
     */
    public PBanque(){
        super("PBanque");
    }

    public void active(){
        recompenseOuvrier();
        recompenseProprietaire();
    }

    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public void recompenseOuvrier() {
        ouvrier.recoit("or",1);
        ouvrier.donne("deniers", 2);
    }

    /**
     * Donne la récompense propriétaire dû au joueur
     */
    public void recompenseProprietaire() {
        proprietaire.recoit("or",2);
        proprietaire.donne("deniers", 5);
    }

    /**
     * Donne la récompense de prestige dû au joueur
     */
    public void recompensePrestige() {

    }
}
