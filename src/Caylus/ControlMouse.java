package Caylus;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by thorx on 18/05/2017.
 */
public class ControlMouse extends MouseAdapter {
    private View view;
    private Model model;



    public ControlMouse(View view, Model model) {
        this.view = view;
        this.model = model;
        this.view.setMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        Point point = e.getPoint();
        int coordonnees = detectionCase(point);
        if(model.noPhase==1  && model.coutDePose!=1){
            model.phase1();
            coordonnees=-1;
        }
        if(model.noPhase==1 && coordonnees==-100 && model.coutDePose==1){
            model.noPhase++;
            model.phase2();
            view.editPInfo();
            coordonnees=-1;
        }
        if(model.noPhase==2 && coordonnees==-100){
            model.joueurPasse();
            coordonnees=-1;
        }
        if(model.noPhase==2 && coordonnees==-200){
            model.constChateau();
            coordonnees=-1;
        }
        if(model.noPhase==2 && coordonnees>-1 && coordonnees<34){
            model.poseOuvrier(coordonnees);
            coordonnees=-1;
        }
        if(model.noPhase==3 && coordonnees==-100){
            model.phase3();
            coordonnees=-1;
        }
        if(model.noPhase==4 && coordonnees==-100){
            model.phase4();
            coordonnees=-1;
        }
        if(model.noPhase==5 && coordonnees==-100){
            model.phase5();
            coordonnees=-1;
        }
        if(model.noPhase==6 && coordonnees==-100){
            model.phase6();
            coordonnees=-1;
        }
        if(model.noPhase==7 && coordonnees==-100){
            model.phase7();
            coordonnees=-1;
        }
    }

    public int detectionCase(Point point){
        int coordonnees = -1;
        if( (point.getX() > 1125) && (point.getX() < 1173) && (point.getY() > 900) && (point.getY() < 948))
            coordonnees=-100;
        for(int i = 0; i<34; i++)
                if( (point.getX() > view.cases[i].getX()+300 )&& (point.getX() < (view.cases[i].getX()+300+70)) && (point.getY() > view.cases[i].getY()) && (point.getY() < (view.cases[i].getY()+70)))
                    coordonnees = i;
        for(int i = 0; i<model.nbrJoueurs; i++)
            if( (point.getX() > 350 && (point.getX() < 550)) && (point.getY() > 15 && (point.getY() < 215)))
                coordonnees = -200;
        return coordonnees;
    }

    public void mouseEntered(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
}
