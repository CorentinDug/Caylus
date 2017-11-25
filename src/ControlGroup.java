/**
 * Created by thorx on 18/05/2017.
 */
public class ControlGroup {
    private Model model;
    protected View view;
    private ControlMouse controlMouse;



    public ControlGroup(Model model) {
        this.model = model;
        this.view = new View(this.model);
        this.model.setView(this.view);

        this.controlMouse = new ControlMouse(this.view, this.model);
        this.view.display();    }
}
