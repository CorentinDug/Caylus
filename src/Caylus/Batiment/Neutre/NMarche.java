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

    public int active(View view){
        recOuvrier = view.panneauRecompense(choix,mess+" "+getNom()+" "+ouvrier.getNom());
        if(!recompenseOuvrier(recOuvrier))
            return 1;
        return -1;
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

    /**
     * Donne la récompense propriétaire dû au joueur
     */
    public void recompenseProprietaire() {

    }

    /**
     * Donne la récompense de prestige dû au joueur
     */
    public void recompensePrestige() {

    }
}