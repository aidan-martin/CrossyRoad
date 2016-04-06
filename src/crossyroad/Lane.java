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

    private LaneType type;
    private int laneNumber;
    private SizeLocationProviderIntf sizeLocationProvider;
    public Lane(int laneNumber, LaneType type, SizeLocationProviderIntf sizeLocationProvider) {
        this.laneNumber = laneNumber;
        this.type = type;
        this.sizeLocationProvider = sizeLocationProvider;

        //make array list for lane objects in lane class **************
    }

    public void draw(Graphics graphics) {
        graphics.setColor(getColor());
        graphics.fillRect(sizeLocationProvider.getTopLeftX(laneNumber), 
                sizeLocationProvider.getTopLeftY(laneNumber), 
                sizeLocationProvider.getLaneWidth(laneNumber), 
                sizeLocationProvider.getLaneHeight(laneNumber));
        
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
            
            default :
                return Color.WHITE;

        }
    }

}
