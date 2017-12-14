package Caylus.Batiment.Neutre;

import Caylus.Batiment.Batiment;
import Caylus.View;

public class NCarriere extends Batiment {

    /**
     * Constructeur initialisant le nom
     */
    public NCarriere(){
        super("NCarriere");
    }

    public int active(View view){
        recompenseOuvrier();
        return 0;
    }

    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public void recompenseOuvrier() {
            ouvrier.recoit("pierre",1);
    }

}

