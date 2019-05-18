/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author DavidGD
 */

public class MovementMethods extends JPanel {
    
    private ImageIcon image;
    private String name;
    
    public MovementMethods(String nombre){
        this.name = nombre;
    }
     
    boolean atributo= (false);
    
    /**
     * @return the image
     */
    public ImageIcon getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(ImageIcon image) {
        this.image = image;
    }

    /**
     * @return the name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }
    
}
