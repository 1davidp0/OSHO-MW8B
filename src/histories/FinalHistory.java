/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package histories;

import java.applet.AudioClip;
import java.awt.Cursor;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

/**
 *
 * @author DavidGD
 */

//****************** MAIN CLASS **********************
public class FinalHistory extends JFrame {
    //Declare
    
    //******************** AUDIOS ********************
    AudioClip soundButton;
    //************************************************
    
    //********************* PANEL ********************
    PanelFinalHistory panelStartGame;                               //Panel where the background image and buttons will be placed
    //************************************************
    
    public FinalHistory () {
        //Instantiate
        
        panelStartGame = new PanelFinalHistory("/images/finalhistory1Background.png");
        
        soundButton = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/soundButton.wav"));
        
        //Add
        
        setSize(1080, 720);                                    //Size of the Start Game window
        setLocationRelativeTo(null);                           //Place the Start Game window towards the center
        setTitle("Medieval World 8 Bits: Historia");           //Add a title to the Start Game window
        setDefaultCloseOperation(EXIT_ON_CLOSE);               //When the game closes, the program ends
        
        //****************** ADD PANEL ******************
        this.getContentPane().add(panelStartGame);             //Add the panel and its content to the JFrame
        panelStartGame.setLayout(null);                        //To deactivate the design
        //***********************************************
        
        setVisible(true);
    }
    
    //****************** SUB CLASSES *********************
    public class PanelFinalHistory extends JPanel implements ActionListener {
        //Declare
        
        private String name;
        
        //**************** IMAGES ***************
        ImageIcon background;                                  //Image for the History 1 background
        ImageIcon imageNext;                                   //Image for the Next button
        //***************************************
        
        //*************** BUTTONS ***************
        JButton next;                                          //Button to continue with the game
        //***************************************

        public PanelFinalHistory(String name) {
            //Instantiate
            
            this.name = name;
            setLayout(null);
            
            imageButtons();                                    //Load the button images
            
            next = new JButton(imageNext);
            
            //Add
        
            //***************** ADD BUTTONS *****************
            next.setBounds(860, 550, 150, 50);                 //Locate the position and size of the Next button
            next.setContentAreaFilled(false);                  //Cancels the Next background
            next.setBorder(null);                              //Overrides the edges of the Next button
            next.setCursor(new Cursor(HAND_CURSOR));
            add(next);                                         //Add the Next button to the panel
            //***********************************************
            
            setVisible(true);
            
            next.addActionListener(this);
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == next) {
                soundButton.play();
                menu.Menu m = new menu.Menu();
                dispose();                                     //Method to close the class that is open
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
            imageNext = new ImageIcon("src/images/buttonNext.png");
        }
    }
    //****************************************************
}
//************************************************