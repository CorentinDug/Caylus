import Batiment.Batiment;
import Batiment.Neutre.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Schnoeby on 19/11/2017.
 */
public class Partie {
    protected ArrayList<Joueur> listeJoueur;
    protected ArrayList<Joueur> finDePose;
    protected ArrayList<Joueur> ordreDeTour;

    protected ArrayList<String> batSpéciaux;
    protected ArrayList<String> batNeutre;
    protected ArrayList<String> batBois;
    protected ArrayList<String> batPierre;
    protected ArrayList<String> batPrestiqe;
    protected ArrayList<String> batResidentiel;

    protected Color[] couleur;
    protected int nbrJoueurs;
    protected Prévot prévot;
    protected Baillis baillis;

    public Partie(int joueurs){
        nbrJoueurs=joueurs;
        prévot = new Prévot();
        baillis = new Baillis();
        listeJoueur = new ArrayList<Joueur>();
        finDePose = new ArrayList<Joueur>();
        ordreDeTour = new ArrayList<Joueur>();
        initBatiment();
        initCouleur();
    }

    public void initCouleur( ){
        couleur = new Color[5];
        couleur[0]= Color.blue;
        couleur[1]= Color.red;
        couleur[2]= Color.green;
        couleur[3]= Color.orange;
        couleur[4]= Color.black;
    }

    public void initBatiment(){
        batNeutre = new ArrayList<>();
            batNeutre.add("NCarriere");
            batNeutre.add("NForet");
            batNeutre.add("NCharpentier");
            batNeutre.add("NMarche");
            batNeutre.add("NFerme");
            batNeutre.add("NScierie");

        batSpéciaux = new ArrayList<>();
            batSpéciaux.add("porte");
            batSpéciaux.add("banque");
            batSpéciaux.add("taverne2");
            batSpéciaux.add("joute");
            batSpéciaux.add("ecurie");
            batSpéciaux.add("taverne");


        batBois = new ArrayList<String>();
        batPierre = new ArrayList<String>();
        batPrestiqe = new ArrayList<String>();
        batResidentiel = new ArrayList<String>();
    }

    public void poseOuvrier(Joueur joueur){
        joueur.poseOuvrier();
    }

    public void initPartie() {
        for(Joueur joueur: listeJoueur){
            ordreDeTour.add(joueur);
        }
        Collections.shuffle(ordreDeTour);
        Collections.shuffle(batNeutre);
    }
}
