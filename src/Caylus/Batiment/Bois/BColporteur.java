package Caylus.Batiment.Bois;
import Caylus.Batiment.Batiment;
import Caylus.Joueur;

public class BColporteur extends Batiment {
    private String[] choix = new String[]{"nourriture","tissu","bois","pierre"};
    private String[] choixProprio = new String[]{"1 nourriture + 1 tissu","1 nourriture + 1 pierre","1 nourriture + 1 bois","2 nourritures","1 tissu + 1 pierre","1 tissu + 1 bois","2 tissus","1 pierre + 1 bois","2 pierres","2 bois"};

    private String recOuvrier;
    private String recProprio;
    private String messProprio = "Proprietaire choix récompense";

    /**
     * Constructeur initialisant le nom
     */
    public BColporteur(){
        super("BColporteur");
        coutConst[0]=0;
        coutConst[1]=0;
        coutConst[2]=0;
        coutConst[3]=1;
        coutConst[4]=0;
        prestige=4;
    }




    public int active(){
        int retour=0;
        recOuvrier = view.panneauRecompense(choix,mess);
        if(!recompenseOuvrier(recOuvrier)){
            retour =-1;
        }
        recProprio = view.panneauRecompense(choixProprio,messProprio);
        if(!recompenseProprietaire(recProprio)){
            if(retour ==-1)
                retour = -3;
            else
                retour = -2;
        }
        return retour;
    }


    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public boolean recompenseOuvrier(String chaine) {
        if(ouvrier.donne("denier", 2)){
            ouvrier.recoit(chaine, 1);
            return true;
        }
        return false;
    }

    /**
     * Donne la récompense propriétaire dû au joueur
     */
    public boolean recompenseProprietaire(String choix) {
        if(proprietaire!=ouvrier)
            proprietaire.recoit("prestige",1);
        if(proprietaire.donne("denier",2)){
            switch (choix) {
                case "1 nourriture + 1 tissu":
                    proprietaire.recoit("nourriture", 1);
                    proprietaire.recoit("tissu", 1);
                    break;
                case "1 nourriture + 1 pierre":
                    proprietaire.recoit("nourriture",1);
                    proprietaire.recoit("pierre",1);
                    break;
                case "1 nourriture + 1 bois":
                    proprietaire.recoit("nourriture",1);
                    proprietaire.recoit("bois",1);
                    break;
                case "2 nourritures":
                    proprietaire.recoit("nourriture",1);
                    break;
                case "1 tissu + 1 pierre":
                    proprietaire.recoit("tissu",1);
                    proprietaire.recoit("pierre",1);
                    break;
                case "1 tissu + 1 bois":
                    proprietaire.recoit("tissu",1);
                    proprietaire.recoit("bois",1);
                    break;
                case "2 tissus":
                    ouvrier.recoit("tissu",2);
                    break;
                case "1 pierre + 1 bois":
                    proprietaire.recoit("pierre",1);
                    proprietaire.recoit("bois",1);
                    break;
                case "2 pierres":
                    proprietaire.recoit("pierre",2);
                    break;
                case "2 bois":
                    proprietaire.recoit("bois",2);
                    break;
            }
            return true;
        }
       return false;
    }

    /**
     * Donne la récompense de prestige dû au joueur
     */
    public void recompensePrestige() {

    }
}