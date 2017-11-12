import com.apple.eawt.Application;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.BLACK;
import static java.awt.Color.CYAN;
import static java.awt.Color.GRAY;

/**
 * Created by Schnoeby on 11/11/2017.
 */
public class View extends JFrame {

    private Plateau jpPlateau;
    private JPanel panelInfo;
    private Application app;
    private JLabel[] caseP;
    private ImageIcon[] imageCase;

    public View() {

        this.setTitle("Caylus");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setSize(1000, 1000);
        this.setLocationRelativeTo(null);
        this.initImage();
        this.initInfo();
        this.initPLateau();
        this.setVisible(true);

        this.app = Application.getApplication();

    }

    public void initInfo() {
        panelInfo=new Info(350,700);

    }


    public void initPLateau() {

        jpPlateau = new Plateau(1000, 1000);
        jpPlateau.setLayout(null);

        int x = 30;
        int y = 850;
        int decalColonne =90;
        int decalLigne =70;
        int j=0;

        caseP=new JLabel[34];
        for(int i=0;i<34;i++) {
            caseP[i] = new JLabel();
            caseP[i].setIcon(imageCase[i]);
            jpPlateau.add(caseP[i]);
            if(j%6==0 && j!=0){
                y-=decalLigne;
            }
            caseP[i].setBounds(x, y, 70, 70);
            if(j%6==0 && j!=0){
                decalColonne=-decalColonne;
                y-=decalLigne;
            }
            if(j==27){
                x+=3*decalColonne;
                decalLigne =50;
                j=4;
            }

            x+=decalColonne;
            j++;

        }
        jpPlateau.add(panelInfo);
        panelInfo.setBounds(650,370,350,700);
        setContentPane(jpPlateau);
    }
    public void initImage(){
        imageCase=new ImageIcon[34];
        for(int i=0;i<34;i++)
            imageCase[i]= new ImageIcon("./res/img//Batiment/Vide.png");
        imageCase[20]= new ImageIcon("./res/img//Batiment/Charpentier.png");
        imageCase[21]= new ImageIcon("./res/img//Batiment/marché.png");
        imageCase[28]= new ImageIcon("./res/img//Batiment/taverne2.png");
        imageCase[29]= new ImageIcon("./res/img//Batiment/ecurie.png");
        imageCase[30]= new ImageIcon("./res/img//Batiment/joute.png");
        imageCase[31]= new ImageIcon("./res/img//Batiment/taverne.png");
        imageCase[32]= new ImageIcon("./res/img//Batiment/banque.png");
        imageCase[33]= new ImageIcon("./res/img//Batiment/porte.png");
    }



}
