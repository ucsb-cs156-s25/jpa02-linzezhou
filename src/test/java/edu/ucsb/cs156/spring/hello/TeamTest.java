package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }
    @Test
    public void test_SameObject(){
        String teamName = "Team-07";
        Team team = new Team(teamName);
        team.addMember("A");
        assert(team.equals(team));
    }
    @Test
    public void test_DiffObject(){
        String teamName = "Team-07";
        Team team = new Team(teamName);
        assert(!team.equals("Team-07"));
    }

    @Test
    public void test_SameNameNMember(){
        Team a = new Team("team_A");
        a.addMember("A");
        a.addMember("B");
        Team a_d = new Team("team_A");
        a_d.addMember("A");
        a_d.addMember("B");
        assert(a.equals(a_d));
    }

    @Test
    public void test_SameNameDiffMember(){
        Team a = new Team("team_A");
        a.addMember("A");
        Team a_d = new Team("team_A");
        a.addMember("B");
        assert(!a.equals(a_d));
    }

    @Test
    public void test_DiffNameSameMember(){
        Team a = new Team("team_A");
        a.addMember("A");
        Team a_d = new Team("team_B");
        a.addMember("A");
        assert(!a.equals(a_d));
    }

    @Test
    public void test_DiffNameDiffMember(){
        Team a = new Team("team_A");
        a.addMember("A");
        Team a_d = new Team("team_B");
        a.addMember("B");
        assert(!a.equals(a_d));
    }

    @Test
    public void test_HashCode(){
        Team a = new Team("team_A");
        a.addMember("A");
        int result = a.hashCode();
        int expectedResult = -877712641;
        assertEquals(expectedResult, result);
    }
}
