/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package state;

import java.awt.Graphics;

/**
 *
 * @author Balloon
 */
public class pit extends Floor{
    
    public pit(int x,int y,int w,int h){
        super.x = x;
        super.y = y;
        super.width = w;
        super.height = h;
        
        
    }
    
    public void draw(Graphics g){
        g.drawRect(x, y, width, height);
    }
}
