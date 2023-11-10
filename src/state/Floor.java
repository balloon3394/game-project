/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package state;

import charactor.Totoro;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author Balloon
 */
public class Floor  {
    
    int x,y;
    int width,height;
    public ImageIcon image;
    
    
    public Rectangle2D getbound() {
        return (new Rectangle2D.Double(x, y, width, height));
    }
}
