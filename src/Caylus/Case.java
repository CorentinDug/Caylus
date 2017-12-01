package Caylus;

import Caylus.Batiment.*;

/**
 * Created by Schnoeby on 19/11/2017.
 */
public class Case {
    private boolean ouvrier;
    private Batiment batiment;

    public Case(){
        ouvrier = false;
        batiment = null;
    }

    public String getBatiment() {
        return batiment.getNom();
    }

    public void setBatiment(Batiment batiment) {
        this.batiment = batiment;
    }
}
