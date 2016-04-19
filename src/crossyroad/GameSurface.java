/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossyroad;

import environment.Environment;
import grid.Grid;
import images.ResourceTools;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 *
 * @author aidanmartin
 */
class GameSurface extends Environment implements SizeLocationProviderIntf {

    Grid grid;
    ArrayList<Lane> lanes;
    ArrayList<Lane> laneObjects;
    private int laneBaseHeight;
    private int laneHeight;
    private Image Tree = ResourceTools.loadImageFromResource("crossyroad/Tree.png");
    private Image RedCar = ResourceTools.loadImageFromResource("crossyroad/Red_Car.png");
    private Image PurpleCar = ResourceTools.loadImageFromResource("crossyroad/Purple_Car.png");

    public GameSurface() {

//        grid = new Grid(24, 13, 70, 70, new Point(0, 0), Color.DARK_GRAY);
//       lanes = new ArrayList<>();
        ArrayList<LaneObject> lo = new ArrayList<>();
        lo.add(new LaneObject(ObjectType.STATIONARY_BARRIER, 50, 200, 40, 50, 0, Tree));
        lo.add(new LaneObject(ObjectType.MOVING_VEHICLE, 1, 2, 50, 35, 3, RedCar));
//       lo.add(new LaneObject)
//       lo.add(new LaneObject(ObjectType.MOVING_LOG, 70, 200, 10, 50, PurpleCar));

       // figure out how to scale them, size (50) **
//       lanes.add(new Lane(0, LaneType.FIELD, this, lo));
//       lanes.add(new Lane(1, LaneType.SIDEWALK, this, lo));
//       lanes.add(new Lane(2, LaneType.ROAD, this));
//       lanes.add(new Lane(3, LaneType.WATER, this));
        laneBaseHeight = 0;
        laneHeight = 70;

        laneObjects = new ArrayList<>();

        lanes = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            double rand = Math.random();

            if (rand < .34) {
                lanes.add(Lane.getLane(i, LaneType.ROAD, this));
            } else if (rand < .67) {
                lanes.add(Lane.getLane(i, LaneType.FIELD, this));
            } else {
                lanes.add(Lane.getLane(i, LaneType.WATER, this));
            }
        }
    }

//<editor-fold defaultstate="collapsed" desc="GetRandom">
    public int getRandom(int min, int max) {
        return (int) (min + (Math.random() * (min - max + 1)));

    }

    public Point getRandomLane() {
        return new Point(getRandom(0, getLaneHeight(laneHeight)), getRandom(getLaneWidth(laneHeight), 0));
    }

//</editor-fold>
    @Override
    public void initializeEnvironment() {
    }
    
    @Override
    public void timerTaskHandler() {
        laneBaseHeight++;

        if (lanes != null) {
            for (Lane lane : lanes) {
                lane.update();
            }
       
        }
    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {
    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {
    }

    @Override
    public void paintEnvironment(Graphics graphics) {
//        if (grid != null) {
//            grid.paintComponent(graphics);
//        }

        if (lanes != null) {
            for (Lane lane : lanes) {
                lane.draw(graphics);
            }
        }

    }

//<editor-fold defaultstate="collapsed" desc="SizeLocationProviderIntf">
    @Override
    public int getTopLeftX(int laneNumber) {
        return 0;
    }

    @Override
    public int getTopLeftY(int laneNumber) {
        return laneBaseHeight + ((laneNumber + 1) * laneHeight);
    }

    @Override
    public int getLaneHeight(int laneNumber) {
        return laneHeight;
    }

    @Override
    public int getLaneWidth(int laneNumber) {
        return this.getWidth();
    }
//</editor-fold>

}
