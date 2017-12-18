package Caylus.Batiment.Bois;

import Caylus.Batiment.Batiment;
import Caylus.Joueur;
import Caylus.Model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;


public class BCarriere extends Batiment {

    /**
     * Constructeur initialisant le nom, les couts de construction et le nombre de prestiges reçue à la construction
     */
    public BCarriere(){
        super("Carriere");
        coutConst[0]=0;
        coutConst[1]=0;
        coutConst[2]=1;
        coutConst[3]=1;
        coutConst[4]=0;
        prestige=2;
    }

    /**
     * Donne les récompenses aux personnes concerné
     * @return
     */
    public int active(){
        recompenseOuvrier();
        recompenseProprietaire();
        return 0;
    }

    /**
     * Donne la récompense au joueur qui a posé un ouvrier
     * @return
     */
    public boolean recompenseOuvrier() {
        ouvrier.recoit("pierre", 2);
        return true;
    }

}
