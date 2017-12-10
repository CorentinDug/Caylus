package Caylus.Batiment.Bois;
import Caylus.Batiment.Batiment;

public class BMacon extends Batiment {

    /**
     * Constructeur initialisant le nom
     */
    public BMacon(){
        super("BMaçon");
    }


    public void active(){
        recompenseOuvrier();
        recompenseProprietaire();
    }

    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public void recompenseOuvrier() {

    }



    /**
     * Donne la récompense de prestige dû au joueur
     */
    public void recompensePrestige() {

    }
}