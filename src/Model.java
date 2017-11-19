/**
 * Created by Schnoeby on 19/11/2017.
 */
public class Model {
    private Case[] cases;
    final int size = 34;
    private View view;
    private Partie partie;

    public Model(){
        this.partie= new Partie();
        initCases();
    }

    public void initCases(){
        cases=new Case[34];
        for(int i = 0; i < this.size; i++){
                this.cases[i] = new Case();
        }
    }

    public Joueur tourJoueur(){
      return partie.getJoueur();
    }

    public void poserOuvrier(int coordonnees, Joueur joueur){
        partie.ouvrierPosé(joueur);
        view.poserOuvrier(coordonnees, joueur);
    }

    public void setView(View view) {
        this.view = view;
    }

}
