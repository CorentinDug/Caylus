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
    }

    public void active(){
        recompenseOuvrier();
    }

    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public void recompenseOuvrier() {
        ouvrier.recoit("pierre", 2);
    }
    /**
     * Donne la récompense de prestige dû au joueur
     */
    public void recompensePrestige() {

    }
}
