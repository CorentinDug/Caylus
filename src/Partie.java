import java.awt.*;

/**
 * Created by Schnoeby on 19/11/2017.
 */
public class Partie {
    private Joueur joueur1;
    private Joueur joueur2;

    public Partie(){
        joueur1 = new Joueur("Jean");
        joueur2 = new Joueur("Paul");
        initCouleur();
    }

    public Joueur getJoueur() {
        if(joueur2.getOuvrier()==0) {
            joueur1.recoit("ouvrier",6);
            joueur2.recoit("ouvrier",6);
        }
        if(joueur1.getOuvrier()==0) {
            return joueur2;
        }
        return joueur1;
    }

    public void initCouleur( ){
        joueur1.setCouleur(Color.blue);
        joueur2.setCouleur(Color.yellow);
    }

    public void ouvrierPosé(Joueur joueur){
        joueur.donne("ouvrier",1);

    }

}
