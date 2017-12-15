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

    public int active(){
        recompenseOuvrier();
        return 0;
    }

    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public boolean recompenseOuvrier() {
        System.out.println("marche");
        ouvrier.recoit("denier", 3);
        return true;
    }
}

