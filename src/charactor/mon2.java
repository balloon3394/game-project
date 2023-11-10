/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package charactor;

import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import main.Gamepanal;


public class mon2 {
    public int x,y;
    public int width,height;
    public int countM,countA ;
    public ImageIcon[] imm = new ImageIcon[4];
    public ImageIcon[] ima = new ImageIcon[3];
    Gamepanal gp;
    Totoro to;

    public mon2(Gamepanal gp,int x,int y,int w,int h) {
        
        this.gp = gp;
        width = w;
        height = h;
        this.x = x;
        this.y = y;
        for(int i=0;i<4;i++){
                imm[i] = new ImageIcon("mon2m"+(i+1)+".png");
            }
        for(int i=0;i<3;i++){
                ima[i] = new ImageIcon("mon2a"+(i+1)+".png");
            }
        
    }
    
    public void update(Totoro to){
        
        if(gp.state2){
            
            
            x-=10;
            countM++;
                  
            if(gp.Intersect(this.getbound(), to.getbound())){
                countA++;
                if(countA == 3){
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
                countA = 0;
                
            }
            if (countA > 2){
                countA = 0;
            }
            if (countM > 2){
                countM = 0;
            }
        
        }
        else{
            x = 600;
        }
    }
    
    public Rectangle2D getbound() {
        return (new Rectangle2D.Double(x, y, 180, 150));
    }
}
