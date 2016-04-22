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
    private Image Tree = ResourceTools.loadImageFromResource("crossyroad/Tree.png");
    private Image RedCar = ResourceTools.loadImageFromResource("crossyroad/Red_Car.png");
    private Image PurpleCar = ResourceTools.loadImageFromResource("crossyroad/Purple_Car.png");
    private int changeX;
    private int changeY;

    private GameState gameState = GameState.MENU;

    private Iterable<Lane> getLanesSafe() {
        ArrayList<Lane> lanesSafe = new ArrayList<>();
        for (Lane lane : lanes) {
            lanesSafe.add(lane);
        }
        return lanesSafe;
    }
//</editor-fold>

    public GameSurface() {

        cat = new MainCharacter(750 + changeX, +changeY, 2, this, this);

        lanes = new ArrayList<>();

        ArrayList<LaneObject> lo = new ArrayList<>();

        laneBaseHeight = 0;
        laneHeight = 70;

        laneObjects = new ArrayList<>();

        lanes = new ArrayList<>();
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
            laneBaseHeight++;
            moveDelay = 0;
        } else {
            laneBaseHeight++;

        }

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

}
