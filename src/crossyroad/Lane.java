/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossyroad;

import images.ResourceTools;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author leonsurwald
 */
public class Lane {

<<<<<<< HEAD
    //x and y
    // height, width
    //private lane type
    private LaneType type;
    private int laneNumber;
    private SizeLocationProviderIntf sizeLocationProvider;
    

    public Lane(int laneNumber, LaneType type, SizeLocationProviderIntf sizeLocationProvider) {
=======
    
    {
        laneObjects = new ArrayList<>();
    }
    
    public Lane(int laneNumber, LaneType type, SizeLocationProviderIntf sizeLocationProvider, 
            ArrayList<LaneObject> laneObjects) {
>>>>>>> master
        this.laneNumber = laneNumber;
        this.type = type;
        this.sizeLocationProvider = sizeLocationProvider;
        
        this.laneObjects = laneObjects;

        //make array list for lane objects in lane class **************
    }

    public void draw(Graphics graphics) {
        for (LaneObject laneObject : laneObjects) {
            laneObject.setY(sizeLocationProvider.getTopLeftY(laneNumber));
        }
        
        
        graphics.setColor(getColor());
        graphics.fillRect(sizeLocationProvider.getTopLeftX(laneNumber), 
                sizeLocationProvider.getTopLeftY(laneNumber), 
                sizeLocationProvider.getLaneWidth(laneNumber), 
                sizeLocationProvider.getLaneHeight(laneNumber));
        
        for (LaneObject laneObject : laneObjects){
            laneObject.draw(graphics);
        }
        
    }

    private Color getColor() {
        switch (type) {
            case WATER:
                return (new Color(135, 206, 250));

            case ROAD:
                return Color.DARK_GRAY;

            case SIDEWALK:
                return Color.GRAY;

            case FIELD:
                return (new Color(34, 139, 34));
            
            default :
                return Color.WHITE;

        }
    }

    private final LaneType type;
    private final int laneNumber;
    private SizeLocationProviderIntf sizeLocationProvider;
    private int y;
    
    private ArrayList<LaneObject> laneObjects;

    void update() {
        for (LaneObject laneObject : laneObjects){
            laneObject.move();
        }
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
}
