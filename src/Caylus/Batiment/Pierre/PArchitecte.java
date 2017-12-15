package Caylus.Batiment.Pierre;

import Caylus.Batiment.Batiment;
import Caylus.View;

public class PArchitecte extends Batiment {
    private String[] choix;
    private String recOuvrier;
    /**
     * Constructeur initialisant le nom
     */
    public PArchitecte(){
        super("PArchitecte");
        mess = "Choisissez un batiment";
        choix = new String[]{
                "Cathedrale 1 bois + 4 pierres + 3 or",
                "Monument 4 pierrs + 1 2 or",
                "Bibliothèque 3 bois + 1 or",
                "Grenier 3 nourriture + 1 or",
                "Tisserand 3 tissus + 1 or",
                "Statue 2 pierres + 1 or",
                "Theatre 3 bois + 2 or",
                "Université 3 pierres + 2 or",
                "Hotel 3 pierres + 2 or",
                "Residentiel"};
        coutConst[0]=0;
        coutConst[1]=1;
        coutConst[2]=0;
        coutConst[3]=1;
        coutConst[4]=0;
        prestige=6;
    }

    public int active(View view) {
        recOuvrier = view.panneauRecompense(choix,mess+" "+getNom()+" "+ouvrier.getNom());
        if(!recompenseOuvrier(recOuvrier))
            return -1;
        if(recOuvrier.equals("Residentiel"))
            return 11;
        return 12;
    }

    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public boolean recompenseOuvrier(String choix) {
        return ouvrier.fabriqueBat(choix);
    }

}