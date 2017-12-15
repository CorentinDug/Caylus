package Caylus.Batiment.Residentiel;

import Caylus.Batiment.Batiment;

public class Residence extends Batiment {
        private static String nom = "Residence";

    /**
     * Constructeur initialisant le nom
     */
    public Residence(){
        super("Residence");
        prestige=2;
    }

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

