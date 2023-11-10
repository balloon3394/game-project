/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.Graphics;
import javax.swing.*;


/**
 *
 * @author Balloon
 */
public class homegame extends JPanel{
        private ImageIcon bgmenu = new ImageIcon("MenuMain.png");
        private Icon exit = new ImageIcon("exit2.png");
        private Icon start = new ImageIcon("start2.png");
        
        public JButton Bstart = new JButton(start);
        public JButton Bexit = new JButton(exit);
        
        homegame(){
            setLayout(null);
            Bstart.setBounds(600, 410,224,120);
            Bexit.setBounds(600, 550,224,120);
            add(Bstart);
            add(Bexit);
            
        }
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(bgmenu.getImage(),0,0,1024,768,this);
            
        }
            
                    
}
