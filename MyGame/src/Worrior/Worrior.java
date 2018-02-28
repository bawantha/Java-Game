/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Worrior;

import GridPoint.GridPoint;
import Inhabitant.Inhabitant;
import MountDoom.MountDoom;
import WalkingStick.WalkingStick;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Worrior extends Observable implements Inhabitant, Observer, Runnable {

    public static ArrayList<Worrior> worriorList = new ArrayList<>();
    static int worriorCount;
    private boolean isMobile = true;
    static boolean winner = false;
    private WalkingStick walkingStick;
    private boolean immotal;
    private boolean alive;// alive-->keeps whether worrior is alive or not
    private final SimpleDateFormat sdf;
    private final Calendar cal;
    private String startTime;
    private String finishedTime;
    
    
    
    public Worrior() {
        
        //Making a calendar Object
        cal = Calendar.getInstance();        
        sdf = new SimpleDateFormat("HH:mm:ss");
        startTime = sdf.format(cal.getTime());                        
                
        this.addObserver(this);
        worriorList.add(this);
        alive = true;
        isMobile = true;
        worriorCount++;//Keeping the Worriorcount
    }

    /**
     * @return the isMobile
     */
    public boolean isIsMobile() {
        return isMobile;
    }

    /**
     * @param isMobile the isMobile to set
     */
    public void setIsMobile(boolean isMobile) {
        this.isMobile = isMobile;
    }

    @Override
    public void eat() {

    }

    @Override
    public void drink() {

    }

    @Override
    public void sleep() {

    }

    //Updating observers
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("------" + this.toString() + " Stoped " + "------ ");

    }

    //notifying Observers in the Worrior List
    @Override
    public void notifyObservers() {
        for (Worrior worrior : worriorList) {
            worrior.update(this, this);
            worrior.setIsMobile(false);
        }

    }

    @Override
    public String toString() {
        String name = "Woorior-" + worriorList.indexOf(this);
        return name;
    }

    public void walk() {
        //seting gridPoints list as a intrinsic Lock
        synchronized (Grid.Grid.gridPoints) {
            try {
                while (winner == false && isIsMobile() && isAlive()) {
                    GridPoint currentGP = GameController.GameController.search_GridPoint_By_Worrior(this);
                    ArrayList<GridPoint> availablePoints = GameController.GameController.avilableGridPoints(this, currentGP);
                    GridPoint nearestPoint = GameController.GameController.nearestPoint(availablePoints, currentGP);
                    synchronized (nearestPoint) {
                        
                        nearestPoint.setWorrior(this);
                        currentGP.setWorrior(null);
                        System.out.println(this + " walked from (" + currentGP.getX() + "," + currentGP.getY() + ") to (" + nearestPoint.getX() + "," + nearestPoint.getY() + ")");
                        GameController.GameController.changeAfterMove(this, nearestPoint);
                        
                    }
                    if (nearestPoint.getX() == 5 && nearestPoint.getY() == 5) {
                        
                        //Seting Finished Time to Finished Time variable
                        setFinishedTime(sdf.format(cal.getTime()));
                        
                        //Writes Winning Data to a file
                        PrintWriter writer = new PrintWriter("E:\\Semister 2-Mine\\MyGame\\src\\GameRecords.txt");                        
                        writer.println(this + " has reached to Mount Doom ! ");
                        writer.println("Started at "+this.getStartTime());
                        writer.println("Finished at "+this.getFinishedTime() );
                        writer.close();
                        
                        //Printing result on Terminal
                        System.out.println(this + " has reached to Mount Doom ! ");
                        setChanged();
                        winner = true;
                        MountDoom md=new MountDoom();
                        md.notifyObservers();
                        break;

                        

                    }
                    try {
                        Thread.sleep((long) (0 + (10 * 10)));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (NullPointerException ex) {

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Worrior.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void run() {
        walk();
    }

    public WalkingStick getWalkingStick() {
        return walkingStick;
    }

    public void loseWalkingStick() {
        setIsMobile(false);
        walkingStick = null;
    }

    public boolean isImmotal() {
        return immotal;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    /**
     * @return the alive
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * @return the startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * @return the finishedTime
     */
    public String getFinishedTime() {
        return finishedTime;
    }

    /**
     * @param finishedTime the finishedTime to set
     */
    public void setFinishedTime(String finishedTime) {
        this.finishedTime = finishedTime;
    }

}
