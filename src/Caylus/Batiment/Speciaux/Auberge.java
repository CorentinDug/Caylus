package Caylus.Batiment.Speciaux;

import Caylus.Batiment.Batiment;
import Caylus.Joueur;
import Caylus.View;

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
        ouvrier2=null;
    }

    public int active(View view){
        ouvrier2=ouvrier;
        ouvrier=null;
        return 6;
    }


    public Joueur getOuvrier(int i) {
        if(i==1)
            return ouvrier;
        else
            return ouvrier2;
    }

    public boolean engager(Joueur joueur) {
        if(ouvrier==null){
            ouvrier=joueur;
            return true;
        }else{
            return false;
        }
    }

    public void retireOuvrier() {}


}

