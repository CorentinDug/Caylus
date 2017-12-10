package Caylus.Batiment.Neutre;

import Caylus.Batiment.Batiment;
import Caylus.View;

import java.util.ArrayList;

public class NCharpentier extends Batiment {
    private ArrayList<String> choix;
    private String[] choixPossible;
    private String recOuvrier;

    /**
     * Constructeur initialisant le nom
     */
    public NCharpentier() {
        super("NCharpentier");
        mess = "Choisissez un batiment";
        choix = new ArrayList<>();
        choix.add("Carrière");
        choix.add("Notaire");
        choix.add("Scierie");
        choix.add("Marché");
        choix.add("Maçon");
        choix.add("Ferme Tissu");
        choix.add("Ferme Nourriture");
        choix.add("Colporteur");
    }

    public int active(View view) {
        choixPossible = new String[choix.size()];
        int i = 0;
        for (String choix : choix){
            choixPossible[i] = choix;
            i++;
        }
        recOuvrier = view.panneauRecompense(choixPossible,mess+" "+getNom()+" "+ouvrier.getNom());
        if(!recompenseOuvrier(recOuvrier))
            return 1;
        choix.remove(recOuvrier);
        return -2;
    }

    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public boolean recompenseOuvrier(String choix) {
        return ouvrier.fabriqueBat(choix);
    }



    /**
     * Donne la récompense de prestige dû au joueur
     */
    public void recompensePrestige() {

    }
}
