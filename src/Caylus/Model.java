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
    protected int noPhase;
    protected int coutDePose;


    protected  Chateau chateau;
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
        noPhase=0;
        chateau = new Chateau();
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

    public int getDenier(int i) {
        int n = i - 1;
        if (listeJoueur[n] != null)
            return listeJoueur[n].getDenier();
        return  0;
    }

    public int getOr(int i) {
        int n = i - 1;
        if (listeJoueur[n] != null)
            return listeJoueur[n].getOr();
        return  0;
    }

    public int getNourriture(int i) {
        int n = i - 1;
        if (listeJoueur[n] != null)
            return listeJoueur[n].getNourriture();
        return  0;
    }

    public int getPierre(int i) {
        int n = i - 1;
        if (listeJoueur[n] != null)
            return listeJoueur[n].getPierre();
        return  0;
    }

    public int getBois(int i) {
        int n = i - 1;
        if (listeJoueur[n] != null)
            return listeJoueur[n].getBois();
        return  0;
    }

    public int getTissu(int i) {
        int n = i - 1;
        if (listeJoueur[n] != null)
            return listeJoueur[n].getTissu();
        return  0;
    }

    public Color getColor(int i) {
        int n = i - 1;
        if (listeJoueur[n] != null)
            return listeJoueur[n].getCouleur();
        return  null;
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
            view.editPJoueur();
        }

        for (Joueur joueur : listeJoueur) {
            ordreDeTour.add(joueur);
        }
        Collections.shuffle(ordreDeTour);
        Collections.shuffle(batNeutre);

    }

    public String getPhase(){
        if(noPhase==1)
            return "Perception des revenues";
        if(noPhase==2)
            return "Placement des ouvriers";
        if(noPhase==3)
            return "L’activation des bâtiment spéciaux";
        if(noPhase==4)
            return "Déplacement du prévôt";
        if(noPhase==5)
            return "L’activation des bâtiments";
        if(noPhase==6)
            return "Construction du château";
        if(noPhase==7)
            return "Fin de tour";
        return "Initialisation des ressources";
    }

    public String getInfoPhase(){
        if(noPhase==1)
            return "";
        if(noPhase==2)
            return "Le cout est de "+coutDePose+" deniers";
        if(noPhase==3)
            return "";
        if(noPhase==4)
            return "Déplacement du prévôt";
        if(noPhase==5)
            return "L’activation des bâtiments";
        if(noPhase==6)
            return "Construction du château";
        if(noPhase==7)
            return "Fin de tour";
        return "";
    }

    public String getTourJoueur(){
        if(noPhase==1 || noPhase==0 ||  noPhase==3)
            return "";
        return ordreDeTour.get(0).getNom();
    }


    public Batiment getBatiment(int coordonnee){
       return cases[coordonnee].getBatiment();
    }


    public void setView(View vue) {
        this.view = vue;
        view.setPrévot(prévot.coordonnée);
        view.setBaillis(baillis.coordonnée);
        view.initImageCase();

    }



    public void initRessource() {
        //changer label info
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
        noPhase++;
        view.editPJoueur();
    }

    public void phase1(){
        view.editPInfo();
        int revenue;
        for (Joueur joueur : listeJoueur) {
            revenue=2;
            for (Batiment propriété : joueur.propriété) {
                if(propriété.getNom().equals("Residence"))
                    revenue++;
                if(propriété.getNom().equals("Bibliothèque"))
                    revenue++;
                if(propriété.getNom().equals("Hotel"))
                    revenue+=2;
            }
            joueur.recoit("denier", revenue);
        }
        view.editPJoueur();
        coutDePose=1;
    }

    public void phase2(int i){
        poseOuvrier(i);
    }

    public void constChateau(){
        Joueur joueur = ordreDeTour.get(0);
        int coordonnée = chateau.ajouterConstructeur(joueur);
        if(coordonnée!=-1)
            if ( joueur.getDenier() >= coutDePose) {
                if(joueur.getOuvrier() != 0){
                    joueur.donne("denier",coutDePose);
                    joueur.poseOuvrier();
                    view.constChateau(coordonnée, joueur);
                    view.editPJoueur();
                }else{
                    view.problèmeOuvrier(joueur.getNom(), 2);
                }
            }else{
                view.problèmeOuvrier(joueur.getNom(), 4);
            }
        else{
            view.problèmeChateau(joueur.getNom(),1);
        }
    }

    public void poseOuvrier(int coordonnee) {
        Joueur joueur = ordreDeTour.get(0);
        if ( joueur.getDenier() >= coutDePose) {
            if (getBatiment(coordonnee) != null) {
                if (joueur.getOuvrier() != 0) {
                    if ( getBatiment(coordonnee).engager(joueur)) {
                        joueur.donne("denier",coutDePose);
                        joueur.poseOuvrier();
                        view.poserOuvrier(coordonnee, joueur);
                        view.editPJoueur();
                    } else {
                        view.problèmeOuvrier(joueur.getNom(), 3);
                    }
                }else{
                    view.problèmeOuvrier(joueur.getNom(), 2);
                }
            }else{
                view.problèmeOuvrier(joueur.getNom(), 1);
            }
        }else{
            view.problèmeOuvrier(joueur.getNom(), 4);
        }
    }

    public void joueurPasse(){
        if(finDePose.isEmpty())
            ordreDeTour.get(0).recoit("denier",1);
        finDePose.add( ordreDeTour.get(0));
        ordreDeTour.remove(0);
        coutDePose++;
        if(ordreDeTour.isEmpty())
            noPhase++;
        view.editPJoueur();
        view.editPInfo();
    }



}
