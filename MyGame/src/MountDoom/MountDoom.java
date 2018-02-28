/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MountDoom;

import Worrior.Worrior;
import static Worrior.Worrior.worriorList;
import java.util.Observable;

/**
 *
 * @author Gimhana
 */
public class MountDoom extends Observable{
    @Override
    public void notifyObservers() {
        for (Worrior worrior : worriorList) {
            worrior.update(this, this);
            worrior.setIsMobile(false);
        }

    }
}
