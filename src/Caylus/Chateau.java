package Caylus;

import java.util.ArrayList;

/**
 * Created by Schnoeby on 03/12/2017.
 */
public class Chateau {

    protected Joueur[] donjon;
    protected boolean compteurDonjon;
    protected Joueur[] muraille;
    protected boolean compteurMuraille;
    protected Joueur[] tour;
    protected boolean compteurTour;
    protected ArrayList<Joueur> ordreConstruction;
    protected int nbrPartie;
    protected String mess;
    private int position;

    /**
     * Constructeur initialisant les parties du chateau, l'ordre de construction et le message affiché lors de l'activation
     */
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


    /**
     * Permet au joueur de commencer à construire le chateau
     * @param view Permet d'afficher les fenêtre de dialogue
     * @return Retourne le nombre de partie du cahteau construit par le joueur
     */
    public int constPartie(View view) {
        Joueur joueur = ordreConstruction.get(0);
        nbrPartie = view.panneauChateau(joueur.getNom());
        if(nbrPartie==0){
            joueur.donne("prestige",2);
            view.problèmeActivation(-6,joueur.getNom(),null);
        }else{
            for (int i = 0; i <nbrPartie; i++) {
                String[] choix = new String[]{"or", "tissu", "bois", "pierre"};
                String[] choix2 = new String[3];
                boolean pose = false;
                String choixRes1 = view.panneauRecompense(choix, mess + "" + joueur.getNom() + " partie " + (i + 1));
                int n = 0;
                for (int j = 0; j < 4; j++) {
                    if (!choix[j].equals(choixRes1)) {
                        choix2[n] = choix[j];
                        n++;
                    }
                }
                String choixRes2 = view.panneauRecompense(choix2, mess + "" + joueur.getNom() + " partie " + (i + 1));
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
                        view.problèmeActivation(-5,joueur.getNom(),null);
                        joueur.donne("prestige", 2);
                        view.problèmeActivation(-6, joueur.getNom(), null);
                        nbrPartie--;
                    }
                }else{
                    view.problèmeActivation(-1,joueur.getNom(),null);
                    joueur.donne("prestige",2);
                    view.problèmeActivation(-6,joueur.getNom(),null);
                    nbrPartie--;
                }
                view.editPJoueur();
                view.editChateau();
            }
        }
        ordreConstruction.remove(joueur);
        return nbrPartie;
    }


    /**
     * Ajouter un joueur dans l'ordre de construction
     * @param joueur Le joueur à ajouter dans l'ordre de construction
     * @return Retourne -1 si le joueur est déjà dans l'ordre de construction ou l'index du joueur qui vient d'être ajouter
     */
    public int ajouterConstructeur(Joueur joueur){
        for(Joueur joueurs : ordreConstruction){
            if(joueurs==joueur)
                return  -1;
        }
        ordreConstruction.add(joueur);
        return ordreConstruction.size()-1;
    }

    public Joueur getConstructeur(int position) {
        Joueur constructeur;
        constructeur = ordreConstruction.get(position);
        return constructeur;
    }
}
