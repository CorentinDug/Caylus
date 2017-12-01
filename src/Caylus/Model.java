package Caylus;

import Caylus.Batiment.Batiment;
import Caylus.Batiment.Bois.*;
import Caylus.Batiment.Neutre.*;
import Caylus.Batiment.Pierre.*;
import Caylus.Batiment.Prestige.*;
import Caylus.Batiment.Residentiel.Residence;
import Caylus.Batiment.Speciaux.*;

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
    protected Joueur[] listeJoueur;
    private ArrayList<Joueur> finDePose;
    private ArrayList<Joueur> ordreDeTour;

    protected ArrayList<Batiment> batSpeciaux;
    protected ArrayList<Batiment> batNeutre;
    protected ArrayList<Batiment> batBois;
    protected ArrayList<Batiment> batPierre;
    protected ArrayList<Batiment> batPrestiqe;
    protected ArrayList<Batiment> batResidentiel;

    private Color[] couleur;

    protected Case[] cases;


    public Model(int nbrJoueur) {
        nbrJoueurs = nbrJoueur;
        prévot = new Prévot();
        baillis = new Baillis();
        listeJoueur = new Joueur[nbrJoueur];
        finDePose = new ArrayList<Joueur>();
        ordreDeTour = new ArrayList<Joueur>();
        initBatiment();
        initCouleur();
        initCases();
    }

    public String getNom(int i) {
        int n = i - 1;
        if (listeJoueur[n] != null)
            return listeJoueur[n].getNom();
        return "Joueur" + i;

    }

    public void initCouleur() {
        couleur = new Color[5];
        couleur[0] = Color.blue;
        couleur[1] = Color.red;
        couleur[2] = Color.green;
        couleur[3] = Color.orange;
        couleur[4] = Color.black;
    }

    public void initBatiment() {
        batNeutre = new ArrayList<>();
        batNeutre.add(new NCarriere());
        batNeutre.add(new NCharpentier());
        batNeutre.add(new NFerme());
        batNeutre.add(new NForet());
        batNeutre.add(new NMarche());
        batNeutre.add(new NScierie());

        batSpeciaux = new ArrayList<>();
        batSpeciaux.add(new Porte());
        batSpeciaux.add(new Comptoir());
        batSpeciaux.add(new DeplPrevot());
        batSpeciaux.add(new Joute());
        batSpeciaux.add(new Ecurie());
        batSpeciaux.add(new Auberge());


        batBois = new ArrayList<>();
        batBois.add(new BCarriere());
        batBois.add(new BColporteur());
        batBois.add(new BFermeNourriture());
        batBois.add(new BFermeSoie());
        batBois.add(new BMacon());
        batBois.add(new BMarche());
        batBois.add(new BNotaire());
        batBois.add(new BScierie());

        batPierre = new ArrayList<>();
        batPierre.add(new PAlchimiste());
        batPierre.add(new PArchitecte());
        batPierre.add(new PArchitecte());
        batPierre.add(new PAtelier());
        batPierre.add(new PBanque());
        batPierre.add(new PEglise());
        batPierre.add(new PFerme());
        batPierre.add(new PParc());
        batPierre.add(new PTailleur());

        batPrestiqe = new ArrayList<>();
        batPrestiqe.add(new Bibliotheque());
        batPrestiqe.add(new Cathedrale());
        batPrestiqe.add(new Grenier());
        batPrestiqe.add(new Hotel());
        batPrestiqe.add(new Monument());
        batPrestiqe.add(new Statue());
        batPrestiqe.add(new Theatre());
        batPrestiqe.add(new Tisserand());
        batPrestiqe.add(new Universite());

        batResidentiel = new ArrayList<>();
        for (int i = 0; i < 8; i++)
            batResidentiel.add(new Residence());

        Collections.shuffle(batNeutre);
    }

    public void initCases() {
        cases = new Case[34];
        for (int i = 0; i < 34; i++) {
            cases[i] = new Case();
        }
        int n = 0;
        for (int i = 0; i < 6; i++) {
            cases[i].setBatiment(batSpeciaux.get(n++));
        }
        n = 0;
        for (int i = 6; i < 12; i++) {
            cases[i].setBatiment(batNeutre.get(n++));
        }
    }

    public void initJoueur() {
        for (int i = 0; i < nbrJoueurs; i++) {
            String nom = view.créerJoueur(i + 1);
            Joueur joueur = new Joueur(nom);
            joueur.setCouleur(couleur[i]);
            listeJoueur[i] = joueur;
            view.editJoueur();
        }

        for (Joueur joueur : listeJoueur) {
            ordreDeTour.add(joueur);
        }
        Collections.shuffle(ordreDeTour);
        Collections.shuffle(batNeutre);

    }

    public void poseOuvrier(int coordonnees, Joueur joueur) {
        view.poserOuvrier(coordonnees, joueur);
    }

    public void setView(View vue) {
        this.view = vue;
        view.setPrévot(prévot.coordonnée);
        view.setBaillis(baillis.coordonnée);
        view.initImageCase();

    }

    public void initRessource() {
        int compteurJoueur=0;
        for (Joueur joueur : listeJoueur) {
            joueur.recoit("nourriture", 2);
            joueur.recoit("bois", 1);
            if(compteurJoueur==0)
                joueur.recoit("denier", 5);
            else if(compteurJoueur==1 || compteurJoueur==2)
                joueur.recoit("denier", 6);
            else
                joueur.recoit("denier", 7);
            compteurJoueur++;

        }
    }
}
