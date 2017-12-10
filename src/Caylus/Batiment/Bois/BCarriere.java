package Caylus.Batiment.Bois;

import Caylus.Batiment.Batiment;
import Caylus.Joueur;
import Caylus.Model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;


public class BCarriere extends Batiment {

    /**
     * Constructeur initialisant le nom
     */
    public BCarriere(){
        super("BCarriere");
        coutConst[0]=0;
        coutConst[1]=0;
        coutConst[2]=1;
        coutConst[3]=1;
        coutConst[4]=0;
    }

    public int active(){
        recompenseOuvrier();
        recompenseProprietaire();
        return -1;
    }

    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public boolean recompenseOuvrier() {
        ouvrier.recoit("pierre", 2);
        return true;
    }
    /**
     * Donne la récompense de prestige dû au joueur
     */

    public void recompensePrestige() {}
}
