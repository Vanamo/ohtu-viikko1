/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vseppane
 */
public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54)); //99
            players.add(new Player("Kurri", "EDM", 37, 53)); //90
            players.add(new Player("Yzerman", "DET", 42, 56)); //98
            players.add(new Player("Gretzky", "EDM", 35, 89)); //124

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp() {
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    /**
     * Test of search method, of class Statistics.
     */
    @Test
    public void searchFindsPlayer() {
        String name = "Kurri";
        Player expResult = new Player("Kurri", "EDM", 37, 53);
        Player result = stats.search(name);
        assertEquals(name, result.getName());
    }

    @Test
    public void playerDoesntExist() {
        String name = "Vanamo";
        assertEquals(null, stats.search(name));
    }

    /**
     * Test of team method, of class Statistics.
     */
    @Test
    public void teamFindsPlayers() {
        String teamName = "EDM";
        List<String> expResult = new ArrayList<>();
        expResult.add("Semenko");
        expResult.add("Kurri");
        expResult.add("Gretzky");

        List<Player> players = stats.team(teamName);
        ArrayList<String> result = new ArrayList<>();
        for (Player player : players) {
            result.add(player.getName());
        }
        assertEquals(expResult, result);
    }

    @Test
    public void teamReturnsEmptyListIfNotFound() {
        String teamName = "JEE";
        List<Player> expResult = new ArrayList<>();

        List<Player> result = stats.team(teamName);
        assertEquals(expResult, result);
    }

    /**
     * Test of topScorers method, of class Statistics.
     */
    @Test
    public void returnsTop3Scorers() {
        int howMany = 3;
        List<Player> expResult = new ArrayList<>();
        expResult.add(new Player("Gretzky", "EDM", 35, 89));
        expResult.add(new Player("Lemieux", "PIT", 45, 54));
        expResult.add(new Player("Yzerman", "DET", 42, 56));

        List<Player> result = stats.topScorers(howMany);

        assertEquals(expResult.toString(), result.toString());
    }

    @Test
    public void returnsAllScorers() {
        int howMany = 10;
        ArrayList<Player> expResult = new ArrayList<Player>();

        expResult.add(new Player("Gretzky", "EDM", 35, 89)); //124
        expResult.add(new Player("Lemieux", "PIT", 45, 54)); //99
        expResult.add(new Player("Yzerman", "DET", 42, 56)); //98
        expResult.add(new Player("Kurri", "EDM", 37, 53)); //90
        expResult.add(new Player("Semenko", "EDM", 4, 12));

        List<Player> result = stats.topScorers(howMany);

        assertEquals(expResult.toString(), result.toString());
    }

    @Test
    public void returnsNoScorers() {
        int howMany = -1;
        List<Player> expResult = new ArrayList<>();

        List<Player> result = stats.topScorers(howMany);
        assertEquals(expResult, result);
    }
}
