/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.applet.AudioClip;
import java.awt.Cursor;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import menu.Menu;
import messager.MessageLose;
import messager.MessageWin;

/**
 *
 * @author DavidGD
 */

//****************** MAIN CLASS **********************
public class Game302 extends JFrame {
    //Declare
    
    boolean var = true; 
    boolean var2 = false; 
    boolean var3 = false;
    int acum = 0;
    int acum2 = 0;
    
    //******************** AUDIOS ********************
    AudioClip soundButton;
    //************************************************
    
    //********************* PANEL ********************
    PanelGame302 panelGame301;                                 //Panel where the background image and buttons will be placed
    //************************************************
    
    public Game302() {
        //Instantiate
        
        panelGame301 = new PanelGame302("/images/fondo.png");
        
        soundButton = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/soundButton.wav"));
        
        //Add
        setSize(1080, 720);                                    //Size of the Game 1 window
        setLocationRelativeTo(null);                           //Place the Game 1 window towards the center
        setTitle("Medieval World 8 Bits:  Juego 3");           //Add a title to the Game 1 window
        setDefaultCloseOperation(EXIT_ON_CLOSE);               //When the game closes, the program ends
        
        //****************** ADD PANEL *****************
        this.getContentPane().add(panelGame301);               //Add the panel and its content to the JFrame
        panelGame301.setLayout(null);                          //To deactivate the design
        //***********************************************
        
        setVisible(true);
    }
    
    //****************** SUB CLASSES *********************
    public class PanelGame302 extends JPanel implements ActionListener, KeyListener {
        //Declare
        
        private String name;
        public int scoreGame302 = 300;
        
        //****************** IMAGES **********************
        ImageIcon background;                                  //Image for the Game 3 background
        ImageIcon imageBack;                                   //Image for the Back button
        ImageIcon imageMinusThree;                             //Image for the label with the Number Minus Three
        ImageIcon imageInterrogative;                          //Image for the label with the Question mark 1
        ImageIcon imageSix;                                    //Image for the label with the Number Six
        ImageIcon imageInterrogative2;                         //Image for the label with the Question mark 2
        ImageIcon imageTwo;                                    //Image for the label with the Number Two
        ImageIcon imageEqual;                                  //Image for the label with the Equalization sign
        ImageIcon imageMinusNine;                              //Image for the label with the Number Minus Nine
        ImageIcon imageArrow;                                  //Image for the label with the Arrow
        ImageIcon arrow;                                       //Image for the label with the Arrow
        ImageIcon in;                                          //Image for the label with the Arrow
        //************************************************
        
        //********************* LABELS *******************
        JLabel labelMinusThree;                                //Label to the Number Minus Three
        JLabel labelInterrogative;                             //Label to the Question mark 1
        JLabel labelSix;                                       //Label to the Number Six
        JLabel labelInterrogative2;                            //Label to the Question mark 2
        JLabel labelTwo;                                       //Label to the Number Two
        JLabel labelEqual;                                     //Label to the Equalization sign
        JLabel labelMinusNine;                                 //Label to the Number Minus Nine
        JLabel labelArrow;                                     //Label to the Arrow
        //************************************************
        
        //***************** BUTTONS **********************
        JButton backMenu;                                      //Button to back to menu
        //************************************************
        
        public PanelGame302(String name) {
            //Instantiate
            
            this.name = name;
            setLayout(null);
            
            //****************** LOAD IMAGES ****************
            imageComponents();                                 //Load the images of the numbers, operators, etc
            imageButtons();                                    //Load the image of the buttons
            //***********************************************
            
            labelMinusThree = new JLabel(imageMinusThree);
            labelInterrogative = new JLabel(imageInterrogative);
            labelSix = new JLabel(imageSix);
            labelInterrogative2 = new JLabel(imageInterrogative2);
            labelTwo = new JLabel(imageTwo);
            labelEqual = new JLabel(imageEqual);
            labelMinusNine = new JLabel(imageMinusNine);
            labelArrow = new JLabel();
            
            backMenu = new JButton(imageBack);
            
            //Add
            
            //***************** ADD LABELS ******************
            labelMinusThree.setBounds(20, 300, 200, 100);      //Locate the position and size of the label with the Number Minus Three
            labelInterrogative.setBounds(230, 300, 100, 100);  //Locate the position and size of the label with the Question mark 1
            labelSix.setBounds(348, 300, 100, 100);            //Locate the position and size of the label with the Number Six
            labelInterrogative2.setBounds(470, 300, 100, 100); //Locate the position and size of the label with the Question mark 2
            labelTwo.setBounds(590, 300, 100, 100);            //Locate the position and size of the label with the Number Two
            labelEqual.setBounds(720, 300, 100, 100);          //Locate the position and size of the label with the Equalization sign
            labelMinusNine.setBounds(840, 300, 200, 100);      //Locate the position and size of the label with the Number Minus Nine
            labelArrow.setBounds(255, 230, 50, 50);            //Locate the position and size of the label with the Arrow
            imageArrow();                                      //Load the image of the label with the Arrow
            labelArrow.setIcon(in);                            //Assign the image to the label
            labelArrow.setBorder(null);                        //Overrides the edges of the label with the Arrow
            add(labelMinusThree);                              //Add the label with the Number Minus Three to the panel
            add(labelInterrogative);                           //Add the label with the Question mark 1
            add(labelSix);                                     //Add the label with the Number Six to the panel
            add(labelInterrogative2);                          //Add the label with the Question mark 2
            add(labelTwo);                                     //Add the label with the Number Two to the panel
            add(labelEqual);                                   //Add the label with the Equalization sign
            add(labelMinusNine);                               //Add the label with the Number Minus Nine to the panel
            add(labelArrow);                                   //Add the label with the Arrow
            //***********************************************
            
            //***************** ADD BUTTONS *****************
            backMenu.setBounds(50, 20, 150, 50);               //Locate the position and size of the Back Menu button
            backMenu.setContentAreaFilled(false);              //Cancels the Back Menu button background
            backMenu.setBorder(null);                          //Overrides the edges of the Back Menu button
            backMenu.setCursor(new Cursor(HAND_CURSOR));
            add(backMenu);                                     //Add the Back Menu button to the panel
            //***********************************************
            
            setVisible(true);
            setFocusable(true);
            
            backMenu.addActionListener(this);
            addKeyListener(this);
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == backMenu) {
                soundButton.play();
                
                try {
                    int answer = JOptionPane.showConfirmDialog(rootPane, "¿Estas seguro que deseas volver al menú?");
                    
                    if(answer == JOptionPane.YES_OPTION) {
                        Menu m = new Menu();
                        dispose();                                 //Method to close the class that is open
                    }
                } catch(NullPointerException ex) {
                    System.out.println("");
                }
            }
        }
        
        @Override
        public void keyPressed(KeyEvent ke) {
            if (ke.getKeyChar() == 'a' || ke.getKeyChar() == 'A' || ke.getExtendedKeyCode() == KeyEvent.VK_LEFT) {
                labelArrow.setLocation( 255, 230);
                var = true;
                arrow = new ImageIcon(getClass().getResource("/images/arrow1.png"));
                in = new ImageIcon(arrow.getImage().getScaledInstance(labelArrow.getWidth(), labelArrow.getHeight(), Image.SCALE_DEFAULT));
                labelArrow.setIcon(in);
                labelArrow.setBorder(null);
            }
            if (ke.getKeyChar() == 'd' || ke.getKeyChar() == 'D' || ke.getExtendedKeyCode() == KeyEvent.VK_RIGHT) {
                labelArrow.setLocation( 495, 230);
                var = false;
                arrow = new ImageIcon(getClass().getResource("/images/arrow1.png"));
                in = new ImageIcon(arrow.getImage().getScaledInstance(labelArrow.getWidth(), labelArrow.getHeight(), Image.SCALE_DEFAULT));
                labelArrow.setIcon(in);
                labelArrow.setBorder(null);
            }
            if (ke.getKeyChar() == 'w' || ke.getKeyChar() == 'W' || ke.getExtendedKeyCode() == KeyEvent.VK_UP) {
                acum += 1;
                if(acum > 4) {
                    acum = 4;
                }
            }
            if (ke.getKeyChar() == 's' || ke.getKeyChar() == 'S' || ke.getExtendedKeyCode() == KeyEvent.VK_DOWN) {
                acum -= 1;
                if(acum < 1) {
                    acum=1;
                }
            }
            if (var == true) {
                if (acum == 1) {
                    ImageIcon other1 = new ImageIcon(getClass().getResource("/images/sum.png"));
                    ImageIcon icn = new ImageIcon(other1.getImage().getScaledInstance(labelInterrogative.getWidth(), labelInterrogative.getHeight(), Image.SCALE_DEFAULT));
                    labelInterrogative.setIcon(icn); labelInterrogative.setText(""); var2 = false;
                }
                else {
                    if (acum == 2) {
                        ImageIcon other2 = new ImageIcon(getClass().getResource("/images/subtraction.png"));
                        ImageIcon icn2 = new ImageIcon(other2.getImage().getScaledInstance(labelInterrogative.getWidth(), labelInterrogative.getHeight(), Image.SCALE_DEFAULT));
                        labelInterrogative.setIcon(icn2); labelInterrogative.setText(""); var2 = false;
                    }
                    else {
                        if (acum == 3) {
                            ImageIcon other3 = new ImageIcon(getClass().getResource("/images/multiplication.png"));
                            ImageIcon icn3 = new ImageIcon(other3.getImage().getScaledInstance(labelInterrogative.getWidth(), labelInterrogative.getHeight(), Image.SCALE_DEFAULT));
                            labelInterrogative.setIcon(icn3); labelInterrogative.setText(""); var2 = true;
                        }
                        else {
                            if (acum == 4) {
                                ImageIcon other4 = new ImageIcon(getClass().getResource("/images/division.png"));
                                ImageIcon icn4 = new ImageIcon(other4.getImage().getScaledInstance(labelInterrogative.getWidth(), labelInterrogative.getHeight(), Image.SCALE_DEFAULT));
                                labelInterrogative.setIcon(icn4); labelInterrogative.setText(""); var2 = false;
                            }
                        }
                    }
                }
            }
            if (var == false) {
                if (acum == 1) {
                    ImageIcon other1 = new ImageIcon(getClass().getResource("/images/sum.png"));
                    ImageIcon icn = new ImageIcon(other1.getImage().getScaledInstance(labelInterrogative2.getWidth(), labelInterrogative2.getHeight(), Image.SCALE_DEFAULT));
                    labelInterrogative2.setIcon(icn); labelInterrogative2.setText(""); var3 = false;
                }
                else {
                    if (acum ==  2) {
                        ImageIcon other2 = new ImageIcon(getClass().getResource("/images/subtraction.png"));
                        ImageIcon icn2 = new ImageIcon(other2.getImage().getScaledInstance(labelInterrogative2.getWidth(), labelInterrogative2.getHeight(), Image.SCALE_DEFAULT));
                        labelInterrogative2.setIcon(icn2); labelInterrogative2.setText(""); var3 = false;
                    }
                    else {
                        if (acum == 3) {
                            ImageIcon other3 = new ImageIcon(getClass().getResource("/images/multiplication.png"));
                            ImageIcon icn3 = new ImageIcon(other3.getImage().getScaledInstance(labelInterrogative2.getWidth(), labelInterrogative2.getHeight(), Image.SCALE_DEFAULT));
                            labelInterrogative2.setIcon(icn3); labelInterrogative2.setText(""); var3 = false;
                        }
                        else {
                            if (acum == 4) {
                                ImageIcon other4 = new ImageIcon(getClass().getResource("/images/division.png"));
                                ImageIcon icn4 = new ImageIcon(other4.getImage().getScaledInstance(labelInterrogative2.getWidth(), labelInterrogative2.getHeight(), Image.SCALE_DEFAULT));
                                labelInterrogative2.setIcon(icn4); labelInterrogative2.setText(""); var3 = true;
                            }
                        }
                    }
                }
            }
            if (ke.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
                //Here it is checked if the user solved the operation well.
                if (var2 == true && var3 == true) {
                    soundButton.play();
                    MessageWin mw = new MessageWin(scoreGame302);
                    dispose();                                 //Method to close the class that is open
                }
                else {
                    soundButton.play();
                    
                    if (scoreGame302 > 10) {
                        JOptionPane.showMessageDialog(null, "Sigue intentando.");
                        scoreGame302 -= 30;
                    }
                    
                    if(scoreGame302 <= 0) {
                        int count = 3;
                        MessageLose ml = new MessageLose(count);
                        dispose();
                    }
                }
            }
        }
        
        @Override
        public void keyTyped(KeyEvent ke) {}
        
        @Override
        public void keyReleased(KeyEvent ke) {}
        
        @Override
        public void paint (Graphics g){
            background = new ImageIcon (getClass().getResource(name));
            g.drawImage(background.getImage(),0,0,getWidth(),getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
        
        private void imageComponents() {
            imageMinusThree = new ImageIcon("src/images/-three.png");
            imageInterrogative = new ImageIcon("src/images/interrogative.png");
            imageSix = new ImageIcon("src/images/six.png");
            imageInterrogative2 = new ImageIcon("src/images/interrogative.png");
            imageTwo = new ImageIcon("src/images/two.png");
            imageEqual = new ImageIcon("src/images/same.png");
            imageMinusNine = new ImageIcon("src/images/-nine.png");
        }
        
        private void imageButtons() {
            imageBack = new ImageIcon("src/images/buttonBack.png");
        }
        
        private void imageArrow() {
            arrow = new ImageIcon(getClass().getResource("/images/arrow1.png"));
            in = new ImageIcon(arrow.getImage().getScaledInstance(labelArrow.getWidth(), labelArrow.getHeight(), Image.SCALE_DEFAULT));
        }
    }
    //****************************************************
}
//****************************************************