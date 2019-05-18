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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
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
public class Game1 extends JFrame {
    //Declare
    
    //******************** AUDIOS ********************
    AudioClip soundButton;
    //************************************************
    
    //********************* PANEL ********************
    PanelGame1 panelGame1;                                      //Panel where the background image and buttons will be placed
    //************************************************
    
    public Game1() {
        //Instantiate
        
        panelGame1 = new PanelGame1("/images/background1.png");
        
        soundButton = java.applet.Applet.newAudioClip(getClass().getResource("/sounds/soundButton.wav"));
        
        //Add
        
        setSize(1080, 720);                                     //Size of the Game 1 window
        setLocationRelativeTo(null);                            //Place the Game 1 window towards the center
        setTitle("Medieval World 8 Bits:  Juego 1");            //Add a title to the Game 1 window
        setDefaultCloseOperation(EXIT_ON_CLOSE);                //When the game closes, the program ends
        
        //******************* ADD PANEL ******************
        this.getContentPane().add(panelGame1);                  //Add the panel and its content to the JFrame
        panelGame1.setLayout(null);                             //To deactivate the design
        //************************************************
        
        setVisible(true);                                       //Makes visible what is inside the window
    }
    
    //****************** SUB CLASSES *********************
    public class PanelGame1 extends JPanel implements ActionListener {
        //Declare
        
        Game1 g1;
        LogicGames logic = new LogicGames();                    //Object created for the logic of the game
        public boolean faceUp = false;
        public boolean firstCard = false;
        public int scoreGame1 = 300;
        private String name;
        
        //****************** IMAGES **********************
        ImageIcon background;                                   //Image for the Game 1 background
        ImageIcon imageBack;                                    //Image for the Back button
        ImageIcon imageRestart;                                 //Image for the Restart button
        ImageIcon image1;                                       //Image to compare the same cards
        ImageIcon image2;                                       //Image to compare the same cards
        ImageIcon mainCard;                                     //Main card that hides the other cards
        ImageIcon cardImage1;                                   //Image for the Card Button 1
        ImageIcon cardImage2;                                   //Image for the Card Button 2
        ImageIcon cardImage3;                                   //Image for the Card Button 3
        ImageIcon cardImage4;                                   //Image for the Card Button 4
        ImageIcon cardImage5;                                   //Image for the Card Button 5
        ImageIcon cardImage6;                                   //Image for the Card Button 6
        ImageIcon cardImage7;                                   //Image for the Card Button 7
        ImageIcon cardImage8;                                   //Image for the Card Button 8
        ImageIcon cardImage9;                                   //Image for the Card Button 9
        ImageIcon cardImage10;                                  //Image for the Card Button 10
        ImageIcon cardImage11;                                  //Image for the Card Button 11
        ImageIcon cardImage12;                                  //Image for the Card Button 12
        //************************************************
        
        //***************** BUTTONS **********************
        JButton backMenu;                                       //Button to return to menu
        JButton restart;                                        //Button to restart the Game 1
        final JButton[] pButton;                                //Two-dimensional button 
        //************************************************
        
        //************** CARD BUTTONS ********************
        Button cardButton1;                                     //Card Button 1
        Button cardButton2;                                     //Card Button 2
        Button cardButton3;                                     //Card Button 3
        Button cardButton4;                                     //Card Button 4
        Button cardButton5;                                     //Card Button 5
        Button cardButton6;                                     //Card Button 6
        Button cardButton7;                                     //Card Button 7
        Button cardButton8;                                     //Card Button 8
        Button cardButton9;                                     //Card Button 9
        Button cardButton10;                                    //Card Button 10
        Button cardButton11;                                    //Card Button 11
        Button cardButton12;                                    //Card Button 12
        //************************************************
        
        public PanelGame1(String name) {
            //Instantiate
            
            this.name = name;
            setLayout(null);
            
            //****************** LOAD IMAGES ****************
            imageButtons();                                     //Load the images of the buttons
            mainCard();                                         //Load the image that hides the cards
            setCards();                                         //Load the other cards
            //***********************************************
            
            backMenu = new JButton(imageBack);
            restart = new JButton(imageRestart);
            pButton = new JButton[2];
            cardButton1 = new Button(mainCard, cardImage1);
            cardButton2 = new Button(mainCard, cardImage2);
            cardButton3 = new Button(mainCard, cardImage3);
            cardButton4 = new Button(mainCard, cardImage4);
            cardButton5 = new Button(mainCard, cardImage5);
            cardButton6 = new Button(mainCard, cardImage6);
            cardButton7 = new Button(mainCard, cardImage7);
            cardButton8 = new Button(mainCard, cardImage8);
            cardButton9 = new Button(mainCard, cardImage9);
            cardButton10 = new Button(mainCard, cardImage10);
            cardButton11 = new Button(mainCard, cardImage11);
            cardButton12 = new Button(mainCard, cardImage12);
            
            //***************** ADD BUTTONS *****************
            backMenu.setBounds(50, 550, 150, 50);               //Locate the position and size of the Back Menu button
            restart.setBounds(860, 550, 150, 50);               //Locate the position and size of the Restart button
            backMenu.setContentAreaFilled(false);               //Cancels the Back Menu button background
            restart.setContentAreaFilled(false);                //Cancels the Restart button background
            backMenu.setBorder(null);                           //Overrides the edges of the Back Menu button
            restart.setBorder(null);                            //Overrides the edges of the Restart button
            backMenu.setCursor(new Cursor(HAND_CURSOR));
            restart.setCursor(new Cursor(HAND_CURSOR));
            add(backMenu);                                      //Add the Back Menu button to the panel
            add(restart);                                       //Add the Restart button to the panel
            //***********************************************
            
            //************** ADD CARD BUTTONS ***************
            cardButton1.setBounds(240, 135, 81, 101);           //Locate the position and size of the Card Button 1
            cardButton2.setBounds(411, 135, 81, 101);           //Locate the position and size of the Card Button 2
            cardButton3.setBounds(583, 135, 81, 101);           //Locate the position and size of the Card Button 3
            cardButton4.setBounds(750, 135, 81, 101);           //Locate the position and size of the Card Button 4
            cardButton5.setBounds(240, 270, 81, 101);           //Locate the position and size of the Card Button 5
            cardButton6.setBounds(411, 270, 81, 100);           //Locate the position and size of the Card Button 6
            cardButton7.setBounds(583, 270, 81, 101);           //Locate the position and size of the Card Button 7
            cardButton8.setBounds(750, 270, 81, 101);           //Locate the position and size of the Card Button 8
            cardButton9.setBounds(240, 400, 81, 101);           //Locate the position and size of the Card Button 9
            cardButton10.setBounds(411, 400, 81, 101);          //Locate the position and size of the Card Button 10
            cardButton11.setBounds(583, 400, 81, 101);          //Locate the position and size of the Card Button 11
            cardButton12.setBounds(750, 400, 81, 101);          //Locate the position and size of the Card Button 12
            cardButton1.setCursor(new Cursor(HAND_CURSOR));
            cardButton2.setCursor(new Cursor(HAND_CURSOR));
            cardButton3.setCursor(new Cursor(HAND_CURSOR));
            cardButton4.setCursor(new Cursor(HAND_CURSOR));
            cardButton5.setCursor(new Cursor(HAND_CURSOR));
            cardButton6.setCursor(new Cursor(HAND_CURSOR));
            cardButton7.setCursor(new Cursor(HAND_CURSOR));
            cardButton8.setCursor(new Cursor(HAND_CURSOR));
            cardButton9.setCursor(new Cursor(HAND_CURSOR));
            cardButton10.setCursor(new Cursor(HAND_CURSOR));
            cardButton11.setCursor(new Cursor(HAND_CURSOR));
            cardButton12.setCursor(new Cursor(HAND_CURSOR));
            add(cardButton1);                                   //Add the Card Button 1 to the panel
            add(cardButton2);                                   //Add the Card Button 2 to the panel
            add(cardButton3);                                   //Add the Card Button 3 to the panel
            add(cardButton4);                                   //Add the Card Button 4 to the panel
            add(cardButton5);                                   //Add the Card Button 5 to the panel
            add(cardButton6);                                   //Add the Card Button 6 to the panel
            add(cardButton7);                                   //Add the Card Button 7 to the panel
            add(cardButton8);                                   //Add the Card Button 8 to the panel
            add(cardButton9);                                   //Add the Card Button 9 to the panel
            add(cardButton10);                                  //Add the Card Button 10 to the panel
            add(cardButton11);                                  //Add the Card Button 11 to the panel
            add(cardButton12);                                  //Add the Card Button 12 to the panel
            //***********************************************
            
            setVisible(true);
        
            backMenu.addActionListener(this);
            restart.addActionListener(this);
            cardButton1.addActionListener(this);
            cardButton2.addActionListener(this);
            cardButton3.addActionListener(this);
            cardButton4.addActionListener(this);
            cardButton5.addActionListener(this);
            cardButton6.addActionListener(this);
            cardButton7.addActionListener(this);
            cardButton8.addActionListener(this);
            cardButton9.addActionListener(this);
            cardButton10.addActionListener(this);
            cardButton11.addActionListener(this);
            cardButton12.addActionListener(this);
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == backMenu) {
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
            if (e.getSource() == restart) {
                soundButton.play();
                restart();
            }
            if (e.getSource() == cardButton1) {
                soundButton.play();
                buttonEnable(cardButton1);
            }
            if (e.getSource() == cardButton2) {
                soundButton.play();
                buttonEnable(cardButton2);
            }
            if (e.getSource() == cardButton3) {
                soundButton.play();
                buttonEnable(cardButton3);
            }
            if (e.getSource() == cardButton4) {
                soundButton.play();
                buttonEnable(cardButton4);
            }
            if (e.getSource() == cardButton5) {
                soundButton.play();
                buttonEnable(cardButton5);
            }
            if (e.getSource() == cardButton6) {
                soundButton.play();
                buttonEnable(cardButton6);
            }
            if (e.getSource() == cardButton7) {
                soundButton.play();
                buttonEnable(cardButton7);
            }
            if (e.getSource() == cardButton8) {
                soundButton.play();
                buttonEnable(cardButton8);
            }
            if (e.getSource() == cardButton9) {
                soundButton.play();
                buttonEnable(cardButton9);
            }
            if (e.getSource() == cardButton10) {
                soundButton.play();
                buttonEnable(cardButton10);
            }
            if (e.getSource() == cardButton11) {
                soundButton.play();
                buttonEnable(cardButton11);
            }
            if (e.getSource() == cardButton12) {
                soundButton.play();
                buttonEnable(cardButton12);
            }
        }
        
        //****************** SUB CLASSES *********************
        public class Button extends JButton implements MouseListener {
        
            public Button(ImageIcon mainCard, ImageIcon cardImage) {
                super.setIcon(mainCard);
                super.setDisabledIcon(cardImage);
                super.setRolloverIcon(new ImageIcon("src/images/cardRollover.png"));
                
                super.setContentAreaFilled(false);
                super.setBorder(null);
                
                addMouseListener(this);
            }
            
            @Override
            public void mouseClicked(MouseEvent me) {}
            
            @Override
            public void mousePressed(MouseEvent me) {}
            
            @Override
            public void mouseReleased(MouseEvent me) {}
            
            @Override
            public void mouseEntered(MouseEvent me) {}
            
            @Override
            public void mouseExited(MouseEvent me) {
                compare();
            }
        }
        //****************************************************
        
        @Override
        public void paint(Graphics g) {
            background = new ImageIcon(getClass().getResource(name));
            g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
        
        private void imageButtons() {                                    //Load the image buttons
            imageBack = new ImageIcon("src/images/buttonBack.png");
            imageRestart = new ImageIcon("src/images/buttonRestart.png");
        }
        
        private void mainCard() {                                        //Load the main card
            mainCard = new ImageIcon("src/images/card0.png");
        }
        
        private void setCards() {                                        //Hide the other cards
            int[] numbers = logic.getCardNumbers(); 
            cardImage1 = new ImageIcon(getClass().getResource("/images/card" + numbers[0] + ".png"));
            cardImage2 = new ImageIcon(getClass().getResource("/images/card" + numbers[1] + ".png"));
            cardImage3 = new ImageIcon(getClass().getResource("/images/card" + numbers[2] + ".png"));
            cardImage4 = new ImageIcon(getClass().getResource("/images/card" + numbers[3] + ".png"));
            cardImage5 = new ImageIcon(getClass().getResource("/images/card" + numbers[4] + ".png"));
            cardImage6 = new ImageIcon(getClass().getResource("/images/card" + numbers[5] + ".png"));
            cardImage7 = new ImageIcon(getClass().getResource("/images/card" + numbers[6] + ".png"));
            cardImage8 = new ImageIcon(getClass().getResource("/images/card" + numbers[7] + ".png"));
            cardImage9 = new ImageIcon(getClass().getResource("/images/card" + numbers[8] + ".png"));
            cardImage10 = new ImageIcon(getClass().getResource("/images/card" + numbers[9] + ".png"));
            cardImage11 = new ImageIcon(getClass().getResource("/images/card" + numbers[10] + ".png"));
            cardImage12 = new ImageIcon(getClass().getResource("/images/card" + numbers[11] + ".png"));
        }
        
        private void buttonEnable(JButton cardButton) {                 //Encoding of the hidden image
            if (!faceUp) {
                cardButton.setEnabled(false);
                image1 = (ImageIcon) cardButton.getDisabledIcon();
                pButton[0] = cardButton;
                faceUp = true;
                firstCard = false;
            } else {
                cardButton.setEnabled(false);
                image2 = (ImageIcon) cardButton.getDisabledIcon();
                pButton[1] = cardButton;
                firstCard = true;
                messajeWin();
            }
        }
        
        public void compare() {
            if (faceUp && firstCard) {
                if (image1.getDescription().compareTo(image2.getDescription()) != 0) {
                    pButton[0].setEnabled(true);
                    pButton[1].setEnabled(true);
                    if (scoreGame1 > 10) {
                        scoreGame1 -= 15;
                    }
                }
                faceUp = false;
            }
        }
        
        private void messajeWin() {                                     //Victory message
            if (!cardButton1.isEnabled() && !cardButton2.isEnabled() && !cardButton3.isEnabled() && !cardButton4.isEnabled() && !cardButton5.isEnabled()
                && !cardButton6.isEnabled() && !cardButton7.isEnabled() && !cardButton8.isEnabled() && !cardButton9.isEnabled() && !cardButton10.isEnabled()
                && !cardButton11.isEnabled() && !cardButton12.isEnabled()) {
                MessageWin mw = new MessageWin(scoreGame1);
                dispose();                                      //Method to close the class that is open
            } else {
                if(scoreGame1 <= 0) {
                    int count = 1;
                    MessageLose ml = new MessageLose(count);
                    dispose();
                }
            }
        }
        
        private void restart() {                                        //Restart the game 1
            cardButton1.setEnabled(true);
            cardButton2.setEnabled(true);
            cardButton3.setEnabled(true);
            cardButton4.setEnabled(true);
            cardButton5.setEnabled(true);
            cardButton6.setEnabled(true);
            cardButton7.setEnabled(true);
            cardButton8.setEnabled(true);
            cardButton9.setEnabled(true);
            cardButton10.setEnabled(true);
            cardButton11.setEnabled(true);
            cardButton12.setEnabled(true);
            
            firstCard = false;
            faceUp = false;
            scoreGame1 = 0;
        }
    }
    //****************************************************
}
//************************************************