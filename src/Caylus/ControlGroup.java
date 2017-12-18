package Caylus;

/**
 * Created by thorx on 18/05/2017.
 */
public class ControlGroup {
    private Model model;
    protected View view;
    private ControlMouse controlMouse;
    private ControlMenu controlMenu;

    /**
     * Initialise la vue, le model et la musique du jeu
     * @param model La classe qui gère toute les donnée
     * @param backgroundMusic La musique lancé pendant le jeu
     */
    public ControlGroup(Model model, BackgroundMusic backgroundMusic) {
        this.model = model;
        view = new View(this.model);
        model.setView(this.view);
        controlMouse = new ControlMouse(this.view, this.model);
        controlMenu = new ControlMenu(this.view, this.model, backgroundMusic);
        view.display();
        model.initJoueur();
        model.initRessource();
    }
}
