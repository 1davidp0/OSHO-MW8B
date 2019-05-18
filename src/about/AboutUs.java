/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package about;

import java.applet.AudioClip;
import java.awt.Cursor;
import static java.awt.Frame.HAND_CURSOR;
import menu.Menu;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author DavidGD
 */

//****************** MAIN CLASS **********************
public class AboutUs extends JFrame {
    //Declare
    
    //******************** AUDIOS ********************
    AudioClip soundButton;
    //************************************************
    
    //********************* PANEL ********************
    PanelAboutUs panelAboutUs;                                  //Panel where the background image and buttons will be placed
    //************************************************
    
    public AboutUs() {
        //Instantiate
        
        panelAboutUs = new PanelAboutUs("/images/aboutBackground.png");
        
        soundButton = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/soundButton.wav"));
        
        //Add
        
        setSize(1080, 720);                                     //Size of the About Us window
        setLocationRelativeTo(null);                            //Place the About Us window towards the center
        setTitle("Medieval World 8 Bits: Acerca de");           //Add a title to the About Us window
        setDefaultCloseOperation(EXIT_ON_CLOSE);                //When the game closes, the program ends
        
        //******************* ADD PANEL ******************
        this.getContentPane().add(panelAboutUs);                //Add the panel and its content to the JFrame
        panelAboutUs.setLayout(null);                           //To deactivate the design
        //************************************************
        
        setVisible(true);
    }
    
    //****************** SUB CLASSES *********************
    public class PanelAboutUs extends JPanel implements ActionListener {
        //Declare
        
        private String name;
        
        //****************** IMAGES **********************
        ImageIcon background;                                   //Image for the About Us background
        ImageIcon imageBack;                                    //Image for the Back button
        //************************************************
        
        //***************** BUTTONS **********************
        JButton backMenu;                                       //Button to return to menu
        //************************************************

        public PanelAboutUs(String name) {
            //Instantiate
            
            this.name = name;
            setLayout(null);
            
            //****************** LOAD IMAGES ****************
            imageButtons();                                     //Load the button images
            //***********************************************
            
            backMenu = new JButton(imageBack);
            
            //Add
            
            //***************** ADD BUTTONS *****************
            backMenu.setBounds(860, 550, 150, 50);              //Locate the position and size of the Back Menu button
            backMenu.setContentAreaFilled(false);               //Cancels the Back Menu button background
            backMenu.setBorder(null);                           //Overrides the edges of the Back Menu button
            backMenu.setCursor(new Cursor(HAND_CURSOR));
            add(backMenu);                                      //Add the Back Menu to the panel
            //***********************************************
            
            setVisible(true);
            
            backMenu.addActionListener(this);
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == backMenu) {
                soundButton.play();
                Menu m1 = new Menu();
                dispose();                                      //Method to close the class that is open
            }
        }
        
        @Override
        public void paint(Graphics g) {
            background = new ImageIcon(getClass().getResource(name));
            g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
        
        private void imageButtons() {
            imageBack = new ImageIcon("src/images/buttonBack.png");
        }
    }
    //***************************************
}
//***************************************