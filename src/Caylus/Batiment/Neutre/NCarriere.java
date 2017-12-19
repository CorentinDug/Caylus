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

    /**
     * Donne les récompenses aux personnes concerné
     * @return
     */
    public int active(View view){
        recompenseOuvrier();
        return 0;
    }

    /**
     *  Renvoie true si le batiment est une batiments neutre
     */
    public boolean isNeutre(){
        return true;
    }

    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public boolean recompenseOuvrier() {
            ouvrier.recoit("pierre",1);
            return true;
    }

}

