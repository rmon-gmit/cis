package com.rmon.pipeline;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Stage implements Serializable {

    private List<Step> steps = new ArrayList();
    public String stageName;
    public int numberOfSteps;

    public Stage(String stageName) {
        this.stageName = stageName;
    }

    public boolean executeStage() {

        for (Step step : steps) {
            // if condition is met...
            System.out.println("Running stage");
            step.runCommands();
            // else skip
        }
        return true;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public int getNumberOfSteps() {
        return numberOfSteps;
    }

    public void setNumberOfSteps(int numberOfSteps) {
        this.numberOfSteps = numberOfSteps;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void addStep(Step step) {
        steps.add(step);
    }


}
