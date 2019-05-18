/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamesInstructions;

import game.Game2;
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
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author DavidGD
 */

//****************** MAIN CLASS **********************
public class Instruction2 extends JFrame {
    //Declare
    
    //******************** AUDIOS ********************
    AudioClip soundButton;
    //************************************************
    
    //********************* PANEL ********************
    PanelInstruction2 panelInstruction2;                       //Panel where the background image and buttons will be placed
    //************************************************

    public Instruction2() {
        //Instantiate
        
        panelInstruction2 = new PanelInstruction2("/images/instructGame2.png");
        
        soundButton = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/soundButton.wav"));
        
        //Add
        
        setSize(1030, 640);                                    //Size of the Start Game window
        setLocationRelativeTo(null);                           //Place the Start Game window towards the center
        setTitle("Medieval World 8 Bits: Instrucciones 2");    //Add a title to the Start Game window
        setDefaultCloseOperation(EXIT_ON_CLOSE);               //When the game closes, the program ends
        
        //****************** ADD PANEL ******************
        this.getContentPane().add(panelInstruction2);          //Add the panel and its content to the JFrame
        panelInstruction2.setLayout(null);                     //To deactivate the design
        //***********************************************
        
        setVisible(true);
    }
    
    //****************** SUB CLASSES *********************
    public class PanelInstruction2 extends JPanel implements ActionListener {
        
        private String name;
        
        //**************** IMAGES ***************
        ImageIcon background;                                  //Image for the Instruction 2 background
        ImageIcon imageNext;                                   //Image for the Next button
        ImageIcon imageMap;                                    //Image for show the map that have to build
        //***************************************
        
        //**************** LABELS ***************
        JLabel labelMap;                                       //Label to show the map
        //***************************************
        
        //*************** BUTTONS ***************
        JButton buttonNext;                                    //Button to enter the game
        //***************************************
        
        public PanelInstruction2(String name) {
            //Instantiate
            
            this.name = name;
            setLayout(null);
            
            //****************** LOAD IMAGES ****************
            imageLabels();                                     //Load the label images
            imageButtons();                                    //Load the button images
            //***********************************************
            
            labelMap = new JLabel(imageMap);
            buttonNext = new JButton(imageNext);
            
            //Add
            
            //***************** ADD LABELS ******************
            labelMap.setBounds(120, 150, 80, 100);             //Locate the position and size of the Map label
            add(labelMap);                                     //Add the Map label to the panel
            //***********************************************
            
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
                Game2 g2 = new Game2();
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
        
        private void imageLabels() {
            imageMap = new ImageIcon("src/images/c3.png");
        }
        
        private void imageButtons() {
            imageNext = new ImageIcon("src/images/buttonNext.png");
        }
    }
    //***************************************
}
//***************************************