package Caylus;

import Caylus.Batiment.*;

/**
 * Created by Schnoeby on 19/11/2017.
 */
public class Case {
    private Batiment batiment;

    /**
     * Constructeur initialisant la case
     */
    public Case(){
        batiment = null;
    }

    /**
     * @return Retourne le batiment associé à la case
     */
    public Batiment getBatiment() {
        return batiment;
    }

    /**
     * Change le batiment associé à la case
     * @param batiment Le nouveau batiment
     */
    public void setBatiment(Batiment batiment) {
        this.batiment = batiment;
    }

    /**
     * @return Retourne l'ouvrier qui travaille dans le batiment associé à cette case
     */
    public Joueur getOuvrier(){
        return batiment.getOuvrier();
    }

    /**
     * @return Retourne le propriétaire du batiment associé à cette case
     */
    public Joueur getProprietaire(){return batiment.getProprietaire();}

    /**
     * @return Retourne le nom du batiment associé à cette case
     */
    public String getNomBat(){
        if(batiment==null)
            return"Vide";
        return batiment.getNom();
    }

    /**
     * @return Retourne le nom de l'ouvrier qui traivaille sur le batiment associé à cette case
     */
    public String getNomOuvrier(){
        return getOuvrier().getNom();
    }

    /**
     * @return Retourne le nom du propriétaire du batiment associé à cette case
     */
    public String getNomProprio(){
        if(getProprietaire()==null)
            return "";
        return getProprietaire().getNom();
    }
}
