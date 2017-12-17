package Caylus.Batiment.Pierre;

import Caylus.Batiment.Batiment;

public class PAlchimiste extends Batiment {
    private String[] choixOuvrier = new String[]{"1 nourriture + 1 tissu","1 nourriture + 1 pierre","1 nourriture + 1 bois","2 nourritures","1 tissu + 1 pierre","1 tissu + 1 bois","2 tissus","1 pierre + 1 bois","2 pierres","2 bois"};
    private String[] choix = new String[]{"nourriture","tissu","bois","pierre"};
    private String recOuvrier;
    private String recProprio;
    private String messProprio = "Proprietaire choix dons";
    /**
     * Constructeur initialisant le nom
     */
    public PAlchimiste(){
        super("PAlchimiste");
        coutConst[0]=0;
        coutConst[1]=1;
        coutConst[2]=0;
        coutConst[3]=1;
        coutConst[4]=0;
        prestige=6;
    }

    public int active(){
        recOuvrier = view.panneauRecompense(choixOuvrier,mess);
        recompenseOuvrier(recOuvrier);
        recompenseProprietaire();
        return 0;
    }

    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public void recompenseOuvrier(String choix) {
        boolean aDonné=false;
        switch (choix) {
            case "1 nourriture + 1 tissu":
                if(ouvrier.donne("nourriture", 1))
                    if( ouvrier.donne("tissu", 1))
                        aDonné=true;
                break;
            case "1 nourriture + 1 pierre":
                if(ouvrier.donne("nourriture", 1))
                    if( ouvrier.donne("pierre", 1))
                        aDonné=true;
                break;
            case "1 nourriture + 1 bois":
                if(ouvrier.donne("nourriture", 1))
                    if( ouvrier.donne("bois", 1))
                        aDonné=true;
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
        if(aDonné == true)
            ouvrier.recoit("or",1);
    }

    /**
     * Donne la récompense propriétaire dû au joueur
     */
    public boolean recompenseProprietaire() {
        if(proprietaire!=null && proprietaire!=ouvrier) {
            proprietaire.recoit("prestige", 1);
        }
       for (int i = 0; i<4; i++){
           recProprio = view.panneauRecompense(choix,mess);
           proprietaire.recoit(recProprio, 1);
       }

        return true;
    }

}