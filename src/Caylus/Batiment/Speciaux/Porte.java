package Caylus.Batiment.Speciaux;

import Caylus.Batiment.Batiment;
import Caylus.View;

/**
 * Created by Schnoeby on 01/12/2017.
 */
public class Porte extends Batiment {
    /**
     * Constructeur initialisant le nom
     */
    public Porte(){
        super("porte");
    }

    public int active(View view){
        return 1;
    }


}

