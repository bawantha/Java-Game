/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameController;

import Grid.Grid;
import GridPoint.GridPoint;
import MagicTree.MagicTree;
import Monster.Monster;
import Monster.WickedMonster;
import Worrior.Worrior;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author DELL
 */
public class GameController {

    static Random r = new Random();

    //Adding Grid Points to Grid
    public static void add_GridPoints_to_Grid(Grid grid) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                GridPoint gridPoint = new GridPoint();
                gridPoint.setX(i);
                gridPoint.setY(j);
                grid.gridPoints[i][j] = gridPoint;
            }
        }
    }

    //Filtering Grid Points By x , y coordinates
    public static GridPoint search_GridPoint_By_Coordinates(int x, int y) {
        GridPoint gp = null;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (Grid.gridPoints[i][j].getX() == x && Grid.gridPoints[i][j].getY() == y) {
                    gp = Grid.gridPoints[i][j];
                }
            }
        }
        return gp;
    }

    //searching Grid Point By worrior
    public static GridPoint search_GridPoint_By_Worrior(Worrior worrior) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (Grid.gridPoints[i][j].getWorrior() == worrior) {
                    return Grid.gridPoints[i][j];
                }
            }
        }
        return null;
    }

    //Creating grid Points with Corner coordinates-->x=0 or y=0 type coordinates.
    public static GridPoint makeGridPoint() {
        GridPoint gp;
        int[] coordinates = new int[2];
        int x = r.nextInt(10);
        int y = r.nextInt(10);
        coordinates[0] = x;
        coordinates[1] = y;
        if (x == 0) {
            coordinates[1] = y;
        } else if (y == 0) {
            coordinates[0] = x;
        } else if (x == y) {
            return makeGridPoint();
        } else {
            return makeGridPoint();
        }
        //gp is assigned with the existing GridPoint with corresponding coordinates
        gp = search_GridPoint_By_Coordinates(coordinates[0], coordinates[1]);
        return gp;

    }

    //Adding Magic Trees to grid
    public static void add_Trees_To_GridPoints(MagicTree magicTree) {
        int x = r.nextInt(10);
        int y = r.nextInt(10);

        //Trees should not be in the Mount Doom
        if (Grid.gridPoints[x][y].getMagicTree() == null) {
            Grid.gridPoints[x][y].setMagicTree(magicTree);
        } else {
            add_Trees_To_GridPoints(magicTree);
        }
    }

    //Adding Monsters and Wicked Monsters to Grid
    public static void add_Monsters_To_GridPoints(Monster monster) {
        int x = r.nextInt(10);
        int y = r.nextInt(10);
        if (x == 5 && y == 5) {

        } else {
            if (Grid.gridPoints[x][y].getMonster() == null) {
                Grid.gridPoints[x][y].setMonster(monster);
            } else {
                add_Monsters_To_GridPoints(monster);
            }
        }
    }

    //Adding Wooriors and Super Worriors to Grid
    public static void assign_Worriors_To_GridPoints(Worrior worrior) {
        GridPoint gp = makeGridPoint();
        if (gp.getWorrior() == null) {
            gp.setWorrior(worrior);
        } else {
            assign_Worriors_To_GridPoints(worrior);
        }
    }

    //Returns the available grid Points for a worrior
    public static ArrayList<GridPoint> avilableGridPoints(Worrior worrior, GridPoint currrentGridPoint) {

        ArrayList<GridPoint> avilablePoints = new ArrayList<>();
        try {

            int x = currrentGridPoint.getX();
            int y = currrentGridPoint.getY();

            //Makes new Grid Point objects corresponding to the current coordinate
            GridPoint gp1 = search_GridPoint_By_Coordinates(x, y - 1);//left coordinate
            GridPoint gp2 = search_GridPoint_By_Coordinates(x, y + 1);//Right Coordinate
            GridPoint gp3 = search_GridPoint_By_Coordinates(x - 1, y);//Up coordiante
            GridPoint gp4 = search_GridPoint_By_Coordinates(x + 1, y);//Down coordiante

            //if the passed objects aren't Worrior Objects they are added to avilablePoints arryList
            if (gp1 != null && gp1.getWorrior() == null) {
                avilablePoints.add(gp1);
            }
            if (gp2 != null && gp2.getWorrior() == null) {
                avilablePoints.add(gp2);
            }
            if (gp3 != null && gp3.getWorrior() == null) {
                avilablePoints.add(gp3);
            }
            if (gp4 != null && gp4.getWorrior() == null) {
                avilablePoints.add(gp4);
            }
        } catch (NullPointerException ex) {

        }

        return avilablePoints;

    }

    //Returns the closest gridPoint a worrior can gain
    public static GridPoint nearestPoint(ArrayList<GridPoint> avilablePoints, GridPoint currrentGridPoint) {

        int minDistance = 50;//Minimum Distannce to Left of Right corners' Bottom or Top to Mount Doom
        GridPoint earlyLocation = currrentGridPoint;//Current Grid Point
        GridPoint nearestPoint = currrentGridPoint;//Initially Current Grid Point is the nearest Point

        for (GridPoint avilablePoint : avilablePoints) {
            double dis = Math.pow((avilablePoint.getX() - 5), 2) + Math.pow((avilablePoint.getY() - 5), 2);
            if (dis < minDistance) {
                minDistance = (int) dis;
                nearestPoint = avilablePoint;
            }
        }
        return nearestPoint;
    }

    public static void changeAfterMove(Worrior worrior, GridPoint gridPoint) {

        if (gridPoint.getMagicTree() != null) {
            System.out.println(worrior + " found a Magic Tree at(" + gridPoint.getX() + "," + gridPoint.getY() + ")");
            if (gridPoint.getMagicTree().getMagicFruit() != null) {
                System.out.println(worrior + " ate Magic Fruit and becomes Imortal!");
                gridPoint.getMagicTree().grabFruit();
            } else {
                System.out.println("No Magic Fruit availble ");
            }
        }

        //If the Grid Point keeps a Wicked Monster 
        if (gridPoint.getMonster() != null && gridPoint.getMonster() instanceof WickedMonster) {
            gridPoint.getMonster().killWorrior(worrior);
            System.out.println(worrior + " is killed by Monster!!");

            //If the GridPoint keeps just a Monster
        } else if (gridPoint.getMonster() != null) {

            //Invokes the stealwalkingstick method in Monster class
            gridPoint.getMonster().stealWalkingStick(worrior);

            System.out.println(worrior + " Lost his Walking stick !!");
            System.out.println(worrior + " is attacked by a monster !");
        }
    }

    //Super Worrior Can see the Nearest Grid Points with Magc Trees.
    public static ArrayList<GridPoint> Binocular_Vision_Super_Worrior(Worrior worrior, GridPoint gridPoint) {
        ArrayList<GridPoint> availableGridPoints = GameController.avilableGridPoints(worrior, gridPoint);
        ArrayList<GridPoint> binocular_Seen_GP = new ArrayList<>();

        for (GridPoint GP : availableGridPoints) {
            if (GP.getMagicTree() != null) {
                binocular_Seen_GP.add(GP);
            }
        }
        return binocular_Seen_GP;
    }
}
