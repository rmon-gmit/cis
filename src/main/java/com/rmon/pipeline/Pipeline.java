package com.rmon.pipeline;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pipeline implements Serializable {

    private String pipelineName;
    private int numberOfStages;
    private List<Stage> stages = new ArrayList();
    private String agent;

    public Pipeline(String pipelineName, String agent) {
        setPipelineName(pipelineName);
        setAgent(agent);
    }

    public void addStage(Stage stage) {
        stages.add(stage);
    }

    public void start() {
        for (Stage stage : stages) {
            System.out.println("Running pipeline");
            stage.executeStage();
        }
    }

    public void stop() {

    }

    public void pause() {

    }

    public void resume() {

    }

    public String getPipelineName() {
        return pipelineName;
    }

    public void setPipelineName(String pipelineName) {
        this.pipelineName = pipelineName;
    }

    public int getNumberOfStages() {
        return numberOfStages;
    }

    public void setNumberOfStages(int numberOfStages) {
        this.numberOfStages = numberOfStages;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }
}
