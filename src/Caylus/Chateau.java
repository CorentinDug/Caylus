package Caylus;

import java.util.ArrayList;

/**
 * Created by Schnoeby on 03/12/2017.
 */
public class Chateau {

    protected Joueur[] donjon;
    protected Joueur[] muraille;
    protected Joueur[] tour;
    protected ArrayList<Joueur> ordreConstruction;
    protected int nbrPartie;
    protected String mess;


    public  Chateau(){
        donjon= new Joueur[6];
        donjon= new Joueur[10];
        donjon= new Joueur[14];
        ordreConstruction = new ArrayList<>();
        mess = "Choisissez un nbr de partie";
    }

    public int constPartie(View view){
        for(Joueur joueur : ordreConstruction){
            nbrPartie = view.panneauChateau(joueur.getNom());
        }
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
