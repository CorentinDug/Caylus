package Caylus.Batiment.Pierre;

import Caylus.Batiment.Batiment;

public class PParc extends Batiment {
    private String[] choix = new String[]{"bois","nouriture"};
    private String recProprio;

    /**
     * Constructeur initialisant le nom, les couts de construction et le nombre de prestiges reçue à la construction
     */
    public PParc(){
        super("Parc");
        coutConst[0]=0;
        coutConst[1]=1;
        coutConst[2]=0;
        coutConst[3]=1;
        coutConst[4]=0;
        prestige=3;
    }

    /**
     * Donne les récompenses aux personnes concerné
     * @return
     */
    public int active(){
        recompenseOuvrier();
        recompenseProprietaire();
        return 0;
    }


    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public boolean recompenseOuvrier() {
        ouvrier.recoit("bois", 2);
        ouvrier.recoit("nourriture", 1);
        return true;
    }


    /**
     * Donne la récompense propriétaire dû au joueur
     */
    public boolean recompenseProprietaire() {
        if(proprietaire!=null && proprietaire!=ouvrier)
            proprietaire.recoit("prestige",1);
        recProprio = view.panneauRecompense(choix,mess);
        proprietaire.recoit(recProprio,1);
        return true;
    }
}