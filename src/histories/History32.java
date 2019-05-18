/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package histories;

import gamesInstructions.Instruction3;
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
public class History32 extends JFrame {
    //Declare
    
    //******************** AUDIOS ********************
    AudioClip soundButton;
    //************************************************
    
    //********************* PANEL ********************
    PanelHistory32 panelStartGame;                               //Panel where the background image and buttons will be placed
    //************************************************
    
    public History32 () {
        //Instantiate
        
        panelStartGame = new PanelHistory32("/images/history3-2Background.png");
        
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
    public class PanelHistory32 extends JPanel implements ActionListener {
        //Declare
        
        private String name;
        
        //**************** IMAGES ***************
        ImageIcon background;                                  //Image for the History 1 background
        ImageIcon imageNext;                                   //Image for the Next button 
        ImageIcon imageBack;                                   //Image for the Back button 
        //***************************************
        
        //*************** BUTTONS ***************
        JButton next;                                          //Button to continue with the game
        JButton back;                                          //Button to return
        //***************************************

        public PanelHistory32(String name) {
            //Instantiate
            
            this.name = name;
            setLayout(null);
            
            imageButtons();                                    //Load the button images
            
            next = new JButton(imageNext);
            back = new JButton(imageBack);
            
            //Add
        
            //***************** ADD BUTTONS *****************
            next.setBounds(860, 550, 150, 50);                 //Locate the position and size of the Next button
            next.setContentAreaFilled(false);                  //Cancels the Next background
            next.setBorder(null);                              //Overrides the edges of the Next button
            next.setCursor(new Cursor(HAND_CURSOR));
            back.setBounds(50, 550, 150, 50);                  //Locate the position and size of the Back button
            back.setContentAreaFilled(false);                  //Cancels Back background
            back.setBorder(null);                              //Overrides the edges of the Back button
            back.setCursor(new Cursor(HAND_CURSOR));
            add(next);                                         //Add the Next button to the panel
            add(back);                                         //Add the Back button to the panel
            //***********************************************
            
            setVisible(true);
            
            next.addActionListener(this);
            back.addActionListener(this);
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == next) {
                soundButton.play();
                Instruction3 i3 = new Instruction3();
                dispose();                                     //Method to close the class that is open
            }
            if(e.getSource() == back) {
                soundButton.play();
                History3 h3 = new History3();
                dispose();
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
            imageBack = new ImageIcon("src/images/buttonBack.png");
        }
        
        
    }
    //****************************************************
}
//************************************************