/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Worrior;

import Binocular.Binocular;
import GameController.GameController;
import GridPoint.GridPoint;
import static Worrior.Worrior.worriorList;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class SuperWorrior extends Worrior {

    private Binocular binocular;//Super worriorhas a binocular

    public SuperWorrior() {
        super();
    }

    @Override
    public String toString() {
        String name = "SuperWoorior-" + worriorList.indexOf(this);
        return name;
    }

    @Override
    public void walk() {
        synchronized (Grid.Grid.gridPoints) {
            try {
                while (winner == false && isIsMobile() && isAlive()) {
                    GridPoint currentGP = GameController.search_GridPoint_By_Worrior(this);
                    ArrayList<GridPoint> availablePoints = GameController.avilableGridPoints(this, currentGP);
                    ArrayList<GridPoint> Binocular_Vision_Super_Worrior = GameController.Binocular_Vision_Super_Worrior(this, currentGP);
                    GridPoint nearestPoint = GameController.nearestPoint(availablePoints, currentGP);

                    String binoVision="";
                    if(Binocular_Vision_Super_Worrior.isEmpty()){
                        binoVision="No Where !!";
                    }else{
                        for(GridPoint GP:Binocular_Vision_Super_Worrior){

                            String temp=" ("+GP.getX()+","+GP.getY()+") ";
                            binoVision+=temp;
                        }
                    }

                    synchronized (nearestPoint) {
                        nearestPoint.setWorrior(this);
                        currentGP.setWorrior(null);
                        System.out.println(this + " sees a Magic Tree at "+binoVision);
                        System.out.println(this + " walked from (" + currentGP.getX() + "," + currentGP.getY() + ") to (" + nearestPoint.getX() + "," + nearestPoint.getY() + ")");
                        GameController.changeAfterMove(this, nearestPoint);

                    }

                    if (nearestPoint.getX() == 5 && nearestPoint.getY() == 5) {
                        System.out.println(this + " has reached to Mount Doom ! ");
                        setChanged();
                        winner = true;
                        notifyObservers();
                        break;

                    }

                    try {
                        Thread.sleep((long) (0 + (10 * 10)));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (NullPointerException ex) {

            }
        }
    }

    

    /**
     *
     */
    @Override
    public void eat() {

    }

    /**
     *
     */
    @Override
    public void drink() {

    }

    /**
     *
     */
    @Override
    public void sleep() {

    }

    
}
