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

    public MainCharacter(int x, int y, int laneNumber, MoveValidatorIntf moveValidator, SizeLocationProviderIntf sizeLocationProvider) {
        this.x = x;
        this.y = y;
        this.laneNumber = laneNumber;
        
        this.direction = direction;
        this.moveValidator = moveValidator;
        this.sizeLocationProvider = sizeLocationProvider;
        
        
        ImageManager im = new ImageManager();
        im.addImage(cat1, ResourceTools.loadImageFromResource("crossyroad/cat1.png"));
        im.addImage(cat2, ResourceTools.loadImageFromResource("crossyroad/cat2.png"));
        
        frontImages = new ArrayList<>();
        frontImages.add(cat1);
        frontImages.add(cat2);
        
        animator = new Animator(im, frontImages, 400);
        
    } 
    
    public void draw(Graphics graphics) {
//        graphics.drawImage(getImage(), x, y, null); //top left x and y, height , width
        graphics.drawImage(getImage(), x, this.sizeLocationProvider.getTopLeftY(getLaneNumber()), null); //top left x and y, height , width
    }

    public void move() {
        x = x;
//        y = y;

        
//        int x;
//        int yNew = y;
//
//        if (getDirection() == Direction.LEFT) {
//            x--;
//        } else if (getDirection() == Direction.RIGHT) {
//            x++;
//        } else if (getDirection() == Direction.UP) {
//            y++;
//        } else if (getDirection() == Direction.DOWN) {
//            y--;
//        }

//        Point newLoc = moveValidator.validateMove(new Point(xNew, yNew));
//        x = newLoc.x;
//        y = newLoc.y;
        
    }

    //<editor-fold defaultstate="collapsed" desc="Properties">
    private Direction direction;
    private int x;
    private int y;
    private Animator animator;
    private int laneNumber;
    
    private static final String cat1 = "cat1";
    private static final String cat2 = "cat2";
    
    private static ArrayList<String> frontImages;
    

    private final MoveValidatorIntf moveValidator;
    private SizeLocationProviderIntf sizeLocationProvider;

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
        if (animator != null) {
            return animator.getCurrentImage();            
        } else {
            return null;
        }
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

    /**
     * @return the laneNumber
     */
    public int getLaneNumber() {
        return laneNumber;
    }

    /**
     * @param laneNumber the laneNumber to set
     */
    public void setLaneNumber(int laneNumber) {
        this.laneNumber = laneNumber;
    }
    
    /**
     * @param laneNumber the laneNumber to set
     */
    public void addLaneNumber(int laneNumber) {
        this.laneNumber += laneNumber;
    }
//</editor-fold>

}
