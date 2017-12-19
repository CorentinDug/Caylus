package Caylus;

import org.junit.Assert;
import org.junit.Test;

public class ModelTest {

    @Test
    public void testVainqueur2Joueurs(){
        Model model = new Model(2);
        Joueur joueur1 = new Joueur("Joueur1");
        joueur1.recoit("prestige",13);
        Joueur joueur2 = new Joueur("Joueur2");
        joueur2.recoit("prestige",3);
        model.listeJoueur[0]=joueur1;
        model.listeJoueur[1]=joueur2;
        Assert.assertEquals(model.vainqueur(), joueur1.getNom());
    }
}
