/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package charactor;

import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import main.Gamepanal;

/**
 *
 * @author Balloon
 */
public class mon3 {
public int x,y;
    public int width,height;
    public int count ;
    public ImageIcon[] im = new ImageIcon[4];
    Gamepanal gp;
    Totoro to;

    public mon3(Gamepanal gp,int x,int y,int w,int h) {
        
        this.gp = gp;
        width = w;
        height = h;
        this.x = x;
        this.y = y;
        for(int i=0;i<im.length;i++){
                im[i] = new ImageIcon("mon3a"+(i+1)+".png");
            }
        
    }
    
    public void update(Totoro to){
        
        if(gp.state2){
            if(gp.Intersect(this.getbound(), to.getbound())){
                count++;
                if(count == 3){
                    if(!to.blessed){
                        gp.HP -= 1;
                    
                    }
                    else{
                        to.blessed = false;
                    }
                    to.countf = 5;
                    to.x -= 100;
                }

            }
            else{
                count = 0;
                
            }
            if (count > 2){
                count = 0;
            }
        
        }
    }
    
    public Rectangle2D getbound() {
        return (new Rectangle2D.Double(x, y, 180, 150));
    }
    
    
}
