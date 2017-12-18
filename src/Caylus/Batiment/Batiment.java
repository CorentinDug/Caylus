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
    protected int prestige;

    /**
     * Constructeur initialisant le nom, les couts de construction, les propriétaire, les ouvrière et le nombre de prestiges reçue à la construction
     * coutConst[0] correspond à l'or
     * coutConst[1] correspond à la nourriture
     * coutConst[2] correspond à la pierre
     * coutConst[3] correspond à le bois
     * coutConst[4] correspond à le tissu
     * @param nom Le nom du batiment
     */
    public Batiment(String nom){
        this.nom=nom;
        ouvrier=null;
        proprietaire=null;
        coutConst = new int[5];
        prestige=0;
    }

    /**
     * @return Retourne le nom du batiment
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne l'ouvrier du batiment
     * @return
     */
    public Joueur getOuvrier(){
        return ouvrier;
    }

    /**
     * @param index Numéro de l'ouvrier
     * @return Retourne un ouvrier du batiment en fonction de l'index
     */
    public Joueur getOuvrier(int index) {
        return null;
    }

    /**
     * @return Retourne le propriétaire du batiment
     */
    public Joueur getProprietaire(){return proprietaire;}

    /**
     * @param joueur Le joueur en paramètre devient l'ouvrier
     * @return Retourne vrai si l'ouvrier a été engagé
     */
    public boolean engager(Joueur joueur) {
        if(ouvrier!=null)
            return false;
        ouvrier=joueur;
        return true;
    }

    /**
     * Enlève l'ouvrier du batiment
     */
    public void retireOuvrier() {
        ouvrier = null;
    }

    /**
     * Retourne vrai si le batiment est neutre
     * @return
     */
    public boolean isNeutre(){
        return false;
    }

    /**
     * @return Retourne le nombre de prestige que l'on obtient à la fabrication
     */
    public int getPrestige() {
        return prestige;
    }

    /**
     * Change le propriétaire du batiment
     * @param proprietaire  Le joueur en paramètre devient le propriétaire
     */
    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }

    /**
     * Donne les récompenses aux personnes concerné
     * @return Retourne 0 si l'activation est standard
     */
    public int active(View view){return 0;}

    /**
     * Donne la récompense propriétaire dû au joueur
     */
    public boolean recompenseProprietaire() {
        if(proprietaire!=null && proprietaire!=ouvrier)
            proprietaire.recoit("prestige",1);
        return true;
    }

    /**
     *Donne la récompense ouvrière dû au joueur
     * @return Retourne vrai si la récompense a été attribué
     */
    public boolean recompenseOuvrier() {
        return true;
    }

    /**
     *
     * @return Retourne le tableau du cout de construction
     */
    public int[] coutContructon() {
        return  coutConst;
    }

}
