import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Schnoeby on 25/11/2017.
 */
public class ControlButtonMenu implements ActionListener {
    private ViewMenu viewMenu;


    public ControlButtonMenu(ViewMenu viewMenu) {
        this.viewMenu = viewMenu;
        viewMenu.setButtonControler(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewMenu.getQuitter()) {
            System.exit(0);
        } else{
            int nbrJoueurs = 0;
            if (e.getSource() == viewMenu.getDeuxJoueurs()) {
                nbrJoueurs = 2;
            } else if (e.getSource() == viewMenu.getTroisJoueurs()) {
                nbrJoueurs = 3;
            } else if (e.getSource() == viewMenu.getQuatreJoueurs()) {
                nbrJoueurs = 4;
            }else if (e.getSource() == viewMenu.getCinqJoueurs()) {
                nbrJoueurs = 5;
            }
            viewMenu.undisplay();
            Model model = new Model(nbrJoueurs);
            ControlGroup controlGroup = new ControlGroup(model);
        }
    }
}
