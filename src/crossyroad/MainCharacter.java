/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossyroad;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author aidanmartin
 */
public class MainCharacter {

    public MainCharacter(int x, int y, Image image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public void draw(Graphics graphics) {
        graphics.drawImage(image, x, y, null);
    }

    public void move() {
       int xNew = x;
       int yNew = y;
       
        if (direction == Direction.LEFT) {
            xNew--;
        } else if (direction == Direction.RIGHT) {
            xNew++;
        } else if (direction == Direction.UP) {
            yNew++;
        } else if (direction == Direction.DOWN) {
            yNew--;
        }
        
        
    }

    //<editor-fold defaultstate="collapsed" desc="Properties">
    private Direction direction;
    private int x;
    private int y;
    private Image image;

    /**
     * @return the direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
        
        if (direction == Direction.UP) {
            
        }
    }

    /**
     * @return the image
     */
    public Image getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
//</editor-fold>

}
