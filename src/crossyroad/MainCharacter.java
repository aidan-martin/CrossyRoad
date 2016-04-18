/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossyroad;

import images.Animator;
import images.ImageManager;
import images.ResourceTools;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author aidanmartin
 */
public class MainCharacter {

    public MainCharacter(int x, int y, Direction direction, MoveValidatorIntf moveValidator) {
        this.x = x;
        this.y = y;
//        this.image = image;
        this.direction = direction;
        this.moveValidator = moveValidator;
        
        
        ImageManager im = new ImageManager();
        im.addImage(cat1, ResourceTools.loadImageFromResource("crossyroad/cat1.png"));
        im.addImage(cat2, ResourceTools.loadImageFromResource("crossyroad/cat2.png"));
        
        frontImages = new ArrayList<>();
        frontImages.add(cat1);
        frontImages.add(cat2);
        
        animator = new Animator(im, frontImages, 400);
        
    } 
    
    Animator animator;
    
    private static final String cat1 = "cat1";
    private static final String cat2 = "cat2";
    
    private static ArrayList<String> frontImages;
    

    public void draw(Graphics graphics) {
        graphics.drawImage(image, x, y, null);
    }

    public void move() {
        int xNew = x;
        int yNew = y;

        if (getDirection() == Direction.LEFT) {
            xNew--;
        } else if (getDirection() == Direction.RIGHT) {
            xNew++;
        } else if (getDirection() == Direction.UP) {
            yNew++;
        } else if (getDirection() == Direction.DOWN) {
            yNew--;
        }

        Point newLoc = moveValidator.validateMove(new Point(xNew, yNew));
        x = newLoc.x;
        y = newLoc.y;
        
    }

    //<editor-fold defaultstate="collapsed" desc="Properties">
    private Direction direction;
    private int x;
    private int y;
    private Image image;
    private final MoveValidatorIntf moveValidator;

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
