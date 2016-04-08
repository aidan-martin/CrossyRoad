/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossyroad;

import java.awt.Image;

/**
 *
 * @author aidanmartin
 */
public class LaneObject {

    //rafts, trains, cars
    //barriers -- trees, rocks, benches
    //coins
    
    
    public void barriers() {
        
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
    private Direction direction;
    private Image image;
    private boolean standable;

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
//</editor-fold>

}
