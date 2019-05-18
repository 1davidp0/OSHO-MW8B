/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import histories.History3;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Cursor;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import messager.MessageLose;

/**
 *
 * @author DavidGD
 */

//****************** MAIN CLASS **********************
public class Game2 extends JFrame {
    //Declare
    
    //******************** AUDIOS ********************
    AudioClip soundButton;
    //************************************************
    
    //********************* PANEL ********************
    PanelGame2 panelGame2;                                     //Panel where the background image and buttons will be placed
    //************************************************
    
    public Game2(){
        //Instantiate
        
        panelGame2 = new PanelGame2("/images/background1.png");
        
        soundButton = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/soundButton.wav"));
        
        //Add
        setSize(1080, 720);                                    //Size of the Game 1 window
        setLocationRelativeTo(null);                           //Place the Game 1 window towards the center
        setTitle("Medieval World 8 Bits:  Juego 2");           //Add a title to the Game 1 window
        setDefaultCloseOperation(EXIT_ON_CLOSE);               //When the game closes, the program ends
        
        //****************** ADD PANEL ******************
        this.getContentPane().add(panelGame2);                 //Add the panel and its content to the JFrame
        panelGame2.setLayout(null);                            //To deactivate the design
        //***********************************************
        
        setVisible(true);                                      //Makes visible what is inside the window
    }
    
    //****************** SUB CLASSES *********************
    public class PanelGame2 extends JPanel implements ActionListener {
        //Declare
        
        private String name;
        public int scoreGame2 = 300;
        
        //****************** IMAGES **********************
        ImageIcon background;                                  //Image for the Game 2 background
        ImageIcon imageButton;                                 //Image for the button Check
        //************************************************
        
        //*********** ENTRANCE MOVEMENTS *****************
        EntranceMovement object1;                              //Object to use the methods to compare
        EntranceMovement object2;                              //Object to use the methods to compare
        EntranceMovement object3;                              //Object to use the methods to compare
        EntranceMovement object4;                              //Object to use the methods to compare
        EntranceMovement object5;                              //Object to use the methods to compare
        EntranceMovement object6;                              //Object to use the methods to compare
        EntranceMovement object7;                              //Object to use the methods to compare
        EntranceMovement object8;                              //Object to use the methods to compare
        EntranceMovement object9;                              //Object to use the methods to compare
        EntranceMovement object10;                             //Object to use the methods to compare
        EntranceMovement object11;                             //Object to use the methods to compare
        EntranceMovement object12;                             //Object to use the methods to compare
        //************************************************
        
        //********************* PANEL ********************
        JPanel panel1;                                         //Panel 1 where the corresponding label will be placed
        JPanel panel2;                                         //Panel 2 where the corresponding label will be placed
        JPanel panel3;                                         //Panel 3 where the corresponding label will be placed
        JPanel panel4;                                         //Panel 4 where the corresponding label will be placed
        JPanel panel5;                                         //Panel 5 where the corresponding label will be placed
        JPanel panel6;                                         //Panel 6 where the corresponding label will be placed
        JPanel panel7;                                         //Panel 7 where the corresponding label will be placed
        JPanel panel8;                                         //Panel 8 where the corresponding label will be placed
        JPanel panel9;                                         //Panel 9 where the corresponding label will be placed
        JPanel panel10;                                        //Panel 10 where the corresponding label will be placed
        JPanel panel11;                                        //Panel 11 where the corresponding label will be placed
        JPanel panel12;                                        //Panel 12 where the corresponding label will be placed
        //************************************************
        
        //***************** BUTTONS **********************
        JButton buttonCheck;                                   //Button to check if the labels are in place
        //************************************************
        
        public PanelGame2(String name) {
            //Instantiate
            
            this.name = name;
            setLayout(null);
            
            //****************** LOAD IMAGES ****************
            imageButtons();                                    //Load the image of the buttons
            //***********************************************
            
            MovementMethods m = new MovementMethods("");
            
            panel1 = new JPanel();
            panel2 = new JPanel();
            panel3 = new JPanel();
            panel4 = new JPanel();
            panel5 = new JPanel();
            panel6 = new JPanel();
            panel7 = new JPanel();
            panel8 = new JPanel();
            panel9 = new JPanel();
            panel10 = new JPanel();
            panel11 = new JPanel();
            panel12 = new JPanel();
            
            buttonCheck = new JButton(imageButton);
            
            //Add
            
            //***************** ADD PANELS ******************
            panel1.setBounds(290, 180, 110, 110);              //Locate the position and size of the Panel 1
            object1 = new EntranceMovement(                    //
                    "/images/map1.png", panel1);
            object1.setBounds(70, 60, 100, 100);               //Locate the position and size of the Object 1
            panel1.setBorder(BorderFactory.createBevelBorder(  //Edges are added to the Panel 1
                    WIDTH, Color.black, Color.black));
            panel1.setBackground(Color.white);                 //A color is added to the Panel 1
            
            panel2.setBounds(400, 180, 110, 110);              //Locate the position and size of the Panel 2
            object2 = new EntranceMovement(                    //
                    "/images/map2.png", panel2);
            object2.setBounds(220, 60, 100, 100);              //Locate the position and size of the Object 2
            panel2.setBorder(BorderFactory.createBevelBorder(  //Edges are added to the Panel 2
                    WIDTH, Color.black, Color.black));
            panel2.setBackground(Color.white);                 //A color is added to the Panel 2
            
            panel3.setBounds(510, 180, 110, 110);              //Locate the position and size of the Panel 3
            object3 = new EntranceMovement(                    //
                    "/images/map3.png", panel3);
            object3.setBounds(370, 60, 100, 100);              //Locate the position and size of the Object 3
            panel3.setBorder(BorderFactory.createBevelBorder(  //Edges are added to the Panel 3
                    WIDTH, Color.black, Color.black));
            panel3.setBackground(Color.white);                 //A color is added to the Panel 3
            
            panel4.setBounds(620, 180, 110, 110);              //Locate the position and size of the Panel 4
            object4 = new EntranceMovement(                    //
                    "/images/map4.png", panel4);
            object4.setBounds(510, 60, 100, 100);              //Locate the position and size of the Object 4
            panel4.setBorder(BorderFactory.createBevelBorder(  //Edges are added to the Panel 4
                    WIDTH, Color.black, Color.black));
            panel4.setBackground(Color.white);                 //A color is added to the Panel 4
            
            panel5.setBounds(290, 290, 110, 110);              //Locate the position and size of the Panel 5
            object5 = new EntranceMovement(                    //
                    "/images/map5.png", panel5);
            object5.setBounds(670, 60, 100, 100);              //Locate the position and size of the Object 5
            panel5.setBorder(BorderFactory.createBevelBorder(  //Edges are added to the Panel 5
                    WIDTH, Color.black, Color.black));
            panel5.setBackground(Color.white);                 //A color is added to the Panel 5
            
            panel6.setBounds(400, 290, 110, 110);              //Locate the position and size of the Panel 6
            object6 = new EntranceMovement(                    //
                    "/images/map6.png", panel6);
            object6.setBounds(820, 60, 100, 100);              //Locate the position and size of the Object 6
            panel6.setBorder(BorderFactory.createBevelBorder(  //Edges are added to the Panel 6
                    WIDTH, Color.black, Color.black));
            panel6.setBackground(Color.white);                 //A color is added to the Panel 6
            
            panel7.setBounds(510, 290, 110, 110);              //Locate the position and size of the Panel 7
            object7 = new EntranceMovement(                    //
                    "/images/map7.png", panel7);
            object7.setBounds(70, 520, 100, 100);              //Locate the position and size of the Object 7
            panel7.setBorder(BorderFactory.createBevelBorder(  //Edges are added to the Panel 7
                    WIDTH, Color.black, Color.black));
            panel7.setBackground(Color.white);                 //A color is added to the Panel 7
            
            panel8.setBounds(620, 290, 110, 110);              //Locate the position and size of the Panel 8
            object8 = new EntranceMovement(                    //
                    "/images/map8.png", panel8);
            object8.setBounds(220, 520, 100, 100);             //Locate the position and size of the Object 8
            panel8.setBorder(BorderFactory.createBevelBorder(  //Edges are added to the Panel 8
                    WIDTH, Color.black, Color.black));
            panel8.setBackground(Color.white);                 //A color is added to the Panel 8
            
            panel9.setBounds(290, 400, 110, 110);              //Locate the position and size of the Panel 9
            object9 = new EntranceMovement(                    //
                    "/images/map9.png", panel9);
            object9.setBounds(370, 520, 100, 100);             //Locate the position and size of the Object 9
            panel9.setBorder(BorderFactory.createBevelBorder(  //Edges are added to the Panel 9
                    WIDTH, Color.black, Color.black));
            panel9.setBackground(Color.white);                 //A color is added to the Panel 9
            
            panel10.setBounds(400, 400, 110, 110);             //Locate the position and size of the Panel 10
            object10 = new EntranceMovement(                   //
                    "/images/map10.png", panel10);
            object10.setBounds(520, 520, 100, 100);            //Locate the position and size of the Object 10
            panel10.setBorder(BorderFactory.createBevelBorder( //Edges are added to the Panel 10
                    WIDTH, Color.black, Color.black));
            panel10.setBackground(Color.white);                //A color is added to the Panel 10
            
            panel11.setBounds(510, 400, 110, 110);             //Locate the position and size of the Panel 11
            object11 = new EntranceMovement(                   //
                    "/images/map11.png", panel11);
            object11.setBounds(670, 520, 100, 100);            //Locate the position and size of the Object 11
            panel11.setBorder(BorderFactory.createBevelBorder( //Edges are added to the Panel 11
                    WIDTH, Color.black, Color.black));
            panel11.setBackground(Color.white);                //A color is added to the Panel 11
            
            panel12.setBounds(620, 400, 110, 110);             //Locate the position and size of the Panel 12
            object12 = new EntranceMovement(                   //
                    "/images/map12.png", panel12);
            object12.setBounds(820, 520, 100, 100);            //Locate the position and size of the Object 12
            panel12.setBorder(BorderFactory.createBevelBorder( //Edges are added to the Panel 12
                    WIDTH, Color.black, Color.black));
            panel12.setBackground(Color.white);                //A color is added to the Panel 12
            
            add(object1);                                      //Add the Object 1 to the panel
            add(panel1);                                       //Add the Panel 1 to the panel
            add(object2);                                      //Add the Object 2 to the panel
            add(panel2);                                       //Add the Panel 2 to the panel
            add(object3);                                      //Add the Object 3 to the panel
            add(panel3);                                       //Add the Panel 3 to the panel
            add(object4);                                      //Add the Object 4 to the panel
            add(panel4);                                       //Add the Panel 4 to the panel
            add(object5);                                      //Add the Object 5 to the panel
            add(panel5);                                       //Add the Panel 5 to the panel
            add(object6);                                      //Add the Object 6 to the panel
            add(panel6);                                       //Add the Panel 6 to the panel
            add(object7);                                      //Add the Object 7 to the panel
            add(panel7);                                       //Add the Panel 7 to the panel
            add(object8);                                      //Add the Object 8 to the panel
            add(panel8);                                       //Add the Panel 8 to the panel
            add(object9);                                      //Add the Object 9 to the panel
            add(panel9);                                       //Add the Panel 9 to the panel
            add(object10);                                     //Add the Object 10 to the panel
            add(panel10);                                      //Add the Panel 10 to the panel
            add(object11);                                     //Add the Object 11 to the panel
            add(panel11);                                      //Add the Panel 11 to the panel
            add(object12);                                     //Add the Object 12 to the panel
            add(panel12);                                      //Add the Panel 12 to the panel
            //***********************************************
            
            //***************** ADD BUTTONS *****************
            buttonCheck.setBounds(800, 290, 150, 50);          //Locate the position and size of the Check button
            buttonCheck.setContentAreaFilled(false);           //Cancels the Check button background
            buttonCheck.setBorder(null);                       //Overrides the edges of the Check button
            buttonCheck.setCursor(new Cursor(HAND_CURSOR));
            add(buttonCheck);                                  //Add the Check button to the panel
            //***********************************************
            
            setVisible(true);
            
            buttonCheck.addActionListener(this);
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
           //Conditional for check puzzle.
            if (object1.isVar() == true && object2.isVar() == true && object3.isVar() == true && object4.isVar() 
                && object5.isVar() == true && object6.isVar() == true && object7.isVar() == true && 
                object8.isVar() == true && object9.isVar() == true && object10.isVar() == true 
                && object11.isVar() == true && object12.isVar() == true) {
                soundButton.play();
                
                JOptionPane.showMessageDialog(null, "¡Felicidades! lograste pasar el segundo nivel. Tu puntaje es: " + scoreGame2, "Win!!", JOptionPane.INFORMATION_MESSAGE);
                
                History3 h3 = new History3();
                dispose();                                     //Method to close the class that is open
            }else {
                soundButton.play();
                
                if(scoreGame2 > 10) {
                    JOptionPane.showMessageDialog(null, "Es falso, intenta de nuevo");
                    scoreGame2 = scoreGame2 - 15;
                }
                
                if(scoreGame2 <= 0) {
                    int count = 2;
                    MessageLose ml = new MessageLose(count);
                    dispose();
                }
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
            imageButton = new ImageIcon("src/images/buttonCheck.png");
        }
    }
    //****************************************************
}
//************************************************