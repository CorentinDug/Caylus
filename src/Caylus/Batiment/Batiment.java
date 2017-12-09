package Caylus.Batiment;


import Caylus.Joueur;
import Caylus.Model;
import Caylus.View;

public class Batiment {
    protected View view;
    protected  String nom;
    protected Joueur proprietaire;
    protected Joueur ouvrier;
    protected String mess = "Choix de récompense!";

    public Batiment(String nom){
        this.nom=nom;
        ouvrier=null;
    }
    public String getNom() {
        return nom;
    }

    public Joueur getOuvrier(){
        return ouvrier;
    }

    public boolean engager(Joueur joueur) {
        if(ouvrier!=null)
            return false;
        ouvrier=joueur;
        return true;
    }

    public void active(){
        recompenseOuvrier();
    }

    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public void recompenseOuvrier() {}

    /**
     * Donne la récompense propriétaire dû au joueur
     */
    public void recompenseProprietaire() {}

    /**
     * Donne la récompense de prestige dû au joueur
     */
    public void recompensePrestige() {}

}
