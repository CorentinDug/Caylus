/**
 * Created by Schnoeby on 19/11/2017.
 */
public class Case {
    private boolean ouvrier;
    private String batiment;

    public Case(){
        ouvrier = false;
        batiment = "vide";
    }

    public String getBatiment() {
        return batiment;
    }

    public void setBatiment(String batiment) {
        this.batiment = batiment;
    }
}
