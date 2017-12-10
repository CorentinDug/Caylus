package Caylus.Batiment;


import Caylus.Joueur;
import Caylus.Model;
import Caylus.View;

public class Batiment {
    protected View view;
    protected  String nom;
    protected Joueur proprietaire;
    protected Joueur ouvrier;
    protected String mess = "Choix de récompense";
    protected int[] coutConst;

    public Batiment(String nom){
        this.nom=nom;
        ouvrier=null;
        proprietaire=null;
        coutConst = new int[5];
    }
    public String getNom() {
        return nom;
    }

    public Joueur getOuvrier(){
        return ouvrier;
    }

    public Joueur getProprietaire(){return proprietaire;}

    public boolean engager(Joueur joueur) {
        if(ouvrier!=null)
            return false;
        ouvrier=joueur;
        return true;
    }

    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }

    public int active(View view){return -1;}

    /**
     * Donne la récompense propriétaire dû au joueur
     */
    public void recompenseProprietaire() {
        if(proprietaire!=null && proprietaire!=ouvrier)
            proprietaire.recoit("prestige",1);
    }

    /**
     * Donne la récompense de prestige dû au joueur
     */
    public void recompensePrestige() {}

    public int[] coutContructon() {
        return  coutConst;
    }

}
