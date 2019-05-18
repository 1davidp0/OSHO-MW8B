/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author DavidGD
 */

public class EntranceMovement  extends MovementMethods implements MouseMotionListener {
    final private JPanel miPanel;
    private boolean var = false;
    
    public EntranceMovement(String nombre, JPanel miPanel) {
        super(nombre);
        
        addMouseMotionListener(this);
        
        this.miPanel = miPanel; 
        
    }
    
    boolean d = false;
     public void colicion(JPanel position1) {
        if(this.getX() >= position1.getX() && this.getX()+this.getWidth() <= position1.getX()+position1.getWidth()
            && this.getY() >= position1.getY() && this.getY()+this.getHeight() <= position1.getY()+position1.getHeight()){
            var = true;
        }
        else{
            var = false;
        }
        
    }
    @Override
    public void mouseDragged(MouseEvent me) {
	setLocation(this.getX() + me.getX() - this.getWidth() / 2, this.getY() + me.getY() - this.getHeight() / 2);
        colicion(miPanel);
    }

    @Override
    public void mouseMoved(MouseEvent me) {
    
    }
    
    @Override
    public void paint (Graphics g) {
        setImage(new ImageIcon(getClass().getResource(getName())));
        g.drawImage(getImage().getImage(), 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }

    /**
     * @return the var
     */
    public boolean isVar() {
        return var;
    }

    /**
     * @param var the var to set
     */
    public void setVar(boolean var) {
        this.var = var;
    }
    
}
