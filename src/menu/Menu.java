/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import about.AboutUs;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import characterInfo.ChooseCharacter;
import instruct.Instructions;
import java.applet.AudioClip;
import java.awt.Cursor;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.Graphics;

/**
 *
 * @author DavidGD
 */

//****************** MAIN CLASS **********************
public class Menu extends JFrame {
    //Declare
    
    //******************** AUDIOS ********************
    AudioClip soundFrame;
    AudioClip soundButton;
    //************************************************
    
    //********************* PANEL ********************
    PanelMenu panelMenu;                                        //Panel where the background image and buttons will be placed
    //************************************************
    
    public Menu() {
        //Instantiate
        
        panelMenu = new PanelMenu("/images/menuBackground.png");
        
        soundFrame = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/soundGame.wav"));
        soundButton = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/soundButton.wav"));
        
        //Add
        
        soundFrame.play();
        
        setSize(1080, 720);                                     //Size of the Menu window
        setLocationRelativeTo(null);                            //Place the Menu window towards the center
        setTitle("Medieval World 8 Bits: Menú");                //Add a title to the Menu window
        setDefaultCloseOperation(EXIT_ON_CLOSE);                //When the game closes, the program ends
        
        //******************* ADD PANEL ******************
        this.getContentPane().add(panelMenu);                   //Add the panel and its content to the JFrame
        panelMenu.setLayout(null);                              //To deactivate the design
        //************************************************
        
        setVisible(true);                                       //Makes visible what is inside the window
    }
    
    //****************** SUB CLASSES *********************
    public class PanelMenu extends JPanel implements ActionListener {
        //Declare
        
        private String name;
        
        //****************** IMAGES **********************
        ImageIcon background;                                   //Image for the Menu background
        ImageIcon imagePlay;                                    //Image for the Play button
        ImageIcon imageInstructions;                            //Image for the Instruction button
        ImageIcon imageAboutUs;                                 //Image for the About Us button
        ImageIcon imageExit;                                    //Image for the Exit button
        //************************************************
        
        //***************** BUTTONS **********************
        JButton play;                                           //Button to Play
        JButton instructions;                                   //Button to see the instructions of the game
        JButton aboutUs;                                        //Button to read a description of the creators of the game
        JButton exit;                                           //Button to exit the game
        //************************************************
        
        public PanelMenu(String name) {
            //Instantiate
            
            this.name = name;
            setLayout(null);
            
            //****************** LOAD IMAGES ****************
            imageButtons();                                     //Load the button images
            //***********************************************
            
            play = new JButton(imagePlay);
            instructions = new JButton(imageInstructions);
            aboutUs = new JButton(imageAboutUs);
            exit = new JButton(imageExit);
            
            //Add
            
            //***************** ADD BUTTONS *****************
            play.setBounds(250, 400, 150, 50);                  //Locate the position and size of the Play button
            play.setContentAreaFilled(false);                   //Cancels the Play button background
            play.setBorder(null);                               //Overrides the edges of the Play button
            play.setCursor(new Cursor(HAND_CURSOR));
            instructions.setBounds(250, 500, 150, 50);          //Locate the position and size of the Instruction button
            instructions.setContentAreaFilled(false);           //Cancels the Instruction button background
            instructions.setBorder(null);                       //Overrides the edges of the Instruction button
            instructions.setCursor(new Cursor(HAND_CURSOR));
            aboutUs.setBounds(660, 400, 150, 50);               //Locate the position and size of the About Us button
            aboutUs.setContentAreaFilled(false);                //Cancels the About Us button background
            aboutUs.setBorder(null);                            //Overrides the edges of the About Us button
            aboutUs.setCursor(new Cursor(HAND_CURSOR));
            exit.setBounds(660, 500, 150, 50);                  //Locate the position and size of the Exit button
            exit.setContentAreaFilled(false);                   //Cancels the Exit button background
            exit.setBorder(null);                               //Overrides the edges of the Exit button
            exit.setCursor(new Cursor(HAND_CURSOR));
            add(play);                                          //Add the Play button to the panel
            add(instructions);                                  //Add the Instructions button to the panel
            add(aboutUs);                                       //Add the About Us button to the panel
            add(exit);                                          //Add the Exit button to the panel
            //***********************************************
            
            setVisible(true);
            
            play.addActionListener(this);
            instructions.addActionListener(this);
            aboutUs.addActionListener(this);
            exit.addActionListener(this);
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()== play) {
                soundButton.play();
                soundFrame.stop();
                ChooseCharacter cc = new ChooseCharacter();
                dispose();                                      //Method to close the class that is open
            }
            if (e.getSource()== instructions) {
                soundButton.play();
                soundFrame.stop();
                Instructions it = new Instructions();
                dispose();                                      //Method to close the class that is open
            }
            if (e.getSource()== aboutUs) {
                soundButton.play();
                soundFrame.stop();
                AboutUs au = new AboutUs();
                dispose();                                      //Method to close the class that is open
            }
            if (e.getSource()== exit) {
                soundButton.play();
                soundFrame.stop();
                System.exit(0);
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
            imagePlay = new ImageIcon("src/images/buttonPlay.png");
            imageInstructions = new ImageIcon("src/images/buttonInstructions.png");
            imageAboutUs = new ImageIcon("src/images/buttonAboutUs.png");
            imageExit = new ImageIcon("src/images/buttonExit.png");
        }
    
    }
    //****************************************************
    
}
//****************************************************