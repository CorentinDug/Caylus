package Caylus.Batiment.Speciaux;

import Caylus.Batiment.Batiment;

/**
 * Created by Schnoeby on 01/12/2017.
 */
public class Comptoir extends Batiment {

    /**
     * Constructeur initialisant le nom
     */
    public Comptoir(){
        super("Comptoir");
    }

    public void active(){
        recompenseOuvrier();
    }

    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public void recompenseOuvrier() {
        ouvrier.recoit("denier", 3);
    }
}

