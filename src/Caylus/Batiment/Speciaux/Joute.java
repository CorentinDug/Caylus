package Caylus.Batiment.Speciaux;

import Caylus.Batiment.Batiment;

/**
 * Created by Schnoeby on 01/12/2017.
 */
public class Joute extends Batiment {
    private String[] choix = new String[]{"Oui", "Non"};
    private String recOuvrier;
    private String messJoute = "Payez la joute?";

    /**
     * Constructeur initialisant le nom
     */
    public Joute(){
        super("Joute");
    }

    public void active(){
        recOuvrier = view.panneauRecompense(choix,messJoute);
        if(recOuvrier.equals("Oui")) {
            recompenseOuvrier();
        }
    }
    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public void recompenseOuvrier() {
        ouvrier.donne("denier", 1);
        ouvrier.donne("tissu", 1);
        ouvrier.recoit("prestige", 1);
    }
}

