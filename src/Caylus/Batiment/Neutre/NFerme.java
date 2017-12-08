package Caylus.Batiment.Neutre;


import Caylus.Batiment.Batiment;

public class NFerme extends Batiment {
    private String[] choix = new String[]{"nourriture","tissu"};
    private String recOuvrier;
    /**
     * Constructeur initialisant le nom
     */
    public NFerme(){
        super("NFerme");
    }

    public void active(){
        recOuvrier = view.panneauRecompense(choix,mess);
        recompenseOuvrier(recOuvrier);
    }
    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public void recompenseOuvrier(String choix) {
        ouvrier.recoit(choix,1);
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
