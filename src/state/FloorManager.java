/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package state;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import main.Gamepanal;


public class FloorManager  {
    
    Gamepanal gp;
    Floor[] f;
    
    
    
    public FloorManager(Gamepanal gp) {
        
        this.gp = gp;
        f = new Floor[10];
        getFloorImage();
    }
    
    public void getFloorImage(){
        try{
            f[0] = new Floor(); 
            f[0].image = new ImageIcon("pl13.png");
            f[0].width = 620;
            f[0].height = 150;
            
            f[1] = new Floor(); 
            f[1].image = new ImageIcon("pl7.png");
            f[1].width = 200;
            f[1].height = 100;
            
            f[2] = new Floor(); 
            f[2].image = new ImageIcon("pl1.png");
            f[2].width = 400;
            f[2].height = 80;
            
            f[3] = new Floor(); 
            f[3].image = new ImageIcon("ladder.png");
            f[3].width = 180;
            f[3].height = 300;
            
            f[4] = new Floor(); 
            f[4].image = new ImageIcon("stu.png");
            f[4].width = 120;
            f[4].height = 160;
            
            f[5] = new Floor(); 
            f[5].image = new ImageIcon("pl14.png");
            
            f[6] = new Floor(); 
            f[6].image = new ImageIcon("water.png");
            
            
            
        
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void draw(Graphics g){
        
        if(gp.state1){
            g.drawImage(f[0].image.getImage(), -100, 620, f[0].width, f[0].height, null);
            g.drawImage(f[0].image.getImage(), 900, 620, f[0].width, f[0].height, null);
            g.drawImage(f[2].image.getImage(), 100, 350, f[2].width, f[2].height, null);
            g.drawImage(f[1].image.getImage(), 580, 500, f[1].width, f[1].height, null);
            g.drawImage(f[3].image.getImage(), 120, 350, f[3].width, f[3].height, null);
            
        }
        else if(gp.state2){
            g.drawImage(f[0].image.getImage(), -200, 620, 1300, f[0].height, null);
            g.drawImage(f[2].image.getImage(), -30, 260, 350, f[2].height, null);
            g.drawImage(f[4].image.getImage(), 170, 140, f[4].width, f[4].height, null);
            g.drawImage(f[3].image.getImage(), 80, 270, f[3].width, 390, null);
            g.drawImage(f[2].image.getImage(), 430, 340, 350, f[2].height, null);
            
        }
        else if(gp.state3){
            g.drawImage(f[5].image.getImage(), -100, 620, 400, 150, null);
            g.drawImage(f[6].image.getImage(), 280, 585, 650, 150, null);
            g.drawImage(f[5].image.getImage(), 910, 610, 400, 150, null);
            g.drawImage(f[1].image.getImage(), 320, 500, f[1].width, f[1].height, null);
            g.drawImage(f[1].image.getImage(), 570, 460, f[1].width, f[1].height, null);
        }
    }
    
    
}
