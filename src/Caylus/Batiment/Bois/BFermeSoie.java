package Caylus.Batiment.Bois;
import Caylus.Batiment.Batiment;

public class BFermeSoie extends Batiment {
    private String[] choix = new String[]{"2 Tissu", "nourriture"};
    private String recOuvrier;

    /**
     * Constructeur initialisant le nom
     */
    public BFermeSoie(){
        super("BFermeSoie");

    }

    public void active(){
        recOuvrier = view.panneauRecompense(choix,mess);
        recompenseOuvrier(recOuvrier);
    }

    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public void recompenseOuvrier(String choix) {
        if (choix.equals("2 Tissu")) {
            ouvrier.recoit("tissu", 2);
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