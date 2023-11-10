
package main;

import java.awt.Canvas;
import charactor.Totoro;
import input.SoundHandler;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class Game extends JFrame implements ActionListener {
    homegame home = new homegame();
    
    Gamepanal gamepanal = new Gamepanal();
    
    
    
    public Game()  {
        
        this.add(home);
        
        home.Bstart.addActionListener(this);
        home.Bexit.addActionListener(this);
        gamepanal.Brestart.addActionListener(this);
        gamepanal.startGameThread();
        
        
        //play music//
        try {
            SoundHandler.RunMusic();
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == home.Bstart){
            this.setLocationRelativeTo(null);
            this.remove(home);
            this.setSize(1024, 768);
            this.add(gamepanal);
            gamepanal.requestFocusInWindow();
            gamepanal.timestart = false;
        }
        else if (e.getSource() == home.Bexit) {
            System.exit(0);
        }
        this.validate();
        this.repaint();
    }
        
    public static void main(String[] args)  {
        
        JFrame frame = new Game();
        frame.setTitle("Togohome");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1024, 768);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        
    }
    
    
    
    
        
        
        
        
        
    
    
     
    
    
    
    
    
    
    
       
        
            
                    
            
            
    
    
    
    
    
    
    
    
   
   

    
    
    
    
    
}

