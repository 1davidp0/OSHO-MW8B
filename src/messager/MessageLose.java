/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messager;

import game.Game1;
import game.Game2;
import game.Game301;
import game.Game302;
import game.Game303;
import histories.History2;
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
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author DavidGD
 */

//****************** MAIN CLASS **********************
public class MessageLose extends JFrame {
    //Declare
    
    //******************** AUDIOS ********************
    AudioClip soundWin;
    AudioClip soundButton;
    //************************************************
    
    //********************* PANEL ********************
    PanelMessageLose paneVictory;                               //Panel where the background image and buttons will be placed
    //************************************************
    
    public MessageLose(int count) {
        //Instantiate
        
        paneVictory = new PanelMessageLose("/images/background1.png", count);
        
        soundWin = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/soundLose.wav"));
        soundButton = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/soundButton.wav"));
        
        //Add
        
        soundWin.play();
        
        setSize(720, 480);                                     //Size of the Game 1 window
        setLocationRelativeTo(null);                           //Place the Game 1 window towards the center
        setTitle("Medieval World 8 Bits:  Victoria");          //Add a title to the Game 1 window
        setDefaultCloseOperation(EXIT_ON_CLOSE);               //When the game closes, the program ends
        
        //****************** ADD PANEL ******************
        this.getContentPane().add(paneVictory);                 //Add the panel and its content to the JFrame
        paneVictory.setLayout(null);                            //To deactivate the design
        //***********************************************
        
        setVisible(true);                                      //Makes visible what is inside the window
    }
    
    //****************** SUB CLASSES *********************
    public class PanelMessageLose extends JPanel implements ActionListener {
        
        private String name;
        private int count;
        
        //****************** IMAGES **********************
        ImageIcon background;
        ImageIcon imageButton;                                 //Image for the button Check
        //************************************************
        
        //****************** LABELS **********************
        JLabel labelScore1;                                    //Label for the score
        JLabel labelScore2;                                    //Label for the score
        //************************************************
        
        //***************** BUTTONS **********************
        JButton buttonOk;                                      //Button to continue telling the story
        //************************************************
        
        public PanelMessageLose(String name, int count) {
            //Instantiate
            
            this.name = name;
            this.count = count;
            setLayout(null);
            
            //****************** LOAD IMAGES ****************
            imageButtons();                                    //Load the image of the buttons
            //***********************************************
            
            labelScore1 = new JLabel("¡Lo siento! has perdido el");
            labelScore2 = new JLabel("nivel. vuelve a intentarlo");
            
            buttonOk = new JButton(imageButton);
            
            //Add
            
            //***************** ADD LABELS ******************
            labelScore1.setBounds(105, 185, 1000, 50);            //Locate the position and size of the Label Name button
            labelScore2.setBounds(100, 220, 1000, 50);           //Locate the position and size of the Label Name button
            labelScore1.setForeground(Color.BLACK);
            labelScore2.setForeground(Color.BLACK);
            labelScore1.setFont(new Font("absender", Font.BOLD, 35));
            labelScore2.setFont(new Font("absender", Font.BOLD, 35));
            add(labelScore1);                                    //Add the Label Name button to the panel
            add(labelScore2);                                    //Add the Label Name button to the panel
            //***********************************************
            
            //***************** ADD BUTTONS *****************
            buttonOk.setBounds(280, 320, 150, 50);               //Locate the position and size of the Ok button
            buttonOk.setContentAreaFilled(false);                //Cancels the Ok button background
            buttonOk.setBorder(null);                            //Overrides the edges of the Ok button
            buttonOk.setCursor(new Cursor(HAND_CURSOR));
            add(buttonOk);                                      //Add the Ok button to the panel
            //***********************************************
            
            setVisible(true);
            
            buttonOk.addActionListener(this);
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == buttonOk) {
                soundButton.play();
                
                if(count == 1) {
                    Game1 g1 = new Game1();
                } else {
                    if(count == 2) {
                        Game2 g2 = new Game2();
                    } else {
                        if(count == 301) {
                            Game301 g301 = new Game301();
                        } else {
                            if(count == 302) {
                                Game302 g302 = new Game302();
                            } else {
                                if(count == 303) {
                                    Game303 g303 = new Game303();
                                }
                            }
                        }
                    }
                }
                dispose();
            }
        }
        
        @Override
        public void paint (Graphics g){
            background = new ImageIcon (getClass().getResource(name));
            g.drawImage(background.getImage(),0,0,getWidth(),getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
        
        private void imageButtons() {
            imageButton = new ImageIcon("src/images/buttonOk.png");
        }
        
    }
    //****************************************************
}
//****************************************************