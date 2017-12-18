package Caylus.Batiment.Pierre;

import Caylus.Batiment.Batiment;

public class PTailleur extends Batiment {

    /**
     * Constructeur initialisant le nom, les couts de construction et le nombre de prestiges reçue à la construction
     */
    public PTailleur(){
        super("Tailleur");
        coutConst[0]=0;
        coutConst[1]=0;
        coutConst[2]=0;
        coutConst[3]=1;
        coutConst[4]=1;
        prestige=6;
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
        if(ouvrier.donne("tissu", 2)){
            ouvrier.recoit("prestige",4);
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
        if(proprietaire.donne("tissu", 3)){
            proprietaire.recoit("prestige",6);
            return true;
        }
        return false;
    }
}
