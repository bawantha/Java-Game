/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Monster;

import Worrior.Worrior;

/**
 *
 * @author DELL
 */
public class WickedMonster extends Monster {

    

    @Override
    public String toString(){
        String name="WickedMonster";
        return name;
    }
    
    
    @Override
    public void killWorrior(Worrior worrior) {
        if (!worrior.isImmotal()) {
            worrior.setAlive(false);
            worrior = null;
        }else{
            System.out.println(worrior+" is Imortal");
        }
        
    }

}
