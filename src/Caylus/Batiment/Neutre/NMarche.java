package Caylus.Batiment.Neutre;

import Caylus.Batiment.Batiment;

public class NMarche extends Batiment {

    /**
     * Constructeur initialisant le nom
     */
    public NMarche(){
        super("NMarche");

    }

    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public void recompenseOuvrier(String choix) {
        ouvrier.donne(choix,1);
        ouvrier.recoit("denier", 4);
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