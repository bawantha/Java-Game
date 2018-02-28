/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MagicTree;

import GridPoint.GridPoint;

/**
 *
 * @author DELL
 */
public class MagicTree {
    
    private GridPoint gridPoint;//Keeps the coordinates of the Tree   
    private MagicFruit magicFruit;
    
    public MagicTree() {
        magicFruit=new MagicFruit();
    }
    @Override
    public String toString(){
        return "MT";
        
    }
    
    public void grabFruit(){
        magicFruit=null;
    }
    
    /**
     * @return the gridPoint
     */
    public GridPoint getGridPoint() {
        return gridPoint;
    }

    /**
     * @param gridPoint the gridPoint to set
     */
    public void setGridPoint(GridPoint gridPoint) {
        this.gridPoint = gridPoint;
    }

    /**
     * @return the magicFruit
     */
    public MagicFruit getMagicFruit() {
        return magicFruit;
    }
            

}
