package Batiment.Bois;
import Batiment.Batiment;

abstract class Bois implements Batiment {
    public Bois(){}
    public abstract void recompenseOuvrier();
    public abstract void recompenseProprietaire();
    public abstract void recompensePrestige();
}
