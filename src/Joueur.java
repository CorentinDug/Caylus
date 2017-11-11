/**
 * Created by Schnoeby on 11/11/2017.
 */
public class Joueur {
    private String nom;
    private int denier;
    private int nourriture;
    private int tissu;
    private int bois;
    private int pierre;
    private int or;
    private int ouvrier;
    private int maison;
    private int prestige;

    public Joueur(String nom) {
        this.nom = nom;
        prestige = 0;
    }

    public String getNom() {
        return nom;
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

    public int getOuvier() {
        return ouvrier;
    }

    public int getMaison() {
        return maison;
    }

    public int getPrestige() {
        return prestige;
    }

    public void donne(String ressource, int quantité) {
        switch (ressource) {
            case "denier":
                denier -=quantité;
                break;
            case "nourriture":
                nourriture -=quantité;
                break;
            case "tissu":
                tissu -=quantité;
                break;
            case "bois":
                bois -=quantité;
                break;
            case "pierre":
                pierre -=quantité;
                break;
            case "or":
                or-=quantité;
                break;
            case "ouvrier":
                ouvrier-=quantité;
                break;
            case "maison":
                maison -=quantité;
                break;
            case "prestige":
                prestige-=quantité;
                break;
        }
    }

    public void recoit(String ressource, int quantité) {
        switch (ressource) {
            case "denier":
                denier +=quantité;
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
                pierre +=quantité;
                break;
            case "or":
                or+=quantité;
                break;
            case "ouvrier":
                ouvrier +=quantité;
                break;
            case "maison":
                maison +=quantité;
                break;
            case "prestige":
                maison +=quantité;
                break;
        }
    }
}
