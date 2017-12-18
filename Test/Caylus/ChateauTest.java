package Caylus;

import org.junit.Assert;
import org.junit.Test;

public class ChateauTest {

    @Test
    public void testAjouterConstructeur(){
        Chateau chateau = new Chateau();
        Joueur joueur = new Joueur("Joueur");
        int position = chateau.ajouterConstructeur(joueur);
        Assert.assertEquals(chateau.getConstructeur(position), joueur);
    }

    @Test
    public void testAjoutConstructeurEchouer(){
        Chateau chateau = new Chateau();
        Joueur joueur = new Joueur("Joueur");
        chateau.ajouterConstructeur(joueur);
        Assert.assertEquals(chateau.ajouterConstructeur(joueur), -1);
    }
}
