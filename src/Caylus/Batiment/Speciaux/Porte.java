package Caylus.Batiment.Speciaux;

import Caylus.Batiment.Batiment;

/**
 * Created by Schnoeby on 01/12/2017.
 */
public class Porte extends Batiment {
    /**
     * Constructeur initialisant le nom
     */
    public Porte(){
        super("Porte");
    }

    public int active(){
        return 1;
    }


}

