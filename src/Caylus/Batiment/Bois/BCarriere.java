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

    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public void recompenseOuvrier() {
        ouvrier.recoit("pierre", 2);
    }

    /**
     * Donne la récompense propriétaire dû au joueur
     */
    private void recompenseProprietaire() {
    }

    /**
     * Donne la récompense de prestige dû au joueur
     */
    public void recompensePrestige() {

    }
}
