import javax.swing.*;
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
        if(coordonnees!=-1)
            model.poserOuvrier(coordonnees, model.tourJoueur());
    }

    public int detectionCase(Point point){
        int coordonnees = -1;
        for(int i = 0; i<34; i++)
                if( (point.getX() > view.cases[i].getX()) && (point.getX() < (view.cases[i].getX()+70)) && (point.getY() > view.cases[i].getY()) && (point.getY() < (view.cases[i].getY()+70)))
                    coordonnees = i;
        return coordonnees;
    }

    public void mouseEntered(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
}
