/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossyroad;

import java.awt.Dimension;
import environment.ApplicationStarter;

/**
 *
 * @author aidanmartin
 */
public class CrossyRoad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    ApplicationStarter.run(new String[0], "Crossy Road", new Dimension(1680,1050), new GameSurface());
    
    }
    
}

// TO DO:

//improve randomness
//make the lanes keep drawing -- start at top
//game starts with lanes paused, press play to start moving

//   - ability to be hit & die by cars
//   - drown in water
//   - stand on logs
//   - blocked by barries (trees)

