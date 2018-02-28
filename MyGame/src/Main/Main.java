/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import GameController.GameController;
import Grid.Grid;
import MagicTree.MagicTree;
import Monster.Monster;
import Monster.WickedMonster;
import Worrior.SuperWorrior;
import Worrior.Worrior;

/**
 *
 * @author DELL
 */
public class Main {

    public static void main(String[] args) {

        //Making the GridObject
        Grid grid = new Grid();
        
        //Adding GridPoints to Grid
        GameController.add_GridPoints_to_Grid(grid);

        //Making Worrior and SuperWorrior objects
        Worrior w1 = new Worrior();
        Worrior w2 = new SuperWorrior();
        Worrior w3 = new Worrior();
        Worrior w4 = new SuperWorrior();
        
        //Adding those objects to GridPoints
        GameController.assign_Worriors_To_GridPoints(w1);
        GameController.assign_Worriors_To_GridPoints(w2);
        GameController.assign_Worriors_To_GridPoints(w3);
        GameController.assign_Worriors_To_GridPoints(w4);
        
        //Making Magic Tree Objects
        MagicTree mt1 = new MagicTree();
        MagicTree mt2 = new MagicTree();
        MagicTree mt3 = new MagicTree();
        MagicTree mt4 = new MagicTree();
        MagicTree mt5 = new MagicTree();

        //Adding those objects to GridPoints
        GameController.add_Trees_To_GridPoints(mt1);
        GameController.add_Trees_To_GridPoints(mt2);
        GameController.add_Trees_To_GridPoints(mt3);
        GameController.add_Trees_To_GridPoints(mt4);
        GameController.add_Trees_To_GridPoints(mt5);
        
        //Making Monster and WickedMonster Objects
        Monster m1 = new Monster();
        Monster m2 = new WickedMonster();
        Monster m3 = new Monster();
        Monster m4 = new WickedMonster();
        Monster m5 = new WickedMonster();

        //Adding those objects to GridPoints
        GameController.add_Monsters_To_GridPoints(m1);
        GameController.add_Monsters_To_GridPoints(m2);
        GameController.add_Monsters_To_GridPoints(m3);
        GameController.add_Monsters_To_GridPoints(m4);
        GameController.add_Monsters_To_GridPoints(m5);

        //Printing Grid on terminal
        System.out.println(grid);

        //Making Thread Objects using runnable interface,Worrior
        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w2);
        Thread t3 = new Thread(w3);
        Thread t4 = new Thread(w4);
        
        //Starting Threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
    }

}
