package Caylus.Batiment.Neutre;

import Caylus.Batiment.Batiment;
import Caylus.View;

public class NMarche extends Batiment {
    private String[] choix = new String[]{"nourriture","tissu","bois","pierre","or"};
    private String recOuvrier;
    private String mess = "Choississez quoi donner";

    /**
     * Constructeur initialisant le nom
     */
    public NMarche(){
        super("NMarche");
    }


    public boolean isNeutre(){
        return true;
    }

    /**
     * Donne les récompenses aux personnes concerné
     * @return
     */
    public int active(View view){
        recOuvrier = view.panneauRecompense(choix,mess+" "+getNom()+" "+ouvrier.getNom());
        if(!recompenseOuvrier(recOuvrier))
            return -1;
        return 0;
    }
    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public boolean recompenseOuvrier(String choix) {
        if(ouvrier.donne(choix,1)){
            ouvrier.recoit("denier", 4);
            return true;
        }
        return false;
    }

}