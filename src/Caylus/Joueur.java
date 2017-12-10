package Caylus;

import Caylus.Batiment.Batiment;
import Caylus.Batiment.Bois.*;


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
        nourriture=0;
        tissu=0;
        bois=0;
        pierre=1;
        or=0;
        ouvrier=6;
        maison=20;
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

    public int getMaison() {
        return maison;
    }

    public int getPrestige() {
        return prestige;
    }



    public boolean poseMaison(){
        if(maison==0)
            return false;
        maison--;
        return true;
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
            case "Carrière":
                bat = new BCarriere();
                break;
            case "Notaire":
                bat = new BNotaire();
                break;
            case "Scierie":
                bat = new BScierie();
                break;
            case "Marché":
                bat = new BMarche();
                break;
            case "Maçon":
                bat = new BMarche();

                break;
            case "Ferme Tissu":
                bat = new BFermeSoie();

                break;
            case "Ferme Nourriture":
                bat = new BFermeNourriture();
                break;
            case "Colporteur":
                bat = new BColporteur();
                break;
        }
        if(bat !=null){
            coutConst=bat.coutContructon();
            if(coutConst[0]<=or && coutConst[1]<=nourriture && coutConst[2]<=pierre && coutConst[3]<=bois && coutConst[4]<=tissu && 0<maison ){
                donne("or", coutConst[0]);
                donne("nourriture", coutConst[1]);
                donne("pierre", coutConst[2]);
                donne("bois", coutConst[3]);
                donne("tissu", coutConst[4]);
                poseMaison();
                bat.setProprietaire(this);
                propriété.add(bat);
                return true;
            }
        }

        return  false;
    }


    public void reprendOuvrier(){
        ouvrier++;
    }

    public void reprendMaison(){
        maison++;
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
                    return false;
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
                maison +=quantité;
                break;
        }
    }
}
