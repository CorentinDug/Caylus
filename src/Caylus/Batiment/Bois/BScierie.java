package Caylus.Batiment.Bois;

import Caylus.Batiment.Batiment;

public class BScierie extends Batiment {

    /**
     * Constructeur initialisant le nom, les couts de construction et le nombre de prestiges reçue à la construction
     */
    public BScierie(){
        super("Scierie");
        coutConst[0]=0;
        coutConst[1]=0;
        coutConst[2]=1;
        coutConst[3]=1;
        coutConst[4]=0;
        prestige=2;
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
        return true;
    }

}
