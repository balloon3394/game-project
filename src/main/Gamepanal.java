
package main;

import charactor.Totoro;
import charactor.mon1;
import charactor.mon2;
import charactor.mon3;
import charactor.mon4;
import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import state.*;
import input.keyhandler;
import java.awt.Color;
import java.awt.Font;


public class Gamepanal extends JPanel implements Runnable{
    
    //object state//
    private final ImageIcon shield = new ImageIcon("shield.png");
    private final ImageIcon imgstate1 = new ImageIcon("state1.png");
    private final ImageIcon imgstate2 = new ImageIcon("state2.png");
    private final ImageIcon imgstate3 = new ImageIcon("map3.png");
    private final ImageIcon win = new ImageIcon("You win.png");
    private ImageIcon bggameover = new ImageIcon("You Lose.png");
    private final ImageIcon h1 = new ImageIcon("h1.png");
    private final ImageIcon h2 = new ImageIcon("h2.png");
    
    private FloorManager floors = new FloorManager(this);
    
    private Icon restart = new ImageIcon("reStart.png");
    public JButton Brestart = new JButton(restart);
    
    public boolean timestart = true;
    private int minute = 0;
    private int second = 0;
    private boolean gamewin = false;
    
    public int dy;
    public Game w;
    
    //FPS
    int FPS = 60;
    
    public keyhandler keyH = new keyhandler();
            
     
    Totoro totoro = new Totoro(this,keyH);
    mon1 m1 = new mon1(this,330,380,300,300);
    mon2 m2 = new mon2(this, 600, 380, 200, 300);
    mon3 m3 = new mon3(this, 620, 130, 200, 250);
    mon4 m4 = new mon4(this, 850, 400, 280, 350);
    
    public boolean gover = false ; 
    public int state = 1;
    public int HP=3;
    
    public boolean state1 = false;
    public boolean state2 = false;
    public boolean state3 = false;
    
    Thread gameThread;
    
    
    
    Thread mon = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                
                        
                m1.update(totoro);
                m2.update(totoro);
                m3.update(totoro);
                m4.update(totoro);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();
            }
        }
    });
    
    Thread t = new Thread(new Runnable() {
        public void run() {
            while (true) {
                if (timestart == false) {
                    second = second + 1;
                    if(second == 60){
                        second = 0;
                        minute += 1;
                        
                    }
                    
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();
            }
        }
    });
    
    
    
    public Gamepanal(){
        
        
        this.setFocusable(true);
        this.setLayout(null);
        
        
        
        Brestart.addActionListener(new restart());
        
        this.addKeyListener(keyH);
        
        
        
        
        
        
                    
        
                    
                
        state1 = true;        
        mon.start();
        t.start();
                
    } 
    
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        
        double drawInterval = 1000000000/FPS; 
        double nextDrawTime = System.nanoTime() + drawInterval;
        
        while(gameThread != null)
        {
            
            
            update();
            repaint();
            
            
            try{
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;
                
                if(remainingTime < 0){
                    remainingTime = 0;
                }
                Thread.sleep((long)remainingTime);
                
                nextDrawTime += drawInterval;
            
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public void update(){
        
        totoro.update();
        
    }

    
    
                    
    //reatart button//                
    public class restart implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == Brestart){
                HP = 3;
                gover = false;
                state1 = true;
                state2 = false;
                state3 = false;
                totoro.x = 0;
                totoro.y = 480;
                totoro.isJumping = false;
                totoro.speedx = 0;
                totoro.speedy = 0;
                minute = 0;
                second = 0;
                timestart = false;
                gamewin = false;
                
            }
        }
    
    }
  
    @Override
    public void paintComponent(Graphics g){
        
        
        super.paintComponent(g);
        
        
        if(!gover){
            
            if(totoro.y > 610){
                HP = 0;
                gover = true;
            }
            
            
            
        
            if(state1){
                
                
                this.remove(Brestart);
                g.drawImage(imgstate1.getImage(),0,0,1024,768,this);
                g.setColor(Color.WHITE);
                g.setFont(new Font("Hobo Std", Font.HANGING_BASELINE, 50));
                g.drawString("Time " + minute + ":" + second, 400,50 );
                
                floors.draw(g);
                //pit1.draw(g);
                
                if(HP == 3){
                    g.drawImage(h1.getImage(),30,40,70,70,null);
                    g.drawImage(h1.getImage(),95,40,70,70,null);
                    g.drawImage(h1.getImage(),160,40,70,70,null);
                }
                if(HP == 2){
                    g.drawImage(h1.getImage(),30,40,70,70,null);
                    g.drawImage(h1.getImage(),95,40,70,70,null);
                    g.drawImage(h2.getImage(),160,40,70,70,null);
                }
                if(HP == 1){
                    g.drawImage(h1.getImage(),30,40,70,70,null);
                    g.drawImage(h2.getImage(),95,40,70,70,null);
                    g.drawImage(h2.getImage(),160,40,70,70,null);
                }
                if(HP == 0){
                    gover = true;
                    state1 = false;
                }

                ///////////monster1//////////////
                g.drawImage(m1.im[m1.count].getImage(), m1.x, m1.y, m1.width, m1.height, null);
                ///////////totoro////////////////
                if(totoro.side == 2 || totoro.countf == 0){
                    g.drawImage(totoro.im[totoro.countf].getImage(),(int)totoro.x,(int)totoro.y,totoro.width,totoro.height,null);

                }
                else if(totoro.side == 1){
                    g.drawImage(totoro.imb[totoro.countb].getImage(),(int)totoro.x,(int)totoro.y,totoro.width,totoro.height,null);

                }
                if(totoro.x < -60){
                    totoro.x = -60;
                }
                
                if(totoro.x > 960){
                    totoro.x = -20;
                    state1 = false;
                    state2 = true;
                }
                
                
                
                if(totoro.x > 435 && totoro.x < 528 || totoro.x > 650 && totoro.x < 780){
                    totoro.falling = true;
                    totoro.y += 10;
                }
                else if(totoro.x >= 528 && totoro.x < 650 ){
                    totoro.falling = false;
                    totoro.ground = 350;
                }
                else if(totoro.x > 60 && totoro.x < 300 && totoro.y == 480 ){
                    if(keyH.action == true){
                        totoro.climbing = true;
                        
                         
                    }
                    
                }
                else if(totoro.y == 190 && totoro.x < 330 ){
                    totoro.climbing = false;
                    totoro.ground = 190;
                    
                }
                else{
                    totoro.falling = false;
                    totoro.ground = 480;
                }
                //////////////////////////////////
                
            }
            else if(state2){
                
                
                g.drawImage(imgstate2.getImage(),0,0,1024,768,this);
                g.setColor(Color.WHITE);
                g.setFont(new Font("Hobo Std", Font.HANGING_BASELINE, 50));
                g.drawString("Time " + minute + ":" + second, 400,50 );
                
                floors.draw(g);
                
                
                if(HP == 3){
                    g.drawImage(h1.getImage(),30,40,70,70,null);
                    g.drawImage(h1.getImage(),95,40,70,70,null);
                    g.drawImage(h1.getImage(),160,40,70,70,null);
                }
                if(HP == 2){
                    g.drawImage(h1.getImage(),30,40,70,70,null);
                    g.drawImage(h1.getImage(),95,40,70,70,null);
                    g.drawImage(h2.getImage(),160,40,70,70,null);
                }
                if(HP == 1){
                    g.drawImage(h1.getImage(),30,40,70,70,null);
                    g.drawImage(h2.getImage(),95,40,70,70,null);
                    g.drawImage(h2.getImage(),160,40,70,70,null);
                }
                if(HP == 0){
                    gover = true;
                    state2 = false;
                }
                
                
                if(totoro.blessed){
                    g.drawImage(shield.getImage(),30,40,70,70,null);
                    g.drawImage(shield.getImage(),95,40,70,70,null);
                    g.drawImage(shield.getImage(),160,40,70,70,null);
                }
                
                ///////////monster//////////////
                if(this.Intersect(m2.getbound(), totoro.getbound())){
                    g.drawImage(m2.ima[m2.countA].getImage(), m2.x, m2.y, m2.width, m2.height, null);
                }else{
                    g.drawImage(m2.imm[m2.countM].getImage(), m2.x, m2.y, m2.width, m2.height, null);
                
                }
                g.drawImage(m3.im[m3.count].getImage(), m3.x, m3.y, m3.width, m3.height, null);

                ///////////totoro////////////////
                if(totoro.side == 2 || totoro.countf == 0){
                    g.drawImage(totoro.im[totoro.countf].getImage(),totoro.x,totoro.y,totoro.width,totoro.height,null);

                }
                else if(totoro.side == 1){
                    g.drawImage(totoro.imb[totoro.countb].getImage(),totoro.x,totoro.y,totoro.width,totoro.height,null);

                }
                if(totoro.x < -60){
                    totoro.x = -60;
                }
                if(totoro.x > 960){
                    totoro.x = -20;
                    state2 = false;
                    state3 = true;
                }
                
                
                if(totoro.x > 23 && totoro.x < 79 && totoro.y == 480 ){
                    if(keyH.action == true){
                        totoro.climbing = true;
                    }
                    
                }
                else if(totoro.y == 100 && totoro.x < 160 ){
                    totoro.climbing = false;
                    totoro.ground = 100;
                    
                }
                else if( totoro.x > 385 && totoro.x <= 636){
                    totoro.ground = 180;
                }
                else if(totoro.x > 222 && totoro.x <= 320){
                    totoro.ground = 480;
                }
                
                else if(totoro.y == 100 && totoro.x > 160){
                    
                    totoro.ground = 480;
                }
                else if(totoro.x > 636){
                    totoro.ground = 480;
                }
               
                if(totoro.y == 100 && totoro.x > 100 && totoro.x < 140){
                    if(keyH.action == true){
                        totoro.blessed = true;
                    }
                }
                        
                         
            }
            else if(state3){
                g.drawImage(imgstate3.getImage(),0,0,1024,768,this);
                g.setColor(Color.WHITE);
                g.setFont(new Font("Hobo Std", Font.HANGING_BASELINE, 50));
                g.drawString("Time " + minute + ":" + second, 400,50 );
                
                floors.draw(g);
                
                
                if(HP == 3){
                    g.drawImage(h1.getImage(),30,40,70,70,null);
                    g.drawImage(h1.getImage(),95,40,70,70,null);
                    g.drawImage(h1.getImage(),160,40,70,70,null);
                }
                if(HP == 2){
                    g.drawImage(h1.getImage(),30,40,70,70,null);
                    g.drawImage(h1.getImage(),95,40,70,70,null);
                    g.drawImage(h2.getImage(),160,40,70,70,null);
                }
                if(HP == 1){
                    g.drawImage(h1.getImage(),30,40,70,70,null);
                    g.drawImage(h2.getImage(),95,40,70,70,null);
                    g.drawImage(h2.getImage(),160,40,70,70,null);
                }
                if(HP == 0){
                    gover = true;
                    state3 = false;
                }
                
                
                if(totoro.blessed){
                    g.drawImage(shield.getImage(),30,40,70,70,null);
                    g.drawImage(shield.getImage(),95,40,70,70,null);
                    g.drawImage(shield.getImage(),160,40,70,70,null);
                }
                
                ///////////monster//////////////
                g.drawImage(m4.im.getImage(), m4.x, m4.y, m4.width, m4.height, null);
                
                ///////////totoro////////////////
                if(totoro.side == 2 || totoro.countf == 0){
                    g.drawImage(totoro.im[totoro.countf].getImage(),totoro.x,totoro.y,totoro.width,totoro.height,null);

                }
                else if(totoro.side == 1){
                    g.drawImage(totoro.imb[totoro.countb].getImage(),totoro.x,totoro.y,totoro.width,totoro.height,null);

                }
                if(totoro.x < -60){
                    totoro.x = -60;
                }
                if(totoro.x > 960){
                    totoro.x = -20;
                    state3 = false;
                    gamewin = true;
                }
                
                if(totoro.x > 180 && totoro.x < 300 || totoro.x > 630 && totoro.x < 828){
                    totoro.falling = true;
                    totoro.y += 4;
                }
                else if(totoro.x > 220 && totoro.x < 450 ){
                    totoro.falling = false;
                    totoro.ground = 350;
                }
                else if(totoro.x >= 480 && totoro.x < 630 ){
                    totoro.falling = false;
                    totoro.ground = 300;
                }
                else{
                    totoro.falling = false;
                    totoro.ground = 480;
                }
            }
            else if(gamewin){
                g.drawImage(win.getImage(),0,0,1000,800,this);
                Brestart.setBounds(100, 605, 217, 114);
                this.add(Brestart);
                g.setColor(Color.GREEN);
                g.setFont(new Font("Hobo Std", Font.HANGING_BASELINE, 50));
                g.drawString("Time=" + minute + ":" + second, 100,540 );
                timestart = true;
            }
        }
        else{
            g.drawImage(bggameover.getImage(),0,0,1000,800,this);
            Brestart.setBounds(390, 605, 217, 114);
            this.add(Brestart);
            g.setColor(Color.RED);
            g.setFont(new Font("Hobo Std", Font.HANGING_BASELINE, 50));
            g.drawString("Time=" + minute + ":" + second, 400,540 );
            timestart = true;
        }
        
    }
    
    
    public boolean Intersect(Rectangle2D a, Rectangle2D b) {
        return (a.intersects(b));
    }
}
                
                
                
                
                
                
                
                
                
                
                    

                    
            
    
