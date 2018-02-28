/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GridPoint;

import MagicTree.MagicTree;
import Monster.Monster;
import Worrior.SuperWorrior;
import Worrior.Worrior;

/**
 *
 * @author DELL
 */
public class GridPoint {

    private int x, y;
    private Worrior worrior;
    private MagicTree magicTree;
    private Monster monster;
    
    

    public GridPoint() {
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

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

    @Override
    public String toString() {
        
        String name = "GP (" + x + "," + y + ") W:" + getWorrior() + " MT " + getMagicTree() + " Mon:" + getMonster();
        if (getWorrior() instanceof SuperWorrior) {
        
            if (getMagicTree() == null) {
                //If GridPoint contains SuperWorrior and MagicTree
                name = "GP (" + x + "," + y + ") W:" + (SuperWorrior) getWorrior() + " MT " + getMagicTree() + " Mon:" + getMonster();
                //If GridPoint contains just a SuperWorrior
            } else {
                name = "GP (" + x + "," + y + ") W:" + (SuperWorrior)getWorrior() + " MT:" + getMagicTree() + " MF:" + getMagicTree().getMagicFruit() + " Mon:" + getMonster() ;
            }

            //If Grid Point contains just a Worrior
        } else if (getWorrior() instanceof Worrior) {
            name = "GP (" + x + "," + y + ") W:" + getWorrior() + " MT " + getMagicTree() + " Mon:" + getMonster();
            //If GridPoint contains Worrior and a Magic Tree
            if (getMagicTree() == null) {
                return name;
            } else {
                name = "GP (" + x + "," + y + ") W:" + getWorrior() + " MT:" + getMagicTree() + " MF:" + getMagicTree().getMagicFruit() + " Mon:" + getMonster() ;
            }
        }
        
        return name;
    }

    /**
     * @return the worrior
     */
    public Worrior getWorrior() {
        return worrior;
    }

    /**
     * @param worrior the worrior to set
     */
    public void setWorrior(Worrior worrior) {
        this.worrior = worrior;
    }

    /**
     * @return the magicTree
     */
    public MagicTree getMagicTree() {
        return magicTree;
    }

    /**
     * @param magicTree the magicTree to set
     */
    public void setMagicTree(MagicTree magicTree) {
        this.magicTree = magicTree;
    }

    /**
     * @return the monster
     */
    public Monster getMonster() {
        return monster;
    }

    /**
     * @param monster the monster to set
     */
    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    
    

}
