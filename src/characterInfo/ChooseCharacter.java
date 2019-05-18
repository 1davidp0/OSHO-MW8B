/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characterInfo;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import menu.Menu;

/**
 *
 * @author DavidGD
 */

//****************** MAIN CLASS **********************
public class ChooseCharacter extends JFrame {
    //Declare
    
    //******************** AUDIOS ********************
    AudioClip soundButton;
    //************************************************
    
    //********************* PANEL ********************
    PanelChCharacter panelChooseCh;                             //Panel where the background image and buttons will be placed
    //************************************************
    
    public ChooseCharacter() {
        //Instantiate
        
        panelChooseCh = new PanelChCharacter("/images/chCharacterBackground.png");
        
        soundButton = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/soundButton.wav"));
        
        //Add
        
        setSize(1080, 720);                                     //Size of the Choose Character window
        setLocationRelativeTo(null);                            //Place the Choose Character window towards the center
        setTitle("Medieval World 8 Bits: Escoger personaje");   //Add a title to the Choose Character window
        setDefaultCloseOperation(EXIT_ON_CLOSE);                //When the game closes, the program ends
        
        //******************* ADD PANEL ******************
        this.getContentPane().add(panelChooseCh);               //Add the panel and its content to the JFrame
        panelChooseCh.setLayout(null);                          //To deactivate the design
        //************************************************
        
        setVisible(true);
    }
    
    //****************** SUB CLASSES *********************
    public class PanelChCharacter extends JPanel implements ActionListener {
        //Declare
        
        private String name;
        
        //****************** IMAGES **********************
        ImageIcon background;                                   //Image for the Character Data background
        ImageIcon character1;                                   //Image for the Character 1 button
        ImageIcon character2;                                   //Image for the Character 2 button
        ImageIcon character3;                                   //Image for the Character 3 button
        ImageIcon imageBack;                                    //Image for the Back button 
        //************************************************
        
        //****************** LABELS **********************
        JLabel labelCharacter1;                                 //Label to name the Character button 1
        JLabel labelCharacter2;                                 //Label to name the Character button 2
        JLabel labelCharacter3;                                 //Label to name the Character button 3
        //************************************************
        
        //***************** BUTTONS **********************
        JButton buttonCharacter1;                               //Button for the character 1
        JButton buttonCharacter2;                               //Button for the character 2
        JButton buttonCharacter3;                               //Button for the character 3
        JButton backMenu;                                       //Button to return to menu
        //************************************************

        public PanelChCharacter(String name) {
            //Instantiate
            
            this.name = name;
            setLayout(null);
            
            //****************** LOAD IMAGES ****************
            imageCharacters();                                  //Load the Character button images
            imageButtons();                                     //Load the button images
            //***********************************************
            
            labelCharacter1 = new JLabel("Caballero");
            labelCharacter2 = new JLabel("Hechicero");
            labelCharacter3 = new JLabel("Cazador");
            buttonCharacter1 = new JButton(character1);
            buttonCharacter2 = new JButton(character2);
            buttonCharacter3 = new JButton(character3);
            backMenu = new JButton(imageBack);
            
            //***************** ADD LABELS ******************
            labelCharacter1.setBounds(240, 270, 150, 50);       //Locate the position and size of the Caracter label 1
            labelCharacter2.setBounds(490, 270, 150, 50);       //Locate the position and size of the Caracter label 2
            labelCharacter3.setBounds(730, 270, 150, 50);       //Locate the position and size of the Caracter label 3
            labelCharacter1.setForeground(Color.BLACK);
            labelCharacter2.setForeground(Color.BLACK);
            labelCharacter3.setForeground(Color.BLACK);
            labelCharacter1.setFont(new Font("absender", Font.BOLD, 20));
            labelCharacter2.setFont(new Font("absender", Font.BOLD, 20));
            labelCharacter3.setFont(new Font("absender", Font.BOLD, 20));
            add(labelCharacter1);                               //Add the Character label 1 to the panel
            add(labelCharacter2);                               //Add the Character label 2 to the panel
            add(labelCharacter3);                               //Add the Character label 3 to the panel
            //***********************************************
            
            //***************** ADD BUTTONS *****************
            buttonCharacter1.setBounds(182, 330, 200, 200);     //Locate the position and size of the Caracter button 1
            buttonCharacter1.setContentAreaFilled(false);       //Cancels the Caracter button 1 background
            buttonCharacter1.setBorder(null);                   //Overrides the edges of the Caracter button 1
            buttonCharacter1.setCursor(new Cursor(HAND_CURSOR));
            buttonCharacter2.setBounds(432, 330, 200, 200);     //Locate the position and size of the Caracter button 2
            buttonCharacter2.setContentAreaFilled(false);       //Cancels theCaracter button 2 background
            buttonCharacter2.setBorder(null);                   //Overrides the edges of the Caracter button 2
            buttonCharacter2.setCursor(new Cursor(HAND_CURSOR));
            buttonCharacter3.setBounds(682, 330, 200, 200);     //Locate the position and size of the Caracter button 3
            buttonCharacter3.setContentAreaFilled(false);       //Cancels the Caracter button 3 background
            buttonCharacter3.setBorder(null);                   //Overrides the edges of the Caracter button 3
            buttonCharacter3.setCursor(new Cursor(HAND_CURSOR));
            backMenu.setBounds(50, 550, 150, 50);               //Locate the position and size of the Back Menu button
            backMenu.setContentAreaFilled(false);               //Cancels the Back Menu button background
            backMenu.setBorder(null);                           //Overrides the edges of the Back Menu button 
            backMenu.setCursor(new Cursor(HAND_CURSOR));
            add(buttonCharacter1);                              //Add the Character button 1 to the panel
            add(buttonCharacter2);                              //Add the Character button 2 to the panel
            add(buttonCharacter3);                              //Add the Character button 3 to the panel
            add(backMenu);                                      //Add the Back Menu button to the panel
            //***********************************************
            
            setVisible(true);
            
            buttonCharacter1.addActionListener(this);
            buttonCharacter2.addActionListener(this);
            buttonCharacter3.addActionListener(this);
            backMenu.addActionListener(this);
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == buttonCharacter1 || e.getSource() == buttonCharacter2 || e.getSource() == buttonCharacter3) {
                soundButton.play();
                CharacterData cd = new CharacterData();
                dispose();                                      //Method to close the class that is open
            }
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
        
        private void imageCharacters() {
            character1 = new ImageIcon("src/images/characterKnight.png");
            character2 = new ImageIcon("src/images/characterMagician.png");
            character3 = new ImageIcon("src/images/characterHunter.png");
        }
        
        private void imageButtons() {
            imageBack = new ImageIcon("src/images/buttonBack.png");
        }
    }
    //****************************************************
}
//************************************************