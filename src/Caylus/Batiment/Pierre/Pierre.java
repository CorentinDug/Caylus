package Caylus.Batiment.Pierre;
import Caylus.Batiment.Batiment;

abstract class Pierre implements Batiment {
    public Pierre(){}
    public abstract void recompenseOuvrier();
    public abstract void recompenseProprietaire();
    public abstract void recompensePrestige();
}
