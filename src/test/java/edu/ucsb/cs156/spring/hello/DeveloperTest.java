package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Forrest Z", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId(){
        assertEquals("linzezhou", Developer.getGithubId());
    }
    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team  t = Developer.getTeam();
        assertEquals("s25-07", t.getName());
    }
    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Forrest Z"),"Team should contain Forrest Z");
        assertTrue(t.getMembers().contains("Steven"),"Team should contain Steven");
        assertTrue(t.getMembers().contains("Hannya"),"Team should contain Hannya");
        assertTrue(t.getMembers().contains("Hannah"),"Team should contain Hannah");
        assertTrue(t.getMembers().contains("Shelly"),"Team should contain Shelly");
        assertTrue(t.getMembers().contains("Annika"),"Team should contain Annika");
    }
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
