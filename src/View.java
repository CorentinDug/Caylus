import com.apple.eawt.Application;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * Created by Schnoeby on 11/11/2017.
 */

public class View extends JFrame {
    private Model model;
    private Plateau jpPlateau;
    private JPanel panelInfo;
    private Application app;
    protected JLabel[] cases;
    protected JLabel[] casesOuvrier;

    private ImageIcon[] imageCases;

    private Image icone;
    private ImageIcon iconeDUT;
    private ImageIcon iconeApp;
    private Image img;


    public View(Model model) {
        this.model = model;
        setTitle("Caylus");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setSize(1000, 1000);
        setLocationRelativeTo(null);
        initInfo();
        initPLateau();

        icone = Toolkit.getDefaultToolkit().getImage("res/img/icone.png");
        iconeDUT = new ImageIcon("res/img/dut.png");
        ImageIcon imageIcon = new ImageIcon("res/img/icone.png");
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        iconeApp = new ImageIcon(newimg);  // transform it back
        imageIcon = new ImageIcon("res/img/dut.png"); //unscaled image
        image = imageIcon.getImage();
        newimg = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        iconeDUT = new ImageIcon(newimg);
        img = new ImageIcon("res/img/icone.png").getImage();
        app = Application.getApplication();
        try {
            app.setDockIconImage(img);
        } catch(NullPointerException e) {
            //e.printStackTrace();
        }
        this.setIconImage(icone);

    }

    public void setMouseListener(MouseAdapter listener) {
        jpPlateau.addMouseMotionListener(listener);
        jpPlateau.addMouseListener(listener);
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

        cases=new JLabel[34];
        casesOuvrier=new JLabel[34];
        for(int i=0;i<34;i++) {
            cases[i] = new JLabel();
            casesOuvrier[i] = new JLabel();
            jpPlateau.add(casesOuvrier[i]);
            jpPlateau.add(cases[i]);
            if(j%6==0 && j!=0){
                y-=decalLigne;
            }
            cases[i].setBounds(x, y, 70, 70);
            casesOuvrier[i].setBounds(x+50, y+50, 20, 20);
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

    public void initImageCase() {
        for (int i = 0; i < 34; i++) {
            cases[i].setIcon(imageCases[i]);
        }
    }

    public void initListeImage(){
        imageCases = new ImageIcon[34];
        for (int i = 0; i < 34; i++) {
            BufferedImage imageCase = null;
            try {
                System.out.println("./res/img/Batiment/Spécial/"+model.cases[i].getBatiment()+".png");
                imageCase = ImageIO.read(new File("./res/img/Batiment/"+model.cases[i].getBatiment()+".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            ImageIcon iconCase = new ImageIcon(imageCase);
            imageCases[i]= iconCase;
        }


    }

    public void display() {
        this.setVisible(true);
    }

    public void poserOuvrier(int coordonnees, Joueur joueur){
        casesOuvrier[coordonnees].setBackground(joueur.getCouleur());
        casesOuvrier[coordonnees].setOpaque(true);
    }

    public void setBaillis(int coordonnees){
        cases[coordonnees].setBorder(BorderFactory.createLineBorder(Color.white,3));
        cases[coordonnees].setOpaque(true);
    }

    public void setPrévot(int coordonnees){
        cases[coordonnees].setBorder(BorderFactory.createLineBorder(Color.white,1));
        cases[coordonnees].setOpaque(true);
    }

    public String créerJoueur(int i) {
        String nom = JOptionPane.showInputDialog(null, "Entrez un nom pour le Joueur "+i) ;
        return nom;
    }




}
