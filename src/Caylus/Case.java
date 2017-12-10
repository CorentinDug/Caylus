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

    public Joueur getOuvrier(){
        return batiment.getOuvrier();
    }

    public Joueur getProprietaire(){return batiment.getProprietaire();}

    public String getNomBat(){
        if(batiment==null)
            return"Vide";
        return batiment.getNom();
    }

    public String getNomOuvrier(){
        return getOuvrier().getNom();
    }

    public String getNomProprio(){
        if(getProprietaire()==null)
            return "";
        return getProprietaire().getNom();
    }
}
