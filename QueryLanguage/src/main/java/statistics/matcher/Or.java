/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import statistics.Player;

/**
 *
 * @author vseppane
 */
public class Or implements Matcher {

    private Matcher[] matchers;
    
    public Or(Matcher... matchers) {
        this.matchers = matchers;
        System.out.println("or matchers: " + matchers.length);
    }

    
    @Override
    public boolean matches(Player p) {
        for (Matcher m : matchers) {
            System.out.println("p: " + p + "m: " + m.matches(p));
            if (m.matches(p)) return true;
        }
        return false;
    }
    
}
