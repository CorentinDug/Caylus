package Caylus.Batiment.Prestige;

import Caylus.Batiment.Batiment;

public class Bibliotheque extends Batiment {

    /**
     * Constructeur initialisant le nom, les couts de construction et le nombre de prestiges reçue à la construction
     */
    public Bibliotheque(){
        super("Bibliotheque");
        coutConst[0]=1;
        coutConst[1]=0;
        coutConst[2]=0;
        coutConst[3]=3;
        coutConst[4]=0;
        prestige=10;
    }

    /**
     * Donne les récompenses aux personnes concerné
     * @return
     */
    public int active(){
        recompenseOuvrier();
        return 0;
    }

    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public boolean recompenseOuvrier() {
        ouvrier.recoit("denier",1);
        return true;
    }
}
