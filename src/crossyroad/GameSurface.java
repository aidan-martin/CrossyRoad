/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossyroad;

import environment.Environment;
import grid.Grid;
import java.awt.Color;
import java.awt.Graphics;
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
    

    public GameSurface() {

        grid = new Grid(24, 13, 70, 70, new Point(0, 0), Color.DARK_GRAY);
        
       lanes = new ArrayList<>();
       lanes.add(new Lane(0, LaneType.FIELD, this));
       lanes.add(new Lane(1, LaneType.SIDEWALK, this));
       lanes.add(new Lane(2, LaneType.ROAD, this));
       lanes.add(new Lane(3, LaneType.WATER, this));

       laneBaseHeight = 200;
       laneHeight = 70;
       
       laneObjects = new ArrayList<>();
       
       
    }

    @Override
    public void initializeEnvironment() {
    }

    @Override
    public void timerTaskHandler() {
        laneBaseHeight++;
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
            for (Lane lane: lanes){
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
