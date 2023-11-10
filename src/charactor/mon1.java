
package charactor;

import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import main.Gamepanal;


public class mon1 {
    public int x,y;
    public int width,height;
    public int count ;
    public ImageIcon[] im = new ImageIcon[5];
    Gamepanal gp;
    Totoro to;

    public mon1(Gamepanal gp,int x,int y,int w,int h) {
        
        this.gp = gp;
        width = w;
        height = h;
        this.x = x;
        this.y = y;
        for(int i=0;i<im.length;i++){
                im[i] = new ImageIcon("mon"+(i+1)+".png");
            }
        
    }
    
    public void update(Totoro to){
        
        if(gp.state1){
            if(gp.Intersect(this.getbound(), to.getbound())){
                count++;
                if(count == 4){
                    gp.HP -= 1;
                    to.countf = 5;
                    to.x -= 100;
                }

            }
            else{
                count = 0;
                
            }
            if (count > 3){
                count = 0;
            }
        
        }
    }
    
    public Rectangle2D getbound() {
        return (new Rectangle2D.Double(x, y, 180, 150));
    }
    
    
}
