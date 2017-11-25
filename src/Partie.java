import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Schnoeby on 19/11/2017.
 */
public class Partie {
    protected ArrayList<Joueur> joueur;
    protected Color[] couleur;
    protected int nbrJoueurs;
    protected Prévot prévot;
    protected Baillis baillis;

    public Partie(int joueurs){
        nbrJoueurs=joueurs;
        prévot = new Prévot();
        baillis = new Baillis();
        joueur = new ArrayList<Joueur>();
        initCouleur();
    }

    public int getNbrJoueurs() {
        return nbrJoueurs;
    }

    public void initCouleur( ){
        couleur = new Color[5];
        couleur[0]= Color.blue;
        couleur[1]= Color.red;
        couleur[2]= Color.green;
        couleur[3]= Color.orange;
        couleur[4]= Color.black;
    }



    public void poseOuvrier(Joueur joueur){
        joueur.poseOuvrier();

    }


}
