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

    public static Lane getLane(int laneNumber, LaneType type, SizeLocationProviderIntf sizeLocationProvider) {
        ArrayList<LaneObject> laneObjects = new ArrayList<>();

        switch (type) {
            case FIELD:

                for (int i = 0; i < 15; i++) {
                    if (Math.random() > .75) {
<<<<<<< HEAD
                        laneObjects.add(new LaneObject(ObjectType.STATIONARY_BARRIER, (i * 100), 0, 50, 70, Direction.NULL,0, ResourceTools.loadImageFromResource("crossyroad/Tree.png")));
=======
                        laneObjects.add(new LaneObject(ObjectType.STATIONARY_BARRIER, (i * 500), 0, 50, 70, 0, ResourceTools.loadImageFromResource("crossyroad/tree1.png")));
                        laneObjects.add(new LaneObject(ObjectType.STATIONARY_BARRIER, (i * 400), 0, 50, 70, 0, ResourceTools.loadImageFromResource("crossyroad/tree2.png")));
                        laneObjects.add(new LaneObject(ObjectType.STATIONARY_BARRIER, (i * 300), 0, 50, 70, 0, ResourceTools.loadImageFromResource("crossyroad/tree3.png")));
                        laneObjects.add(new LaneObject(ObjectType.STATIONARY_BARRIER, (i * 200), 0, 50, 70, 0, ResourceTools.loadImageFromResource("crossyroad/tree4.png")));
                        //fix the ugly trees pls
>>>>>>> am-new-01
                    }
                }
                break;

            case ROAD:
                int xOffset = -400;
                
                for (int i = 0; i < 2; i++) {
                    if (Math.random() > .65) {
                        int speed = getRandomValue(3, 6);
<<<<<<< HEAD
                        
                        laneObjects.add(new LaneObject(ObjectType.MOVING_VEHICLE, (i * 400) + xOffset, 0, 100, 80, Direction.LEFT, speed, ResourceTools.loadImageFromResource("crossyroad/Yellow_Car.png")));
//                        laneObjects.add(new LaneObject(ObjectType.MOVING_VEHICLE, (i * 300), 0, 100, 80, speed, ResourceTools.loadImageFromResource("crossyroad/Red_Car.png")));
//                        laneObjects.add(new LaneObject(ObjectType.MOVING_VEHICLE, (i * 200), 0, 100, 80, speed, ResourceTools.loadImageFromResource("crossyroad/Purple_Car.png")));
//                        laneObjects.add(new LaneObject(ObjectType.MOVING_VEHICLE, (i * 100), 0, 100, 80, speed, ResourceTools.loadImageFromResource("crossyroad/Green_Car.png")));
                        // Fix this pls ^^^^^^ make more random, cars going different directions and speeds
=======

                        laneObjects.add(new LaneObject(ObjectType.MOVING_VEHICLE, (i * 700), 0, 100, 80, speed, ResourceTools.loadImageFromResource("crossyroad/Yellow_Car.png")));
                        laneObjects.add(new LaneObject(ObjectType.MOVING_VEHICLE, (i * 500), 0, 100, 80, speed, ResourceTools.loadImageFromResource("crossyroad/Red_Car.png")));
                        laneObjects.add(new LaneObject(ObjectType.MOVING_VEHICLE, (i * 300), 0, 100, 80, speed, ResourceTools.loadImageFromResource("crossyroad/Purple_Car.png")));
                        laneObjects.add(new LaneObject(ObjectType.MOVING_VEHICLE, (i * 100), 0, 100, 80, speed, ResourceTools.loadImageFromResource("crossyroad/Green_Car.png")));
                     
>>>>>>> am-new-01
                    }
                }
                break;

            case WATER:
<<<<<<< HEAD
                for (int i = 0; i < 5; i++) {
                    if (Math.random() > .75) {
//                    laneObjects.add(new LaneObject(ObjectType.MOVING_LOG, (i * 300), 0, 100, 50, 5, ResourceTools.loadImageFromResource("crossyroad/Long_Log.png")));
//                    laneObjects.add(new LaneObject(ObjectType.MOVING_LOG, (i * 200), 0, 100, 50, 5, ResourceTools.loadImageFromResource("crossyroad/Short_Log.png")));
//                    laneObjects.add(new LaneObject(ObjectType.MOVING_LOG, (i * 100), 0, 100, 50, 5, ResourceTools.loadImageFromResource("crossyroad/Medium_Log.png")));
=======
                for (int i = 0; i < 7; i++) {
                    if (Math.random() > 0.4) {
//                        int speed = getRandomValue(3, 6);
                        
                        laneObjects.add(new LaneObject(ObjectType.MOVING_LOG, (i * 1000), 0, 100, 50, 3, ResourceTools.loadImageFromResource("crossyroad/Long_Log.png")));
                        laneObjects.add(new LaneObject(ObjectType.MOVING_LOG, (i * 500), 0, 100, 50, 3, ResourceTools.loadImageFromResource("crossyroad/Short_Log.png")));
                        laneObjects.add(new LaneObject(ObjectType.MOVING_LOG, (i * 100), 0, 100, 50, 3, ResourceTools.loadImageFromResource("crossyroad/Medium_Log.png")));
>>>>>>> am-new-01

                    }
                }
                break;

            case SIDEWALK:
                for (int i = 0; i < 10; i++) {

                }

                break;
                
                //min & max of objects in lanes
                

        }

        return new Lane(laneNumber, type, sizeLocationProvider, laneObjects);
    }

    private static int getRandomValue(int min, int max) {
        return min + (int) (Math.random() * (max - min));
    }

    {
        laneObjects = new ArrayList<>();
    }

    public Lane(int laneNumber, LaneType type, SizeLocationProviderIntf sizeLocationProvider,
            ArrayList<LaneObject> laneObjects) {
        this.laneNumber = laneNumber;
        this.type = type;
        this.sizeLocationProvider = sizeLocationProvider;

        this.laneObjects = laneObjects;
        this.startX = -400;
        this.endX = 1700;
    }

    public void draw(Graphics graphics) {
        for (LaneObject laneObject : getLaneObjects()) {
            laneObject.setY(sizeLocationProvider.getTopLeftY(laneNumber));
        }

        graphics.setColor(getColor());
        graphics.fillRect(sizeLocationProvider.getTopLeftX(laneNumber),
                sizeLocationProvider.getTopLeftY(laneNumber),
                sizeLocationProvider.getLaneWidth(laneNumber),
                sizeLocationProvider.getLaneHeight(laneNumber));
        
        for (LaneObject laneObject : getLaneObjects()) {
            laneObject.draw(graphics);
        }

    }

    private Color getColor() {
        
        switch (type) {
            case WATER:
                return Color.BLUE;

            case ROAD:
                return Color.DARK_GRAY;
                        
            case SIDEWALK:
                return Color.GRAY;

            case FIELD:
                return Color.GREEN;

            default:
                return Color.WHITE;

        }
    }

    private final LaneType type;
    private final int laneNumber;
    private SizeLocationProviderIntf sizeLocationProvider;
    private int y;
    private int startX, endX;

    private ArrayList<LaneObject> laneObjects;

    void update() {
        for (LaneObject laneObject : getLaneObjects()) {
            laneObject.move();
            
            if (laneObject.getX() > endX) {
                laneObject.setX(startX);
            }
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Properties">
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
<<<<<<< HEAD
    
    /**
     * @return the startX
     */
    public int getStartX() {
        return startX;
    }
    
    /**
     * @param startX the startX to set
     */
    public void setStartX(int startX) {
        this.startX = startX;
    }
    
    /**
     * @return the endX
     */
    public int getEndX() {
        return endX;
    }
    
    /**
     * @param endX the endX to set
     */
    public void setEndX(int endX) {
        this.endX = endX;
    }
//</editor-fold>
=======

    /**
     * @return the laneObjects
     */
    public ArrayList<LaneObject> getLaneObjects() {
        return laneObjects;
    }
>>>>>>> am-new-01
}
