/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossyroad;

/**
 *
 * @author leonsurwald
 */
public interface SizeLocationProviderIntf {
    public int getTopLeftX(int laneNumber);
    public int getTopLeftY(int laneNumber);
    
    public int getLaneHeight(int laneNumber);
    public int getLaneWidth(int laneNumber);
}
