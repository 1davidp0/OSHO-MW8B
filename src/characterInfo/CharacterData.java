/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characterInfo;

import histories.History1;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author DavidGD
 */

//****************** MAIN CLASS **********************
public class CharacterData extends JFrame {
    //Declare
    
    //******************** AUDIOS ********************
    AudioClip soundButton;
    //************************************************
    
    public Character ch = new Character();
    
    //********************* PANEL ********************
    PanelCharacterData panelCharacterData;                  //Panel where the background image and buttons will be placed
    //************************************************
    
    public CharacterData() {
        //Instantiate
        
        panelCharacterData = new PanelCharacterData("/images/characterDataBackground.png");
        
        soundButton = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/soundButton.wav"));
        
        //Add
        
        setSize(1080, 720);                                     //Size of the Character Data window
        setLocationRelativeTo(null);                            //Place the Character Data window towards the center
        setTitle("Medieval World 8 Bits: Datos personaje");     //Add a title to the Character Data window
        setDefaultCloseOperation(EXIT_ON_CLOSE);                //When the game closes, the program ends
        
        //******************* ADD PANEL ******************
        this.getContentPane().add(panelCharacterData);          //Add the panel and its content to the JFrame
        panelCharacterData.setLayout(null);                     //To deactivate the design
        //***********************************************
        
        setVisible(true);
    }
    
    //****************** SUB CLASSES *********************
    public class PanelCharacterData extends JPanel implements ActionListener {
        //Declare
        
        private String name;
        
        //****************** IMAGES **********************
        ImageIcon background;                                   //Image for the Character Data background
        ImageIcon imagePlay;                                    //Image for the Play button
        ImageIcon imageBack;                                    //Image for the Back button 
        //************************************************
        
        //****************** LABELS **********************
        JLabel labelName;                                       //Label to name the TextField Name
        JLabel labelSkill;                                      //Label to name the TextField Skill
        JLabel labelWeapon;                                     //Label to name the TextField Weapon
        //************************************************
        
        //**************** TEXTFIELDS ********************
        JTextField textFieldName;                               //TextField for the user to enter the character's name
        JTextField textFieldSkill;                              //TextField for the user to enter the character's skill
        JTextField textFieldWeapon;                             //TextField for the user to enter the name of the character's weapon
        //************************************************
        
        //***************** BUTTONS **********************
        JButton playGame;                                       //Button to start telling the story
        JButton back;                                           //Button to return to the menu
        //************************************************
        
        public PanelCharacterData(String name) {
            //Instantiate
            
            this.name = name;
            setLayout(null);
            
            //****************** LOAD IMAGES ****************
            imageButtons();                                     //Load the button images
            //***********************************************
            
            labelName = new JLabel("Nombre personaje:");
            labelSkill = new JLabel("Habilidad personaje:");
            labelWeapon = new JLabel("Nombre arma personaje:");
            
            textFieldName = new JTextField();
            textFieldSkill = new JTextField();
            textFieldWeapon = new JTextField();
            
            playGame = new JButton(imagePlay);
            back = new JButton(imageBack);
            
            //Add
            
            //***************** ADD LABELS ******************
            labelName.setBounds(290, 300, 250, 40);             //Locate the position and size of the Label Name button
            labelSkill.setBounds(290, 390, 250, 40);            //Locate the position and size of the Label Skill button
            labelWeapon.setBounds(290, 480, 250, 40);           //Locate the position and size of the Label Weapon button
            labelName.setForeground(Color.BLACK);
            labelSkill.setForeground(Color.BLACK);
            labelWeapon.setForeground(Color.BLACK);
            labelName.setFont(new Font("absender", Font.BOLD, 18));
            labelSkill.setFont(new Font("absender", Font.BOLD, 18));
            labelWeapon.setFont(new Font("absender", Font.BOLD, 18));
            add(labelName);                                     //Add the Label Name button to the panel
            add(labelSkill);                                    //Add the Label Skill button to the panel
            add(labelWeapon);                                   //Add the Label Weapon button to the panel
            //***********************************************
            
            //*************** ADD TEXTFIELDS ****************
            textFieldName.setBounds(540, 300, 250, 40);         //Locate the position and size of the TextField Name button
            textFieldSkill.setBounds(540, 390, 250, 40);        //Locate the position and size of the TextField Skill button
            textFieldWeapon.setBounds(540, 480, 250, 40);       //Locate the position and size of the TextField Weapon button
            textFieldName.setForeground(Color.BLACK);
            textFieldSkill.setForeground(Color.BLACK);
            textFieldWeapon.setForeground(Color.BLACK);
            textFieldName.setFont(new Font("absender", Font.BOLD, 18));
            textFieldSkill.setFont(new Font("absender", Font.BOLD, 18));
            textFieldWeapon.setFont(new Font("absender", Font.BOLD, 18));
            add(textFieldName);                                 //Add the TextField Name button to the panel
            add(textFieldSkill);                                //Add the TextField Skill button to the panel
            add(textFieldWeapon);                               //Add the TextField Weapon button to the panel
            //***********************************************
            
            //***************** ADD BUTTONS *****************
            playGame.setBounds(860, 550, 150, 50);              //Locate the position and size of the Play Game button
            back.setBounds(50, 550, 150, 50);                   //Locate the position and size of the Back button
            playGame.setContentAreaFilled(false);               //Cancels the Play Game button background
            back.setContentAreaFilled(false);                   //Cancels the Back button background
            playGame.setBorder(null);                           //Overrides the edges of the Play Game button
            back.setBorder(null);                               //Overrides the edges of the Back button
            playGame.setCursor(new Cursor(HAND_CURSOR));
            back.setCursor(new Cursor(HAND_CURSOR));
            add(playGame);                                      //Add the Play button to the panel
            add(back);                                          //Add the Back button to the panel
            //***********************************************
            
            setVisible(true);
            
            playGame.addActionListener(this);
            back.addActionListener(this);
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if (e.getSource() == playGame) {
                soundButton.play();
                if (!textFieldName.getText().equalsIgnoreCase("") && !textFieldSkill.getText().equalsIgnoreCase("") && !textFieldWeapon.getText().equalsIgnoreCase("")) {
                    ch.saveData(textFieldName.getText(), textFieldSkill.getText(), textFieldWeapon.getText());
                    saveData();
                    ch.print();
                    ch.setName(textFieldName.getText()); ch.setSkill(textFieldSkill.getText()); ch.setWeapon(textFieldWeapon.getText());
                    History1 h1 = new History1();
                    dispose();                                  //Method to close the class that is open
                }
                else {
                    soundButton.play();
                    JOptionPane.showMessageDialog(rootPane, "Debes llenar todos los campos");
                }
            }
            if (e.getSource() == back) {
                soundButton.play();
                ChooseCharacter cc = new ChooseCharacter();
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
            imagePlay = new ImageIcon("src/images/buttonPlay.png");
            imageBack = new ImageIcon("src/images/buttonBack.png");
        }
        
        public void saveData() {
            FileWriter archivo = null;
            PrintWriter line = null;
            
            try {
                archivo = new FileWriter("PlayerData.txt", true);
                PrintWriter pw = new PrintWriter(archivo);
                
                pw.println("*******************************************************************");
                pw.println("\tDATOS DEL JUGADOR");
                pw.println("Nombre del personaje: " + textFieldName.getText());
                pw.println("Habilidad del personaje: " + textFieldSkill.getText());
                pw.println("Nombre arma del personaje: " + textFieldWeapon.getText());
                pw.println("*******************************************************************");
                pw.println(" ");
                pw.close();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    //****************************************************
}
//************************************************