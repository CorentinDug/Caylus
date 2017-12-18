package Caylus;

/**
 * Created by Schnoeby on 25/11/2017.
 */
public class Prévot {
    protected int coordonnée;

    /**
     * Constructeur initialisant le prévot
     */
    public Prévot() {
        this.coordonnée = 11;
    }

    /**
     * @return Retourne la coordonnée du prévot
     */
    public int getCoordonnée() {
        return coordonnée;
    }

    /**
     * Change la coordonnée du prévot
     * @param coordonnée La nouvelle coordonnée du prévot
     */
    public void setCoordonnée(int coordonnée) {
        this.coordonnée = coordonnée;
    }

}
