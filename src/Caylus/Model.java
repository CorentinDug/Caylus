package Caylus;

import Caylus.Batiment.Batiment;
import Caylus.Batiment.Bois.*;
import Caylus.Batiment.Neutre.*;
import Caylus.Batiment.Pierre.*;
import Caylus.Batiment.Prestige.*;
import Caylus.Batiment.Residentiel.Residence;
import Caylus.Batiment.Speciaux.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;


import javax.swing.Timer;


/**
 * Created by Schnoeby on 19/11/2017.
 */
public class Model {
    private View view;

    protected int nbrJoueurs;
    protected int noPhase;
    protected int coutDePose;
    protected int compteurBat;

    protected  Chateau chateau;
    protected Prévot prévot;
    protected Baillis baillis;
    public Joueur[] listeJoueur;
    private ArrayList<Joueur> finDePose;
    private ArrayList<Joueur> ordreDeTour;
    private ArrayList<Joueur> ordreDePhase2;


    protected ArrayList<Batiment> batSpeciaux;
    protected ArrayList<Batiment> batNeutre;


    private Color[] couleur;

    protected Case[] cases;

    protected String[] Ressources;

    public Model(int nbrJoueur) {
        noPhase=0;
        chateau = new Chateau();
        nbrJoueurs = nbrJoueur;
        prévot = new Prévot();
        baillis = new Baillis();
        listeJoueur = new Joueur[nbrJoueur];
        finDePose = new ArrayList<Joueur>();
        ordreDeTour = new ArrayList<Joueur>();
        ordreDePhase2 = new ArrayList<Joueur>();
        Ressources =  new String[] {"denier","nourriture","tissu","bois","pierre","or"};
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

    public int getPrestige(int i) {
        int n = i - 1;
        if (listeJoueur[n] != null)
            return listeJoueur[n].getPrestige();
        return  0;
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
        if(noPhase==2)
            return "Le cout est de "+coutDePose+" deniers";
        return "";
    }

    public String getTourJoueur(){
        if(noPhase==2)
            if(!ordreDePhase2.isEmpty())
                return ordreDePhase2.get(0).getNom();
        return "";

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

    public void phase2(){
        if(ordreDePhase2.isEmpty())
            ordreDePhase2.addAll(ordreDeTour);
    }

    public void constChateau(){
        Joueur joueur = ordreDePhase2.get(0);
        int coordonnée = chateau.ajouterConstructeur(joueur);
        if(coordonnée!=-1)
            if ( joueur.getOuvrier() != 0) {
                if(joueur.donne("denier",coutDePose)){
                    joueur.poseOuvrier();
                    ordreDePhase2.remove(0);
                    view.constChateau(coordonnée, joueur);
                }else{
                    view.problèmeOuvrier(joueur.getNom(), -4);
                }
            }else{
                view.problèmeOuvrier(joueur.getNom(), -2);
            }
        else{
            view.problèmeChateau(joueur.getNom(),-1);
        }
        phase2();
        view.editPInfo();
        view.editPJoueur();
    }

    public void poseOuvrier(int coordonnee) {
        Joueur joueur = ordreDePhase2.get(0);
        if (joueur.getDenier() >= coutDePose || cases[5].getBatiment().getOuvrier() != joueur) {
            if (getBatiment(coordonnee) != null) {
                if (joueur.getOuvrier() != 0) {
                    if (getBatiment(coordonnee).engager(joueur)) {
                        if (cases[5].getBatiment().getOuvrier() != joueur)
                            joueur.donne("denier", coutDePose);
                        joueur.poseOuvrier();
                        ordreDePhase2.remove(0);
                        view.poserOuvrier(coordonnee, joueur);
                    } else {
                        view.problèmeOuvrier(joueur.getNom(), -3);
                    }
                } else {
                    view.problèmeOuvrier(joueur.getNom(), -2);
                }
            } else {
                view.problèmeOuvrier(joueur.getNom(), -1);
            }
        } else {
            view.problèmeOuvrier(joueur.getNom(), -4);
        }
        phase2();
        view.editPInfo();
        view.editPJoueur();
    }

    public void joueurPasse(){
        if(finDePose.isEmpty())
            ordreDePhase2.get(0).recoit("denier",1);
        finDePose.add( ordreDePhase2.get(0));
        ordreDeTour.remove(ordreDePhase2.get(0));
        ordreDePhase2.remove(0);
        coutDePose++;
        if(ordreDeTour.isEmpty())
            noPhase++;
        phase2();
        view.editPJoueur();
        view.editPInfo();
    }

    public void phase3() {
        view.editPInfo();
        Joueur ouvrier;
        ArrayList<Joueur> newOrdre;
        for (int i = 0; i <= 5; i++) {
            ouvrier = cases[i].getOuvrier();
            if (cases[i].getBatiment() != null) {
                if (ouvrier != null) {
                    int index = cases[i].getBatiment().active(view);

                    if (index == -1 || index == -2 || index == -3)
                        view.problèmeConstruction(index, ouvrier.getNom(), cases[i].getNomProprio());

                    if(index==1){
                        int coordonné = view.panneauPorte(ouvrier.getNom());
                        if (ouvrier.getOuvrier() != 0) {
                            if (getBatiment(coordonné).engager(ouvrier)) {
                                ouvrier.poseOuvrier();
                                view.poserOuvrier(coordonné, ouvrier);
                            } else {
                                    view.problèmeOuvrier(ouvrier.getNom(), -3);
                                }
                        } else {
                            view.problèmeOuvrier(ouvrier.getNom(), -2);
                        }
                    }

                    if (index == 3) {
                        int rang = -1;
                        int coordonnée = -1;
                        rang = view.deplPrevot(cases[i].getOuvrier());
                        switch (rang) {
                            case 0:
                                coordonnée = prévot.getCoordonnée() - 3;
                                break;
                            case 1:
                                coordonnée = prévot.getCoordonnée() - 2;
                                break;
                            case 2:
                                coordonnée = prévot.getCoordonnée() - 1;
                                break;
                            case 3:
                                coordonnée = prévot.getCoordonnée();
                                break;
                            case 4:
                                coordonnée = prévot.getCoordonnée() + 1;
                                break;
                            case 5:
                                coordonnée = prévot.getCoordonnée() + 2;
                                break;
                            case 6:
                                coordonnée = prévot.getCoordonnée() + 3;
                                break;
                        }
                        if (coordonnée < 6)
                            coordonnée = 6;
                        if (coordonnée > 33)
                            coordonnée = 33;
                        view.setPrévot(coordonnée);
                        prévot.coordonnée = coordonnée;
                    }
                    if(index==5){
                        newOrdre = new ArrayList<Joueur>();
                        newOrdre.add(cases[i].getBatiment().getOuvrier(0));
                        newOrdre.add(cases[i].getBatiment().getOuvrier(1));
                        newOrdre.add(cases[i].getBatiment().getOuvrier(3));
                        for(Joueur joueur : ordreDeTour){
                            for(Joueur joueurOrdre : newOrdre){
                                if(joueur==joueurOrdre)
                                    ordreDeTour.remove(joueurOrdre);
                            }
                        }
                        newOrdre.addAll(ordreDeTour);
                        ordreDeTour=new ArrayList<Joueur>();
                        ordreDeTour.addAll(newOrdre);

                    }

                    cases[i].getBatiment().retireOuvrier();
                    view.retireOuvrier(i);
                    view.editPJoueur();
                    view.editPInfo();
                }
            }
        }
        noPhase++;
    }

    public void phase4() {
        view.editPInfo();
        int rang = -1;
        int coordonnée=-1,cout=-1;
        for (Joueur joueur : finDePose) {
            rang = view.deplPrevot(joueur);
            switch (rang) {
                case 0:
                    coordonnée = prévot.getCoordonnée() - 3;
                    cout = 3;
                    break;
                case 1:
                    coordonnée = prévot.getCoordonnée() - 2;
                    cout = 2;
                    break;
                case 2:
                    coordonnée = prévot.getCoordonnée() - 1;
                    cout = 1;
                    break;
                case 3:
                    coordonnée = prévot.getCoordonnée();
                    cout = 0;
                    break;
                case 4:
                    coordonnée = prévot.getCoordonnée() + 1;
                    cout = 1;
                    break;
                case 5:
                    coordonnée = prévot.getCoordonnée() + 2;
                    cout = 2;
                    break;
                case 6:
                    coordonnée = prévot.getCoordonnée() + 3;
                    cout = 3;
                    break;
            }
            if(coordonnée<6)
                coordonnée=6;
            if(coordonnée>33)
                coordonnée=33;
            if (joueur.getDenier() >= cout) {
                view.setPrévot(coordonnée);
                prévot.coordonnée=coordonnée;
                joueur.donne("denier", cout);
                } else {
                    view.problèmeOuvrier(joueur.getNom(), -4);
                }

                view.editPJoueur();
                view.editPInfo();
            }
            noPhase++;
        }

    public void phase5() {
        view.editPInfo();
        Joueur ouvrier;
        String[] batResidence;
        ArrayList<String> batPossibleRes;
        for (int i = 6; i <= prévot.getCoordonnée(); i++) {
            batPossibleRes = new ArrayList<>();
            if (cases[i].getBatiment() != null) {
                if (cases[i].getOuvrier() != null) {
                    ouvrier = cases[i].getOuvrier();
                    int index = cases[i].getBatiment().active(view);
                    if (index == 0)
                        cases[i].getBatiment().retireOuvrier();
                    if (index == -1 || index == -2 || index == -3)
                        view.problèmeConstruction(index, cases[i].getNomOuvrier(), cases[i].getNomProprio());

                    if (index == 10) {
                        for (Case caseVerif : cases) {
                            if (caseVerif.getBatiment() == null) {
                                caseVerif.setBatiment(ouvrier.dernierePropriete());
                                break;
                            }
                        }
                    }
                    if (index == 11) {
                        int m=-1;
                        cases[15]=new Case();
                        for (Case caseVerif : cases) {
                            if (caseVerif.getBatiment()!=null)
                                if(caseVerif.getBatiment().isNeutre())
                                    batPossibleRes.add(caseVerif.getNomBat());
                        }
                        for(Batiment bat : ouvrier.propriété)
                            batPossibleRes.add(bat.getNom());

                        batResidence = new String[batPossibleRes.size()];
                        for(int j =0;j<batPossibleRes.size();j++)
                            batResidence[j]=batPossibleRes.get(j);

                        String batchoisis = view.choixConst(batResidence, cases[i].getNomOuvrier());
                        if (batchoisis!=null){
                            for (Case caseVerif : cases) {
                                if (caseVerif.getNomBat().equals(batchoisis))
                                    caseVerif.setBatiment(ouvrier.dernierePropriete());
                            }
                        }else{
                            view.problèmeConstruction(-5,ouvrier.getNom(),null);
                            ouvrier.propriété.remove(ouvrier.propriété.size()-1);
                        }
                    }
                    if (index == 12) {
                        int nbrRes=1;
                        for (Case cases : cases) {
                            if (cases.getNomBat().equals("Residence"))
                                batPossibleRes.add(cases.getNomBat()+" "+nbrRes++);
                        }
                        batResidence = new String[batPossibleRes.size()];
                        for(int j =0;j<batPossibleRes.size();j++)
                            batResidence[j]=batPossibleRes.get(j);

                        String batchoisis = view.choixConst(batResidence, cases[i].getNomOuvrier());
                        if (batchoisis!=null){
                            nbrRes=0;
                            for (Case caseVerif : cases) {
                                if (caseVerif.getNomBat().equals("Residence")) {
                                    nbrRes++;
                                    if (batchoisis.equals(caseVerif.getNomBat() + " " + nbrRes++))
                                        caseVerif.setBatiment(ouvrier.dernierePropriete());
                                }
                            }
                        }else{
                            view.problèmeConstruction(-5,ouvrier.getNom(),null);
                            ouvrier.propriété.remove(ouvrier.propriété.size()-1);
                        }
                    }
                    cases[i].getBatiment().retireOuvrier();
                    view.retireOuvrier(i);
                    view.editImageCase();
                    view.editPJoueur();
                    view.editPInfo();

                }
            }

        }
        noPhase++;
    }


    public void phase6()  {
        view.editPInfo();
        chateau.constPartie(view);


    }





}
