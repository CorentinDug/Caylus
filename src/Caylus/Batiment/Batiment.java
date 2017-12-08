package Caylus.Batiment;


import Caylus.Joueur;
import Caylus.Model;

public class Batiment {
    protected  String nom;
    protected Joueur joueur;
    protected Joueur ouvrier;

    public Batiment(String nom){
        this.nom=nom;
        ouvrier=null;
    }
    public String getNom() {
        return nom;
    }

    public boolean engager(Joueur joueur) {
        if(ouvrier!=null)
            return false;
        ouvrier=joueur;
        return true;
    }
}
