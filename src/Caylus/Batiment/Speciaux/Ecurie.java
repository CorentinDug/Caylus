package Caylus.Batiment.Speciaux;

import Caylus.Batiment.Batiment;
import Caylus.Joueur;
import Caylus.View;

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

    /**
     * Donne les récompenses aux personnes concerné
     * la valeur de retour permet de savoir quoi faire dans le model après l'activation, 0 rien et [1=>6] correspond à un batiment spécial
     * @return
     */
    public int active(View view){
        return 5;
    }

    public Joueur getOuvrier(int index) {
        if(index==1)
            return ouvrier;
        if(index==2)
            return ouvrier2;
        else
            return ouvrier3;
    }

    public boolean engager(Joueur joueur) {
        if( ouvrier3!=null )
            return false;
        if(ouvrier==null)
            ouvrier=joueur;
        else if(ouvrier2==null && ouvrier!=joueur)
            ouvrier2=joueur;
        else if(ouvrier2!=null &&  ouvrier!=joueur && ouvrier2!=joueur)
            ouvrier3=joueur;
        else
            return false;
        return true;
    }

}

