package Caylus;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;


public class JoueurTest {

    @Test
    public void testDonneDenierTrue(){
        Joueur joueur = new Joueur("joueur");
        joueur.recoit("denier",13);
        Assert.assertTrue(joueur.donne("denier",12));

    }

    @Test
    public void testDonneNourritureTrue(){
        Joueur joueur = new Joueur("joueur");
        joueur.recoit("nourriture",13);
        Assert.assertTrue(joueur.donne("nourriture",12));
    }

    @Test
    public void testDonneTissuTrue(){
        Joueur joueur = new Joueur("joueur");
        joueur.recoit("tissu",13);
        Assert.assertTrue(joueur.donne("tissu",12));
    }

    @Test
    public void testDonneBoisTrue(){
        Joueur joueur = new Joueur("joueur");
        joueur.recoit("bois",13);
        Assert.assertTrue(joueur.donne("bois",12));
    }

    @Test
    public void testDonnePierreTrue(){
        Joueur joueur = new Joueur("joueur");
        joueur.recoit("pierre",13);
        Assert.assertTrue(joueur.donne("pierre",12));
    }

    @Test
    public void testDonneOrTrue(){
        Joueur joueur = new Joueur("joueur");
        joueur.recoit("or",13);
        Assert.assertTrue(joueur.donne("or",12));
    }

    @Test
    public void testDonnePrestigeTrue(){
        Joueur joueur = new Joueur("joueur");
        joueur.recoit("prestige",13);
        Assert.assertTrue(joueur.donne("prestige",12));
    }

    @Test
    public void testDonneDenierFalse(){
        Joueur joueur = new Joueur("joueur");
        joueur.recoit("denier",1);
        Assert.assertFalse(joueur.donne("denier",12));

    }

    @Test
    public void testDonneNourritureFalse(){
        Joueur joueur = new Joueur("joueur");
        joueur.recoit("nourriture",1);
        Assert.assertFalse(joueur.donne("nourriture",12));
    }

    @Test
    public void testDonneTissuFalse(){
        Joueur joueur = new Joueur("joueur");
        joueur.recoit("tissu",1);
        Assert.assertFalse(joueur.donne("tissu",12));
    }

    @Test
    public void testDonneBoisFalse(){
        Joueur joueur = new Joueur("joueur");
        joueur.recoit("bois",1);
        Assert.assertFalse(joueur.donne("bois",12));
    }

    @Test
    public void testDonnePierreFalse(){
        Joueur joueur = new Joueur("joueur");
        joueur.recoit("pierre",1);
        Assert.assertFalse(joueur.donne("pierre",12));
    }

    @Test
    public void testDonneOrFalse(){
        Joueur joueur = new Joueur("joueur");
        joueur.recoit("or",1);
        Assert.assertFalse(joueur.donne("or",13));
    }
}
