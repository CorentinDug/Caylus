package Caylus;

import com.apple.eawt.Application;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Schnoeby on 25/11/2017.
 */
public class ViewMenu extends JFrame {

    private JButton deuxJoueurs, troisJoueurs, quatreJoueurs, cinqJoueurs, quitter;
    private JLabel title;
    private Image icone;
    private ImageIcon iconeDUT;
    private Image img;
    private Application app;

    public ViewMenu() {
        this.init();
        this.createView();
        this.pack();
        this.setSize(800, 400);
        this.setLocationRelativeTo(null);
        this.setTitle("Caylus");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.display();
        this.icone = Toolkit.getDefaultToolkit().getImage("res/img/icone.png");
        this.img = new ImageIcon("res/img/icone.png").getImage();  // your desired image
        this.app = Application.getApplication();
        try {
            app.setDockIconImage(img);
        } catch(NullPointerException e) {
            //e.printStackTrace();
        }
        this.setIconImage(icone);

    }

    public void setButtonControler(ActionListener listener) {
        deuxJoueurs.addActionListener(listener);
        troisJoueurs.addActionListener(listener);
        quatreJoueurs.addActionListener(listener);
        cinqJoueurs.addActionListener(listener);
        quitter.addActionListener(listener);
    }

    public void init(){
        deuxJoueurs = new JButton();
        troisJoueurs = new JButton();
        quatreJoueurs = new JButton();
        cinqJoueurs = new JButton();
        quitter = new JButton();
        title = new JLabel();
        BufferedImage imageTitle = null;
        try {
            imageTitle = ImageIO.read(new File("./res/img/logo_title.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageIcon imageIcon = new ImageIcon("res/img/dut.png");
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        this.iconeDUT = new ImageIcon(newimg);
        ImageIcon iconTitle = new ImageIcon(imageTitle);
        iconTitle = new ImageIcon(iconTitle.getImage().getScaledInstance(200, 45, BufferedImage.SCALE_SMOOTH));
        title.setIcon(iconTitle);

        deuxJoueurs.setPreferredSize(new Dimension(128, 180));
        troisJoueurs.setPreferredSize(new Dimension(128, 180));
        quatreJoueurs.setPreferredSize(new Dimension(128, 180));
        cinqJoueurs.setPreferredSize(new Dimension(128, 180));
        quitter.setPreferredSize(new Dimension(120, 50));

        deuxJoueurs.setIcon(setButtonIcon("deuxJoueurs", 128,180));
        troisJoueurs.setIcon(setButtonIcon("troisJoueurs", 128,180));
        quatreJoueurs.setIcon(setButtonIcon("quatreJoueurs", 128,180));
        cinqJoueurs.setIcon(setButtonIcon("cinqJoueurs", 128,180));
        quitter.setIcon(setButtonIcon("quitter", 120,50));

    }
    public void createView(){
        PanelPrinc jpp = new PanelPrinc(800,400);

        jpp.setLayout(new GridLayout(1,1));
        JPanel jPanelGlobal = new JPanel(new GridBagLayout());
        JPanel jPanelJoueur = new JPanel(new GridBagLayout());
        JPanel jPanelTitle = new JPanel();
        JPanel jPanelQuitter = new JPanel(new GridBagLayout());


        jPanelGlobal.setOpaque(false);
        jPanelTitle.setOpaque(false);
        jPanelJoueur.setOpaque(false);
        jPanelQuitter.setOpaque(false);

        jPanelTitle.add(title,new GridBagConstraints());
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = gbc2.gridy = 0;

        gbc2.gridheight = 1;
        gbc2.insets = new Insets(5, 20, 0, 20);
        jPanelJoueur.add(deuxJoueurs,gbc2);
        gbc2.gridx = 1;
        gbc2.gridy = 0;
        jPanelJoueur.add(troisJoueurs,gbc2);
        gbc2.gridx = 2;
        gbc2.gridy = 0;
        jPanelJoueur.add(quatreJoueurs,gbc2);
        gbc2.gridx = 3;
        gbc2.gridy = 0;
        jPanelJoueur.add(cinqJoueurs,gbc2);

        gbc2.insets = new Insets(0, 10, 0, 10);
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        jPanelQuitter.add(quitter, gbc2);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gbc.gridy = 0;

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(5, 0, 0, 0);

        jPanelGlobal.add(jPanelTitle,gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(20, 0, 0, 0);
        jPanelGlobal.add(jPanelJoueur, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        jPanelGlobal.add(jPanelQuitter, gbc);
        jpp.add(jPanelGlobal);

        setContentPane(jpp);

    }
    public void display() {
        this.setVisible(true);
    }

    public void undisplay(){ this.setVisible(false); }

    public JButton getDeuxJoueurs() {
        return deuxJoueurs;
    }

    public JButton getTroisJoueurs() {
        return troisJoueurs;
    }


    public JButton getQuatreJoueurs() {
        return quatreJoueurs;
    }

    public JButton getCinqJoueurs() {return cinqJoueurs;}

    public JButton getQuitter() {
        return quitter;
    }


    public ImageIcon setButtonIcon(String buttonName, int width, int height){
        BufferedImage imageCase = null;
        try {
            imageCase = ImageIO.read(new File("./res/img/" + buttonName +".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageIcon iconCase = new ImageIcon(imageCase);
        iconCase = new ImageIcon(iconCase.getImage().getScaledInstance(width, height, BufferedImage.SCALE_SMOOTH));
        return iconCase;
    }


}
