import com.apple.eawt.Application;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Schnoeby on 11/11/2017.
 */
public class View extends JFrame {

    private JPanel jpPlateau;
    private PanelPrinc jpP;
    private Application app;
    private JLabel[] caseP;
    private ImageIcon[] imageCase;

    public View() {

        this.setTitle("Caylus");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setSize(1100, 700);
        this.setLocationRelativeTo(null);
        this.initImage();
        this.createView();
        this.setVisible(true);

        this.app = Application.getApplication();

    }

    public void createView() {
        jpPlateau = new PanelPrinc(1100, 700);
        jpPlateau.setLayout(null);

        caseP=new JLabel[2];
        for(int i=0;i<2;i++) {
            caseP[i] = new JLabel();
            caseP[i].setIcon(imageCase[i]);
            jpPlateau.add(caseP[i]);
            caseP[i].setBounds(1050, 650, 80, 30);
        }
        setContentPane(jpPlateau);
    }
    public void initImage(){
        imageCase=new ImageIcon[2];
        imageCase[0]= new ImageIcon("./res/img//Batiment/1.png");
        imageCase[1]= new ImageIcon("./res/img//Batiment/2.png");
    }



}
