package Caylus.Batiment.Pierre;

import Caylus.Batiment.Batiment;

public class PAlchimiste extends Batiment {
    private String[] choixProprio = new String[]{"1 de chaque","2 nourritures + 1 tissu + 1 bois","2 nourritures + 1 tissu + 1 pierre","2 nourritures + 1 pierre + 1 bois","3 nourritures + 1 tissu" ,"3 nourritures + 1 bois" ,"3 nourritures + 1 pierre","4 nourritures","2 tissus + 1 nourriture + 1 bois","2 tissus + 1 pierre + 1 bois","2 tissus + 1 nourriture + 1 pierre","3 tissus + 1 nourriture","3 tissus + 1 bois","3 tissus + 1 pierre","4 tissus","2 pierres+ 1 nourriture + 1 tissu","2 pierres+ 1 bois + 1 tissu","2 pierres+ 1 nourriture + 1 bois","3 pierres + 1 nourriture","3 pierres + 1 bois","3 pierres + 1 tissu","4 pierres","2 bois+ 1 nourriture + 1 tissu","2 bois+ 1 pierre+ 1 tissu","2 bois+ 1 nourriture + 1 pierre","3 bois+ 1 nourriture","3 bois+ 1 pierre","3 bois+ 1 tissu","4 bois"};
    private String[] choixOuvrier = new String[]{"1 nourriture + 1 tissu","1 nourriture + 1 pierre","1 nourriture + 1 bois","2 nourritures","1 tissu + 1 pierre","1 tissu + 1 bois","2 tissus","1 pierre + 1 bois","2 pierres","2 bois"};
    private String recOuvrier;
    private String recProprio;
    private String messProprio = "Proprietaire choix dons";
    /**
     * Constructeur initialisant le nom
     */
    public PAlchimiste(){
        super("PAlchimiste");
    }

    public void active(){
        recOuvrier = view.panneauRecompense(choixOuvrier,mess);
        recompenseOuvrier(recOuvrier);
        recProprio = view.panneauRecompense(choixProprio,messProprio);
        recompenseProprietaire(recProprio);
    }

    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public void recompenseOuvrier(String choix) {
        ouvrier.recoit("or",1);
        switch (choix) {
            case "1 nourriture + 1 tissu":
                ouvrier.donne("nourriture", 1);
                ouvrier.donne("tissu", 1);
                break;
            case "1 nourriture + 1 pierre":
                ouvrier.donne("nourriture",1);
                ouvrier.donne("pierre",1);
                break;
            case "1 nourriture + 1 bois":
                ouvrier.donne("nourriture",1);
                ouvrier.donne("bois",1);
                break;
            case "2 nourritures":
                ouvrier.donne("nourriture",1);
                break;
            case "1 tissu + 1 pierre":
                ouvrier.donne("tissu",1);
                ouvrier.donne("pierre",1);
                break;
            case "1 tissu + 1 bois":
                ouvrier.donne("tissu",1);
                ouvrier.donne("bois",1);
                break;
            case "2 tissus":
                ouvrier.donne("tissu",2);
                break;
            case "1 pierre + 1 bois":
                ouvrier.donne("pierre",1);
                ouvrier.donne("bois",1);
                break;
            case "2 pierres":
                ouvrier.donne("pierre",2);
                break;
            case "2 bois":
                ouvrier.donne("bois",2);
                break;
        }
    }

    /**
     * Donne la récompense propriétaire dû au joueur
     */
    public void recompenseProprietaire(String choix) {
        switch(choix){
            case "1 de chaque":
                proprietaire.donne("nourriture", 1);
                proprietaire.donne("tissu", 1);
                proprietaire.donne("bois", 1);
                proprietaire.donne("pierre", 1);
                break;
            case "2 nourritures + 1 tissu + 1 bois":
                proprietaire.donne("nourriture", 2);
                proprietaire.donne("tissu", 1);
                proprietaire.donne("bois", 1);
                break;
            case "2 nourritures + 1 tissu + 1 pierre":
                proprietaire.donne("nourriture", 2);
                proprietaire.donne("tissu", 1);
                proprietaire.donne("pierre", 1);
                break;
            case "2 nourritures + 1 pierre + 1 bois":
                proprietaire.donne("nourriture", 2);
                proprietaire.donne("bois", 1);
                proprietaire.donne("pierre", 1);
                break;
            case "3 nourritures + 1 tissu":
                proprietaire.donne("nourriture", 3);
                proprietaire.donne("tissu", 1);
                break;
            case "3 nourritures + 1 bois":
                proprietaire.donne("nourriture", 3);
                proprietaire.donne("bois", 1);
                break;
            case "3 nourritures + 1 pierre":
                proprietaire.donne("nourriture", 3);
                proprietaire.donne("pierre", 1);
                break;
            case "4 nourritures":
                proprietaire.donne("nourriture", 4);
                break;
            case "2 tissus + 1 nourriture + 1 bois":
                proprietaire.donne("tissu", 2);
                proprietaire.donne("nourriture", 1);
                proprietaire.donne("bois", 1);
                break;
            case "2 tissus + 1 pierre + 1 bois":
                proprietaire.donne("tissu", 2);
                proprietaire.donne("pierre", 1);
                proprietaire.donne("bois", 1);
                break;
            case "2 tissus + 1 nourriture + 1 pierre":
                proprietaire.donne("tissu", 2);
                proprietaire.donne("pierre", 1);
                proprietaire.donne("nourriture", 1);
                break;
            case "3 tissus + 1 nourriture":
                proprietaire.donne("tissu", 3);
                proprietaire.donne("nourriture", 1);
                break;
            case "3 tissus + 1 bois":
                proprietaire.donne("tissu", 3);
                proprietaire.donne("bois", 1);
                break;
            case "3 tissus + 1 pierre":
                proprietaire.donne("tissu", 3);
                proprietaire.donne("pierre", 1);
                break;
            case "4 tissus":
                proprietaire.donne("tissu", 4);
                break;
            case "2 pierres+ 1 nourriture + 1 tissu":
                proprietaire.donne("pierre", 2);
                proprietaire.donne("nourriture", 1);
                proprietaire.donne("tissu", 1);
                break;
            case "2 pierres+ 1 bois + 1 tissu":
                proprietaire.donne("pierre", 2);
                proprietaire.donne("bois", 1);
                proprietaire.donne("tissu", 1);
                break;
            case "2 pierres+ 1 nourriture + 1 bois":
                proprietaire.donne("pierre", 2);
                proprietaire.donne("nourriture", 1);
                proprietaire.donne("bois", 1);
                break;
            case "3 pierres + 1 nourriture":
                proprietaire.donne("pierre", 3);
                proprietaire.donne("nourriture", 1);
                break;
            case "3 pierres + 1 bois":
                proprietaire.donne("pierre", 3);
                proprietaire.donne("bois", 1);
                break;
            case "3 pierres + 1 tissu":
                proprietaire.donne("pierre", 3);
                proprietaire.donne("tissu", 1);
                break;
            case "4 pierres":
                proprietaire.donne("pierre", 4);
                break;
            case "2 bois+ 1 nourriture + 1 tissu":
                proprietaire.donne("bois", 2);
                proprietaire.donne("nourriture", 1);
                proprietaire.donne("tissu", 1);
                break;
            case "2 bois+ 1 pierre+ 1 tissu":
                proprietaire.donne("bois", 2);
                proprietaire.donne("pierre", 1);
                proprietaire.donne("tissu", 1);
                break;
            case "2 bois+ 1 nourriture + 1 pierre":
                proprietaire.donne("bois", 2);
                proprietaire.donne("nourriture", 1);
                proprietaire.donne("pierre", 1);
                break;
            case "3 bois+ 1 nourriture":
                proprietaire.donne("bois", 3);
                proprietaire.donne("nourriture", 1);
                break;
            case "3 bois+ 1 pierre":
                proprietaire.donne("bois", 3);
                proprietaire.donne("pierre", 1);
                break;
            case "3 bois+ 1 tissu":
                proprietaire.donne("bois", 3);
                proprietaire.donne("tissu", 1);
                break;
            case "4 bois":
                proprietaire.donne("bois", 4);
                break;
        }

    }

    /**
     * Donne la récompense de prestige dû au joueur
     */
    public void recompensePrestige() {

    }
}