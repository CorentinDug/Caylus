package Caylus.Batiment.Speciaux;

import Caylus.Batiment.Batiment;
import Caylus.View;

/**
 * Created by Schnoeby on 01/12/2017.
 */
public class Joute extends Batiment {


    /**
     * Constructeur initialisant le nom
     */
    public Joute() {
        super("Joute");
    }

    public int active(View view) {
        if (!recompenseOuvrier())
            return  1;
        return 0;
    }

    /**
     * Donne la récompense ouvrière dû au joueur
     */
    public boolean recompenseOuvrier() {
        if (ouvrier.donne("denier", 4)) {
            ouvrier.recoit("or", 1);
            return true;
        }
        return false;
    }
}

