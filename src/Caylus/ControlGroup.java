package Caylus;

/**
 * Created by thorx on 18/05/2017.
 */
public class ControlGroup {
    private Model model;
    protected View view;
    private ControlMouse controlMouse;


    public ControlGroup(Model model) {
        this.model = model;
        view = new View(this.model);
        model.setView(this.view);
        controlMouse = new ControlMouse(this.view, this.model);
        view.display();
        model.initJoueur();
        model.initRessource();
    }
}
