package Caylus.Batiment.Bois;
import Caylus.Batiment.Batiment;
import Caylus.View;

import java.util.ArrayList;

public class BMacon extends Batiment {
    private String[] choix;
    private String recOuvrier;

    /**
     * Constructeur initialisant le nom
     */
    public BMacon(){
        super("Macon");
        mess = "Choisissez un batiment";
        choix = new String[]{
                "Eglise 1 pierre + 1 tissu",
                "Parc 1 bois + 1 nourriture",
                "Banque 1 bois + 1 pierre",
                "Alchimiste 1 pierre + 1 nourriture",
                "Ferme 1 pierre + 1 nourriture",
                "Tailleur 1 bois + 1 tissu",
                "Atelier 1 pierre + 1 tissu",
                "Architecte 1 bois + 1 nouriture"};
        coutConst[0]=0;
        coutConst[1]=0;
        coutConst[2]=1;
        coutConst[3]=1;
        coutConst[4]=0;
        prestige=4;
    }

    public int active(View view) {
        recompenseProprietaire();
        recOuvrier = view.panneauRecompense(choix,mess+" "+getNom()+" "+ouvrier.getNom());
        if(!recompenseOuvrier(recOuvrier))
            return -1;
        return 10;
    }

    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public boolean recompenseOuvrier(String choix) {
        return ouvrier.fabriqueBat(choix);
    }

}