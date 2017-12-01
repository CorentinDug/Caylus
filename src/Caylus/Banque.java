package Caylus;

/**
 * Created by Schnoeby on 11/11/2017.
 */
public class Banque {
    private int denier;
    private int nourriture;
    private int tissu;
    private int bois;
    private int pierre;
    private int or;


    public Banque(){
        denier=80;
        nourriture=30;
        tissu=30;
        bois=30;
        pierre=30;
        or=20;
    }

    public int getDenier() {
        return denier;
    }

    public int getNourriture() {
        return nourriture;
    }

    public int getTissu() {
        return tissu;
    }

    public int getBois() {
        return bois;
    }

    public int getPierre() {
        return pierre;
    }

    public int getOr() {
        return or;
    }

    public void recoit(Joueur joueur, String ressource, int quantité){
        joueur.donne(ressource,quantité);
        switch (ressource){
            case "denier":
                denier+=quantité;
                break;
            case "nourriture":
                nourriture+=quantité;
                break;
            case "tissu":
                tissu+=quantité;
                break;
            case "bois":
                bois+=quantité;
                break;
            case "pierre":
                pierre+=quantité;
                break;
            case "or":
                or+=quantité;
                break;
        }
    }

    public void donne(Joueur joueur, String ressource, int quantité){
        joueur.recoit(ressource,quantité);
        switch (ressource){
            case "denier":
                denier-=quantité;
                break;
            case "nourriture":
                nourriture-=quantité;
                break;
            case "tissu":
                tissu-=quantité;
                break;
            case "bois":
                bois-=quantité;
                break;
            case "pierre":
                pierre-=quantité;
                break;
            case "or":
                or-=quantité;
                break;
        }
    }


}
