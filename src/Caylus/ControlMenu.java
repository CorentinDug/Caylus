package Caylus;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Schnoeby on 25/11/2017.
 */
public class ControlMenu implements ActionListener {
    private View view;
    private Model model;
    private BackgroundMusic music;
    String[] test = new String[]{"test"};

    /**
     * Constructeur initialisant le controleur du menu
     * @param view la vue du jeu
     * @param model le model du jeu
     * @param music la musique lancé dans le jeu
     */
    public ControlMenu(View view, Model model, BackgroundMusic music) {
        this.view = view;
        this.model = model;
        this.music = music;
        view.setMenuListener(this);
    }

    /**
     * Lance les actions en foncction de l'action dans le menu
     * @param e Evènement capté
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == view.quitter){
            System.exit(0);
        }
        if (e.getSource() == view.aide){
            File htmlFile = new File("res/aide.html");
            try {
                Desktop.getDesktop().browse(htmlFile.toURI());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if (e.getSource() == view.newGame){
            view.dispose();
            music.stop();
            Caylus.main(null);
        }

    }
}