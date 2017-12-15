package Caylus.Batiment.Speciaux;

import Caylus.Batiment.Batiment;
import Caylus.View;

/**
 * Created by Schnoeby on 01/12/2017.
 */
public class DeplPrevot extends Batiment {

    /**
     * Constructeur initialisant le nom
     */
    public DeplPrevot(){
        super("DeplPrevot");

    }

    public int active(View view){
        return 3;
    }

}

