package Caylus.Batiment.Neutre;


import Caylus.Batiment.Batiment;

public class NFerme extends Batiment {

    /**
     * Constructeur initialisant le nom
     */
    public NFerme(){
        super("NFerme");

    }

    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public void recompenseOuvrier(String choix) {
        ouvrier.recoit(choix,1);
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
