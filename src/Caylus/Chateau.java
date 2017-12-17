package Caylus;

import jdk.nashorn.internal.scripts.JO;

import java.util.ArrayList;

/**
 * Created by Schnoeby on 03/12/2017.
 */
public class Chateau {

    private String[] choix;
    private String[] choix2;
    private String choixRes1;
    private String choixRes2;
    protected Joueur[] donjon;
    protected boolean compteurDonjon;
    protected Joueur[] muraille;
    protected boolean compteurMuraille;
    protected Joueur[] tour;
    protected boolean compteurTour;
    protected ArrayList<Joueur> ordreConstruction;
    protected int nbrPartie;
    protected String mess;


    public Chateau() {
        donjon = new Joueur[6];
        compteurDonjon = false;
        muraille = new Joueur[10];
        compteurMuraille = false;
        tour = new Joueur[14];
        compteurTour = false;
        ordreConstruction = new ArrayList<>();
        mess = "Choisissez quoi donner";
    }

    public int constPartie(View view) {
        Joueur joueur = ordreConstruction.get(0);
        nbrPartie = view.panneauChateau(joueur.getNom());
        if(nbrPartie==0){
            joueur.donne("prestige",2);
            view.problèmeConstruction(-6,joueur.getNom(),null);
        }else{
            for (int i = 0; i <nbrPartie; i++) {
                choix = new String[]{"or", "tissu", "bois", "pierre"};
                choix2 = new String[3];
                boolean pose = false;
                choixRes1 = view.panneauRecompense(choix, mess+""+joueur.getNom()+" partie "+ (i+1));
                int n = 0;
                for (int j = 0; j < 4; j++) {
                    if (!choix[j].equals(choixRes1)) {
                        choix2[n] = choix[j];
                        n++;
                    }
                }
                choixRes2 = view.panneauRecompense(choix2, mess+""+joueur.getNom()+" partie "+ (i+1));
                if (joueur.donne("nourriture", 1) && joueur.donne(choixRes1, 1) && joueur.donne(choixRes2, 1)) {
                    view.editPJoueur();
                    if (!compteurDonjon) {
                        for (int j = 0; j < donjon.length; j++) {
                            if (donjon[j] == null && !pose) {
                                donjon[j] = joueur;
                                joueur.recoit("prestige",5);
                                pose = true;
                            }
                        }

                        if (donjon[5]!=null){
                            compteurDonjon = true;
                        }

                    } else if (!compteurMuraille) {
                        for (int j = 0; j < muraille.length; j++) {
                            if (muraille[j] == null && !pose ) {
                                muraille[j] = joueur;
                                joueur.recoit("prestige",4);
                                pose = true;
                            }
                        }

                        if (muraille[9]!=null)
                            compteurMuraille = true;

                    } else if (!compteurTour) {
                        for (int j = 0; j < tour.length; j++) {
                            if (tour[j] == null && !pose) {
                                tour[j] = joueur;
                                joueur.recoit("prestige",3);
                                pose = true;
                            }
                        }
                        if (tour[13]!=null){
                            compteurTour = true;
                            nbrPartie--;
                        }
                    }else {
                        view.problèmeConstruction(-5,joueur.getNom(),null);
                        joueur.donne("prestige", 2);
                        view.problèmeConstruction(-6, joueur.getNom(), null);
                        nbrPartie--;
                    }
                }else{
                    view.problèmeConstruction(-1,joueur.getNom(),null);
                    joueur.donne("prestige",2);
                    view.problèmeConstruction(-6,joueur.getNom(),null);
                    nbrPartie--;
                }
                view.editPJoueur();
                view.editChateau();
            }
        }
        ordreConstruction.remove(joueur);
        return nbrPartie;
    }


    public int ajouterConstructeur(Joueur joueur){
        for(Joueur joueurs : ordreConstruction){
            if(joueurs==joueur)
                return  -1;
        }
        ordreConstruction.add(joueur);
        return ordreConstruction.size()-1;
    }

}
