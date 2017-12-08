package Caylus.Batiment.Neutre;

import Caylus.Batiment.Batiment;

public class NCarriere extends Batiment {

    /**
     * Constructeur initialisant le nom
     */
    public NCarriere(){
        super("NCarriere");

    }

    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public void recompenseOuvrier() {
            ouvrier.recoit("pierre",1);
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

