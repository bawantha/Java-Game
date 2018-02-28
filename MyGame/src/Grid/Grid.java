/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grid;

import GridPoint.GridPoint;

/**
 *
 * @author DELL
 */
public class Grid {
    
    //This static 2D array keeps the GridPoints
    public  static GridPoint[][] gridPoints;

    public Grid() {
        gridPoints = new GridPoint[10][10];
    }
    
    @Override
    //Overriding toString method to prnt  GridPoint
    public String toString(){
      
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                System.out.println(gridPoints[i][j].toString());
            }
        }
       return "";
    }

}
