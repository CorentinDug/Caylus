package Caylus.Batiment.Pierre;

import Caylus.Batiment.Batiment;

public class PTailleur extends Batiment {

    /**
     * Constructeur initialisant le nom
     */
    public PTailleur(){
        super("PTailleur");
    }

    public void active(){
        recompenseOuvrier();
        recompenseProprietaire();
    }


    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public void recompenseOuvrier() {
        proprietaire.recoit("prestige",4);
        proprietaire.donne("tissu", 2);
    }

    /**
     * Donne la récompense propriétaire dû au joueur
     */
    public void recompenseProprietaire() {
        proprietaire.recoit("prestige",6);
        proprietaire.donne("tissu", 3);
    }

    /**
     * Donne la récompense de prestige dû au joueur
     */
    public void recompensePrestige() {

    }
}