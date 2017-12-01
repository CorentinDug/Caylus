package Caylus.Batiment.Prestige;
import Caylus.Batiment.Batiment;

abstract class Prestige implements Batiment {
    public Prestige(){}
    public abstract void recompenseOuvrier();
    public abstract void recompenseProprietaire();
    public abstract void recompensePrestige();
}

