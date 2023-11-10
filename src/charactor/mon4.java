/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package charactor;

import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import main.Gamepanal;


public class mon4 {
    public int x,y;
    public int width,height;
    
    public ImageIcon im = new ImageIcon();
    
    Gamepanal gp;
    Totoro to;

    public mon4(Gamepanal gp,int x,int y,int w,int h) {
        
        this.gp = gp;
        width = w;
        height = h;
        this.x = x;
        this.y = y;
        
        im = new ImageIcon("monmon.png");
        
    }
    
    public void update(Totoro to){
        
        if(gp.state3){
            
            
            x-=4;
            
                  
            if(gp.Intersect(this.getbound(), to.getbound())){
                
                
                if(!to.blessed){
                    gp.HP -= 1;

                }
                else{
                    to.blessed = false;
                }
                to.countf = 5;
                to.x -= 100;
                to.blessed = false;
                

            }
            
        
        }
        else{
            x = 600;
        }
    }
    
    public Rectangle2D getbound() {
        return (new Rectangle2D.Double(x, y, 100, 500));
    }
}
