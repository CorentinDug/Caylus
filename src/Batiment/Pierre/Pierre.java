package Batiment.Pierre;
import Batiment.Batiment;

abstract class Pierre implements Batiment {
    public Pierre(){}
    public abstract void recompenseOuvrier();
    public abstract void recompenseProprietaire();
    public abstract void recompensePrestige();
}
