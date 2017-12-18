package Caylus.Batiment.Prestige;

import Caylus.Batiment.Batiment;

public class Hotel extends Batiment {

    /**
     * Constructeur initialisant le nom, les couts de construction et le nombre de prestiges reçue à la construction
     */
    public Hotel(){
        super("Hotel");
        coutConst[0]=2;
        coutConst[1]=0;
        coutConst[2]=3;
        coutConst[3]=0;
        coutConst[4]=0;
        prestige=16;
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
        ouvrier.recoit("denier",2);
        return true;
    }
}

