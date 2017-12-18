package Caylus.Batiment.Neutre;


import Caylus.Batiment.Batiment;
import Caylus.View;

public class NFerme extends Batiment {
    private String[] choix = new String[]{"nourriture","tissu"};
    private String recOuvrier;

    /**
     * Constructeur initialisant le nom
     */
    public NFerme(){
        super("NFerme");
    }

    /**
     *  Renvoie true si le batiment est une batiments neutre
     */
    public boolean isNeutre(){
        return true;
    }

    /**
     * Donne les récompenses aux personnes concerné
     * @return
     */
    public int active(View view){
        recOuvrier = view.panneauRecompense(choix,mess+" "+getNom()+" "+ouvrier.getNom());
        recompenseOuvrier(recOuvrier);
        return 0;
    }
    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public void recompenseOuvrier(String choix) {
        ouvrier.recoit(choix,1);
    }

}
