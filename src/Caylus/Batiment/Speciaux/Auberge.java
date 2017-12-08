package Caylus.Batiment.Speciaux;

import Caylus.Batiment.Batiment;

/**
 * Created by Schnoeby on 01/12/2017.
 */
public class Auberge extends Batiment {
    /**
     * Constructeur initialisant le nom
     */
    public Auberge() {
        super("Auberge");
    }

    public void active(){
        recompenseOuvrier();
    }
    /**
     * Donne la récompense ouvrière dû au joueur
     */
    public void recompenseOuvrier() {

    }

}

