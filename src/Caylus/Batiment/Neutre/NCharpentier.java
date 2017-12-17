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
        choix.add("Carrière  1 bois + 1 pierre");
        choix.add("Notaire 1 bois + 1 tissu");
        choix.add("Scierie 1bois + 1pierre");
        choix.add("Marché 1 bois + 1 ressource");
        choix.add("Maçon 1 bois + 1 pierre");
        choix.add("Ferme Tissu 1 bois + 1 nourriture");
        choix.add("Ferme Nourriture  1 bois + 1 nourriture");
        choix.add("Colporteur 1 bois + 1 ressource");
    }

    public boolean isNeutre(){
        return true;
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
            return -1;
        choix.remove(recOuvrier);
        return 10;
    }

    /**
     *  Donne la récompense ouvrière dû au joueur
     */
    public boolean recompenseOuvrier(String choix) {
        return ouvrier.fabriqueBat(choix);
    }

}
