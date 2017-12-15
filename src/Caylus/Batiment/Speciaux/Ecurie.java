package Caylus.Batiment.Speciaux;

import Caylus.Batiment.Batiment;
import Caylus.Joueur;

/**
 * Created by Schnoeby on 01/12/2017.
 */
public class Ecurie extends Batiment {
    protected Joueur ouvrier2;
    protected Joueur ouvrier3;
    /**
     * Constructeur initialisant le nom
     */
    public Ecurie(){
        super("Ecurie");
    }

    public int active(){
        return 5;
    }
}

