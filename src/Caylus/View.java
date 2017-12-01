package Caylus;

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
    private  PanelPrinc panelPlateau;
    private JPanel panelPrinc, panelInfo, panelJoueur;

    JLabel joueur1,joueur2,joueur3,joueur4,joueur5;


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
        setSize(1300, 1000);
        setLocationRelativeTo(null);
        initPLateau();
        initPInfo();
        initPJoueur();
        createView();
        setPrévot(model.prévot.coordonnée);
        setBaillis(model.baillis.coordonnée);

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
        panelPlateau.addMouseMotionListener(listener);
        panelPlateau.addMouseListener(listener);
    }

    public void initPInfo() {
        panelInfo=new JPanel();
        panelInfo.setPreferredSize(new Dimension(300,300));
        JLabel fond = new JLabel();
        fond.setIcon(new ImageIcon("res/img/infos.png"));
        panelInfo.setLayout(new GridBagLayout());

        panelInfo.add(fond);
        fond.setBounds(0,0,300,300);

    }

    public void editJoueur(){
        joueur1.setText(model.getNom(1));
        joueur2.setText(model.getNom(2));
        if(model.nbrJoueurs>=3){
            joueur3.setText(model.getNom(3));
        }
        if(model.nbrJoueurs>=4){
            joueur4.setText(model.getNom(4));
        }
        if(model.nbrJoueurs>=5){
            joueur5.setText(model.getNom(5));
        }




    }

    public void initPJoueur() {
        panelJoueur = new JPanel();
        panelJoueur.setPreferredSize(new Dimension(300, 1000));
        panelJoueur.setLayout(null);

        JLabel fond = new JLabel();
        fond.setIcon(new ImageIcon("res/img/joueur.png"));

        Font font = new Font("Arial",Font.BOLD,30);

        joueur1 = new JLabel(model.getNom(1));
        joueur1.setBounds(100,50,200,50);
        joueur1.setFont(font);
        panelJoueur.add(joueur1);


        joueur2 = new JLabel(model.getNom(2));
        joueur2.setBounds(100,150,200,50);
        joueur2.setFont(font);
        panelJoueur.add(joueur2);


        if(model.nbrJoueurs>=3){
            joueur3 = new JLabel(model.getNom(3));
            joueur3.setBounds(100,250,200,50);
            joueur3.setFont(font);
            panelJoueur.add(joueur3);
        }
        if(model.nbrJoueurs>=4){
            joueur4 = new JLabel(model.getNom(4));
            joueur4.setBounds(100,350,200,50);
            joueur4.setFont(font);
            panelJoueur.add(joueur4);
        }
        if(model.nbrJoueurs>=5){
            joueur5 = new JLabel(model.getNom(5));
            joueur5.setBounds(100,450,200,50);
            joueur5.setFont(font);
            panelJoueur.add(joueur5);
        }

        panelJoueur.add(fond);
        fond.setBounds(0,0,300,1000);
    }

    public void initPLateau() {
        panelPlateau = new PanelPrinc(1000,1000);
        panelPlateau.setLayout(null);

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
            panelPlateau.add(casesOuvrier[i]);
            panelPlateau.add(cases[i]);
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
    }

    public void createView() {
        panelPrinc = new JPanel();
        panelPrinc.setLayout(null);

        panelPlateau.setOpaque(false);
        panelJoueur.setOpaque(false);
        panelInfo.setOpaque(false);

        panelPrinc.add(panelJoueur);
        panelJoueur.setBounds(0,0,300,1000);

        panelPrinc.add(panelInfo);
        panelInfo.setBounds(1000,700,300,300);


        panelPrinc.add(panelPlateau);
        panelPlateau.setBounds(300,0,1000,1000);



        setContentPane(panelPrinc);
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
                imageCase = ImageIO.read(new File("./res/img/Caylus.Caylus.Batiment/"+model.cases[i].getBatiment()+".png"));
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
        String nom="";
        while(nom.equals(""))
            nom = JOptionPane.showInputDialog(null, "Entrez un nom pour le Caylus.Joueur "+i) ;
        return nom;
    }




}
