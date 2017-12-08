package Caylus.Batiment.Neutre;

import Caylus.Batiment.Batiment;

public class NMarche extends Batiment {
    private String[] choix = new String[]{"nourriture","tissu","bois","pierre","or"};
    private String recOuvrier;
    private String mess1 = "Choississez quoi donnez";

    /**
     * Constructeur initialisant le nom
     */
    public NMarche(){
        super("NMarche");
    }
    public void active(){
        recOuvrier = view.panneauRecompense(choix,mess1);
        recompenseOuvrier(recOuvrier);
    }
    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public void recompenseOuvrier(String choix) {
        ouvrier.donne(choix,1);
        ouvrier.recoit("denier", 4);
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