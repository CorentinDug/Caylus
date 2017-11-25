import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Schnoeby on 19/11/2017.
 */
public class Model {
    private Case[] cases;
    final int size = 34;
    private View view;
    private Partie partie;

    public Model(int nbrJoueurs){
        partie= new Partie(nbrJoueurs);
        initCases();

    }

    public void initCases(){
        cases=new Case[34];
        for(int i = 0; i < this.size; i++){
                cases[i] = new Case();
        }
    }


    public void initJoueur(int nbrJoueurs ){
        for(int i=0; i<nbrJoueurs;i++){
            String nom = view.créerJoueur(i+1);
            Joueur joueur = new Joueur(nom);
            joueur.setCouleur(partie.couleur[i]);
            partie.joueur.add(joueur);
        }
    }

    public void poseOuvrier(int coordonnees, Joueur joueur){
        partie.poseOuvrier(joueur);
        view.poserOuvrier(coordonnees, joueur);
    }

    public void setView(View vue) {
        this.view = vue;
        view.setPrévot(partie.prévot.coordonnée);
        view.setBaillis(partie.baillis.coordonnée);
        initJoueur(partie.nbrJoueurs);
    }

}
