package com.rmon.pipeline;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StageTest {

    private Stage stage1;

    @BeforeEach
    void init() {
        stage1 = new Stage("stage1");
    }

    @Test
    void executeStageTest() {
        var step1 = new Step();
        var step2 = new Step();

        step1.addCommand("echo test1");
        step2.addCommand("echo test2");

        stage1.addStep(step1);
        stage1.addStep(step2);

        List<List<String>> output = stage1.executeStage();

        assertEquals("test1", output.get(0).get(0));
        assertEquals("test2", output.get(1).get(0));
    }

//    @Test
//    void getIdTest() {
//        System.out.println(stage1.getId());
//    }

    @Test
    void getNameTest() {
        assertEquals("stage1", stage1.getName());
    }

    @Test
    void stepsTests() {
        var step1 = new Step();
        var step2 = new Step();
        stage1.addStep(step1);
        stage1.addStep(step2);
        assertEquals(2, stage1.getSteps().size());
        stage1.removeStep(1);
        assertEquals(1, stage1.getSteps().size());
    }


    @Test
    void skipTests() {
        assertFalse(stage1.isSkip());
        stage1.setSkip(true);
        assertTrue(stage1.isSkip());

    }

}