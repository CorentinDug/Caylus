package Caylus.Batiment.Neutre;

import Caylus.Batiment.Batiment;
import Caylus.View;

public class NScierie extends Batiment {

    /**
     * Constructeur initialisant le nom
     */
    public NScierie(){
        super("NScierie");
    }

    public boolean isNeutre(){
        return true;
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
     *  Donne la récompense ouvrière dû au joueur
     */
    public boolean recompenseOuvrier() {
        ouvrier.recoit("bois",1);
        return true;
    }

}
