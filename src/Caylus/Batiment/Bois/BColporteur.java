package Caylus.Batiment.Bois;
import Caylus.Batiment.Batiment;
import Caylus.Joueur;

public class BColporteur extends Batiment {
    private String[] choix = new String[]{"nourriture","tissu","bois","pierre","or"};
    private String[] choixProprio = new String[]{"1 nourriture + 1 tissu","1 nourriture + 1 pierre","1 nourriture + 1 bois","2 nourritures","1 tissu + 1 pierre","1 tissu + 1 bois","2 tissus","1 pierre + 1 bois","2 pierres","2 bois"};

    private String recOuvrier;
    private String recProprio;
    private String messProprio = "Proprietaire choix récompense";

    /**
     * Constructeur initialisant le nom
     */
    public BColporteur(){
        super("BColporteur");
    }


    public void active(){
        recOuvrier = view.panneauRecompense(choix,mess);
        recompenseOuvrier(recOuvrier);
        recProprio = view.panneauRecompense(choixProprio,messProprio);
        recompenseProprietaire(recProprio);
    }


    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public void recompenseOuvrier(String chaine) {
        ouvrier.recoit(chaine, 1);
    }

    /**
     * Donne la récompense propriétaire dû au joueur
     */
    public void recompenseProprietaire(String choix) {
        switch (choix) {
            case "1 nourriture + 1 tissu":
                ouvrier.recoit("nourriture", 1);
                ouvrier.recoit("tissu", 1);
                break;
            case "1 nourriture + 1 pierre":
                ouvrier.recoit("nourriture",1);
                ouvrier.recoit("pierre",1);
                break;
            case "1 nourriture + 1 bois":
                ouvrier.recoit("nourriture",1);
                ouvrier.recoit("bois",1);
                break;
            case "2 nourritures":
                ouvrier.recoit("nourriture",1);
                break;
            case "1 tissu + 1 pierre":
                ouvrier.recoit("tissu",1);
                ouvrier.recoit("pierre",1);
                break;
            case "1 tissu + 1 bois":
                ouvrier.recoit("tissu",1);
                ouvrier.recoit("bois",1);
                break;
            case "2 tissus":
                ouvrier.recoit("tissu",2);
                break;
            case "1 pierre + 1 bois":
                ouvrier.recoit("pierre",1);
                ouvrier.recoit("bois",1);
                break;
            case "2 pierres":
                ouvrier.recoit("pierre",2);
                break;
            case "2 bois":
                ouvrier.recoit("bois",2);
                break;
        }
    }

    /**
     * Donne la récompense de prestige dû au joueur
     */
    public void recompensePrestige() {

    }
}