package Caylus;

/**
 * Created by Schnoeby on 25/11/2017.
 */
public class Baillis {
    protected int coordonnée;

    /**
     * Constructeur intitialisant la coordonnée
     */
    public Baillis() {
        this.coordonnée = 11;
    }

    /**
     * @return Retourne la coordonnée du baillis
     */
    public int getCoordonnée() {
        return coordonnée;
    }

    /**
     * Change la coordonnée du Baillis en fonction du paramètre
     * @param coordonnée La nouvelle coordonné
     */
    public void setCoordonnée(int coordonnée) {
        this.coordonnée = coordonnée;
    }

}