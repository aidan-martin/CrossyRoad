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
class GameSurface extends Environment implements SizeLocationProviderIntf, MoveValidatorIntf {

//<editor-fold defaultstate="collapsed" desc="PROPERTIES">
    private MainCharacter cat;
    Grid grid;
    ArrayList<Lane> lanes;
    ArrayList<Lane> laneObjects;
    private int laneBaseHeight;
    private int laneHeight;
//    private Image Tree = ResourceTools.loadImageFromResource("crossyroad/Tree.png");
//    private Image RedCar = ResourceTools.loadImageFromResource("crossyroad/Red_Car.png");
//    private Image PurpleCar = ResourceTools.loadImageFromResource("crossyroad/Purple_Car.png");
    private int changeX;
    private int changeY;

    private GameState gameState = GameState.GAME;

    private Iterable<Lane> getLanesSafe() {
        ArrayList<Lane> lanesSafe = new ArrayList<>();
        for (Lane lane : lanes) {
            lanesSafe.add(lane);
        }
        return lanesSafe;
    }
//</editor-fold>

    public GameSurface() {

<<<<<<< HEAD
        cat = new MainCharacter(750 + changeX, changeY, 1, this, this);

        lanes = new ArrayList<>();

        ArrayList<LaneObject> lo = new ArrayList<>();
//        lo.add(new LaneObject(ObjectType.STATIONARY_BARRIER, 50, 200, 40, 50, 0, Tree));
//        lo.add(new LaneObject(ObjectType.MOVING_VEHICLE, 1, 2, 50, 35, 3, RedCar));
//       lo.add(new LaneObject)
//       lo.add(new LaneObject(ObjectType.MOVING_LOG, 70, 200, 10, 50, PurpleCar));

        // figure out how to scale them, size (50) **
//        lanes.add(new Lane(0, LaneType.FIELD, this, lo));
//        lanes.add(new Lane(1, LaneType.SIDEWALK, this, lo));
        // figure out how to scale them, size (50) **
//       lanes.add(new Lane(0, LaneType.FIELD, this, lo));
//       lanes.add(new Lane(1, LaneType.SIDEWALK, this, lo));
//       lanes.add(new Lane(2, LaneType.ROAD, this));
//       lanes.add(new Lane(3, LaneType.WATER, this));
        laneBaseHeight = -500;
=======

        lanes = new ArrayList<>();

//        ArrayList<LaneObject> lo = new ArrayList<>();
        laneBaseHeight = 0;
>>>>>>> am-new-01
        laneHeight = 70;

        laneObjects = new ArrayList<>();

        lanes = new ArrayList<>();
<<<<<<< HEAD
        for (int i = 0; i < 20; i++) {
            double random = getRandomValue(0, 3);

            if (random == 0) {
                lanes.add(Lane.getLane(i, LaneType.ROAD, this));
            } else if (random == 1) {
                lanes.add(Lane.getLane(i, LaneType.FIELD, this));
            } else if (random == 2) {
                lanes.add(Lane.getLane(i, LaneType.WATER, this));
            } else if (random == 3) {
                lanes.add(Lane.getLane(i, LaneType.SIDEWALK, this));

=======

        for (int i = 0; i < 30; i++) {
            double rand = Math.random();

            if (rand < .25) {
                lanes.add(Lane.getLane(i, LaneType.ROAD, this));
            } else if (rand < .50) {
                lanes.add(Lane.getLane(i, LaneType.FIELD, this));
            } else if (rand < .75) {
                lanes.add(Lane.getLane(i, LaneType.WATER, this));
            } else {
                lanes.add(Lane.getLane(i, LaneType.SIDEWALK, this));
>>>>>>> am-new-01
            }

        }
        
        cat = new MainCharacter(750 + changeX, +changeY, 2, this, this);
    }

    private static int getRandomValue(int min, int max) {
        return min + (int) (Math.random() * (max - min));
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

    double moveDelay = 0;
    double moveDelayLimit = 4;

    @Override
    public void timerTaskHandler() {
        laneBaseHeight++;

        if (lanes != null) {
            for (Lane lane : getLanesSafe()) {
                lane.update();
            }
        }
        if (moveDelay >= moveDelayLimit) {
            laneBaseHeight--;
            moveDelay = 0;
        } else {
            laneBaseHeight--;

        }
        checkIntersection();
    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            cat.setX(cat.getX() - getLaneHeight(1));
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            cat.setX(cat.getX() + getLaneHeight(1));
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            cat.addLaneNumber(1);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            cat.addLaneNumber(-1);
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            gameState = GameState.PAUSE;
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER && gameState == GameState.MENU) {
            gameState = GameState.GAME;
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER && gameState == GameState.PAUSE) {
            gameState = GameState.GAME;
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER && gameState == GameState.GAMEOVER) {
            gameState = GameState.RESTART;
        }
    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {
    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {
    }

    @Override
    public void paintEnvironment(Graphics graphics) {

        switch (gameState) {
            case MENU:
                this.setBackground(Color.red);
                graphics.setColor(Color.BLACK);
                graphics.drawString("Press Enter to Start", 15, 15);
                break;

            case GAME:
                this.setBackground(Color.WHITE);
                if (lanes != null) {
                    for (Lane lane : getLanesSafe()) {
                        lane.draw(graphics);
                    }
                }

                if (cat != null) {
                    cat.draw(graphics);
                }

                break;

            case PAUSE:
                break;

            case GAMEOVER:
                break;

            case RESTART:
                break;
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

    @Override
    public Point validateMove(Point proposedLocation) {
        return proposedLocation;
    }

    public void checkIntersection() {
        if ((lanes != null) && (cat != null)) {
            for (LaneObject lo : lanes.get(cat.getLaneNumber()).getLaneObjects()) {
                if (cat.getHitBox().intersects(lo.getHitBox())) {
                    System.out.println("AAAAAAAAHHCHCHFHHSHHFHFHFHFHHF!!!!");
                }
            }
        }
    }

}
