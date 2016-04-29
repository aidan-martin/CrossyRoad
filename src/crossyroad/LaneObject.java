/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossyroad;

import images.ResourceTools;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**
 *
 * @author aidanmartin
 */
public class LaneObject {

    public LaneObject(ObjectType type, int x, int y, int height, int width, int speed, Image image) {
        this.type = type;

        this.x = x;
        this.y = y;

        this.speed = speed;
        this.image = image;

        this.height = height;
        this.width = width;

    }

    public void draw(Graphics graphics) {
//    graphics.drawImage(getImage, x, y, null)
//        Long_Log = ResourceTools.loadImageFromResource("crossyroad/Long_Log.png");
//        Medium_Log = ResourceTools.loadImageFromResource("crossyroad/Medium_Log.png");
//        Short_Log = ResourceTools.loadImageFromResource("crossyroad/Short_Log.png");
//        Tree = ResourceTools.loadImageFromResource("crossyroad/Tree.png");
//
//        
//        graphics.setColor(Color.red);
//        graphics.drawRect(getX(), getY(), 20, 20);

        if (image != null) {
            graphics.drawImage(image, x, y, height, width, null);
        }

    }

//<editor-fold defaultstate="collapsed" desc="Properties">
    //properties
    //  - speed
    //  - direction
    //  - image
    //  - sound (later)
    //  - stand on it (true or false) - boolean
    private int x, y;
    private int speed;
    private int height, width;
    private Direction direction;
    private Image image;
    private boolean standable;
    private ObjectType type;

    public Rectangle getHitBox() {
        return new Rectangle(x, y, width, height);
    }

    /**
     * @return the speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

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
     * @return the standable
     */
    public boolean isStandable() {
        return standable;
    }

    /**
     * @param standable the standable to set
     */
    public void setStandable(boolean standable) {
        this.standable = standable;
    }

    public void move() {
        setX(getX() + speed);
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
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }
//</editor-fold>

}
