/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Monster;

import Inhabitant.Inhabitant;
import WalkingStick.WalkingStick;

import Worrior.Worrior;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Monster implements Inhabitant{
    
    
    //walkingSticks-->keeps the stolen walking sticks
    ArrayList<WalkingStick> walkingSticks=new ArrayList<>();
    
    
    //Implementation of stealing worrior walking sticks
    public void stealWalkingStick(Worrior worrior){        
        walkingSticks.add(worrior.getWalkingStick());
        worrior.loseWalkingStick();
    }
    
    @Override
    public String toString(){
        String name="Mon";
        return name;
    }

    @Override
    public void eat() {
        //
    }

    @Override
    public void drink() {
        //
    }

    @Override
    public void sleep() {
        //
    }

    public void killWorrior(Worrior worrior) {
        
    }
}
