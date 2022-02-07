package com.rmon.pipeline;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Stage implements Serializable {

    private List<Step> steps = new ArrayList();
    public String name;

    public Stage(String name) {
        setName(name);
    }

    public boolean executeStage() {

        for (Step step : steps) {
            // if condition is met...
            System.out.println("Running stage");
            try {
                step.runCommands();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // else skip
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void addStep(Step step) {
        steps.add(step);
    }


}
