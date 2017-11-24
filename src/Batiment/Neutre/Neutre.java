package Batiment.Neutre;
import Batiment.Batiment;

abstract class Neutre implements Batiment {
    public Neutre(){}
    public abstract void recompenseOuvrier();
    public abstract void recompenseProprietaire();
    public abstract void recompensePrestige();
}
