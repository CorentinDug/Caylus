package Caylus;

import Caylus.Batiment.Batiment;

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
        pierre=0;
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

    public boolean poseOuvrier(){
        ouvrier--;
        return true;
    }

    public void reprendOuvrier(){
        ouvrier++;
    }

    public void reprendMaison(){
        maison++;
    }

    public void donne(String ressource, int quantité) {
        switch (ressource) {
            case "denier":
                denier -=quantité;

                break;
            case "nourriture":
                nourriture -=quantité;
                break;
            case "tissu":
                tissu -=quantité;
                break;
            case "bois":
                bois -=quantité;
                break;
            case "pierre":
                pierre -=quantité;
                break;
            case "or":
                or-=quantité;
                break;
            case "prestige":
                prestige-=quantité;
                break;
        }
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
