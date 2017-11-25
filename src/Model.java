import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Schnoeby on 19/11/2017.
 */
public class Model {
    protected Case[] cases;
    final int size = 34;
    private View view;
    private Partie partie;

    public Model(int nbrJoueurs){
        partie= new Partie(nbrJoueurs);
        initCases();

    }

    public void initCases(){
        cases=new Case[size];
        for(int i = 0; i < size; i++){
                cases[i] = new Case();
        }
        int n=0;
        for(int i = size-1; i > 27; i--) {
            cases[i].setBatiment(partie.batSpéciaux.get(n++));
        }
        n=0;
        for(int i = 27; i > 21; i--) {
            cases[i].setBatiment(partie.batNeutre.get(n++));
        }
    }

    public String getBatimentSpecial(int i){
        return partie.batSpéciaux.get(i);
    }

    public void initJoueur(int nbrJoueurs ){
        for(int i=0; i<nbrJoueurs;i++){
            String nom = view.créerJoueur(i+1);
            Joueur joueur = new Joueur(nom);
            joueur.setCouleur(partie.couleur[i]);
            partie.listeJoueur.add(joueur);
        }
        partie.initPartie();
    }

    public void poseOuvrier(int coordonnees, Joueur joueur){
        partie.poseOuvrier(joueur);
        view.poserOuvrier(coordonnees, joueur);
    }

    public void setView(View vue) {
        this.view = vue;
        view.setPrévot(partie.prévot.coordonnée);
        view.setBaillis(partie.baillis.coordonnée);
        view.initListeImage();
        view.initImageCase();
        initJoueur(partie.nbrJoueurs);
    }

}
