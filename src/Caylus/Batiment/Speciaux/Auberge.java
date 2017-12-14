package Caylus.Batiment.Speciaux;

import Caylus.Batiment.Batiment;
import Caylus.Joueur;

/**
 * Created by Schnoeby on 01/12/2017.
 */
public class Auberge extends Batiment {
    protected Joueur ouvrier2;
    /**
     * Constructeur initialisant le nom
     */
    public Auberge() {
        super("Auberge");
    }

    public int active(){
        ouvrier2=ouvrier;
        ouvrier=null;
        return 6;
    }


}

