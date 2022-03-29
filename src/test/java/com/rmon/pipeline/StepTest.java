package com.rmon.pipeline;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StepTest {

//    @BeforeEach
//    void setUp() {
//        var step = new Step();
//    }

    @Test
    void runCommandsTest() {
        var step = new Step();
        step.addCommand("echo test1");
        step.addCommand("echo test2");
        assertEquals("test1", step.runCommands().get(0));
        assertEquals("test2", step.runCommands().get(1));
    }

    @Test
    void getCommandsTest() {
        var step = new Step();
        assertEquals(0, step.getCommands().size());
        step.addCommand("cd");
        assertEquals(1, step.getCommands().size());
    }

    @Test
    void addCommandTest() {
        var step = new Step();
        step.addCommand("dir");
        step.addCommand("cd");
        assertEquals(2, step.getCommands().size());
    }

    @Test
    void removeCommandTest() {
        var step = new Step();
        step.addCommand("dir");
        step.addCommand("cd");
        step.removeCommand(0);
        assertEquals(1, step.getCommands().size());
        assertEquals("cd", step.getCommands().get(0));
    }


    @Test
    void skipTest() {
        var step = new Step();
        assertFalse(step.isSkip());
        step.setSkip(true);
        assertTrue(step.isSkip());
    }
}