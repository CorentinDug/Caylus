package Caylus.Batiment.Pierre;

import Caylus.Batiment.Batiment;

public class PEglise extends Batiment {

    /**
     * Constructeur initialisant le nom, les couts de construction et le nombre de prestiges reçue à la construction
     */
    public PEglise(){
        super("Eglise");
        coutConst[0]=0;
        coutConst[1]=0;
        coutConst[2]=1;
        coutConst[3]=0;
        coutConst[4]=1;
        prestige=3;
    }

    /**
     * Donne les récompenses aux personnes concerné
     * @return
     */
    public int active(){
        int retour=0;
        if(!recompenseOuvrier()){
            retour =-1;
        }
        if(!recompenseProprietaire()){
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
    public boolean recompenseOuvrier() {
        if(ouvrier.donne("deniers", 4)){
            ouvrier.recoit("prestige",5);
            return true;
        }
        return false;
    }

    /**
     * Donne la récompense propriétaire dû au joueur
     */
    public boolean recompenseProprietaire() {
        if(proprietaire!=null && proprietaire!=ouvrier)
            proprietaire.recoit("prestige",1);
        if(proprietaire.donne("deniers", 5)){
            proprietaire.recoit("or",2);
            return true;
        }
        return false;
    }
}
