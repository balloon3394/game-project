
package input;


import charactor.Totoro;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import main.Gamepanal;


public class keyhandler  implements KeyListener{
    
    Gamepanal gp;
    Totoro to = new Totoro(gp, this);
    public boolean up,left,right,action;
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        
        if(code == KeyEvent.VK_W || code == KeyEvent.VK_SPACE ){
            up = true;
        }
        if(code == KeyEvent.VK_A){
            left = true;
        }
        if(code == KeyEvent.VK_D ){
            right = true;
        }
        if(code == KeyEvent.VK_E){
            action = true;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        
        if(code == KeyEvent.VK_W || code == KeyEvent.VK_SPACE ){
            up = false;
            
            
        }
        if(code == KeyEvent.VK_A){
            left = false;
        }
        if(code == KeyEvent.VK_D ){
            right = false;
        }
        if(code == KeyEvent.VK_E){
            action = false;
            
        }
        
        if(code == KeyEvent.VK_A ||code == KeyEvent.VK_D ){
            to.speedx = 0;
        }
        
    
    } 

}
