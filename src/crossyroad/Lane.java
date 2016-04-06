/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossyroad;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author leonsurwald
 */
public class Lane {

    //x and y
    // height, width
    //private lane type
    private LaneType type;
    private int laneNumber;
    private SizeLocationProviderIntf sizeLocationProvider;
    

    public Lane(int laneNumber, LaneType type, SizeLocationProviderIntf sizeLocationProvider) {
        this.laneNumber = laneNumber;
        this.type = type;
        this.sizeLocationProvider = sizeLocationProvider;
    }

    public void draw(Graphics graphics) {
        graphics.setColor(getColor());
        graphics.fillRect(sizeLocationProvider.getTopLeftX(laneNumber), 
                sizeLocationProvider.getTopLeftY(laneNumber), 
                sizeLocationProvider.getLaneWidth(laneNumber), 
                sizeLocationProvider.getLaneHeight(laneNumber));
    }

//types: field, 
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

}
