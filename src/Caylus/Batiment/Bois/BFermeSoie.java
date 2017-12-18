package Caylus.Batiment.Bois;
import Caylus.Batiment.Batiment;

public class BFermeSoie extends Batiment {
    private String[] choix = new String[]{"2 Tissu", "nourriture"};
    private String recOuvrier;

    /**
     * Constructeur initialisant le nom, les couts de construction et le nombre de prestiges reçue à la construction
     */
    public BFermeSoie(){
        super("FermeTissu");
        coutConst[0]=0;
        coutConst[1]=1;
        coutConst[2]=0;
        coutConst[3]=1;
        coutConst[4]=0;
        prestige=2;
    }

    /**
     * Donne les récompenses aux personnes concerné
     * @return
     */
    public int active(){
        recOuvrier = view.panneauRecompense(choix,mess);
        recompenseOuvrier(recOuvrier);
        recompenseProprietaire();
        return 0;
    }

    /**
     *  Donne la récompense ouvrière dû au joueur
     * @param choix
     */
    public void recompenseOuvrier(String choix) {
        if (choix.equals("2 Tissu")) {
            ouvrier.recoit("tissu", 2);
        }else{
            ouvrier.recoit(choix,1);
        }
    }

}