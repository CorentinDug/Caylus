package Caylus;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * Created by Schnoeby on 11/11/2017.
 */

public class View extends JFrame {
    private Model model;
    private PanelPrinc panelPlateau;
    private JPanel panelPrinc, panelInfo, panelJoueur;
    private JLabel ress1, ress2, ress3, ress4, ress5;
    private JLabel joueur1, joueur2, joueur3, joueur4, joueur5;
    private JPanel ressJ1, ressJ2, ressJ3, ressJ4, ressJ5;
    private JLabel denierJ1, orJ1, nourritureJ1, pierreJ1, boisJ1, tissuJ1, prestigeJ1;
    private JLabel denierJ2, orJ2, nourritureJ2, pierreJ2, boisJ2, tissuJ2, prestigeJ2;
    private JLabel denierJ3, orJ3, nourritureJ3, pierreJ3, boisJ3, tissuJ3, prestigeJ3;
    private JLabel denierJ4, orJ4, nourritureJ4, pierreJ4, boisJ4, tissuJ4, prestigeJ4;
    private JLabel denierJ5, orJ5, nourritureJ5, pierreJ5, boisJ5, tissuJ5, prestigeJ5;
    private JMenuBar menuBar;
    protected JMenuItem aide, quitter, newGame;
    private JMenu menu;

    protected JLabel[] cases;
    protected JLabel[] casesOuvrier;
    protected JLabel casesAuberge;
    protected JLabel caseEcurie2;
    protected JLabel caseEcurie3;

    protected JLabel[] ordreContruction;
    protected JLabel[] donjon;
    protected JLabel[] muraille;
    protected JLabel[] tour;

    protected JLabel passer, phase, infoPhase, tourJoueur;

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
        initMenu();
        createView();

        icone = Toolkit.getDefaultToolkit().getImage("res/img/icone.png");
        ImageIcon imageIcon = new ImageIcon("res/img/icone.png");
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        iconeApp = new ImageIcon(newimg);  // transform it back
        imageIcon = new ImageIcon("res/img/dut.png"); //unscaled image
        image = imageIcon.getImage();
        newimg = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        img = new ImageIcon("res/img/icone.png").getImage();
        this.setIconImage(icone);

    }

    private void initMenu() {

        menuBar = new JMenuBar();
        menu = new JMenu("menu");
        quitter = new JMenuItem("quitter");
        aide = new JMenuItem("aide");
        newGame = new JMenuItem("Nouvelle Partie");
        menu.add(newGame);
        menu.add(aide);
        menu.addSeparator();
        menu.add(quitter);
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    public void setMouseListener(MouseAdapter listener) {
        panelPrinc.addMouseMotionListener(listener);
        panelPrinc.addMouseListener(listener);
    }

    public void setMenuListener(ActionListener listener) {
        quitter.addActionListener(listener);
        aide.addActionListener(listener);
        newGame.addActionListener(listener);

    }

    public void editPInfo() {
        phase.setText(model.getPhase());
        infoPhase.setText(model.getInfoPhase());
        tourJoueur.setText(model.getTourJoueur());
    }

    public void editInfoPhase(String info) {
        infoPhase.setText(info);
    }

    public void initPInfo() {
        panelInfo = new JPanel(null);
        panelInfo.setPreferredSize(new Dimension(300, 300));

        Font font = new Font("Arial", Font.BOLD, 15);
        //Font fontRess = new Font("Arial",Font.BOLD,20);

        File is = new File("./res/font/Starjedi.ttf");
        Font fontPerso = null;
        try {
            fontPerso = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
        Font sizedFont = fontPerso.deriveFont(14f);

        phase = new JLabel(model.getPhase());
        panelInfo.add(phase, 0);
        initLabel(phase, 10, 10, 300, 50, sizedFont, Color.white);

        infoPhase = new JLabel(model.getInfoPhase());
        panelInfo.add(infoPhase, 0);
        initLabel(infoPhase, 50, 50, 300, 50, sizedFont, Color.white);

        tourJoueur = new JLabel(model.getTourJoueur());
        panelInfo.add(tourJoueur, 0);
        initLabel(tourJoueur, 120, 100, 300, 50, sizedFont, Color.white);

        passer = new JLabel(new ImageIcon("res/img/Passer.png"));
        panelInfo.add(passer, 0);
        initLabel(passer, 125, 200, 50, 50, sizedFont, Color.white);

        JLabel fond = new JLabel(new ImageIcon("res/img/infos.png"));
        panelInfo.add(fond);
        initLabel(fond, 0, 0, 300, 300, sizedFont, Color.white);


    }

    public void initLabel(JLabel label, int x, int y, int width, int height, Font font, Color color) {
        label.setFont(font);
        label.setForeground(color);
        label.setBounds(x, y, width, height);
        label.setOpaque(false);
    }

    public void initPanel(JPanel jPanel, int x, int y, int width, int height, Font font, Color color) {
        jPanel.setFont(font);
        jPanel.setForeground(color);
        jPanel.setBounds(x, y, width, height);
        jPanel.setOpaque(false);
    }

    public void editPJoueur() {

        joueur1.setText(model.getNom(1));
        ress1.setBorder(BorderFactory.createLineBorder(model.getColor(1), 3));
        denierJ1.setText("" + model.getDenier(1));
        orJ1.setText("" + model.getOr(1));
        nourritureJ1.setText("" + model.getNourriture(1));
        pierreJ1.setText("" + model.getPierre(1));
        boisJ1.setText("" + model.getBois(1));
        tissuJ1.setText("" + model.getTissu(1));
        prestigeJ1.setText("" + model.getPrestige(1));

        joueur2.setText(model.getNom(2));
        ress2.setBorder(BorderFactory.createLineBorder(model.getColor(2), 3));
        denierJ2.setText("" + model.getDenier(2));
        orJ2.setText("" + model.getOr(2));
        nourritureJ2.setText("" + model.getNourriture(2));
        pierreJ2.setText("" + model.getPierre(2));
        boisJ2.setText("" + model.getBois(2));
        tissuJ2.setText("" + model.getTissu(2));
        prestigeJ2.setText("" + model.getPrestige(2));


        if (model.nbrJoueurs >= 3) {
            joueur3.setText(model.getNom(3));
            ress3.setBorder(BorderFactory.createLineBorder(model.getColor(3), 3));
            denierJ3.setText("" + model.getDenier(3));
            orJ3.setText("" + model.getOr(3));
            nourritureJ3.setText("" + model.getNourriture(3));
            pierreJ3.setText("" + model.getPierre(3));
            boisJ3.setText("" + model.getBois(3));
            tissuJ3.setText("" + model.getTissu(3));
            prestigeJ3.setText("" + model.getPrestige(3));
        }
        if (model.nbrJoueurs >= 4) {
            joueur4.setText(model.getNom(4));
            ress4.setBorder(BorderFactory.createLineBorder(model.getColor(4), 3));
            denierJ4.setText("" + model.getDenier(4));
            orJ4.setText("" + model.getOr(4));
            nourritureJ4.setText("" + model.getNourriture(4));
            pierreJ4.setText("" + model.getPierre(4));
            boisJ4.setText("" + model.getBois(4));
            tissuJ4.setText("" + model.getTissu(4));
            prestigeJ4.setText("" + model.getPrestige(4));
        }
        if (model.nbrJoueurs >= 5) {
            joueur5.setText(model.getNom(5));
            ress5.setBorder(BorderFactory.createLineBorder(model.getColor(5), 3));
            denierJ5.setText("" + model.getDenier(5));
            orJ5.setText("" + model.getOr(5));
            nourritureJ5.setText("" + model.getNourriture(5));
            pierreJ5.setText("" + model.getPierre(5));
            boisJ5.setText("" + model.getBois(5));
            tissuJ5.setText("" + model.getTissu(5));
            prestigeJ5.setText("" + model.getPrestige(5));
        }
    }

    public void initPJoueur() {
        panelJoueur = new JPanel();
        panelJoueur.setPreferredSize(new Dimension(300, 1000));
        panelJoueur.setLayout(null);

        JLabel fond = new JLabel();
        fond.setIcon(new ImageIcon("res/img/joueur.png"));
        //g.drawImage(fond, 0, 0, this.getWidth(), this.getHeight(), this);

        Font font = new Font("Arial", Font.BOLD, 30);
        //Font fontRess = new Font("Arial",Font.BOLD,20);

        File is = new File("./res/font/Starjedi.ttf");
        Font fontPerso = null;
        try {
            fontPerso = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
        Font sizedFont = fontPerso.deriveFont(25f);

        panelJoueur.setFont(sizedFont);
        panelJoueur.setForeground(Color.white);

        joueur1 = new JLabel(model.getNom(1));
        initLabel(joueur1, 100, 50, 200, 50, null, null);
        panelJoueur.add(joueur1);

        ress1 = new JLabel(new ImageIcon("./res/img/Ressource/Ressource.png"));
        initLabel(ress1, 0, 0, 300, 65, null, null);


        ressJ1 = new JPanel(null);
        ressJ1.add(ress1);

        denierJ1 = new JLabel("" + model.getDenier(1));
        ressJ1.add(denierJ1, 0);
        initLabel(denierJ1, 29, 10, 50, 25, null, Color.black);
        orJ1 = new JLabel("" + model.getOr(1));
        ressJ1.add(orJ1, 0);
        initLabel(orJ1, 76, 6, 50, 25, null, Color.black);
        nourritureJ1 = new JLabel("" + model.getNourriture(1));
        ressJ1.add(nourritureJ1, 0);
        initLabel(nourritureJ1, 120, 6, 50, 25, null, Color.black);
        pierreJ1 = new JLabel("" + model.getPierre(1));
        ressJ1.add(pierreJ1, 0);
        initLabel(pierreJ1, 170, 6, 50, 25, null, Color.black);
        boisJ1 = new JLabel("" + model.getBois(1));
        ressJ1.add(boisJ1, 0);
        initLabel(boisJ1, 221, 6, 50, 25, null, Color.black);
        tissuJ1 = new JLabel("" + model.getTissu(1));
        ressJ1.add(tissuJ1, 0);
        initLabel(tissuJ1, 265, 6, 50, 25, null, Color.black);
        prestigeJ1 = new JLabel("" + model.getPrestige(1));
        ressJ1.add(prestigeJ1, 0);
        initLabel(prestigeJ1, 135, 33, 50, 25, null, Color.black);


        initPanel(ressJ1, 0, 100, 300, 65, sizedFont, Color.BLACK);
        panelJoueur.add(ressJ1, 0);


        joueur2 = new JLabel(model.getNom(2));
        initLabel(joueur2, 100, 200, 200, 50, null, null);
        panelJoueur.add(joueur2);

        ress2 = new JLabel(new ImageIcon("./res/img/Ressource/Ressource.png"));
        initLabel(ress2, 0, 0, 300, 65, null, null);

        ressJ2 = new JPanel(null);
        ressJ2.add(ress2);

        denierJ2 = new JLabel("" + model.getDenier(2));
        ressJ2.add(denierJ2, 0);
        initLabel(denierJ2, 29, 10, 50, 25, null, Color.black);
        orJ2 = new JLabel("" + model.getOr(2));
        ressJ2.add(orJ2, 0);
        initLabel(orJ2, 76, 6, 50, 25, null, Color.black);
        nourritureJ2 = new JLabel("" + model.getNourriture(2));
        ressJ2.add(nourritureJ2, 0);
        initLabel(nourritureJ2, 120, 6, 50, 25, null, Color.black);
        pierreJ2 = new JLabel("" + model.getPierre(2));
        ressJ2.add(pierreJ2, 0);
        initLabel(pierreJ2, 170, 6, 50, 25, null, Color.black);
        boisJ2 = new JLabel("" + model.getBois(2));
        ressJ2.add(boisJ2, 0);
        initLabel(boisJ2, 221, 6, 50, 25, null, Color.black);
        tissuJ2 = new JLabel("" + model.getTissu(2));
        ressJ2.add(tissuJ2, 0);
        initLabel(tissuJ2, 265, 6, 50, 25, null, Color.black);
        prestigeJ2 = new JLabel("" + model.getPrestige(2));
        ressJ2.add(prestigeJ2, 0);
        initLabel(prestigeJ2, 135, 33, 50, 25, null, Color.black);

        initPanel(ressJ2, 0, 250, 300, 65, sizedFont, Color.black);
        panelJoueur.add(ressJ2, 0);


        if (model.nbrJoueurs >= 3) {
            joueur3 = new JLabel(model.getNom(3));
            initLabel(joueur3, 110, 350, 200, 50, null, null);
            panelJoueur.add(joueur3);

            ress3 = new JLabel(new ImageIcon("./res/img/Ressource/Ressource.png"));
            initLabel(ress3, 0, 0, 300, 65, null, null);


            ressJ3 = new JPanel(null);
            ressJ3.add(ress3);

            denierJ3 = new JLabel("" + model.getDenier(3));
            ressJ3.add(denierJ3, 0);
            initLabel(denierJ3, 29, 10, 50, 25, null, Color.black);
            orJ3 = new JLabel("" + model.getOr(3));
            ressJ3.add(orJ3, 0);
            initLabel(orJ3, 76, 6, 50, 25, null, Color.black);
            nourritureJ3 = new JLabel("" + model.getNourriture(3));
            ressJ3.add(nourritureJ3, 0);
            initLabel(nourritureJ3, 120, 6, 50, 25, null, Color.black);
            pierreJ3 = new JLabel("" + model.getPierre(3));
            ressJ3.add(pierreJ3, 0);
            initLabel(pierreJ3, 170, 6, 50, 25, null, Color.black);
            boisJ3 = new JLabel("" + model.getBois(3));
            ressJ3.add(boisJ3, 0);
            initLabel(boisJ3, 221, 6, 50, 25, null, Color.black);
            tissuJ3 = new JLabel("" + model.getTissu(3));
            ressJ3.add(tissuJ3, 0);
            initLabel(tissuJ3, 265, 6, 50, 25, null, Color.black);
            prestigeJ3 = new JLabel("" + model.getPrestige(3));
            ressJ3.add(prestigeJ3, 0);
            initLabel(prestigeJ3, 135, 33, 50, 25, null, Color.black);

            initPanel(ressJ3, 0, 400, 300, 65, sizedFont, Color.black);
            panelJoueur.add(ressJ3, 0);
        }
        if (model.nbrJoueurs >= 4) {
            joueur4 = new JLabel(model.getNom(4));
            initLabel(joueur4, 110, 500, 200, 50, null, null);
            panelJoueur.add(joueur4);

            ress4 = new JLabel(new ImageIcon("./res/img/Ressource/Ressource.png"));
            initLabel(ress4, 0, 0, 300, 65, null, null);


            ressJ4 = new JPanel(null);
            ressJ4.add(ress4);
            denierJ4 = new JLabel("" + model.getDenier(4));
            ressJ4.add(denierJ4, 0);
            initLabel(denierJ4, 29, 10, 50, 25, null, Color.black);
            orJ4 = new JLabel("" + model.getOr(4));
            ressJ4.add(orJ4, 0);
            initLabel(orJ4, 76, 6, 50, 25, null, Color.black);
            nourritureJ4 = new JLabel("" + model.getNourriture(4));
            ressJ4.add(nourritureJ4, 0);
            initLabel(nourritureJ4, 120, 6, 50, 25, null, Color.black);
            pierreJ4 = new JLabel("" + model.getPierre(4));
            ressJ4.add(pierreJ4, 0);
            initLabel(pierreJ4, 170, 6, 50, 25, null, Color.black);
            boisJ4 = new JLabel("" + model.getBois(4));
            ressJ4.add(boisJ4, 0);
            initLabel(boisJ4, 221, 6, 50, 25, null, Color.black);
            tissuJ4 = new JLabel("" + model.getTissu(4));
            ressJ4.add(tissuJ4, 0);
            initLabel(tissuJ4, 265, 6, 50, 25, null, Color.black);
            prestigeJ4 = new JLabel("" + model.getPrestige(4));
            ressJ4.add(prestigeJ4, 0);
            initLabel(prestigeJ4, 135, 33, 50, 25, null, Color.black);


            initPanel(ressJ4, 0, 550, 300, 65, sizedFont, Color.black);
            panelJoueur.add(ressJ4, 0);
        }
        if (model.nbrJoueurs >= 5) {
            joueur5 = new JLabel(model.getNom(5));
            initLabel(joueur5, 110, 650, 200, 50, null, null);
            panelJoueur.add(joueur5);


            ress5 = new JLabel(new ImageIcon("./res/img/Ressource/Ressource.png"));
            initLabel(ress5, 0, 0, 300, 65, null, null);


            ressJ5 = new JPanel(null);
            ressJ5.add(ress5);

            denierJ5 = new JLabel("" + model.getDenier(5));
            ressJ5.add(denierJ5, 0);
            initLabel(denierJ5, 29, 10, 50, 25, null, Color.black);
            orJ5 = new JLabel("" + model.getOr(5));
            ressJ5.add(orJ5, 0);
            initLabel(orJ5, 76, 6, 50, 25, null, Color.black);
            nourritureJ5 = new JLabel("" + model.getNourriture(5));
            ressJ5.add(nourritureJ5, 0);
            initLabel(nourritureJ5, 120, 6, 50, 25, null, Color.black);
            pierreJ5 = new JLabel("" + model.getPierre(5));
            ressJ5.add(pierreJ5, 0);
            initLabel(pierreJ5, 170, 6, 50, 25, null, Color.black);
            boisJ5 = new JLabel("" + model.getBois(5));
            ressJ5.add(boisJ5, 0);
            initLabel(boisJ5, 221, 6, 50, 25, null, Color.black);
            tissuJ5 = new JLabel("" + model.getTissu(5));
            ressJ5.add(tissuJ5, 0);
            initLabel(tissuJ5, 265, 6, 50, 25, null, Color.black);
            prestigeJ5 = new JLabel("" + model.getPrestige(5));
            ressJ5.add(prestigeJ5, 0);
            initLabel(prestigeJ5, 135, 33, 50, 25, null, Color.black);

            initPanel(ressJ5, 0, 700, 300, 65, sizedFont, Color.black);
            panelJoueur.add(ressJ5, 0);
        }

        panelJoueur.add(fond);
        fond.setBounds(0, 0, 300, 1000);
    }

    public void initPLateau() {
        panelPlateau = new PanelPrinc(1000, 1000,"res/img/plateau.png");
        panelPlateau.setLayout(null);
        casesAuberge = new JLabel();
        caseEcurie2 = new JLabel();
        caseEcurie3 = new JLabel();

        int x = 400;
        int y = 200;
        int decalColonne = 90;
        int decalLigne = 80;
        int j = 3;

        cases = new JLabel[34];
        casesOuvrier = new JLabel[34];
        for (int i = 0; i < 34; i++) {
            cases[i] = new JLabel();
            casesOuvrier[i] = new JLabel();
            panelPlateau.add(casesOuvrier[i]);
            panelPlateau.add(cases[i]);
            if (j % 6 == 0 && j != 0) {
                y += decalLigne;
            }
            cases[i].setBounds(x, y, 70, 70);

            casesOuvrier[i].setBounds(x + 50, y + 50, 20, 20);
            if (i == 4) {
                caseEcurie2.setBounds(x + 50, y + 25, 20, 20);
                caseEcurie3.setBounds(x + 50, y, 20, 20);
                panelPlateau.add(caseEcurie2);
                panelPlateau.add(caseEcurie3);
            }
            if (i == 5) {
                casesAuberge.setBounds(x + 50, y, 20, 20);
                panelPlateau.add(casesAuberge);
            }


            if (j % 6 == 0 && j != 0) {
                decalColonne = -decalColonne;
                y += decalLigne;
            }
            if (i == 5) {
                x += 3 * decalColonne;
                decalLigne = 50;
                j = 4;
            }

            x += decalColonne;
            j++;
        }

        ordreContruction = new JLabel[model.nbrJoueurs];
        for (int i = 0; i < model.nbrJoueurs; i++) {
            ordreContruction[i] = new JLabel();
            panelPlateau.add(ordreContruction[i]);
            ordreContruction[i].setBounds(20, 50 + i * 30, 25, 25);
        }

        donjon = new JLabel[6];
        for (int i = 0; i < 6; i++) {
            donjon[i] = new JLabel();
            panelPlateau.add(donjon[i]);
            donjon[i].setBounds(300 + i * 30, 50, 25, 25);
        }
        muraille = new JLabel[10];
        for (int i = 0; i <10; i++) {
            muraille[i] = new JLabel();
            panelPlateau.add(muraille[i]);
            muraille[i].setBounds(300 + i * 30, 80, 25, 25);
        }
        tour = new JLabel[14];
        for (int i = 0; i <14; i++) {
            tour[i] = new JLabel();
            panelPlateau.add(tour[i]);
            tour[i].setBounds(300 + i * 30, 110, 25, 25);
        }
    }

    public void initImageCase() {
        editImageCase();

        for (JLabel label : ordreContruction) {
            label.setBackground(Color.GRAY);
            label.setOpaque(true);
        }
        for (JLabel label : donjon) {
            label.setBackground(Color.GRAY);
            label.setOpaque(true);
        }
        for (JLabel label : muraille) {
            label.setBackground(Color.GRAY);
            label.setOpaque(true);
        }
        for (JLabel label : tour) {
            label.setBackground(Color.GRAY);
            label.setOpaque(true);
        }
    }


    public void editImageCase() {
        for (int i = 0; i < 34; i++){
            cases[i].setOpaque(false);
            cases[i].setIcon(new ImageIcon("./res/img/Batiment/" + model.cases[i].getNomBat() + ".png"));
        }
    }

    public void createView() {
        panelPrinc = new JPanel();
        panelPrinc.setLayout(null);

        panelPlateau.setOpaque(false);
        panelJoueur.setOpaque(false);
        panelInfo.setOpaque(false);

        panelPrinc.add(panelJoueur);
        panelJoueur.setBounds(0, 0, 300, 1000);

        panelPrinc.add(panelInfo);
        panelInfo.setBounds(1000, 700, 300, 300);


        panelPrinc.add(panelPlateau);
        panelPlateau.setBounds(300, 0, 1000, 1000);


        setContentPane(panelPrinc);
    }


    public void display() {
        this.setVisible(true);
    }

    public void poserOuvrier(int coordonnees, Joueur joueur) {
        JLabel label = new JLabel();
        if (coordonnees == 5) {
            if (casesOuvrier[coordonnees].getBackground() == label.getBackground()) {
                casesOuvrier[coordonnees].setBackground(joueur.getCouleur());
                casesOuvrier[coordonnees].setOpaque(true);
            } else{
                casesAuberge.setBackground(joueur.getCouleur());
                casesAuberge.setOpaque(true);
            }
        } else if (coordonnees == 4) {
            if (casesOuvrier[coordonnees].getBackground() == label.getBackground()) {
                casesOuvrier[coordonnees].setBackground(joueur.getCouleur());
                casesOuvrier[coordonnees].setOpaque(true);
            } else if (caseEcurie2.getBackground() == label.getBackground()) {
                caseEcurie2.setBackground(joueur.getCouleur());
                caseEcurie2.setOpaque(true);
            } else {
                caseEcurie3.setBackground(joueur.getCouleur());
                caseEcurie3.setOpaque(true);
            }
        } else {
            casesOuvrier[coordonnees].setBackground(joueur.getCouleur());
            casesOuvrier[coordonnees].setOpaque(true);
        }
    }

    public void constChateau(int coordonnees, Joueur joueur) {
        ordreContruction[coordonnees].setBackground(joueur.getCouleur());
    }

    public void editChateau() {
        int i =0;
        for(Joueur joueur : model.chateau.donjon){
            if (joueur==null){
                donjon[i].setBackground(Color.GRAY);
            }else{
                donjon[i].setBackground(joueur.getCouleur());
            }
            i++;
        }
        i =0;
        for(Joueur joueur : model.chateau.muraille) {
            if (joueur == null) {
                muraille[i].setBackground(Color.GRAY);
            } else {
                muraille[i].setBackground(joueur.getCouleur());
            }
            i++;
        }
        i = 0;
        for (Joueur joueur : model.chateau.tour) {
            if (joueur == null) {
                tour[i].setBackground(Color.GRAY);
            } else {
                tour[i].setBackground(joueur.getCouleur());
            }
            i++;
        }
    }

    public void retireOuvrierChateau(){
        for(JLabel label : ordreContruction)
            label.setBackground(Color.gray);
    }



    public void setBaillis(int coordonnees) {
        int coordBaillis = model.baillis.getCoordonnée();
        cases[coordBaillis].setBorder(null);
        cases[coordonnees].setBorder(BorderFactory.createLineBorder(Color.white, 3));
        cases[coordonnees].setOpaque(false);
    }

    public void setPrévot(int coordonnees) {
        int coordPrévot = model.prévot.getCoordonnée();
        int coordBaillis = model.baillis.getCoordonnée();
        cases[coordPrévot].setBorder(null);
        if (coordPrévot == coordBaillis)
            cases[coordBaillis].setBorder(BorderFactory.createLineBorder(Color.white, 3));
        if (coordonnees == coordBaillis)
            cases[coordonnees].setBorder(BorderFactory.createLineBorder(Color.white, 3));
        else
            cases[coordonnees].setBorder(BorderFactory.createLineBorder(Color.white, 1));
        cases[coordonnees].setOpaque(false);
    }

    public String créerJoueur(int i) {
        String nom = "";
        while (nom.equals(""))
            nom = JOptionPane.showInputDialog(null, "Entrez un nom pour le Joueur " + i);
        return nom;
    }

    public void problèmeOuvrier(String joueur, int index) {
        if (index == -1)
            JOptionPane.showMessageDialog(null, "Il n'y a pas de poste ici " + joueur);
        if (index == -2)
            JOptionPane.showMessageDialog(null, "Vous n'avez plus d'ouvrier " + joueur);
        if (index == -3)
            JOptionPane.showMessageDialog(null, "Le poste est d'jà prit " + joueur);
        if (index == -4)
            JOptionPane.showMessageDialog(null, "Pas assez d'argent " + joueur);
    }

    public void problèmeChateau(String joueur, int index) {
        if (index == -1)
            JOptionPane.showMessageDialog(null, "Vous avez déjà un ouvrier qui travaille " + joueur);
    }

    public void retireOuvrier(int i) {
        JLabel label = new JLabel();
        if (i == 4) {
            caseEcurie2.setBackground(label.getBackground());
            caseEcurie2.setOpaque(false);
            caseEcurie3.setBackground(label.getBackground());
            caseEcurie3.setOpaque(false);
        }
        casesOuvrier[i].setBackground(label.getBackground());
        casesOuvrier[i].setOpaque(false);
    }

    public String panneauRecompense(String[] tabRec, String mess) {
        JOptionPane jop = new JOptionPane();
        String recompense = (String) jop.showInputDialog(null,

                "Faites un choix!",

                mess,
                JOptionPane.QUESTION_MESSAGE,
                null,
                tabRec, "Choisir");
        return recompense;
    }

    public int panneauChateau(String nom) {
        int nbrPartie = -1;
        while (nbrPartie < 0 || nbrPartie > 30)
            nbrPartie = Integer.parseInt(JOptionPane.showInputDialog(null, "Entrez un nombre de partie " + nom));
        return nbrPartie;
    }


    public int panneauPorte(String nom) {
        int coordonné = -1;
        while (coordonné < 0 || coordonné > 33)
            coordonné = Integer.parseInt(JOptionPane.showInputDialog(null, "Entrez une coordonnée " + nom));
        return coordonné;
    }

    public String choixConst(String[] bat, String joueur) {
        JOptionPane jop = new JOptionPane();
        return (String) jop.showInputDialog(null,

                "Faites un choix!",

                "Choisir où construire la résidence",
                JOptionPane.QUESTION_MESSAGE,
                null,
                bat, "Choisir");
    }


    public int deplPrevot(Joueur joueur) {
        String[] cases = {"-3 case", "-2 cases", "-1 cases", "0 case", "+1 case", "+2 cases", "+3 cases"};
        JOptionPane jop = new JOptionPane();
        int rang = jop.showOptionDialog(null,
                "Veuillez indiquer le nombre de cases " + joueur.getNom() + " !",
                " Déplacement prévot !",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                cases,
                cases[5]);
        return rang;
    }


    public void problèmeConstruction(int index, String ouvrier, String proprio) {
        if (index == -1)
            JOptionPane.showMessageDialog(null, "Vous n'avez pas les ressource " + ouvrier);
        if (index == -2)
            JOptionPane.showMessageDialog(null, "Vous n'avez pas les ressource " + proprio);
        if (index == -3)
            JOptionPane.showMessageDialog(null, "Vous n'avez pas les ressource " + proprio + " et " + ouvrier);
        if (index == -5)
            JOptionPane.showMessageDialog(null, "Vous n'avez pas de lieu de construction " + ouvrier);
        if (index == -6)
            JOptionPane.showMessageDialog(null, "Vous n'avez pas  construit pénalité de 2 prestiges " + ouvrier);
    }

    public void finDuGame(String vainqueur) {
            JOptionPane.showMessageDialog(null, "Vous avez gagné " + vainqueur);
    }

}