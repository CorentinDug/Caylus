package Caylus.Batiment.Bois;
import Caylus.Batiment.*;
import Caylus.Joueur;

abstract class Bois implements Batiment, BatimentActivable {
    Joueur j1, j2 ;

    public Bois(){}
    public abstract void recompenseOuvrier();
    public abstract void recompenseProprietaire();
    public abstract void recompensePrestige();
}
