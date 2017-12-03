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
        if(model.noPhase==1 && coordonnees==-100 && model.coutDePose!=1){
            model.phase1();
            coordonnees=-1;
        }
        if(model.noPhase==1 && coordonnees==-100 && model.coutDePose==1){
            model.noPhase++;
            view.editPInfo();
            coordonnees=-1;
        }
        if(model.noPhase==2 && coordonnees==-100){
            model.joueurPasse();
            coordonnees=-1;
        }
        if(model.noPhase==2 && coordonnees>-1 && coordonnees<34){
            model.phase2(coordonnees);
            coordonnees=-1;
        }
    }

    public int detectionCase(Point point){
        int coordonnees = -1;
        if( (point.getX() > view.passer.getX()) && (point.getX() < (view.passer.getX()+50)) && (point.getY() > view.passer.getY()) && (point.getY() < (view.passer.getY()+50)))
            coordonnees=-100;
        for(int i = 0; i<34; i++)
                if( (point.getX() > view.cases[i].getX()) && (point.getX() < (view.cases[i].getX()+70)) && (point.getY() > view.cases[i].getY()) && (point.getY() < (view.cases[i].getY()+70)))
                    coordonnees = i;
        return coordonnees;
    }

    public void mouseEntered(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
}
