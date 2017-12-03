package Caylus;

import Caylus.Batiment.*;

/**
 * Created by Schnoeby on 19/11/2017.
 */
public class Case {
    private Batiment batiment;

    public Case(){
        batiment = null;
    }

    public Batiment getBatiment() {
        return batiment;
    }

    public void setBatiment(Batiment batiment) {
        this.batiment = batiment;
    }
}
