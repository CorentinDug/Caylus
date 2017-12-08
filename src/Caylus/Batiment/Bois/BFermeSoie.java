package Caylus.Batiment.Bois;
import Caylus.Batiment.Batiment;

public class BFermeSoie extends Batiment {

    /**
     * Constructeur initialisant le nom
     */
    public BFermeSoie(){
        super("BFermeSoie");

    }

    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public void recompenseOuvrier(String choix) {
        if (choix.equals("soie")) {
            ouvrier.recoit(choix, 2);
        }else{
            ouvrier.recoit(choix,1);
        }
    }

    /**
     * Donne la récompense propriétaire dû au joueur
     */
    public void recompenseProprietaire() {

    }

    /**
     * Donne la récompense de prestige dû au joueur
     */
    public void recompensePrestige() {

    }
}