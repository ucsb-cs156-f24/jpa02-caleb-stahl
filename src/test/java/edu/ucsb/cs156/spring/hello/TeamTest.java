package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

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
    public void same_team_returns_true(){
        Team t1 = Developer.getTeam();
        Team t2 = Developer.getTeam();

        assertTrue(t1.equals(t2));
        assertTrue(t1.equals(t1));
    }

    @Test
    public void different_team_return_false(){
        Team t1 = Developer.getTeam();
        Team t2 = new Team("f24-08");
        t2.addMember("caleb");

        assertFalse(t1.equals(t2));
    }

    @Test
    public void same_class_return_true(){
        Team t1 = Developer.getTeam();
        String s1 = Developer.getName();

        assertFalse(t1.equals(s1));
    }

    @Test
    public void same_object_returns_same_hash(){
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode()); 
        assertEquals(t1.hashCode(), (t1.name.hashCode() | t1.members.hashCode()));
    }
}
