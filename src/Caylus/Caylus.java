package Caylus;

/**
 * Created by Schnoeby on 11/11/2017.
 */
public class Caylus {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                BackgroundMusic backgroundMusic = new BackgroundMusic();
                ViewMenu viewMenu = new ViewMenu();
                ControlButtonMenu controlButtonMenu = new ControlButtonMenu(viewMenu, backgroundMusic);
            }
        });
    }
}
