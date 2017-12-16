package Caylus;

import Caylus.Batiment.Batiment;
import Caylus.Batiment.Bois.*;
import Caylus.Batiment.Pierre.*;
import Caylus.Batiment.Prestige.*;
import Caylus.Batiment.Residentiel.Residence;


import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Schnoeby on 11/11/2017.
 */
public class Joueur {
    private String nom;
    private int denier;
    private int nourriture;
    private int tissu;
    private int bois;
    private int pierre;
    private int or;
    private int ouvrier;
    private int maison;
    private int prestige;
    private Color couleur;
    protected ArrayList<Batiment> propriété;


    public Joueur(String nom) {
        this.nom = nom;
        denier=0;
        nourriture=5;
        tissu=5;
        bois=5;
        pierre=5;
        or=0;
        ouvrier=6;
        prestige = 0;
        propriété = new ArrayList<>();
    }

    public void setCouleur(Color couleur) {this.couleur = couleur;}
    public Color getCouleur() {return couleur;}

    public String getNom() {
        return nom;
    }

    public int getDenier() {
        return denier;
    }

    public int getNourriture() {
        return nourriture;
    }

    public int getTissu() {
        return tissu;
    }

    public int getBois() {
        return bois;
    }

    public int getPierre() {
        return pierre;
    }

    public int getOr() {
        return or;
    }

    public int getOuvrier() {
        return ouvrier;
    }

    public int getPrestige() {
        return prestige;
    }


    public Batiment dernierePropriete(){
        return propriété.get(propriété.size()-1);
    }

    public boolean poseOuvrier(){
        ouvrier--;
        return true;
    }

    public boolean fabriqueBat(String nomBat){
        Batiment bat=null;
        int[] coutConst;
        switch (nomBat) {
            case "Carrière  1 bois + 1 pierre":
                bat = new BCarriere();
                break;
            case "Notaire 1 bois + 1 tissu":
                bat = new BNotaire();
                break;
            case "Scierie 1bois + 1pierree":
                bat = new BScierie();
                break;
            case "Marché 1 bois + 1 ressource":
                bat = new BMarche();
                break;
            case "Maçon 1 bois + 1 pierre":
                bat = new BMarche();
                break;
            case "Ferme Tissu 1 bois + 1 nourriture":
                bat = new BFermeSoie();
                break;
            case "Ferme Nourriture  1 bois + 1 nourriture":
                bat = new BFermeNourriture();
                break;
            case "Colporteur 1 bois + 1 ressource":
                bat = new BColporteur();
                break;
            case "Eglise 1 pierre + 1 tissu":
                bat = new PEglise();
                break;
            case "Parc 1 bois + 1 nourriture":
                bat = new PParc();
                break;
            case "Banque 1 bois + 1 pierre":
                bat = new PBanque();
                break;
            case "Alchimiste 1 pierre + 1 nourriture":
                bat = new PAlchimiste();
                break;
            case "Ferme 1 pierre + 1 nourriture":
                bat = new PFerme();
                break;
            case "Tailleur 1 bois + 1 tissu":
                bat = new PTailleur();
                break;
            case "Atelier 1 pierre + 1 nourritur":
                bat = new PAtelier();
                break;
            case "Architecte 1 bois + 1 nouriture":
                bat = new PArchitecte();
                break;
            case "Residentiel":
                bat = new Residence();
                break;
            case "Cathedrale 1 bois + 4 pierres + 3 or":
                bat = new Cathedrale();
                break;
            case "Monument 4 pierrs + 1 2 or":
                bat = new Monument();
                break;
            case "Bibliothèque 3 bois + 1 or":
                bat = new Bibliotheque();
                break;
            case "Grenier 3 nourriture + 1 or":
                bat = new Grenier();
                break;
            case "Tisserand 3 tissus + 1 or":
                bat = new Tisserand();
                break;
            case "Statue 2 pierres + 1 or":
                bat = new Statue();
                break;
            case "Theatre 3 bois + 2 or":
                bat = new Theatre();
                break;
            case "Université 3 pierres + 2 or":
                bat = new Universite();
                break;
            case "Hotel 3 pierres + 2 or":
                bat = new Hotel();
                break;
        }

        if(bat !=null){
            coutConst=bat.coutContructon();
            if(bat instanceof BColporteur || bat instanceof BMarche) {
                //faire des choses
            }

            if(coutConst[0]<=or && coutConst[1]<=nourriture && coutConst[2]<=pierre && coutConst[3]<=bois && coutConst[4]<=tissu){
                donne("or", coutConst[0]);
                donne("nourriture", coutConst[1]);
                donne("pierre", coutConst[2]);
                donne("bois", coutConst[3]);
                donne("tissu", coutConst[4]);
                bat.setProprietaire(this);
                recoit("prestige",bat.getPrestige());
                propriété.add(bat);
                return true;
            }
        }
        return  false;
    }


    public void reprendOuvrier(){
        ouvrier++;
    }

    public boolean donne(String ressource, int quantité) {
        switch (ressource) {
            case "denier":
                if(quantité>denier)
                    return false;
                denier -=quantité;
                break;
            case "nourriture":
                if(quantité>nourriture)
                    return false;
                nourriture -=quantité;
                break;
            case "tissu":
                if(quantité>tissu)
                    return false;
                tissu -=quantité;
                break;
            case "bois":
                if(quantité>bois)
                    return false;
                bois -=quantité;
                break;
            case "pierre":
                if(quantité>pierre)
                    return false;
                pierre -=quantité;
                break;
            case "or":
                if(quantité>or)
                    return false;
                or-=quantité;
                break;
            case "prestige":
                if(quantité>prestige)
                    prestige=0;
                prestige-=quantité;
                break;
        }
        return true;
    }

    public void recoit(String ressource, int quantité) {
        switch (ressource) {
            case "denier":
                denier +=quantité;
                break;
            case "nourriture":
                nourriture+=quantité;
                break;
            case "tissu":
                tissu+=quantité;
                break;
            case "bois":
                bois+=quantité;
                break;
            case "pierre":
                pierre +=quantité;
                break;
            case "or":
                or+=quantité;
                break;
            case "prestige":
                prestige +=quantité;
                break;
        }
    }
}
