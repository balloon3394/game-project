
package charactor;

import input.keyhandler;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;

import javax.swing.*;
import main.Game;
import main.Gamepanal;


public class Totoro   {
        
        public Game w;
        public int x,y;
        public int width,height;
        public int speedx,speedy,speedc ;
        public int speed;
        public int ground = 480;
        public int jumphigh ;
        public ImageIcon[] im = new ImageIcon[6];
        public ImageIcon[] imb = new ImageIcon[6];
        public int countf = 0;
        public int countb = 0;
        public int side = 0;
        public boolean isJumping = false;
        public boolean falling = false;
        public boolean climbing = false;
        public boolean blessed = false;
        Gamepanal gp;
        keyhandler keyH;
        
        
        
        
        
        public Totoro(Gamepanal gp,keyhandler keyH){
            
            this.gp = gp;
            this.keyH = keyH;
            
            setDefaultvalues();
            
            
            
            
            for(int i=0;i<im.length;i++){
                im[i] = new ImageIcon("t"+(i+1)+".png");
            }
            
            for(int i=0;i<imb.length;i++){
                imb[i] = new ImageIcon("t"+"b"+(i+1)+".png");
            }
            
        }
        
        public void setDefaultvalues(){
            x = 0;
            y = 480;
            width = 200;
            height = 200;
            speedx = 0;
            speedy = 0;
            speedc = 0;
            jumphigh = 2;
            speed = 6;
            isJumping = false;
        }
            
            

            
            
        
        public void update(){
            if(keyH.up == true || keyH.left == true || keyH.right == true){
            
                if(keyH.up == true){
                    if(!isJumping){
                        speedy = -30;//jump
                        isJumping = true;
                    } 
                    if(side == 1){
                        countb = 3;
                    }
                    else if(side == 2){
                        countf = 3;
                    }
                }
                if(keyH.left == true ){
                    System.out.println("x:"+x+"y:"+y);
                    speedx = -speed;
                    side=1;
                    countb++;
                    countf = -1;
                }
                if(keyH.right == true ){
                    System.out.println("x:"+x+"y:"+y);
                    speedx = speed;
                    side=2;
                    countf++;
                    countb=0;
                }
                
                



                if(countf > 4){
                    countf = 0;
                }
                if(countb > 4){
                    countb = 0;
                }

                //update player position
                x += speedx;
                
            }
                y += speedy;

                if(isJumping){
                    speedy += 2 ;//gravity
                }

                
                if(!falling){
                
                    if(y > ground){
                        y = ground  ;
                        isJumping = false;
                        speedy = 0;
                    }
                    
                }
                if(climbing){
                    if(gp.state1){
                        ground = 190;
                    
                    }
                    else if(gp.state2){
                        ground = 100;
                    }
                }
                
                if(blessed){
                    System.out.println("Shieldddddddd");
                }
                
        }
        
        
        
        
        
        
        public void set_x(int x){
            this.x = x;
        }
        
        public void set_y(int y){
            this.y = y;
        }
        
        public double get_x(){
            return this.x ;
        }
        
        public double get_y(){
            return this.y ;
        }
        
        public int getWidth() {
        return width;
        }

        public int getHeight() {
            return height;
        }
        
        public Rectangle2D getbound() {
        return (new Rectangle2D.Double(x, y, 100, 100));
    }
        
         
        
    
        

    
            
            
          
}
       
        
        
        
        
    
        
                    
                    
                    
                    
            

            
            
        
       
        
        
        

        
        
        
        
        
        

        
