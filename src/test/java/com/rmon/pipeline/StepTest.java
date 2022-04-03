package com.rmon.pipeline;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StepTest {

    private Step step;

    @BeforeEach
    void init() {
         step = new Step();
    }

    @Test
    void runCommandsTest() {
        step.addCommand("echo test1");
        step.addCommand("echo test2");
        assertEquals("test1", step.runCommands().get(0));
        assertEquals("test2", step.runCommands().get(1));
    }

    @Test
    void getCommandsTest() {
        assertEquals(0, step.getCommands().size());
        step.addCommand("cd");
        assertEquals(1, step.getCommands().size());
    }

    @Test
    void addCommandTest() {
        step.addCommand("dir");
        step.addCommand("cd");
        assertEquals(2, step.getCommands().size());
    }

    @Test
    void removeCommandTest() {
        step.addCommand("dir");
        step.addCommand("cd");
        step.removeCommand(0);
        assertEquals(1, step.getCommands().size());
        assertEquals("cd", step.getCommands().get(0));
    }


    @Test
    void skipTest() {
        assertFalse(step.isSkip());
        step.setSkip(true);
        assertTrue(step.isSkip());
    }
}