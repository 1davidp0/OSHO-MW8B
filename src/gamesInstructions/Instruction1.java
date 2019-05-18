/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamesInstructions;

import game.Game1;
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
public class Instruction1 extends JFrame {
    //Declare
    
    //******************** AUDIOS ********************
    AudioClip soundButton;
    //************************************************
    
    //********************* PANEL ********************
    PanelInstruction1 panelInstruction1;                       //Panel where the background image and buttons will be placed
    //************************************************

    public Instruction1() {
        //Instantiate
        
        panelInstruction1 = new PanelInstruction1("/images/instructGame1.png");
        
        soundButton = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/soundButton.wav"));
        
        //Add
        
        setSize(1030, 640);                                    //Size of the Start Game window
        setLocationRelativeTo(null);                           //Place the Start Game window towards the center
        setTitle("Medieval World 8 Bits: Instrucciones 1");    //Add a title to the Start Game window
        setDefaultCloseOperation(EXIT_ON_CLOSE);               //When the game closes, the program ends
        
        //****************** ADD PANEL ******************
        this.getContentPane().add(panelInstruction1);          //Add the panel and its content to the JFrame
        panelInstruction1.setLayout(null);                     //To deactivate the design
        //***********************************************
        
        setVisible(true);
    }
    
    //************* SUB-CLASSES *************
    public class PanelInstruction1 extends JPanel implements ActionListener {
        
        private String name;
        
        //**************** IMAGES ***************
        ImageIcon background;                                  //Image for the Instruction 1 background
        ImageIcon imageNext;                                   //Image for the Next button
        ImageIcon imageCard1;                                  //Imege to explain the Game 1
        ImageIcon imageCard2;                                  //Imege to explain the Game 1
        //***************************************
        
        //*************** BUTTONS ***************
        JButton buttonNext;                                    //Button to enter the game
        //***************************************
        
        public PanelInstruction1(String name) {
            //Instantiate
            
            this.name = name;
            setLayout(null);
            
            //****************** LOAD IMAGES ****************
            imageButtons();                                    //Load the button images
            //***********************************************
            
            buttonNext = new JButton(imageNext);
            
            //Add
            
            //***************** ADD BUTTONS *****************
            buttonNext.setBounds(800, 470, 150, 50);           //Locate the position and size of the Next button
            buttonNext.setContentAreaFilled(false);            //Cancels the Next button background
            buttonNext.setBorder(null);                        //Overrides the edges of the Next button
            buttonNext.setCursor(new Cursor(HAND_CURSOR));
            add(buttonNext);                                   //Add the Next button to the panel
            //***********************************************
            
            setVisible(true);
            
            buttonNext.addActionListener(this);
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == buttonNext){
                soundButton.play();
                Game1 g1 = new Game1();
                dispose();                                     //Method to close the class that is open
            }
        }
        
        @Override
        public void paint (Graphics g){
            ImageIcon font = new ImageIcon (getClass().getResource(name));
            g.drawImage(font.getImage(), 0, 0, getWidth(), getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
        
        private void imageButtons() {
            imageNext = new ImageIcon("src/images/buttonNext.png");
        }
    }
    //***************************************
}
//***************************************