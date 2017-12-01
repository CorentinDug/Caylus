package Caylus;

import Caylus.Batiment.Batiment;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Schnoeby on 19/11/2017.
 */
public class Model {
    private View view;

    protected int nbrJoueurs;
    protected Prévot prévot;
    protected Baillis baillis;
    protected  Joueur[] listeJoueur;
    private ArrayList<Joueur> finDePose;
    private ArrayList<Joueur> ordreDeTour;

    private ArrayList<Batiment> batSpeciaux;
    private ArrayList<Batiment> batNeutre;
    private ArrayList<Batiment> batBois;
    private ArrayList<Batiment> batPierre;
    private ArrayList<Batiment> batPrestiqe;
    private ArrayList<Batiment> batResidentiel;

    private Color[] couleur;

    protected Case[] cases;


    public Model(int nbrJoueur){
        nbrJoueurs=nbrJoueur;
        prévot = new Prévot();
        baillis = new Baillis();
        listeJoueur = new Joueur[5];
        finDePose = new ArrayList<Joueur>();
        ordreDeTour = new ArrayList<Joueur>();
        initBatiment();
        initCouleur();
        initCases();
    }

    public String getNom(int i){
        int n=i-1;
        if(listeJoueur[n]!=null)
            return listeJoueur[n].getNom();
        return "Caylus.Joueur"+i;

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
        /*batNeutre = new ArrayList<>();
        batNeutre.add("NCarriere");
        batNeutre.add("NForet");
        batNeutre.add("NCharpentier");
        batNeutre.add("NMarche");
        batNeutre.add("NFerme");
        batNeutre.add("NScierie");*/

       /* batSpéciaux = new ArrayList<>();
        batSpéciaux.add("porte");
        batSpéciaux.add("banque");
        batSpéciaux.add("taverne2");
        batSpéciaux.add("joute");
        batSpéciaux.add("ecurie");
        batSpéciaux.add("taverne");*/


       /* batBois = new ArrayList<String>();
        batPierre = new ArrayList<String>();
        batPrestiqe = new ArrayList<String>();
        batResidentiel = new ArrayList<String>();
        Collections.shuffle(batNeutre);*/
    }

    public void initCases(){
        cases=new Case[34];
        for(int i = 0; i < 34; i++){
                cases[i] = new Case();
        }
        int n=0;
        for(int i = 33; i > 27; i--) {
            cases[i].setBatiment(batSpeciaux.get(n++));
        }
        n=0;
        for(int i = 27; i > 21; i--) {
            cases[i].setBatiment(batNeutre.get(n++));
        }
    }

    public void initJoueur(){
        for(int i=0; i<nbrJoueurs;i++){
            String nom = view.créerJoueur(i+1);
            Joueur joueur = new Joueur(nom);
            joueur.setCouleur(couleur[i]);
            listeJoueur[i]=joueur;
            view.editJoueur();
        }

        for(Joueur joueur: listeJoueur){
            ordreDeTour.add(joueur);
        }
        Collections.shuffle(ordreDeTour);
        Collections.shuffle(batNeutre);

    }

    public void poseOuvrier(int coordonnees, Joueur joueur){
        view.poserOuvrier(coordonnees, joueur);
    }

    public void setView(View vue) {
        this.view = vue;
        view.setPrévot(prévot.coordonnée);
        view.setBaillis(baillis.coordonnée);
        view.initListeImage();
        view.initImageCase();

    }

}
