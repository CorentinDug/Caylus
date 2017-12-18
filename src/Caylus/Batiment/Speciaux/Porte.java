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

    /**
     * Donne les récompenses aux personnes concerné
     * la valeur de retour permet de savoir quoi faire dans le model après l'activation, 0 rien et [1=>6] correspond à un batiment spécial
     * @return
     */
    public int active(View view){
        return 1;
    }


}

