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
        this.setSize(700, 1000);
        this.setLocationRelativeTo(null);
        this.initImage();
        this.createView();
        this.setVisible(true);

        this.app = Application.getApplication();

    }

    public void createView() {
        jpPlateau = new PanelPrinc(700, 1000);
        jpPlateau.setLayout(null);

        int x = 30;
        int y = 850;
        int decalColonne =90;

        caseP=new JLabel[34];
        for(int i=0;i<34;i++) {
            caseP[i] = new JLabel();
            caseP[i].setIcon(imageCase[i]);
            jpPlateau.add(caseP[i]);
            if(i%6==0 && i!=0){
                y-=70;
            }
            caseP[i].setBounds(x, y, 70, 70);
            if(i%6==0 && i!=0){
                decalColonne=-decalColonne;
                y-=70;
            }
            x+=decalColonne;

        }
        setContentPane(jpPlateau);
    }
    public void initImage(){
        imageCase=new ImageIcon[34];
        for(int i=0;i<34;i++)
            imageCase[i]= new ImageIcon("./res/img//Batiment/Vide.png");
        imageCase[13]= new ImageIcon("./res/img//Batiment/mine.png");

    }



}
