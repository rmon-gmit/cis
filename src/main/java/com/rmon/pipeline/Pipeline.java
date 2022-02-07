package com.rmon.pipeline;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pipeline implements Serializable {

    private String name;
    private String agent;
    private List<Stage> stages = new ArrayList();

    public Pipeline(String name, String agent) {
        setName(name);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }
}
